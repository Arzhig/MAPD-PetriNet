package org.pneditor.petrinet.models.lerquemain_rabilloud;

/**
 * The `EdgeOut` class represents an edge in a Petri net simulation, going out of a Place and into a transition.
 * This class extends 'Edge',and has the ability to trigger.
 * 
 * @author Yann Lerquemain
 */
public class EdgeOut extends Edge{
	/**
     * Constructs a new EdgeOut with the specified value, transition and place.
     *
     * @param value      The value associated with the EdgeOut.
     * @param transition      The transition connected by the EdgeOut.
     * @param place      The place connected by the EdgeOut.
	 * @throws IncorrectArgumentException 
     */
	public EdgeOut(Place place, Transition transition, int value) throws PetriNetException {
		super(value, place, transition);
		if (value < -1) {
			throw new IncorrectArgumentException("EdgeOut can't have a negative value");
		}
		else if (value == -1 && this.getClass() != EdgeEmpty.class) {
			throw new IrrelevantClassException("Consider adding an EdgeEmpty instead");
		}
		else if (value == 0 && this.getClass() != EdgeZero.class) {
			throw new IrrelevantClassException("Consider adding an EdgeZero instead");
		}
	}
	
	/**
     * Constructs a new EdgeOut with the specified transition and place, with a default value of 1.
     *
     * @param transition      The transition connected by the EdgeOut.
     * @param place      The place connected by the EdgeOut.
     */
	public EdgeOut(Place place, Transition transition) {
		super(1, place, transition);
	}
	
	/**
     * Constructs a new EdgeOut with the specified value, transition and place.
     * This constructor is only accessible by EdgeEmpty and EdgeZero, it is built
     * so that it does not throw an exception, when we are sure that the given value is valid.
     *
     * @param value      The value associated with the EdgeOut.
     * @param transition      The transition connected by the EdgeOut.
     * @param place      The place connected by the EdgeOut.
     */
	protected EdgeOut(int value, Place place, Transition transition) {
		super(value, place, transition);
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
	
	public boolean equals(Object o) {
		if (o != null && o instanceof EdgeOut) {
			return this.getPlace().equals(((EdgeOut)o).getPlace()) && this.getTransition().equals(((EdgeOut)o).getTransition());
		}
		return false;
	}

}
