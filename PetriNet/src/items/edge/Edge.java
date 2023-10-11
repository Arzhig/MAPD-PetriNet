package items.edge;
import items.*;

/**
 * The `Edge` class represents an edge in a Petri net simulation, connecting a transition to a place.
 * This class stores information about the edge's value, the associated transition, and the associated place.
 * 
 * @author Yann Lerquemain
 */
public class Edge {
	private int value;
	private Place place;
	
	
	public Edge(int value, Place place) {
		this.value = value;
		this.place = place;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}
}
