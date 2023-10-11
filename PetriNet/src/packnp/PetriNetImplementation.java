package packnp;

import java.util.List;

import items.Place;
import items.Transition;
import items.edge.EdgeIn;
import items.edge.EdgeOut;

public class PetriNetImplementation implements PetriNet{
	
	private List<Place> places;
	private List<Transition> transitions;
	
	public PetriNetImplementation() {
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addZero(Place place, Transition transition) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addEmpty(Place place, Transition transition) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(Transition transition, Place place, int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void step(Transition transition) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Place place) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Transition transition) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(EdgeOut outEdge) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(EdgeIn inEdge) {
		// TODO Auto-generated method stub
		
	}

}
