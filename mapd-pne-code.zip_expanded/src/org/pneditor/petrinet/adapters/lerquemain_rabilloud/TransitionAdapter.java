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
	
	public boolean isTriggerable() {
		return this.getTransition().isTriggerable();
	}
	
	public void step() {
		try {
			this.getTransition().step();
		}
		catch (IncorrectArgumentException e) {
			
		}
	}
	
	public void add(EdgeIn inEdge) throws DoubleEdgeException {
		this.getTransition().add(inEdge);
	}
	
	public void add(EdgeOut outEdge) throws DoubleEdgeException {
		this.getTransition().add(outEdge);
	}
	
	public boolean equals(Object o) {
		if (o != null && o.getClass() == TransitionAdapter.class) {
			return ((TransitionAdapter)o).getTransition().equals(this.getTransition());
		}
		return false;
	}
}
