package tests;
import packnp.*;
import exceptions.BadEntryException;
import items.*;

public class Test1 {

	public static void main(String[] args) throws BadEntryException {
		
		//Simple example : 1 origin place, 1 transition
		PetriNetImplementation net1 = new PetriNetImplementation();
		Place p1a = new Place(0);
		Place p2 = new Place(0);
		Transition t1 = new Transition();
		net1.add(p1a);
		net1.add(p2);
		net1.add(t1);
		net1.add(p1a, t1, 3);
		net1.add(t1, p2, 2);
		System.out.println("Tokens in p1a :"+p1a.getToken()); // Expected 0
		net1.getPlace(0).add(4);		
		System.out.println("Tokens in p1a :"+p1a.getToken()); // Expected 4
		System.out.println("Tokens in p2 :"+p2.getToken()); // Expected 0
		net1.step(t1); // Remove 3 tokens in p1, add 2 in p2
		System.out.println("Tokens in p1a :"+p1a.getToken()); // Expected 1
		System.out.println("Tokens in p2 :"+p2.getToken()); // Expected 2
		net1.step(t1); // Shouldn't be able to fire this one
		System.out.println("Tokens in p1a :"+p1a.getToken()); // Expected 1
		System.out.println("Tokens in p2 :"+p2.getToken()); // Expected 2
		t1.getOutEdges().get(0).setValue(1); //Set the edge value to 1
		net1.step(t1); 
		System.out.println("Tokens in p1a :"+p1a.getToken()); // Expected 0
		System.out.println("Tokens in p2 :"+p2.getToken()); // Expected 4
		net1.getPlace(1).remove(4);
		System.out.println("Tokens in p2 :"+p2.getToken()); // Expected 0
		
		//Complexifying the system : 2 place origin, 1 transition
		
		Place p1b = new Place(0);
		net1.add(p1b);
		net1.add(p1b,t1,2);
		net1.getPlace(2).add(4);
		net1.getPlace(0).add(1);
		System.out.println("Tokens in p1a :"+p1a.getToken()); // Expected 1
		System.out.println("Tokens in p1b :"+p1b.getToken()); // Expected 4
		t1.getOutEdges().get(0).setValue(2); //Set the p1a-t1 edge value to 2
		net1.step(t1); // Not supposed to fire
		System.out.println("Tokens in p1a :"+p1a.getToken()); // Expected 1
		System.out.println("Tokens in p1b :"+p1b.getToken()); // Expected 4
		System.out.println("Tokens in p2 :"+p2.getToken()); // Expected 0

		net1.getPlace(0).add(1); // Making the Edge now triggerable
		System.out.println(t1.getOutEdges().get(0).isTriggerable()); //Verifying
		net1.step(t1); // Now supposed to trigger
		System.out.println("Tokens in p1a :"+p1a.getToken()); // Expected 0
		System.out.println("Tokens in p1b :"+p1b.getToken()); // Expected 2
		System.out.println("Tokens in p2 :"+p2.getToken()); // Expected 2
	}
}
