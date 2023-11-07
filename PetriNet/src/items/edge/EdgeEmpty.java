package items.edge;
import exceptions.BadEntryException;
import items.*;

/**
 * The `EdgeEmpty` class represents an edge in a Petri net simulation, going out of a Place and into a transition,
 * which is only triggerable when the connected place has at least one token.
 * This class extends the `EdgeOut` class and overrides triggerability conditions and triggering methods.
 * 
 * @author Yann Lerquemain
 */
public class EdgeEmpty extends EdgeOut {
    /**
     * Constructs a new `EdgeEmpty` with the specified value and place.
     *
     * @param value      The value is fixed at -1 as a convention to identify an EdgeEmpty.
     * @param place      The place connected by the `EdgeEmpty`.
     * @throws BadEntryException 
     */
    public EdgeEmpty(Place place) throws BadEntryException {
        super(1, place);
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
     * @throws BadEntryException 
     */
    @Override
    public void trigger() throws BadEntryException {
        this.getPlace().remove(this.getPlace().getToken());
    }
}
