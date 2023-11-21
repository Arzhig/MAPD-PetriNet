package org.pneditor.petrinet.adapters.imta.lerquemain_rabilloud;

import org.pneditor.petrinet.AbstractTransition;
import org.pneditor.petrinet.models.imta.lerquemain_rabilloud.*;

public class TransitionAdapter extends AbstractTransition {
	private Transition transition;
	
	public TransitionAdapter(String label) {
		super(label);
		this.transition = new Transition();
	}
}
