package org.pneditor.petrinet.adapters.lerquemain_rabilloud;

import org.pneditor.petrinet.*;
import org.pneditor.petrinet.models.lerquemain_rabilloud.*;

/**
 * The PlaceAdapter class allows to connect the Place class in our model to the PNE standards.
 * This class stores information about a place and gives methods to use it.
 * 
 * @author Quentin Rabilloud
 */
public class PlaceAdapter extends AbstractPlace {
	
	private Place place;
	
	/**
     * Constructs a new place adapter with a place from the model.
     * @param label the label of the place
     * @param place the place to adapt
     */
	public PlaceAdapter(String label, Place place){
		super(label);
		this.place = place;
	}

	/**
     * Returns the place associated to the adapter.
     *
     * @return place the place associated to the adapter.
     */
	public Place getPlace() {
		return this.place;
	}
	
	/**
     * Returns the number of tokens in the place associated to the adapter.
     *
     * @return place the number of tokens in the place associated to the adapter.
     */
	@Override
	public int getTokens() {
		return this.getPlace().getToken();
	}

	/**
     * Sets the number of tokens to attribute to the place associated to the adapter.
     *
     * @param tokens the number of tokens to attribute to the place associated to the adapter.
     */
	@Override
	public void setTokens(int tokens) {
		this.getPlace().setToken(tokens);
		
	}
	
	/**
     * Adds one token to the place associated to the adapter.
     */
	@Override
	public void addToken() {
		this.getPlace().add(1);
	}

	/**
     * Removes one token to the place associated to the adapter.
     */
	@Override
	public void removeToken() {
		try {
			this.getPlace().remove(1);
		} catch (IncorrectArgumentException e) {
			System.out.println("The number of tokens removed is incorrect.");
		}
		
	}
	
	/**
	 * Tests if another place adapter is equals, by comparing the places stored
	 * @param o an object to test
	 * @return true if the object is a not null place adapter and has the same place; false otherwise
	 */
	@Override
	public boolean equals(Object o) {
		if (o != null && o.getClass() == PlaceAdapter.class) {
			return ((PlaceAdapter)o).getPlace().equals(this.getPlace());
		}
		return false;
	}

}
