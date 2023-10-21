package packnp;

import java.util.LinkedList;
import java.util.List;

import exceptions.BadEntryException;
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
	public void add(Place place, Transition transition, int value) {
		EdgeOut outEdge = new EdgeOut(value, place);
		transition.add(outEdge);
	}

	@Override
	public void addZero(Place place, Transition transition) {
		EdgeZero zeroEdge = new EdgeZero(place);
		transition.add(zeroEdge);	
	}

	@Override
	public void addEmpty(Place place, Transition transition) {
		EdgeEmpty emptyEdge = new EdgeEmpty(place);
		transition.add(emptyEdge);	
	}

	@Override
	public void add(Transition transition, Place place, int value) throws BadEntryException {
		EdgeIn inEdge = new EdgeIn(value,place);
		transition.add(inEdge);
	}

	@Override
	public void step(Transition transition) {
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

}
