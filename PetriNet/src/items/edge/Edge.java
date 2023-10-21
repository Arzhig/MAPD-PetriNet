package items.edge;
import items.*;

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
     * Constructs a new edge with the specified value and place.
     *
     * @param value      The value associated with the edge.
     * @param place      The place connected by the edge.
     */
	public Edge(int value, Place place){
		this.value = value;
		this.place = place;
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
}
