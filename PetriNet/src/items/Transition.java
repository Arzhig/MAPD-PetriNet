package items;
import java.util.List;
import items.edge.EdgeIn;
import items.edge.EdgeOut;

public class Transition {
	
	//private fields
	
	private List<EdgeOut> outEdges;
	private List<EdgeIn> inEdges;
	
	public Transition() {
		
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
}
