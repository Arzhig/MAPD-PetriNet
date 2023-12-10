package org.pneditor.petrinet.adapters.lerquemain_rabilloud;

import org.pneditor.petrinet.AbstractArc;
import org.pneditor.petrinet.AbstractNode;
import org.pneditor.petrinet.AbstractPlace;
import org.pneditor.petrinet.AbstractTransition;
import org.pneditor.petrinet.PetriNetInterface;
import org.pneditor.petrinet.ResetArcMultiplicityException;
import org.pneditor.petrinet.UnimplementedCaseException;
import org.pneditor.petrinet.models.lerquemain_rabilloud.DoubleEdgeException;
import org.pneditor.petrinet.models.lerquemain_rabilloud.EdgeEmpty;
import org.pneditor.petrinet.models.lerquemain_rabilloud.EdgeIn;
import org.pneditor.petrinet.models.lerquemain_rabilloud.EdgeOut;
import org.pneditor.petrinet.models.lerquemain_rabilloud.EdgeZero;
import org.pneditor.petrinet.models.lerquemain_rabilloud.Place;
import org.pneditor.petrinet.models.lerquemain_rabilloud.Transition;

import logger.PNEditorLogger;

/**
 * The PetriNetAdapter class allows to connect the model we created to the PNE.
 * This class implements methods to link our model to the PNE, thanks to PetriNetInterface.
 * 
 * @author Quentin Rabilloud
 */
public class PetriNetAdapter extends PetriNetInterface{

	/**
     * Adds a new place adapter with default parameters.
     *
     * @return place the newly place adapter created.
     */
	@Override
	public AbstractPlace addPlace() {
		PlaceAdapter place = new PlaceAdapter("", new Place());
		return place;
	}

	/**
     * Adds a new transition adapter with default parameters.
     *
     * @return transition the newly transition adapter created.
     */
	@Override
	public AbstractTransition addTransition() {
		TransitionAdapter transition = new TransitionAdapter("", new Transition());
		return transition;
	}

	/**
     * Adds a new edge adapter between a source and a destination. The type of edge in the edge adapter
     * depends on the type of source and destination.
     *
     * @param source the source of the edge
     * @param destination the destination of the edge
     * @return edge the newly edge adapter created.
     * @throws UnimplementedCaseException
     */
	@Override
	public AbstractArc addRegularArc(AbstractNode source, AbstractNode destination) throws UnimplementedCaseException {
		if (source.getClass() == PlaceAdapter.class) { // if the condition is true it means we add an EdgeOut
			PlaceAdapter souPlace = (PlaceAdapter)source;
			TransitionAdapter desTransition = (TransitionAdapter)destination;
			EdgeOut edge = new EdgeOut(souPlace.getPlace(), desTransition.getTransition());
			EdgeAdapter edgeOutAdapted = new EdgeAdapter(edge);
			try {
				desTransition.add(edge);
			}
			catch (DoubleEdgeException e) {
				//this exception is thrown to notify that another edge cannot be created because there is already one
				throw new UnimplementedCaseException(e.getMessage());
			}
			return edgeOutAdapted;
		}
		TransitionAdapter souTransition = (TransitionAdapter)source;
		PlaceAdapter desPlace = (PlaceAdapter)destination;
		EdgeIn edge = new EdgeIn(souTransition.getTransition(), desPlace.getPlace());
		EdgeAdapter edgeInAdapted = new EdgeAdapter(edge);
		try {
			souTransition.add(edge);
		}
		catch (DoubleEdgeException e) {
			//this exception is thrown to notify that another edge cannot be created because there is already one
			throw new UnimplementedCaseException(e.getMessage());
		}
		return edgeInAdapted;
	}

