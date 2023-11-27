package org.pneditor.petrinet.adapters.lerquemain_rabilloud;

import org.pneditor.petrinet.AbstractTransition;
import org.pneditor.petrinet.models.lerquemain_rabilloud.*;

public class TransitionAdapter extends AbstractTransition {
	
	private Transition transition;
	
	public TransitionAdapter(String label, Transition transition) {
		super(label);
		this.transition = transition;
	}
	
	public Transition getTransition() {
		return this.transition;
	}
	
	public boolean equals(Object o) {
		if (o != null && o.getClass() == TransitionAdapter.class) {
			return ((TransitionAdapter)o).getTransition().equals(this.getTransition());
		}
		return false;
	}
}
