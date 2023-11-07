package items;
import java.util.LinkedList;
import java.util.List;

import exceptions.BadEntryException;
import items.edge.EdgeIn;
import items.edge.EdgeOut;

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
	* Tests if the transition is triggerable, and if it's the case then fires it
	 * @throws BadEntryException 
	*/
	public void step() throws BadEntryException {
		boolean isTriggerable = true;
		for (EdgeOut outEdge : outEdges) {
			isTriggerable = outEdge.isTriggerable() && isTriggerable;
		}
		if (isTriggerable) {
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
	public void add(EdgeOut outEdge) {
		this.getOutEdges().add(outEdge);
	}
	
	/** 
	* Connects an edge going to a place to the transition
	* @param inEdge an edge going to a place
	*/
	public void add(EdgeIn inEdge) {
		this.getInEdges().add(inEdge);
	}
	
	/** 
	* Removes an edge coming from a place to the transition
	* @param outEdge an edge coming from a place
	*/
	public void remove(EdgeOut outEdge) {
		for (int k = 0; k < this.getOutEdges().size(); k++) {
			if ((this.getOutEdges().get(k).getPlace().equals(outEdge.getPlace())) && (this.getOutEdges().get(k).getValue() == outEdge.getValue())) {
				this.getOutEdges().remove(k);
			}
		}
	}
	
	/** 
	* Removes an edge going to a place to the transition
	* @param outEdge an edge going to a place
	*/
	public void remove(EdgeIn inEdge) {
		for (int k = 0; k < this.getInEdges().size(); k++) {
			if ((this.getInEdges().get(k).getPlace().equals(inEdge.getPlace())) && (this.getInEdges().get(k).getValue() == inEdge.getValue())) {
				this.getInEdges().remove(k);
			}
		}
	}
}
