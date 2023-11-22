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
	
	public EdgeAdapter() {
		
	}
	
	private Edge getEdge() {
		return this.edge;
	}
	
	public AbstractNode getSource() {
		if (this.getEdge() instanceof EdgeOut) {
			return new PlaceAdapter("", this.getEdge().getPlace());
		}
		
		return new TransitionAdapter("", this.getEdge().getTransition());
	}

	@Override
	public AbstractNode getDestination() {
		if (this.getEdge() instanceof EdgeIn) {
			return new PlaceAdapter("", this.getEdge().getPlace());
		}
		
		return new TransitionAdapter("", this.getEdge().getTransition());
	}

	@Override
	public boolean isReset() {
		return this.getEdge().getClass() == EdgeEmpty.class;
	}

	@Override
	public boolean isRegular() {
		return !(this.isReset() && this.isInhibitory());
	}

	@Override
	public boolean isInhibitory() {
		return this.getEdge().getClass() == EdgeZero.class;
	}

	@Override
	public int getMultiplicity() throws ResetArcMultiplicityException {
		if (this.isReset()) {
			throw new ResetArcMultiplicityException();
		}
		return this.getEdge().getValue();
	}

	@Override
	public void setMultiplicity(int multiplicity) throws ResetArcMultiplicityException {
		if (multiplicity < 0) {
			throw new ResetArcMultiplicityException();
		}
		this.getEdge().setValue(multiplicity);
	}
}
