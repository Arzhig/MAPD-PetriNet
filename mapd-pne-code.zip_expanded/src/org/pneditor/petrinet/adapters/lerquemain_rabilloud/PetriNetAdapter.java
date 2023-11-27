package org.pneditor.petrinet.adapters.lerquemain_rabilloud;

import org.pneditor.petrinet.AbstractArc;
import org.pneditor.petrinet.AbstractNode;
import org.pneditor.petrinet.AbstractPlace;
import org.pneditor.petrinet.AbstractTransition;
import org.pneditor.petrinet.PetriNetInterface;
import org.pneditor.petrinet.ResetArcMultiplicityException;
import org.pneditor.petrinet.UnimplementedCaseException;
import org.pneditor.petrinet.models.lerquemain_rabilloud.EdgeEmpty;
import org.pneditor.petrinet.models.lerquemain_rabilloud.EdgeIn;
import org.pneditor.petrinet.models.lerquemain_rabilloud.EdgeOut;
import org.pneditor.petrinet.models.lerquemain_rabilloud.EdgeZero;
import org.pneditor.petrinet.models.lerquemain_rabilloud.Place;
import org.pneditor.petrinet.models.lerquemain_rabilloud.Transition;


public class PetriNetAdapter extends PetriNetInterface{

	@Override
	public AbstractPlace addPlace() {
		PlaceAdapter placeAd = new PlaceAdapter("", new Place());
		return placeAd;
	}

	@Override
	public AbstractTransition addTransition() {
		TransitionAdapter transition = new TransitionAdapter("", new Transition());
		return transition;
	}

	@Override
	public AbstractArc addRegularArc(AbstractNode source, AbstractNode destination) throws UnimplementedCaseException {
		if (source.getClass() == PlaceAdapter.class) { // if the condition is true it means we add an EdgeOut
			PlaceAdapter souPlace = (PlaceAdapter)source;
			TransitionAdapter desTransition = (TransitionAdapter)destination;
			EdgeOut edge = new EdgeOut(souPlace.getPlace(), desTransition.getTransition());
			EdgeAdapter edgeOutAdapted = new EdgeAdapter(edge);
			desTransition.getTransition().add(edge);
			return edgeOutAdapted;
		}
		TransitionAdapter souTransition = (TransitionAdapter)source;
		PlaceAdapter desPlace = (PlaceAdapter)destination;
		EdgeIn edge = new EdgeIn(souTransition.getTransition(), desPlace.getPlace());
		EdgeAdapter edgeInAdapted = new EdgeAdapter(edge);
		souTransition.getTransition().add(edge);
		return edgeInAdapted;
	}

	@Override
	public AbstractArc addInhibitoryArc(AbstractPlace place, AbstractTransition transition)
			throws UnimplementedCaseException {
		PlaceAdapter aPlace = (PlaceAdapter)place;
		TransitionAdapter aTransition = (TransitionAdapter)transition;
		EdgeZero edge = new EdgeZero(aPlace.getPlace(), aTransition.getTransition());
		EdgeAdapter edgeZeroAdapted = new EdgeAdapter(edge);
		aTransition.getTransition().add(edge);
		return edgeZeroAdapted;
	}

	@Override
	public AbstractArc addResetArc(AbstractPlace place, AbstractTransition transition)
			throws UnimplementedCaseException {
		PlaceAdapter aPlace = (PlaceAdapter)place;
		TransitionAdapter aTransition = (TransitionAdapter)transition;
		EdgeEmpty edge = new EdgeEmpty(aPlace.getPlace(), aTransition.getTransition());
		EdgeAdapter edgeEmptyAdapted = new EdgeAdapter(edge);
		aTransition.getTransition().add(edge);
		return edgeEmptyAdapted;
	}

	@Override
	public void removePlace(AbstractPlace place) {
		
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
