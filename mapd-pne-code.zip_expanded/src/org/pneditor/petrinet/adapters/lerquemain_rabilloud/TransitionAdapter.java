package org.pneditor.petrinet.adapters.lerquemain_rabilloud;

import org.pneditor.petrinet.AbstractTransition;
import org.pneditor.petrinet.models.lerquemain_rabilloud.*;

import logger.PNEditorLogger;



/**
 * The TransitionAdapter class allows to connect the Transition class in our model to the PNE standards.
 * This class stores information about a transition and gives methods to use it.
 * 
 * @author Quentin Rabilloud
 */
public class TransitionAdapter extends AbstractTransition {
	
	private Transition transition;
	
	/**
     * Constructs a new transition adapter with a transition from the model.
     * @param label the label of the transition
     * @param transition the transition to adapt
     */
	public TransitionAdapter(String label, Transition transition) {
		super(label);
		this.transition = transition;
	}
	
	/**
     * Returns the transition associated to the adapter.
     *
     * @return transition the transition associated to the adapter.
     */
	public Transition getTransition() {
		return this.transition;
	}
	
	/**
	* Tests if the transition adapter is triggerable
	 * @return true if the transition is triggerable; false otherwise 
	*/
	public boolean isTriggerable() {
		return this.getTransition().isTriggerable();
	}
	
	/**
	* Tests if the transition adapter is triggerable, and if it's the case then fires it
	*/
	public void step() {
		try {
			this.getTransition().step();
		}
		catch (IncorrectArgumentException e) {
			PNEditorLogger.infoLogs(e.getMessage());
		}
	}
	
	/** 
	* Connects an edge going to a place to the transition
	* @param inEdge an edge going to a place
	*/
	public void add(EdgeIn inEdge) throws DoubleEdgeException {
		this.getTransition().add(inEdge);
	}
	
	/** 
	* Connects an edge coming from a place to the transition
	* @param outEdge an edge coming from a place
	*/
	public void add(EdgeOut outEdge) throws DoubleEdgeException {
		this.getTransition().add(outEdge);
	}
	
	/**
	 * Tests if another transition adapter is equals, by comparing the transitions stored
	 * @param o an object to test
	 * @return true if the object is a not null transition adapter and has the same transition; false otherwise
	 */
	@Override
	public boolean equals(Object o) {
		if (o != null && o.getClass() == TransitionAdapter.class) {
			return ((TransitionAdapter)o).getTransition().equals(this.getTransition());
		}
		return false;
	}
}
