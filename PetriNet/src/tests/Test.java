package tests;

import packnp.*;
import items.*;
import exceptions.*;

public class Test {
	
	//SYSTEMATIC TESTS
	public static void initializationTest() {
		System.out.println("Testing  initialisation  of a brand new PetriNet");
		try {
			// A brand new PetriNet should contain no item
			PetriNetImplementation net = new PetriNetImplementation();
			if (net.getPlaces().size()!=0) {
				System.out.println("Err 1.1 : Non-zero number of places in newly created network");
				System.exit(1);
			}
			if (net.getTransitions().size()!=0) {
				System.out.println("Err 1.1 : Non-zero number of transitions in newly created network");
				System.exit(1);
			}	
		}
		catch (Exception e) {
		    System.out.println("Unexpected Exception : " + e);
		    e.printStackTrace();
		}
	}
	
	public static void addPlacesTest() {
		int nbPlaces = 0;
		
		System.out.println("Testing addition of places in a PetriNet");
		
		PetriNetImplementation net = new PetriNetImplementation();
		
		nbPlaces = net.getPlaces().size();
		
		//trying to add an incorrect place
		try {
			net.add(new Place(-1));
			System.out.println("Err 2.1 : Added a place with a negative amount of tokens");
		}
		catch (BadEntryException e) {
		    if (net.getPlaces().size() != nbPlaces)
			System.out.println("Err 2.1 : Modified number of places though invalid token value");
		}
		catch (Exception e) {
		    System.out.println("Err 2.1 : Exception not handled : " + e);
		    e.printStackTrace();
		}
		
		nbPlaces = net.getPlaces().size();
		
		//trying to add 3 correct places
		try {
			net.add(new Place(1));
			net.add(new Place(2));
			net.add(new Place(3));
			if (net.getPlaces().size() != nbPlaces+3) {
				System.out.println("Err 2.2 : Number of places in network didn't go up by 3 after adding 3 places");
			}
		}
		catch (Exception e) {
		    System.out.println("Err 2.2 : Exception not handled : " + e);
		    e.printStackTrace();
		}
	}
	
	public static void addTransitionsTest() {
		int nbTransitions = 0;
		
		System.out.println("Testing addition of Transitions in a PetriNet");
		
		PetriNetImplementation net = new PetriNetImplementation();
		
		nbTransitions = net.getTransitions().size();
		
		//trying to add 2 Transitions
		try {
			net.add(new Transition());
			net.add(new Transition());
			if (net.getTransitions().size() != nbTransitions+2) {
				System.out.println("Err 3.1 : Number of transitions in network didn't go up by 2 after adding 2 transitions");
			}
		}
		catch (Exception e) {
		    System.out.println("Err 3.1 : Exception not handled : " + e);
		    e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Test.initializationTest();
		Test.addPlacesTest();
		Test.addTransitionsTest();
	}
}