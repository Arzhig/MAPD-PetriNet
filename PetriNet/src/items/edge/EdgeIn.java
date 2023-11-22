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
     * @param value      The value associated with the `EdgeIn`.
     * @param place      The place connected by the `EdgeIn`.
     */
	public EdgeIn(Transition transition, Place place, int value) throws IncorrectArgumentException{
		super(value, place, transition);
		if (value < 1) {
			throw new IncorrectArgumentException("EdgeIn can't have a null or negative value");
		}
	}
	/**
     * Triggers the transition associated with this incoming edge by adding tokens to the connected place.
     */
	public void trigger() throws IncorrectArgumentException{
		this.getPlace().add(this.getValue());
	}

}
