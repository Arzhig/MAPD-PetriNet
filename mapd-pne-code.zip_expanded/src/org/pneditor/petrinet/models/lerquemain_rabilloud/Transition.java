package org.pneditor.petrinet.models.lerquemain_rabilloud;
import java.util.LinkedList;
import java.util.List;


/**
 * The Transition class represents a transition in a Petri net.
 * A transition is connected to places, upstream and downstream, by edges.
 * 
 * @author Quentin Rabilloud
 */

public class Transition {
	
	//private fields
	
	private List<EdgeOut> outEdges;
	private List<EdgeIn> inEdges;
	
	/**
     * Constructs a new transition and initializes empty lists of edges.
     */
	public Transition() {
		this.outEdges = new LinkedList<EdgeOut>();
		this.inEdges = new LinkedList<EdgeIn>();
	}
	
	/**
	* @return the list of edges going out of a place and linked to the transition
	*/
	public List<EdgeOut> getOutEdges(){
		return this.outEdges;
	}
	
	/**
	* @return the list of edges linked to the transition and going in a place
	*/
	public List<EdgeIn> getInEdges(){
		return this.inEdges;
	}
	
	/**
	* Tests if the transition is triggerable
	 * @return true if the transition is triggerable; false otherwise 
	*/
	public boolean isTriggerable() {
		boolean isTriggerable = true;
		for (EdgeOut outEdge : outEdges) {
			isTriggerable = outEdge.isTriggerable() && isTriggerable;
		}
		return isTriggerable;
	}
	
	/**
	* Tests if the transition is triggerable, and if it's the case then fires it
	 * @throws IncorrectArgumentException 
	*/
	public void step() throws IncorrectArgumentException {
		if (this.isTriggerable()) {
			for (EdgeOut outEdge : outEdges) {
				outEdge.trigger();
			}
			for (EdgeIn inEdge : inEdges) {
				inEdge.trigger();
			}
		}
	}
	
	/** 
	* Connects an edge coming from a place to the transition
	* @param outEdge an edge coming from a place
	*/
	public void add(EdgeOut outEdge) throws DoubleEdgeException {
		if (this.getOutEdges().contains(outEdge)) {
			throw new DoubleEdgeException("An arc is already created between this source and destination");
		}
		outEdge.setTransition(this);
		this.getOutEdges().add(outEdge);
	}
	
	/** 
	* Connects an edge going to a place to the transition
	* @param inEdge an edge going to a place
	*/
	public void add(EdgeIn inEdge) throws DoubleEdgeException {
		if (this.getInEdges().contains(inEdge)) {
			throw new DoubleEdgeException("An arc is already created between this source and destination");
		}
		inEdge.setTransition(this);
		this.getInEdges().add(inEdge);
	}
	
	/** 
	* Removes an edge coming from a place to the transition
	* @param outEdge an edge coming from a place
	*/
	public void remove(EdgeOut outEdge) {
		this.getOutEdges().remove(outEdge);
	}
	
	/** 
	* Removes an edge going to a place to the transition
	* @param outEdge an edge going to a place
	*/
	public void remove(EdgeIn inEdge) {
		this.getInEdges().remove(inEdge);
	}
}
