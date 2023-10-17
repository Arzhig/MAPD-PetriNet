package items;
import java.util.LinkedList;
import java.util.List;
import items.edge.EdgeIn;
import items.edge.EdgeOut;

public class Transition {
	
	//private fields
	
	private List<EdgeOut> outEdges;
	private List<EdgeIn> inEdges;
	
	public Transition() {
		this.outEdges = new LinkedList<EdgeOut>();
		this.inEdges = new LinkedList<EdgeIn>();
	}
	
	public List<EdgeOut> getOutEdges(){
		return this.outEdges;
	}
	
	public List<EdgeIn> getInEdges(){
		return this.inEdges;
	}
	
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
	
	public void add(EdgeOut outEdge) {
		this.getOutEdges().add(outEdge);
	}
	
	public void add(EdgeIn inEdge) {
		this.getInEdges().add(inEdge);
	}
	
	public void remove(EdgeOut outEdge) {
		this.getOutEdges().remove(outEdge);
	}
	
	public void remove(EdgeIn inEdge) {
		this.getInEdges().remove(inEdge);
	}
}
