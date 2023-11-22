package items.edge;
import exceptions.PetriNetException;
import exceptions.IncorrectArgumentException;
import exceptions.IrrelevantClassException;
import items.*;

/**
 * The `EdgeOut` class represents an edge in a Petri net simulation, going out of a Place and into a transition.
 * This class extends 'Edge',and has the ability to trigger.
 * 
 * @author Yann Lerquemain
 */
public class EdgeOut extends Edge{
	/**
     * Constructs a new EdgeOut with the specified value and place.
     *
     * @param value      The value associated with the EdgeOut.
     * @param place      The place connected by the EdgeOut.
	 * @throws IncorrectArgumentException 
     */
	public EdgeOut(Place place, Transition transition, int value) throws PetriNetException {
		super(value, place, transition);
		if (value < -1) {
			throw new IncorrectArgumentException("EdgeOut can't have a negative value");
		}
		else if (value == -1 && this.getClass() != EdgeEmpty.class) {
			throw new IrrelevantClassException("Consider adding a EdgeEmpty instead");
		}
		else if (value == 0 && this.getClass() != EdgeZero.class) {
			throw new IrrelevantClassException("Consider adding a EdgeZero instead");
		}
	}
	
	public EdgeOut(Place place, Transition transition) {
		super(1, place, transition);
	}
	
	/**
     * Checks whether this outgoing edge is triggerable based on the token count in the connected place.
     *
     * @return `true` if the edge is triggerable, `false` otherwise.
     */
	public boolean isTriggerable() {
		return(this.getPlace().getToken()>=this.getValue());
	}
	/**
     * Triggers the transition associated with this outgoing edge by removing tokens from the connected place.
	 * @throws IncorrectArgumentException 
     */
	public void trigger() throws IncorrectArgumentException {
		this.getPlace().remove(this.getValue());
	}

}
