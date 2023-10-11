package items.edge;
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
     * Constructs a new `EdgeZero` with the specified value and place.
     *
     * @param value      The value associated with the `EdgeZero`.
     * @param place      The place connected by the `EdgeZero`.
     */
    public EdgeZero(int value, Place place) {
        super(value, place);
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
     */
    @Override
    public void trigger() {
        this.getPlace().remove(0);
    }
}
