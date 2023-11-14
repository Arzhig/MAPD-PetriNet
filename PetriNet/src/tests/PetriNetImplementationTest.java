package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import exceptions.BadEntryException;
import exceptions.DoubleEdgeException;
import exceptions.IncorrectEdgeException;
import items.Place;
import items.Transition;
import items.edge.EdgeIn;
import items.edge.EdgeOut;
import junit.framework.AssertionFailedError;
import packnp.PetriNetImplementation;

class PetriNetImplementationTest {
	

	@Test
	void testPetriNetImplementation() {
		System.out.println("Testing  initialisation  of a brand new PetriNet");
		try {
			// A brand new PetriNet should contain no item
			PetriNetImplementation net = new PetriNetImplementation();
			
			Assertions.assertEquals(net.getPlaces().size(), 0);
			Assertions.assertEquals(net.getTransitions().size(), 0);
			
		}
		catch (AssertionFailedError e) {
			fail("The net has not been correctly initialized.");
		}
		catch (Exception e) {
		    System.out.println("Unexpected exception : " + e);
		    e.printStackTrace();
		}
	}

	@Test
	void testGetPlaces() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPlace() {
		fail("Not yet implemented");
	}

	@Test
	void testGetTransitions() {
		fail("Not yet implemented");
	}

	@Test
	void testGetTransition() {
		fail("Not yet implemented");
	}

	@Test
	void testAddPlace() {
		
		System.out.println("Testing addition of places in a PetriNet");
		
		PetriNetImplementation net = new PetriNetImplementation();
		
		try {
			Place p1 = new Place(3);
			net.add(p1);
			Assertions.assertEquals(net.getPlace(0), p1);
		}
		catch (AssertionFailedError e) {
			System.out.println("The place created and the place added are different");
		}
		catch (BadEntryException e) {
			System.out.println("The place created was given incorrect arguments");
		}
		catch (Exception e) {
			System.out.println("Err x : exception not handled : " + e);
		    e.printStackTrace();
		}
		
	}

	@Test
	void testAddTransition() {
		System.out.println("Testing addition of transitions in a PetriNet");
		
		PetriNetImplementation net = new PetriNetImplementation();
		
		try {
			Transition t1 = new Transition();
			net.add(t1);
			Assertions.assertEquals(net.getTransition(0), t1);
		}
		catch (AssertionFailedError e) {
			System.out.println("The transition created and the transition added are different");
		}
		catch (Exception e) {
			System.out.println("Err x : exception not handled : " + e);
		    e.printStackTrace();
		}
	}

	@Test
	void testAddEdgeOut() {

		System.out.println("Testing addition of EdgeOut in a PetriNet");
		
		PetriNetImplementation net = new PetriNetImplementation();
		//populating the net
		Transition t1 = new Transition();
		net.add(t1);
		int nTokens = 3;
		
		try {	
			Place p1 = new Place(4);
			net.add(p1);
			net.add(net.getPlace(0),net.getTransition(0),nTokens);
			EdgeOut e1 = net.getTransition(0).getOutEdges().get(0);
			Assertions.assertEquals(e1.getValue(), nTokens);
			Assertions.assertEquals(e1.getPlace(), p1);
		}
		catch (DoubleEdgeException e) {
		    System.out.println("Err x : Added an edge where one already exists.");
		}
		
		catch (BadEntryException e) {
		    System.out.println("Err x : The place created was given incorrect arguments.");
		}
		catch (AssertionFailedError e) {
			System.out.println("Err x : The edge added and the edge created are different.");
		}
		catch (Exception e) {
			System.out.println("Err x : Exception not handled : " + e);
		}
	}

