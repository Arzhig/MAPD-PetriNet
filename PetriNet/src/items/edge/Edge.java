package items.edge;

import items.Place;
import items.Transition;

/**
 * The `Edge` class represents an edge in a Petri net simulation, connecting a transition to a place.
 * This class stores information about the edge's value, the associated transition, and the associated place.
 * 
 * @author Yann Lerquemain
 */
public class Edge {
	/**
     * The value associated with this edge.
     */
	private int value;
	/**
     * The place connected to this edge.
     */
	private Place place;
	
	/**
	 * The transition connected to this edge.
	 */
	private Transition transition;
	
	/**
     * Constructs a new edge with the specified value and place.
     *
     * @param value      The value associated with the edge.
     * @param place      The place connected by the edge.
     */
	public Edge(int value, Place place, Transition transition){
		this.value = value;
		this.place = place;
		this.transition = transition;
	}
	
	/**
     * Get the value associated with this edge.
     *
     * @return The value of the edge.
     */
	public int getValue() {
		return this.value;
	}
	
	/**
     * Set the value associated with this edge.
     *
     * @param value The new value for the edge.
     */
	public void setValue(int value) {
		this.value = value;
	}
	
	/**
     * Get the place connected by this edge.
     *
     * @return The connected place.
     */
	public Place getPlace() {
		return place;
	}
	
	/**
     * Set the place connected by this edge.
     *
     * @param place The new place to connect with the edge.
     */
	public void setPlace(Place place) {
		this.place = place;
	}
	
	
	/**
     * Get the transition connected to this edge.
     *
     * @return transition The connected transition.
     */
	public Transition getTransition() {
		return this.transition;
	}
	
	
	/**
     * Set the transition connected to this edge.
     *
     * @param transition The new transition to connect with the edge.
     */
	public void setTransition(Transition transition) {
		this.transition = transition;
	}
	
	/**
     * Tests if the current edge is an EdgeZero.
     *
     * @return false
     */
	public boolean isEdgeZero() {
		return false;
	}
	
	/**
     * Tests if the current edge is an EdgeEmpty.
     *
     * @return false
     */
	public boolean isEdgeEmpty() {
		return false;
	}
	
}
