package packnp;

import exceptions.BadEntryException;
import items.Place;
import items.Transition;
import items.edge.EdgeIn;
import items.edge.EdgeOut;

/**
 * The PetriNet interface declares the methods required to create a Petri net.
 * 
 * @author Quentin Rabilloud
 */

public interface PetriNet {

	/**
	* Adds a place in the petri net
	* @param place the place instance added
	*/
	public void add(Place place);
	
	/**
	* Adds a transition in the petri net
	* @param transition the transition instance added
	*/
	public void add(Transition transition);
	
	/**
	* Adds an EdgeOut between a place and a transition with a specified value
	* @param place 		the place before the edge
	* @param transition the transition after the edge
	* @param value		the edge's value
	*/
	
	public void add(Place place, Transition transition, int value);
	
	/**
	* Adds a ZeroEdge between a place and a Transition
	* @param place 		the place before the edge
	* @param transition the transition after the edge
	*/
	
	public void addZero(Place place, Transition transition);
	
	/**
	* Adds an EmptyEdge between a place and a Transition
	* @param place 		the place before the edge
	* @param transition the transition after the edge
	*/
	
	public void addEmpty(Place place, Transition transition);

	/**
	* Adds an EdgeIn between a place and a transition with a specified value
	* @param transition the transition before the edge
	* @param place 		the place after the edge
	* @param value		the edge's value
	 * @throws BadEntryException 
	*/
	public void add(Transition transition, Place place, int value) throws BadEntryException;

	/**
	* Launches a step for a transition
	* @param transition the transition undergoing a step
	*/
	
	public void step(Transition transition);

	/**
	* Removes a place from the petri net
	* @param place the place instance removed
	*/
	public void remove(Place place);

	/**
	* Removes a transition from the petri net
	* @param transition the transition instance removed
	*/
	public void remove(Transition transition);

	/**
	* Removes an EdgeOut between a place and a transition
	* @param outEdge the edge instance removed
	*/
	public void remove(EdgeOut outEdge);
	
	/**
	* Removes an EdgeIn between a place and a transition
	* @param inEdge the edge instance removed
	*/
	
	public void remove(EdgeIn inEdge);
}
