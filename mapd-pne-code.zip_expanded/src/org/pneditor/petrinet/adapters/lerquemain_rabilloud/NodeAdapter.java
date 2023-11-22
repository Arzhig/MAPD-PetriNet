package org.pneditor.petrinet.adapters.lerquemain_rabilloud;

import org.pneditor.petrinet.AbstractNode;
import org.pneditor.petrinet.models.imta.Place;

public class NodeAdapter extends AbstractNode {

	public NodeAdapter(String label) {
		super(label);
	}

	@Override
	public boolean isPlace() {
		return this.getClass().equals(Place.class);
	}

}
