package packnp;

import items.Place;
import items.Transition;

public interface PetriNet {

	/*adds a place in the petri net*/
	public void add(Place place);
	
	/*adds a transition in the petri net*/
	public void add(Transition transition);
	
	/*adds an EdgeOut between a place and a transition with a specified value*/
	
	public void add(Place place, Transition transition, int value);
	
	/*adds a ZeroEdge between a place and a Transition*/
	
	public void addZero(Place place, Transition transition);
	
	/*adds an EmptyEdge between a place and a Transition*/
	
	public void addEmpty(Place place, Transition transition);
	
	/*adds and EdgeIn between a place and a transition with a specified value*/
	
	public void add(Transition transition, Place place, int value);
	
	/*launches a step for a transition*/
	
	public void step(Transition transition);
	
	/*removes a place from the petri net*/
	
	public void remove(Place place);
	
	/*removes a transition from the petri net*/
	
	public void remove(Transition transition);
	
	/*removes an EdgeOut between a place and a transition*/
	
	public void remove(Place place, Transition transition);
	
	/*removes an EdgeIn between a transition and a place*/
	
	public void remove(Transition transition, Place place);
}
