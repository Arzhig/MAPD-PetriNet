package org.pneditor.petrinet.adapters.lerquemain_rabilloud;
import org.pneditor.petrinet.AbstractArc;
import org.pneditor.petrinet.AbstractNode;
import org.pneditor.petrinet.ResetArcMultiplicityException;
import org.pneditor.petrinet.models.lerquemain_rabilloud.Edge;
import org.pneditor.petrinet.models.lerquemain_rabilloud.EdgeEmpty;
import org.pneditor.petrinet.models.lerquemain_rabilloud.EdgeIn;
import org.pneditor.petrinet.models.lerquemain_rabilloud.EdgeOut;
import org.pneditor.petrinet.models.lerquemain_rabilloud.EdgeZero;

public class EdgeAdapter extends AbstractArc{
	
	private Edge edge;
	
	public EdgeAdapter(Edge edge) {
		this.edge = edge;
	}
	
	public Edge getEdge() {
		return this.edge;
	}
	
	/**
	 * Indicates whether the node is the connected to the arc or not
	 * @param node a place or a transition potentially linked to the arc
	 * @return true if the node is connected to the arc; false otherwise
	 */
	public boolean isLinked(AbstractNode node) {
		return this.getSource().equals(node) || this.getDestination().equals(node);
	}
	
	/**
	 * Gives the source of the arc
	 * @return a node, the source of the arc
	 */
	public AbstractNode getSource() {
		if (this.getEdge() instanceof EdgeOut) {
			return new PlaceAdapter("", this.getEdge().getPlace());
		}
		
		return new TransitionAdapter("", this.getEdge().getTransition());
	}

	/**
	 * Gives the destination of the arc
	 * @return a node, the source of the arc
	 */
	@Override
	public AbstractNode getDestination() {
		if (this.getEdge() instanceof EdgeIn) {
			return new PlaceAdapter("", this.getEdge().getPlace());
		}
		
		return new TransitionAdapter("", this.getEdge().getTransition());
	}

	/**
	 * Indicates whether the arc is reset or not
	 * @return true if the arc is reset; false otherwise
	 */
	@Override
	public boolean isReset() {
		return this.getEdge().getClass() == EdgeEmpty.class;
	}

	/**
	 * Indicates whether the arc is regular or not
	 * @return true if the arc is regular; false otherwise
	 */
	@Override
	public boolean isRegular() {
		return !(this.isReset() && this.isInhibitory());
	}

	/**
	 * Indicates whether the arc is inhibitory or not
	 * @return true if the arc is inhibitory; false otherwise
	 */
	@Override
	public boolean isInhibitory() {
		return this.getEdge().getClass() == EdgeZero.class;
	}

	/**
	 * Gives the multiplicity of the arc
	 * @return the value of the arc
	 */
	@Override
	public int getMultiplicity() throws ResetArcMultiplicityException {
		if (this.isReset()) {
			throw new ResetArcMultiplicityException();
		}
		return this.getEdge().getValue();
	}

	/**
	 * Modifies the multiplicity of the arc
	 * @param multiplicity the new value of the arc, a positive integer
	 */
	@Override
	public void setMultiplicity(int multiplicity) throws ResetArcMultiplicityException {
		if (multiplicity < 0) {
			throw new ResetArcMultiplicityException();
		}
		this.getEdge().setValue(multiplicity);
	}
}
