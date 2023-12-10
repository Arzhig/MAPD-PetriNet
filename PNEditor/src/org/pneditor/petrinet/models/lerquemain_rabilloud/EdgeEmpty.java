package org.pneditor.petrinet.models.lerquemain_rabilloud;

/**
 * The `EdgeEmpty` class represents an edge in a Petri net simulation, going out of a Place and into a transition,
 * which is only triggerable when the connected place has at least one token.
 * This class extends the `EdgeOut` class and overrides triggerability conditions and triggering methods.
 * 
 * @author Yann Lerquemain
 */
public class EdgeEmpty extends EdgeOut {
    /**
     * Constructs a new `EdgeEmpty` with the specified place and transition.
     * The value is set at -1, as a convention.
     *
     * @param place      The place connected by the EdgeEmpty.
     * @param transition The transition connected by the EdgeEmpty
     */
	public EdgeEmpty(Place place, Transition transition) {
        super(-1, place,transition);
    }

    /**
     * Checks whether this edge is triggerable, which depends on whether the connected place has at least one token.
     *
     * @return `true` if the edge is triggerable, `false` otherwise.
     */
    @Override
    public boolean isTriggerable() {
        return this.getPlace().getToken() > 0;
    }

    /**
     * Triggers the transition associated with this edge by removing all tokens from the connected place.
     * @throws IncorrectArgumentException 
     */
    @Override
    public void trigger() throws IncorrectArgumentException {
        this.getPlace().remove(this.getPlace().getToken());
    }
    
    /**
     * Tests if the current edge is an EdgeEmpty.
     *
     * @return true
     */
	@Override
	public boolean isEdgeEmpty() {
		return true;
	}
}
