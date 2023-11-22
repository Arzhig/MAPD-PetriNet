package org.pneditor.petrinet.adapters.lerquemain_rabilloud;

import org.pneditor.petrinet.AbstractTransition;
import org.pneditor.petrinet.models.lerquemain_rabilloud.*;

public class TransitionAdapter extends AbstractTransition {
	
	private Transition transition;
	
	public TransitionAdapter(String label, Transition transition) {
		super(label);
		this.transition = transition;
	}
}