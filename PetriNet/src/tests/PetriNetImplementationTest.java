package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import exceptions.IncorrectArgumentException;
import exceptions.DoubleEdgeException;
import exceptions.PetriNetException;
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
		System.out.println("Testing the getter for places");
		
		PetriNetImplementation net = new PetriNetImplementation();
		List<Place> places = new LinkedList<Place>();
		
		try {
			Place p1 = new Place(3);
			Place p2 = new Place(5);
			Place p3 = new Place(2);
			
			places.add(p1);
			places.add(p2);
			places.add(p3);
			
			net.add(p1);
			net.add(p2);
			net.add(p3);
			
			Assertions.assertEquals(places, net.getPlaces());
			
		}
		catch (IncorrectArgumentException e) {
			fail("The place created was given incorrect arguments.");
		}
		catch (AssertionFailedError e) {
			fail("The places returned and the places created are different.");
		}
		catch (Exception e) {
			System.out.println("Unexpected exception : " + e);
		    e.printStackTrace();
		}
	}

	@Test
	void testGetPlace() {
		System.out.println("Testing the getter for a place");
		
		PetriNetImplementation net = new PetriNetImplementation();
		
		try {
			Place p1 = new Place(3);
			Place p2 = new Place(5);
			Place p3 = new Place(2);
			
			net.add(p1);
			net.add(p2);
			net.add(p3);
			
			Assertions.assertEquals(p2, net.getPlace(1));
			
		}
		catch (IncorrectArgumentException e) {
			fail("The place created was given incorrect arguments.");
		}
		catch (AssertionFailedError e) {
			fail("The place returned and the place created are different.");
		}
		catch (Exception e) {
			System.out.println("Unexpected exception : " + e);
		    e.printStackTrace();
		}
	}

	@Test
	void testGetTransitions() {
		System.out.println("Testing the getter for transitions");
		
		PetriNetImplementation net = new PetriNetImplementation();
		List<Transition> transitions = new LinkedList<Transition>();
		
		try {
			Transition t1 = new Transition();
			Transition t2 = new Transition();
			Transition t3 = new Transition();
			
			transitions.add(t1);
			transitions.add(t2);
			transitions.add(t3);
			
			net.add(t1);
			net.add(t2);
			net.add(t3);
			
			Assertions.assertEquals(transitions, net.getTransitions());
			
		}
		catch (AssertionFailedError e) {
			fail("The transitions returned and the transitions created are different.");
		}
		catch (Exception e) {
			System.out.println("Unexpected exception : " + e);
		    e.printStackTrace();
		}
	}

	@Test
	void testGetTransition() {
		System.out.println("Testing the getter for a transition");
		
		PetriNetImplementation net = new PetriNetImplementation();
		
		try {
			Transition t1 = new Transition();
			Transition t2 = new Transition();
			Transition t3 = new Transition();
			
			net.add(t1);
			net.add(t2);
			net.add(t3);
			
			Assertions.assertEquals(t2, net.getTransition(1));
			
		}
		catch (AssertionFailedError e) {
			fail("The place returned and the place created are different.");
		}
		catch (Exception e) {
			System.out.println("Unexpected exception : " + e);
		    e.printStackTrace();
		}
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
		catch (IncorrectArgumentException e) {
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
		
		catch (IncorrectArgumentException e) {
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
		
		catch (IncorrectArgumentException e) {
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
			Assertions.assertEquals(e1.getValue(), -1);
			Assertions.assertEquals(e1.getPlace(), p1);
		}
		catch (DoubleEdgeException e) {
		    System.out.println("Err x : Added an edge where one already exists.");
		}
		
		catch (IncorrectArgumentException e) {
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
		
		catch (IncorrectArgumentException e) {
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
		System.out.println("Testing step of a transition in a PetriNet");
		//creating the net
		PetriNetImplementation net = new PetriNetImplementation();
		//Populating the net
		Transition t1 = new Transition();
		Transition t2 = new Transition();
		Transition t3 = new Transition();
		Transition t4 = new Transition();
		Transition t5 = new Transition();
		Transition t6 = new Transition();
		Transition t7 = new Transition();
		net.add(t1);
		net.add(t2);
		net.add(t3);
		net.add(t4);
		net.add(t5);
		net.add(t6);
		net.add(t7);
		
		//Lone transition in
		try {
			int n1 = 1;
			Place p1 = new Place(0);
			net.add(p1);
			net.add(t1,p1,n1);
			net.step(t1);
			Assertions.assertEquals(p1.getToken(), n1);
		} catch (AssertionFailedError e) {
			fail("Err x : The place has not received the due tokens.");
		} catch (IncorrectArgumentException e) {
			fail("Err x : The test parameters are not correct.");
		} catch (Exception e) {
			fail("Err x : Exception not handled : " + e);
		}
		
		//Lone transition out
		try {
			int n2 = 3;
			int expct2 = 1;
			Place p2 = new Place(n2);
			net.add(p2);
			net.add(p2,t2,2);
			net.step(t2);
			Assertions.assertEquals(p2.getToken(), expct2);
		} catch (AssertionFailedError e) {
			fail("Err x : The place has not given the due tokens.");
		} catch (IncorrectArgumentException e) {
			fail("Err x : The test parameters are not correct.");
		} catch (Exception e) {
			fail("Err x : Exception not handled : " + e);
		}
		
		try {
			int expct2 = 1;
			net.step(t2);
			Assertions.assertEquals(t2.getOutEdges().get(0).getPlace().getToken(), expct2);
		} catch (AssertionFailedError e) {
			fail("Err x : The transition has fired with an untriggerable edgeOut.");
		} catch (IncorrectArgumentException e) {
			fail("Err x : The test parameters are not correct.");
		} catch (Exception e) {
			fail("Err x : Exception not handled : " + e);
		}
		
		//Simple both sides
		try {
			int expct31=0;
			int expct32=1;
			
			Place p31 = new Place(expct32);
			Place p32 = new Place(expct31);
			net.add(p31);
			net.add(p32);
			
			net.add(p31,t3,1);
			net.add(t3,p32,1);
			
			net.step(t3);
			
			Assertions.assertEquals(p31.getToken(), expct31);
			Assertions.assertEquals(p32.getToken(), expct32);			
		} catch (AssertionFailedError e) {
			fail("Err x : The transition has not fired.");
		} catch (IncorrectArgumentException e) {
			fail("Err x : The test parameters are not correct.");
		} catch (Exception e) {
			fail("Err x : Exception not handled : " + e);
		}
		
		try {
			int expct31=0;
			int expct32=1;
			
			net.step(t3);
			
			Assertions.assertEquals(t3.getOutEdges().get(0).getPlace().getToken(), expct31);
			Assertions.assertEquals(t3.getInEdges().get(0).getPlace().getToken(), expct32);			
		} catch (AssertionFailedError e) {
			fail("Err x : The transition has fired unexpectedly.");
		} catch (IncorrectArgumentException e) {
			fail("Err x : The test parameters are not correct.");
		} catch (Exception e) {
			fail("Err x : Exception not handled : " + e);
		}
		
		//Double out simple in
		try {
			int expct41=0;
			int expct42=0;
			int expct43=1;
			
			Place p41 = new Place(1);
			Place p42 = new Place(1);
			Place p43 = new Place(0);

			net.add(p41);
			net.add(p42);
			net.add(p43);
			
			net.add(p41,t4,1);
			net.add(p42,t4,1);

			net.add(t4,p43,1);
			
			net.step(t4);
			
			Assertions.assertEquals(p41.getToken(), expct41);
			Assertions.assertEquals(p42.getToken(), expct42);		
			Assertions.assertEquals(p43.getToken(), expct43);

		} catch (AssertionFailedError e) {
			fail("Err x : The transition has not fired.");
		} catch (IncorrectArgumentException e) {
			fail("Err x : The test parameters are not correct.");
		} catch (Exception e) {
			fail("Err x : Exception not handled : " + e);
		}
		
		try {
			int expct41=1;
			int expct42=0;
			int expct43=1;
			t4.getOutEdges().get(0).getPlace().add(1);
			
			net.step(t4);
			
			Assertions.assertEquals(t4.getOutEdges().get(0).getPlace().getToken(), expct41);
			Assertions.assertEquals(t4.getOutEdges().get(1).getPlace().getToken(), expct42);		
			Assertions.assertEquals(t4.getInEdges().get(0).getPlace().getToken(), expct43);

		} catch (AssertionFailedError e) {
			fail("Err x : The transition has fired unexpectedly.");
		} catch (IncorrectArgumentException e) {
			fail("Err x : The test parameters are not correct.");
		} catch (Exception e) {
			fail("Err x : Exception not handled : " + e);
		}
		
		try {
			int expct41=0;
			int expct42=0;
			int expct43=1;
			
			t4.getOutEdges().get(0).getPlace().remove(1);
			
			net.step(t4);
			
			Assertions.assertEquals(t4.getOutEdges().get(0).getPlace().getToken(), expct41);
			Assertions.assertEquals(t4.getOutEdges().get(1).getPlace().getToken(), expct42);		
			Assertions.assertEquals(t4.getInEdges().get(0).getPlace().getToken(), expct43);

		} catch (AssertionFailedError e) {
			fail("Err x : The transition has fired unexpectedly.");
		} catch (IncorrectArgumentException e) {
			fail("Err x : The test parameters are not correct.");
		} catch (Exception e) {
			fail("Err x : Exception not handled : " + e);
		}
		
		//Double in simple out
		try {
			int expct51=0;
			int expct52=1;
			int expct53=1;
			
			Place p51 = new Place(1);
			Place p52 = new Place(0);
			Place p53 = new Place(0);

			net.add(p51);
			net.add(p52);
			net.add(p53);
			
			net.add(p51,t5,1);
			
			net.add(t5,p52,1);
			net.add(t5,p53,1);
			
			net.step(t5);
			
			Assertions.assertEquals(p51.getToken(), expct51);
			Assertions.assertEquals(p52.getToken(), expct52);		
			Assertions.assertEquals(p53.getToken(), expct53);

		} catch (AssertionFailedError e) {
			fail("Err x : The transition has not fired.");
		} catch (IncorrectArgumentException e) {
			fail("Err x : The test parameters are not correct.");
		} catch (Exception e) {
			fail("Err x : Exception not handled : " + e);
		}
		
		try {
			int expct51=0;
			int expct52=1;
			int expct53=1;
			
			net.step(t5);
			
			Assertions.assertEquals(t5.getOutEdges().get(0).getPlace().getToken(), expct51);
			Assertions.assertEquals(t5.getInEdges().get(0).getPlace().getToken(), expct52);		
			Assertions.assertEquals(t5.getInEdges().get(1).getPlace().getToken(), expct53);

		} catch (AssertionFailedError e) {
			fail("Err x : The transition has fired unexpectedly.");
		} catch (IncorrectArgumentException e) {
			fail("Err x : The test parameters are not correct.");
		} catch (Exception e) {
			fail("Err x : Exception not handled : " + e);
		}
		
		//EdgeZero out simple in
		try {
			int expct61=0;
			int expct62=1;
			
			Place p61 = new Place(0);
			Place p62 = new Place(0);
			net.add(p61);
			net.add(p62);

			net.addZero(p61,t6);
			net.add(t6,p62,1);
			
			net.step(t6);
			
			Assertions.assertEquals(p61.getToken(), expct61);
			Assertions.assertEquals(p62.getToken(), expct62);			
		} catch (AssertionFailedError e) {
			fail("Err x : The transition has not fired.");
		} catch (IncorrectArgumentException e) {
			fail("Err x : The test parameters are not correct.");
		} catch (Exception e) {
			fail("Err x : Exception not handled : " + e);
		}
		
		try {
			int expct61=1;
			int expct62=1;
			
			t6.getOutEdges().get(0).getPlace().add(1);
			
			net.step(t6);
			
			Assertions.assertEquals(t6.getOutEdges().get(0).getPlace().getToken(), expct61);
			Assertions.assertEquals(t6.getInEdges().get(0).getPlace().getToken(), expct62);			
		} catch (AssertionFailedError e) {
			fail("Err x : The transition has fired unexpectedly.");
		} catch (IncorrectArgumentException e) {
			fail("Err x : The test parameters are not correct.");
		} catch (Exception e) {
			fail("Err x : Exception not handled : " + e);
		}
				
		//EdgeEmpty out simple in
		try {
			int expct71=0;
			int expct72=1;
			
			Place p71 = new Place(255);
			Place p72 = new Place(0);
			net.add(p71);
			net.add(p72);

			net.addEmpty(p71,t7);
			net.add(t7,p72,1);
			
			net.step(t7);
			
			Assertions.assertEquals(p71.getToken(), expct71);
			Assertions.assertEquals(p72.getToken(), expct72);			
		} catch (AssertionFailedError e) {
			fail("Err x : The transition has not fired.");
		} catch (IncorrectArgumentException e) {
			fail("Err x : The test parameters are not correct.");
		} catch (Exception e) {
			fail("Err x : Exception not handled : " + e);
		}
		
		try {
			int expct71=0;
			int expct72=1;
			
			net.step(t7);
			
			Assertions.assertEquals(t7.getOutEdges().get(0).getPlace().getToken(), expct71);
			Assertions.assertEquals(t7.getInEdges().get(0).getPlace().getToken(), expct72);			
		} catch (AssertionFailedError e) {
			fail("Err x : The transition has fired unexpectedly.");
		} catch (IncorrectArgumentException e) {
			fail("Err x : The test parameters are not correct.");
		} catch (Exception e) {
			fail("Err x : Exception not handled : " + e);
		}
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
		catch (IncorrectArgumentException e) {
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
		catch (PetriNetException e) {
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
		catch (PetriNetException e) {
			System.out.println("Err x : The test parameters are not correct.");
		}
		catch (Exception e) {
			System.out.println("Err x : Exception not handled : " + e);
		}
	}

}