	/**
     * Adds a new edge adapter between a place and a transition. The type of edge in the edge adapter
     * is an edge zero.
     *
     * @param place the source of the edge
     * @param transition the destination of the edge
     * @return edge the newly edge adapter created associated to an edge zero.
     * @throws UnimplementedCaseException
     */
	@Override
	public AbstractArc addInhibitoryArc(AbstractPlace place, AbstractTransition transition)
			throws UnimplementedCaseException {
		PlaceAdapter aPlace = (PlaceAdapter)place;
		TransitionAdapter aTransition = (TransitionAdapter)transition;
		EdgeZero edge = new EdgeZero(aPlace.getPlace(), aTransition.getTransition());
		EdgeAdapter edgeZeroAdapted = new EdgeAdapter(edge);
		try {
			aTransition.add(edge);
		}
		catch (DoubleEdgeException e) {
			//this exception is thrown to notify that another edge cannot be created because there is already one
			throw new UnimplementedCaseException(e.getMessage());
		}
		return edgeZeroAdapted;
	}

	/**
     * Adds a new edge adapter between a place and a transition. The type of edge in the edge adapter
     * is an edge empty.
     *
     * @param place the source of the edge
     * @param transition the destination of the edge
     * @return edge the newly edge adapter created associated to an edge empty.
     * @throws UnimplementedCaseException
     */
	@Override
	public AbstractArc addResetArc(AbstractPlace place, AbstractTransition transition)
			throws UnimplementedCaseException {
		PlaceAdapter aPlace = (PlaceAdapter)place;
		TransitionAdapter aTransition = (TransitionAdapter)transition;
		EdgeEmpty edge = new EdgeEmpty(aPlace.getPlace(), aTransition.getTransition());
		EdgeAdapter edgeEmptyAdapted = new EdgeAdapter(edge);
		try {
			aTransition.add(edge);
		}
		catch (DoubleEdgeException e) {
			//this exception is thrown to notify that another edge cannot be created because there is already one
			throw new UnimplementedCaseException(e.getMessage());
		}
		return edgeEmptyAdapted;
	}

	/**
     * Removes a place from the net. It also removes all connected edges.
     *
     * @param place the place to remove
     */
	@Override
	public void removePlace(AbstractPlace place) {
		for (AbstractTransition transition : this.getTransitions()) {
			for (AbstractArc arc : this.getConnectedArcs(transition)) {
				EdgeAdapter edge = (EdgeAdapter)arc;
				if (edge.isLinked(place)) {
					this.removeArc(arc);
				}
			}
		}
	}

	/**
     * Removes a transition from the net. It also removes all connected edges.
     *
     * @param transition the transition to remove
     */
	@Override
	public void removeTransition(AbstractTransition transition) {
		for (AbstractArc arc : this.getConnectedArcs(transition)) {
			this.removeAbstractArc(arc);
		}
	}

	/**
     * Removes an edge from the net.
     *
     * @param arc the edge to remove
     */
	@Override
	public void removeArc(AbstractArc arc) {
		EdgeAdapter edge = (EdgeAdapter)arc;
		if (edge.getDestination().getClass() == TransitionAdapter.class) {
			TransitionAdapter transition = (TransitionAdapter)edge.getDestination();
			transition.getTransition().remove((EdgeOut)edge.getEdge());
		}
		else {
			TransitionAdapter transition = (TransitionAdapter)edge.getSource();
			transition.getTransition().remove((EdgeIn)edge.getEdge());
		}
	}

	/**
	* Tests if the transition is triggerable
	* 
	* @param transition the transition to test
	* @return true if the transition is triggerable; false otherwise 
	*/
	@Override
	public boolean isEnabled(AbstractTransition transition) throws ResetArcMultiplicityException {
		TransitionAdapter adaTransition = (TransitionAdapter)transition;
		return adaTransition.isTriggerable();
	}

	/**
	* Fires the transition if it is triggerable
	* 
	* @param transition the transition to fire 
	*/
	@Override
	public void fire(AbstractTransition transition) throws ResetArcMultiplicityException {
		TransitionAdapter adaTransition = (TransitionAdapter)transition;
		adaTransition.step();
	}

}
