package org.pneditor.petrinet.adapters.lerquemain_rabilloud;
import org.pneditor.petrinet.AbstractArc;
import org.pneditor.petrinet.AbstractNode;
import org.pneditor.petrinet.ResetArcMultiplicityException;
import org.pneditor.petrinet.models.lerquemain_rabilloud.Edge;
import org.pneditor.petrinet.models.lerquemain_rabilloud.EdgeIn;
import org.pneditor.petrinet.models.lerquemain_rabilloud.EdgeOut;

public class EdgeAdapter extends AbstractArc{
	
	private Edge edge;
	
	public EdgeAdapter(Edge edge) {
		this.edge = edge;
	}
	
	private Edge getEdge() {
		return this.edge;
	}
	
	public AbstractNode getSource() {
		if (this.getEdge() instanceof EdgeOut) {
			return new PlaceAdapter("", this.getEdge().getPlace());
		}
		
		return null;
	}

	@Override
	public AbstractNode getDestination() {
		if (this.getEdge() instanceof EdgeIn) {
			return new PlaceAdapter("", this.getEdge().getPlace());
		}
		
		return null;
	}

	@Override
	public boolean isReset() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRegular() {
		return false;
	}

	@Override
	public boolean isInhibitory() {
		return false;
	}

	@Override
	public int getMultiplicity() throws ResetArcMultiplicityException {
		if (this.isReset()) {
			throw new ResetArcMultiplicityException();
		}
		return 0;
	}

	@Override
	public void setMultiplicity(int multiplicity) throws ResetArcMultiplicityException {
		
	}
}
