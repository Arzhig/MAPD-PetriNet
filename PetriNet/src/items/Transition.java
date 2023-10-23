package items;
import java.util.LinkedList;
import java.util.List;
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
	*/
	public void step() {
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
