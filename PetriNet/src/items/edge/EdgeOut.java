package items.edge;
import exceptions.BadEntryException;
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
	 * @throws BadEntryException 
     */
	public EdgeOut(int value, Place place) throws BadEntryException {
		super(value, place);
		if (value<0) {
			throw new BadEntryException("EdgeOut can't have a negative value");
		}
		else if (value==0) {
			if(this.getClass()!=EdgeZero.class) {
				throw new BadEntryException("Consider adding a EdgeZero instead");
			}
		}
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
	 * @throws BadEntryException 
     */
	public void trigger() throws BadEntryException {
		this.getPlace().remove(this.getValue());
	}

}
