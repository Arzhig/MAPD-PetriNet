package org.pneditor.petrinet.adapters.lerquemain_rabilloud;
import org.pneditor.petrinet.AbstractArc;
import org.pneditor.petrinet.AbstractNode;
import org.pneditor.petrinet.ResetArcMultiplicityException;
import org.pneditor.petrinet.models.lerquemain_rabilloud.Edge;
import org.pneditor.petrinet.models.lerquemain_rabilloud.Place;

public class EdgeAdapter extends AbstractArc{
	
	private int value;
	private AbstractNode source;
	private AbstractNode destination;
	
	public EdgeAdapter(int value, AbstractNode source, AbstractNode destination) {
		this.value = value;
		this.source = source;
		this.destination = destination;
	}
	
	private int getValue() {
		return this.value;
	}
	
	public AbstractNode getSource() {
		return this.source;
	}

	@Override
	public AbstractNode getDestination() {
		return this.destination;
	}

	@Override
	public boolean isReset() {
		// TODO Auto-generated method stub
		return this.getValue() == -1;
	}

	@Override
	public boolean isRegular() {
		return this.getValue() > 0;
	}

	@Override
	public boolean isInhibitory() {
		return this.getValue() == 0;
	}

	@Override
	public int getMultiplicity() throws ResetArcMultiplicityException {
		if (this.isReset()) {
			throw new ResetArcMultiplicityException();
		}
		return this.getValue();
	}

	@Override
	public void setMultiplicity(int multiplicity) throws ResetArcMultiplicityException {
		this.value = multiplicity;
	}
}
