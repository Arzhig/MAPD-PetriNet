package items.edge;
import items.*;

/**
 * The `EdgeIn` class represents an edge in a Petri net simulation, coming into a Place from a transition.
 * This class extends the `Edge` class and adds functionality for triggering transitions.
 * 
 * @author Yann Lerquemain
 */
public class EdgeIn extends Edge{
	/**
     * Constructs a new `EdgeIn` with the specified value and place.
     *
     * @param value      The value associated with the `EdgeIn`.
     * @param place      The place connected by the `EdgeIn`.
     */
	public EdgeIn(int value, Place place) {
		super(value, place);
	}
	/**
     * Triggers the transition associated with this incoming edge by adding tokens to the connected place.
     */
	public void trigger() {
		this.getPlace().add(this.getValue());
	}

}
