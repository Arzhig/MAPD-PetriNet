package org.pneditor.petrinet.adapters.imta.lerquemain_rabilloud;

import org.pneditor.petrinet.*;
import org.pneditor.petrinet.models.imta.lerquemain_rabilloud.*;

public class PlaceAdapter extends AbstractPlace {
	
	private Place place;
	
	public PlaceAdapter(String label){
		super(label);
		try {
			this.place = new Place(0);
		} catch (IncorrectArgumentException e) {
		}
	}

	@Override
	public void addToken() {
		this.place.add(1);
	}

	@Override
	public void removeToken() {
		try {
			this.place.remove(1);
		} catch (IncorrectArgumentException e) {
		}
		
	}

	@Override
	public int getTokens() {
		return this.place.getToken();
	}

	@Override
	public void setTokens(int tokens) {
		this.place.setToken(tokens);
		
	}

}