	@Test
	void testAddEdgeZero() {
		System.out.println("Testing addition of EdgeZero in a PetriNet");
		
		PetriNetImplementation net = new PetriNetImplementation();
		//populating the net
		Transition t1 = new Transition();
		net.add(t1);
		
		try {	
			Place p1 = new Place(4);
			net.add(p1);
			net.addZero(net.getPlace(0),net.getTransition(0));
			EdgeOut e1 = net.getTransition(0).getOutEdges().get(0);
			Assertions.assertEquals(e1.getValue(), 0);
			Assertions.assertEquals(e1.getPlace(), p1);
		}
		catch (DoubleEdgeException e) {
		    System.out.println("Err x : Added an edge where one already exists.");
		}
		
		catch (BadEntryException e) {
		    System.out.println("Err x : The place created was given incorrect arguments.");
		}
		catch (AssertionFailedError e) {
			System.out.println("Err x : The edge added and the edge created are different.");
		}
		catch (Exception e) {
			System.out.println("Err x : Exception not handled : " + e);
		}
	}

	@Test
	void testAddEdgeEmpty() {
		System.out.println("Testing addition of EdgeEmpty in a PetriNet");
		
		PetriNetImplementation net = new PetriNetImplementation();
		//populating the net
		Transition t1 = new Transition();
		net.add(t1);
		
		try {	
			Place p1 = new Place(4);
			net.add(p1);
			net.addEmpty(net.getPlace(0),net.getTransition(0));
			EdgeOut e1 = net.getTransition(0).getOutEdges().get(0);
			Assertions.assertEquals(e1.getValue(), 1);
			Assertions.assertEquals(e1.getPlace(), p1);
		}
		catch (DoubleEdgeException e) {
		    System.out.println("Err x : Added an edge where one already exists.");
		}
		
		catch (BadEntryException e) {
		    System.out.println("Err x : The place created was given incorrect arguments.");
		}
		catch (AssertionFailedError e) {
			System.out.println("Err x : The edge added and the edge created are different.");
		}
		catch (Exception e) {
			System.out.println("Err x : Exception not handled : " + e);
		}
	}

	@Test
	void testAddEdgeIn() {
		System.out.println("Testing addition of EdgeIn in a PetriNet");
		
		PetriNetImplementation net = new PetriNetImplementation();
		//populating the net
		Transition t1 = new Transition();
		net.add(t1);
		int nTokens = 2;
		
		try {	
			Place p1 = new Place(4);
			net.add(p1);
			net.add(net.getTransition(0), net.getPlace(0), nTokens);
			EdgeIn e1 = net.getTransition(0).getInEdges().get(0);
			Assertions.assertEquals(e1.getValue(), nTokens);
			Assertions.assertEquals(e1.getPlace(), p1);
		}
		catch (DoubleEdgeException e) {
		    System.out.println("Err x : Added an edge where one already exists.");
		}
		
		catch (BadEntryException e) {
		    System.out.println("Err x : The place created was given incorrect arguments.");
		}
		catch (AssertionFailedError e) {
			System.out.println("Err x : The edge added and the edge created are different.");
		}
		catch (Exception e) {
			System.out.println("Err x : Exception not handled : " + e);
		}
	}

	@Test
	void testStep() {
		fail("Not yet implemented");
	}

	@Test
	void testRemovePlace() {
		System.out.println("Testing removal of a place in a PetriNet");
		
		PetriNetImplementation net = new PetriNetImplementation();
		//populating the net
		try {
			Place p1 = new Place(6);
			Place p2 = new Place(2);
			Place p3 = new Place(3);
			net.add(p1);
			net.add(p2);
			net.add(p3);
			
			net.remove(p2);
			List<Place> lstExpected = new LinkedList<Place>();
			lstExpected.add(p1);
			lstExpected.add(p3);
			Assertions.assertEquals(net.getPlaces(), lstExpected);
		}
		catch (BadEntryException e) {
		    System.out.println("Err x : The place created was given incorrect arguments.");
		}
		catch (AssertionFailedError e) {
			System.out.println("Err x : The place has not been removed or the wrong one was removed.");
		}
		catch (Exception e) {
			System.out.println("Err x : Exception not handled : " + e);
		}
	}

