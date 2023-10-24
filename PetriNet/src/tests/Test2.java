package tests;
import packnp.*;
import exceptions.BadEntryException;
import items.*;

public class Test2 {

	public static void main(String[] args) throws BadEntryException {
		
		//Simple example : 1 origin place, 1 transition
		PetriNetImplementation net = new PetriNetImplementation();
		net.add(new Place(0));
		net.add(new Transition());
		net.add(new Transition());
		
		net.add(net.getTransition(0),net.getPlace(0),1);
		net.add(net.getPlace(0),net.getTransition(1),1);
		
		
		System.out.println("Tokens in place : " + net.getPlace(0).getToken()); // Expected 0
		net.step(net.getTransition(0));
		System.out.println("Tokens in place : " + net.getPlace(0).getToken()); // Expected 1
		net.step(net.getTransition(1));
		System.out.println("Tokens in place : " + net.getPlace(0).getToken()); // Expected 0
		
	}
}
