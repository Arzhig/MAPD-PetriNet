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
	
	public static void addInEdgesTest() throws BadEntryException {
		int nbInEdges = 0;

		System.out.println("Testing addition of inEdges in a PetriNet");
		
		PetriNetImplementation net = new PetriNetImplementation();
		//populating the net
		net.add(new Place(0));
		net.add(new Place(0));
		net.add(new Transition());
		
		nbInEdges = net.getTransition(0).getInEdges().size();
		try {
			net.add(net.getTransition(0),net.getPlace(0),-1);
			System.out.println("Err 4.1 : Added an EdgeIn with a negative weight.");
		}
		catch (BadEntryException e) {
		    if (net.getTransition(0).getInEdges().size() != nbInEdges) {
		    	System.out.println("Err 4.1 : Modified number of InEdges though invalid weight value");
		    }
		}
		catch (Exception e) {
		    System.out.println("Err 4.1 : Exception not handled : " + e);
		    e.printStackTrace();
		}
		
		try {
			net.add(net.getTransition(0),net.getPlace(0),2);
			if (net.getTransition(0).getInEdges().size() != nbInEdges+1) {
				System.out.println("Err 4.2 : Number of inEdges in transition didn't go up by 1 after adding 1 EdgeIn");
			}
		}
		catch (Exception e) {
		    System.out.println("Err 4.2 : Exception not handled : " + e);
		    e.printStackTrace();
		}
		

		nbInEdges = net.getTransition(0).getInEdges().size();
		try {
			net.add(net.getTransition(0),net.getPlace(0),3);
			System.out.println("Err 4.3 : Added an EdgeIn where one already exists.");
		}
		catch (BadEntryException e) {
		    if (net.getTransition(0).getInEdges().size() != nbInEdges) {
		    	System.out.println("Err 4.3 : Modified number of InEdges though invalid InEdge");
		    }
		}
		catch (Exception e) {
		    System.out.println("Err 4.3 : Exception not handled : " + e);
		    e.printStackTrace();
		}
	}

	public static void addOutEdgesTest() throws BadEntryException {
		int nbOutEdges = 0;

		System.out.println("Testing addition of OutEdges in a PetriNet");
		
		PetriNetImplementation net = new PetriNetImplementation();
		//populating the net
		net.add(new Place(0));
		net.add(new Place(0));
		net.add(new Transition());
		
		nbOutEdges = net.getTransition(0).getOutEdges().size();
		try {
			net.add(net.getPlace(0),net.getTransition(0),-1);
			System.out.println("Err 5.1 : Added an EdgeOut with a negative weight.");
		}
		catch (BadEntryException e) {
		    if (net.getTransition(0).getOutEdges().size() != nbOutEdges) {
		    	System.out.println("Err 5.1 : Modified number of OutEdges though invalid weight value");
		    }
		}
		catch (Exception e) {
		    System.out.println("Err 5.1 : Exception not handled : " + e);
		    e.printStackTrace();
		}
		
		try {
			net.add(net.getPlace(0),net.getTransition(0),2);
			if (net.getTransition(0).getOutEdges().size() != nbOutEdges+1) {
				System.out.println("Err 5.2 : Number of OutEdges in transition didn't go up by 1 after adding 1 EdgeIn");
			}
		}
		catch (Exception e) {
		    System.out.println("Err 5.2 : Exception not handled : " + e);
		    e.printStackTrace();
		}
		

		nbOutEdges = net.getTransition(0).getOutEdges().size();
		try {
			net.add(net.getPlace(0),net.getTransition(0),3);
			System.out.println("Err 5.3 : Added an EdgeOut where one already exists.");
		}
		catch (BadEntryException e) {
		    if (net.getTransition(0).getOutEdges().size() != nbOutEdges) {
		    	System.out.println("Err 5.3 : Modified number of OutEdges though invalid OutEdge");
		    }
		}
		catch (Exception e) {
		    System.out.println("Err 5.3 : Exception not handled : " + e);
		    e.printStackTrace();
		}
	}
	
	
	public static void addZeroEdgesTest() throws BadEntryException {
		int nbZeroEdges = 0;
		
		System.out.println("Testing addition of zero edges in a Petri Net");
		
		PetriNetImplementation net = new PetriNetImplementation();
		//populating the net
		net.add(new Place(0));
		net.add(new Place(0));
		net.add(new Transition());
		
		nbZeroEdges = net.getTransition(0).getOutEdges().size();
		try {
			net.addZero(net.getPlace(0), net.getTransition(0));
			if ((nbZeroEdges + 1) != net.getTransition(0).getOutEdges().size()) {
				System.out.println("Err 6.1 : Number of ZeroEdges did not go up by one after adding one ZeroEdge.");
			}
		}
		catch (Exception e) {
			System.out.println("Err 6.1 : Exception not handled : " + e);
		    e.printStackTrace();
		}
		
		nbZeroEdges = net.getTransition(0).getOutEdges().size();
		try {
			net.addZero(net.getPlace(0),net.getTransition(0));
			System.out.println("Err 6.2 : Added a ZeroEdge where one already exists.");
		}
		catch (BadEntryException e) {
		    if (net.getTransition(0).getOutEdges().size() != nbZeroEdges) {
		    	System.out.println("Err 6.2 : Modified number of ZeroEdges though invalid ZeroEdge.");
		    }
		}
		catch (Exception e) {
		    System.out.println("Err 6.2 : Exception not handled : " + e);
		    e.printStackTrace();
		}
	}
	
	public static void addEmptyEdgesTest() throws BadEntryException {
		int nbEmptyEdges = 0;
		
		System.out.println("Testing addition of empty edges in a Petri Net");
		
		PetriNetImplementation net = new PetriNetImplementation();
		//populating the net
		net.add(new Place(0));
		net.add(new Place(0));
		net.add(new Transition());
		
		nbEmptyEdges = net.getTransition(0).getOutEdges().size();
		try {
			net.addEmpty(net.getPlace(0), net.getTransition(0));
			if ((nbEmptyEdges + 1) != net.getTransition(0).getOutEdges().size()) {
				System.out.println("Err 7.1 : Number of EmptyEdges did not go up by one after adding one EmptyEdge.");
			}
		}
		catch (Exception e) {
			System.out.println("Err 7.1 : Exception not handled : " + e);
		    e.printStackTrace();
		}
		
		nbEmptyEdges = net.getTransition(0).getOutEdges().size();
		try {
			net.addEmpty(net.getPlace(0),net.getTransition(0));
			System.out.println("Err 7.2 : Added a EmptyEdge where one already exists.");
		}
		catch (BadEntryException e) {
		    if (net.getTransition(0).getOutEdges().size() != nbEmptyEdges) {
		    	System.out.println("Err 7.2 : Modified number of EmptyEdges though invalid EmptyEdge.");
		    }
		}
		catch (Exception e) {
		    System.out.println("Err 7.2 : Exception not handled : " + e);
		    e.printStackTrace();
		}
	}
	
	public static void removeTest() throws BadEntryException {
		int nbPlaces = 0;
		int nbTransitions = 0;
		
		System.out.println("Testing removal of Places and Transitions in a Petri Net");
		
		PetriNetImplementation net = new PetriNetImplementation();
		//populating the net
		net.add(new Place(0));
		net.add(new Place(0));
		net.add(new Transition());
		net.add(new Transition());
		
		nbTransitions = net.getTransitions().size();
		nbPlaces = net.getPlaces().size();
		try {
			net.remove(net.getPlace(0));
			if ((nbPlaces - 1) != net.getPlaces().size()) {
				System.out.println("Err 8.1 : Number of Places did not go down by one after removing one Place.");
			}
		}
		catch (Exception e) {
			System.out.println("Err 8.1 : Exception not handled : " + e);
		    e.printStackTrace();
		}
		try {
			net.remove(net.getTransition(0));
			if ((nbTransitions - 1) != net.getTransitions().size()) {
				System.out.println("Err 8.2 : Number of Transitions did not go down by one after removing one Transition.");
			}
		}
		catch (Exception e) {
			System.out.println("Err 8.2 : Exception not handled : " + e);
		    e.printStackTrace();
		}
	}
	
	public static void addTests() throws BadEntryException {
		Test.addPlacesTest();
		Test.addTransitionsTest();
		Test.addInEdgesTest();
		Test.addOutEdgesTest();
		Test.addZeroEdgesTest();
		Test.addEmptyEdgesTest();
	}
	
	public static void main(String[] args) throws BadEntryException {
		Test.initializationTest();
		Test.addTests();
		Test.removeTest();
	}
}
