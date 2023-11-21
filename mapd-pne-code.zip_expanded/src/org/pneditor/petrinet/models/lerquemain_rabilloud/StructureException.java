package org.pneditor.petrinet.models.lerquemain_rabilloud;

/**
 * @author Quentin Rabilloud
 *
 * <i>StructureException</i> is the mother class for <i>DoubleEdgeException</i> and <i>IrrelevantClassException</i>.
 *
 */

@SuppressWarnings("serial")
public class StructureException extends PetriNetException {
	
	public StructureException(String msg) {
		super(msg);
	}

}
