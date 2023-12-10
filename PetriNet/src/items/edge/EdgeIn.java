package items.edge;
import exceptions.IncorrectArgumentException;
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
     * @param transition The transition connected by the EdgeIn
     * @param place      The place connected by the EdgeIn.
     * @param value      The value associated with the EdgeIn.
     * @throws IncorrectArgumentException
     */
	public EdgeIn(Transition transition, Place place, int value) throws IncorrectArgumentException{
		super(value, place, transition);
		if (value < 1) {
			throw new IncorrectArgumentException("EdgeIn can't have a null or negative value");
		}
	}
	
	/**
     * Constructs a new EdgeIn with the specified transition and place, with a default value of 1.
     *
     * @param transition      The transition connected by the EdgeIn.
     * @param place      The place connected by the EdgeIn.
     */
	public EdgeIn(Transition transition, Place place) {
		super(1, place, transition);
	}
	
	/**
     * Triggers the transition associated with this incoming edge by adding tokens to the connected place.
     */
	public void trigger() {
		this.getPlace().add(this.getValue());
	}
	
	public boolean equals(Object o) {
		if (o != null && o instanceof EdgeIn) {
			return this.getPlace().equals(((EdgeIn)o).getPlace()) && this.getTransition().equals(((EdgeIn)o).getTransition());
		}
		return false;
	}

}
