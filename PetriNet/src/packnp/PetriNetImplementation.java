package packnp;

import java.util.LinkedList;
import java.util.List;
import exceptions.BadEntryException;
import exceptions.DoubleEdgeException;
import exceptions.IncorrectEdgeException;
import items.Place;
import items.Transition;
import items.edge.EdgeIn;
import items.edge.EdgeOut;
import items.edge.EdgeZero;
import items.edge.EdgeEmpty;

/**
 * The PetriNetImplementation class implements the PetriNet interface.
 * It represents a PetriNet, containing places and transitions, linked by edges.
 * 
 * @author Quentin Rabilloud
 */

public class PetriNetImplementation implements PetriNet{
	
	//private fields
	
	private List<Place> places;
	private List<Transition> transitions;
	
	public PetriNetImplementation() {
		this.places = new LinkedList<Place>();
		this.transitions = new LinkedList<Transition>();
	}
	
	public List<Place> getPlaces(){
		return this.places;
	}
	
	public Place getPlace(int i) {
		return this.getPlaces().get(i);
	}
	
	public List<Transition> getTransitions(){
		return this.transitions;
	}
	
	public Transition getTransition(int i) {
		return this.getTransitions().get(i);
	}

	@Override
	public void add(Place place) {
		this.getPlaces().add(place);
	}

	@Override
	public void add(Transition transition) {
		this.getTransitions().add(transition);
	}

	@Override
	public void add(Place place, Transition transition, int value) throws IncorrectEdgeException {
		boolean exists = false;
		for(EdgeOut e : transition.getOutEdges()) {
			if (e.getPlace().equals(place)) {exists = true;}
		}
		if (exists == false) {
			EdgeOut outEdge = new EdgeOut(value, place);
			transition.add(outEdge);
		}
		else {
			throw new DoubleEdgeException("Already exisiting edge between this place and transition");
		}
	}

	@Override
	public void addZero(Place place, Transition transition) throws IncorrectEdgeException {
		boolean exists = false;
		for (EdgeOut e : transition.getOutEdges()) {
			if (e.getPlace().equals(place)) {exists = true;}
		}
		if (!exists) {
			EdgeZero zeroEdge = new EdgeZero(place);
			transition.add(zeroEdge);
		}
		else {
			throw new DoubleEdgeException("Already existing edge between this place and transition.");
		}
	}

	@Override
	public void addEmpty(Place place, Transition transition) throws IncorrectEdgeException {
		boolean exists = false;
		for (EdgeOut e : transition.getOutEdges()) {
			if (e.getPlace().equals(place)) {exists = true;}
		}
		if (!exists) {
			EdgeEmpty emptyEdge = new EdgeEmpty(place);
			transition.add(emptyEdge);	
		}
		else {
			throw new DoubleEdgeException("Already existing edge between this place and transition.");
		}
	}

	@Override
	public void add(Transition transition, Place place, int value) throws IncorrectEdgeException {

		boolean exists = false;
		for(EdgeIn e : transition.getInEdges()) {
			if (e.getPlace().equals(place)) {exists = true;}
		}
		if (exists == false) {
			EdgeIn inEdge = new EdgeIn(value, place);
			transition.add(inEdge);
		}
		else {
			throw new DoubleEdgeException("Already exisiting edge between this transition and place");
		}
	}

	@Override
	public void step(Transition transition) throws IncorrectEdgeException {
		transition.step();
	}

	@Override
	public void remove(Place place) {
		this.getPlaces().remove(place);
	}

	@Override
	public void remove(Transition transition) {
		this.getTransitions().remove(transition);
	}

	@Override
	public void remove(EdgeOut outEdge) {
		for (Transition transition : this.getTransitions()) {
			transition.remove(outEdge);
		}
	}

	@Override
	public void remove(EdgeIn inEdge) {
		for (Transition transition : this.getTransitions()) {
			transition.remove(inEdge);
		}
	}
	
	@Override
	public String toString() {
	    int numPlaces = places.size();
	    int numTransitions = transitions.size();
	    int numArcs = 0;

	    for (Transition transition : transitions) {
	        numArcs += transition.getInEdges().size() + transition.getOutEdges().size();
	    }

	    StringBuilder sb = new StringBuilder("Petri Net\n");
	    sb.append(numPlaces).append(" places\n");
	    sb.append(numTransitions).append(" transitions\n");
	    sb.append(numArcs).append(" arcs\n");

	    sb.append("List of places:\n");
	    for (int i = 0; i < numPlaces; i++) {
	        Place place = places.get(i);
	        sb.append(i + 1).append(" : place with ").append(place.getToken()).append(" tokens\n");
	    }

	    sb.append("List of transitions:\n");
	    for (int i = 0; i < numTransitions; i++) {
	        Transition transition = transitions.get(i);
	        sb.append(i + 1).append(" : transition, ");
	        sb.append(transition.getInEdges().size()).append(" arcs incoming, ");
	        sb.append(transition.getOutEdges().size()).append(" arcs outgoing\n");
	    }

	    sb.append("List of arcs:\n");
	    int arcCount = 1;
	    for (Transition transition : transitions) {
	        for (EdgeIn inEdge : transition.getInEdges()) {
	            sb.append(arcCount).append(" : arc with weight ").append(inEdge.getValue());
	            sb.append(" (place with ").append(inEdge.getPlace().getToken()).append(" tokens to transition)\n");
	            arcCount++;
	        }

	        for (EdgeOut outEdge : transition.getOutEdges()) {
	            sb.append(arcCount).append(" : arc with weight ").append(outEdge.getValue());
	            sb.append(" (transition to place with ").append(outEdge.getPlace().getToken()).append(" tokens)\n");
	            arcCount++;
	        }
	    }

	    return sb.toString();
	}

	

}
