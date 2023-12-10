package org.pneditor.petrinet.adapters.lerquemain_rabilloud;
import org.pneditor.petrinet.AbstractArc;
import org.pneditor.petrinet.AbstractNode;
import org.pneditor.petrinet.ResetArcMultiplicityException;
import org.pneditor.petrinet.models.lerquemain_rabilloud.Edge;
import org.pneditor.petrinet.models.lerquemain_rabilloud.EdgeEmpty;
import org.pneditor.petrinet.models.lerquemain_rabilloud.EdgeIn;
import org.pneditor.petrinet.models.lerquemain_rabilloud.EdgeOut;
import org.pneditor.petrinet.models.lerquemain_rabilloud.EdgeZero;


/**
 * The EdgeAdapter class allows to connect the Edge class in our model to the PNE standards.
 * This class stores information about an edge and gives methods to use it.
 * 
 * @author Quentin Rabilloud
 */
public class EdgeAdapter extends AbstractArc{
	
	private Edge edge;
	
	
	/**
     * Constructs a new edge adapter with an edge from the model.
     *
     * @param edge the edge to adapt.
     */
	public EdgeAdapter(Edge edge) {
		this.edge = edge;
	}
	
	/**
     * Returns the edge associated to the adapter.
     *
     * @return edge the associated to the adapter.
     */
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
		return this.getEdge().isEdgeEmpty();
	}

	/**
	 * Indicates whether the arc is regular or not
	 * @return true if the arc is regular; false otherwise
	 */
	@Override
	public boolean isRegular() {
		return !(this.isReset() || this.isInhibitory());
	}

	/**
	 * Indicates whether the arc is inhibitory or not
	 * @return true if the arc is inhibitory; false otherwise
	 */
	@Override
	public boolean isInhibitory() {
		return this.getEdge().isEdgeZero();
	}

	/**
	 * Gives the multiplicity of the arc
	 * @return the value of the arc
	 * @throws ResetArcMultiplicityException
	 */
	@Override
	public int getMultiplicity() throws ResetArcMultiplicityException {
		if (this.isReset()) {
			System.out.println("Why do we try to get the multiplicity of an EdgeEmpty ???");
			throw new ResetArcMultiplicityException();
		}
		return this.getEdge().getValue();
	}

	/**
	 * Modifies the multiplicity of the arc
	 * @param multiplicity the new value of the arc, a positive integer
	 * @throws ResetArcMultiplicityException
	 */
	@Override
	public void setMultiplicity(int multiplicity) throws ResetArcMultiplicityException {
		if (multiplicity < 0) {
			throw new ResetArcMultiplicityException();
		}
		this.getEdge().setValue(multiplicity);
	}
}
