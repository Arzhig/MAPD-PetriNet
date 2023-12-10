package items.edge;

import exceptions.IncorrectArgumentException;
import items.*;

/**
 * The `EdgeZero` class represents an edge in a Petri net simulation, going out of a Place and into a transition,
 * which is only triggerable when the connected place has zero tokens.
 * This class extends the `EdgeOut` class and overrides triggerability conditions and triggering methods.
 * 
 * @author Yann Lerquemain
 */
public class EdgeZero extends EdgeOut {
	/**
     * Constructs a new EdgeZero with the specified place and transition.
     * The value is set at 0, as a convention.
     *
     * @param place      The place connected by the EdgeZero.
     * @param transition The transition connected by the EdgeZero
     */
	public EdgeZero(Place place, Transition transition) {
        super(0,place,transition);
    }

    /**
     * Checks whether this edge is triggerable, which depends on whether the connected place has zero tokens.
     *
     * @return `true` if the edge is triggerable, `false` otherwise.
     */
    @Override
    public boolean isTriggerable() {
        return this.getPlace().getToken() == 0;
    }

    /**
     * Triggers the transition associated with this edge by removing all tokens (zero tokens) from the connected place.
     * @throws IncorrectArgumentException 
     */
    @Override
    public void trigger() throws IncorrectArgumentException {
        this.getPlace().remove(0);
    }
    
    /**
     * Tests if the current edge is an EdgeZero.
     *
     * @return true
     */
    @Override
    public boolean isEdgeZero() {
    	return true;
    }
}
