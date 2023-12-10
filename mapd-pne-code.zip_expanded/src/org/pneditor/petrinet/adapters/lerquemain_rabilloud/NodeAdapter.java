package org.pneditor.petrinet.adapters.lerquemain_rabilloud;

import org.pneditor.petrinet.AbstractNode;
import org.pneditor.petrinet.models.imta.Place;

/**
 * The NodeAdapter class is a theoretical class to represent places and transitions.
 * It is not used in our model.
 * 
 * @author Quentin Rabilloud
 */
public class NodeAdapter extends AbstractNode {

	/**
     * Constructs a new node adapter.
     * @param label the label of the node
     */
	public NodeAdapter(String label) {
		super(label);
	}

	/**
     * Tests if the node is a place.
     * @return true if the node is a place; false otherwise
     */
	@Override
	public boolean isPlace() {
		return this.getClass().equals(Place.class);
	}

}
