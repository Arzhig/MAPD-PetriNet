package org.pneditor.petrinet.adapters.lerquemain_rabilloud;

import org.pneditor.petrinet.*;
import org.pneditor.petrinet.models.lerquemain_rabilloud.*;

public class PlaceAdapter extends AbstractPlace {
	
	private Place place;
	
	public PlaceAdapter(String label, Place place){
		super(label);
		this.place = place;
	}

	public Place getPlace() {
		return this.place;
	}
	
	@Override
	public int getTokens() {
		return this.getPlace().getToken();
	}

	@Override
	public void setTokens(int tokens) {
		this.getPlace().setToken(tokens);
		
	}
	
	@Override
	public void addToken() {
		this.getPlace().add(1);
	}

	@Override
	public void removeToken() {
		try {
			this.getPlace().remove(1);
		} catch (IncorrectArgumentException e) {
			System.out.println("The number of tokens removed is incorrect.");
		}
		
	}
	
	public boolean equals(Object o) {
		if (o != null && o.getClass() == PlaceAdapter.class) {
			return ((PlaceAdapter)o).getPlace().equals(this.getPlace());
		}
		return false;
	}

}
