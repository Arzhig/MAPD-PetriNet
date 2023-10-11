package items.edge;
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
     */
	public EdgeOut(int value, Place place) {
		super(value, place);
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
     */
	public void trigger() {
		this.getPlace().remove(this.getValue());
	}

}
