package org.pneditor.petrinet.adapters.lerquemain_rabilloud;

import org.pneditor.petrinet.AbstractArc;
import org.pneditor.petrinet.AbstractNode;
import org.pneditor.petrinet.AbstractPlace;
import org.pneditor.petrinet.AbstractTransition;
import org.pneditor.petrinet.PetriNetInterface;
import org.pneditor.petrinet.ResetArcMultiplicityException;
import org.pneditor.petrinet.UnimplementedCaseException;


public class AdapterInterface extends PetriNetInterface{

	@Override
	public AbstractPlace addPlace() {
		PlaceAdapter place = new PlaceAdapter("label");
		return place;
	}

	@Override
	public AbstractTransition addTransition() {
		TransitionAdapter transition = new TransitionAdapter("label");
		return transition;
	}

	@Override
	public AbstractArc addRegularArc(AbstractNode source, AbstractNode destination) throws UnimplementedCaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractArc addInhibitoryArc(AbstractPlace place, AbstractTransition transition)
			throws UnimplementedCaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractArc addResetArc(AbstractPlace place, AbstractTransition transition)
			throws UnimplementedCaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removePlace(AbstractPlace place) {
		place = null;
	}

	@Override
	public void removeTransition(AbstractTransition transition) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeArc(AbstractArc arc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEnabled(AbstractTransition transition) throws ResetArcMultiplicityException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void fire(AbstractTransition transition) throws ResetArcMultiplicityException {
		// TODO Auto-generated method stub
		
	}

}