	@Test
	void testRemoveTransition() {
		System.out.println("Testing removal of a transition in a PetriNet");
		
		PetriNetImplementation net = new PetriNetImplementation();
		Transition t1 = new Transition();
		Transition t2 = new Transition();
		Transition t3 = new Transition();
		net.add(t1);
		net.add(t2);
		net.add(t3);
		List<Transition> lstExpected = new LinkedList<Transition>();
		lstExpected.add(t1);
		lstExpected.add(t3);

		try {			
			net.remove(t2);
			Assertions.assertEquals(net.getTransitions(), lstExpected);
		}
		catch (AssertionFailedError e) {
			System.out.println("Err x : The transition has not been removed or the wrong one was removed.");
		}
		catch (Exception e) {
			System.out.println("Err x : Exception not handled : " + e);
		}
	}

	@Test
	void testRemoveEdgeOut() {
		System.out.println("Testing removal of an edge in a PetriNet");
		
		int n1 = 1;
		int n2 = 5;
		int n3 = 2;
		
		PetriNetImplementation net = new PetriNetImplementation();
		Transition t1 = new Transition();
		net.add(t1);


		try {			
			Place p1 = new Place(6);
			Place p2 = new Place(3);
			Place p3 = new Place(2);
			net.add(p1);
			net.add(p2);
			net.add(p3);
			
			net.add(p1, t1, n1);
			net.add(p2, t1, n2);
			net.add(p3, t1, n3);
			
			EdgeOut e1 = new EdgeOut(n1,p1);
			EdgeOut e2 = new EdgeOut(n2,p2);
			EdgeOut e3 = new EdgeOut(n3,p3);

			net.remove(e2);
			
			Assertions.assertEquals(net.getTransition(0).getOutEdges().get(0).getValue(), e1.getValue());
			Assertions.assertEquals(net.getTransition(0).getOutEdges().get(0).getPlace(), e1.getPlace());
			Assertions.assertEquals(net.getTransition(0).getOutEdges().get(1).getValue(), e3.getValue());
			Assertions.assertEquals(net.getTransition(0).getOutEdges().get(1).getPlace(), e3.getPlace());
		}
		catch (AssertionFailedError e) {
			System.out.println("Err x : The edge has not been removed or the wrong one was removed.");
		}
		catch (IncorrectEdgeException e) {
			System.out.println("Err x : The test parameters are not correct.");
		}
		catch (Exception e) {
			System.out.println("Err x : Exception not handled : " + e);
		}
	}

	@Test
	void testRemoveEdgeIn() {
		System.out.println("Testing removal of an edge in a PetriNet");
		
		int n1 = 1;
		int n2 = 5;
		int n3 = 2;
		
		PetriNetImplementation net = new PetriNetImplementation();
		Transition t1 = new Transition();
		net.add(t1);


		try {			
			Place p1 = new Place(6);
			Place p2 = new Place(3);
			Place p3 = new Place(2);
			net.add(p1);
			net.add(p2);
			net.add(p3);
			
			net.add(t1, p1, n1);
			net.add(t1, p2, n2);
			net.add(t1, p3, n3);
			
			EdgeIn e1 = new EdgeIn(n1,p1);
			EdgeIn e2 = new EdgeIn(n2,p2);
			EdgeIn e3 = new EdgeIn(n3,p3);

			net.remove(e2);
			
			Assertions.assertEquals(net.getTransition(0).getInEdges().get(0).getValue(), e1.getValue());
			Assertions.assertEquals(net.getTransition(0).getInEdges().get(0).getPlace(), e1.getPlace());
			Assertions.assertEquals(net.getTransition(0).getInEdges().get(1).getValue(), e3.getValue());
			Assertions.assertEquals(net.getTransition(0).getInEdges().get(1).getPlace(), e3.getPlace());
		}
		catch (AssertionFailedError e) {
			System.out.println("Err x : The edge has not been removed or the wrong one was removed.");
		}
		catch (IncorrectEdgeException e) {
			System.out.println("Err x : The test parameters are not correct.");
		}
		catch (Exception e) {
			System.out.println("Err x : Exception not handled : " + e);
		}
	}

}
