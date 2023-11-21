package org.pneditor.petrinet.models.imta.lerquemain_rabilloud;

/**
 * @author Quentin Rabilloud
 *
 * <i>DoubleEdgeException</i> is raised when two or more edges are created in a <i>PetriNet</i>
 * between a place and a transition.
 *
 */

@SuppressWarnings("serial")
public class DoubleEdgeException extends StructureException {
	
	public DoubleEdgeException(String msg) {
		super(msg);
	}
	
}