package items.edge;
import exceptions.BadEntryException;
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
     * @param value      The value is fixed at 0 as it is triggered when the place contains zero token.
     * @param place      The place connected by the `EdgeZero`.
     * @throws BadEntryException 
     */
    public EdgeZero(Place place) throws BadEntryException {
        super(0, place);
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
     * @throws BadEntryException 
     */
    @Override
    public void trigger() throws BadEntryException {
        this.getPlace().remove(0);
    }
}
