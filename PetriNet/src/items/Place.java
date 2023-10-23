package items;

import exceptions.*;

/**
 * The Place class represents a place in a Petri net simulation, containing tokens.
 * Each place stores a number of tokens evolving during the simulation.
 * 
 * @author Quentin Rabilloud
 */

public class Place {
	
	//private fields
	
	//the current number of tokens in the place
	private int token;
	
	public Place(int token) throws BadEntryException{
		if (token>=0) {
			this.token = token;
		}
		else {
			throw new BadEntryException("Token amount is negative");
		}
	}
	
	/**
	* @return current number of tokens in the place
	*/
	
	public int getToken() {
		return this.token;
	}
	
	/**
	* Changes the current number of tokens in the place
	* @param newToken new number of tokens in the place
	*/
	
	private void setToken(int newToken) {
		this.token = newToken;
	}
	
	/**
	* Adds a specified number of tokens to the place
	* @param aTokens number of tokens added to the place
	*/
	
	public void add(int aTokens) {
		this.setToken(this.getToken() + aTokens); 
	}
	
	/**
	* Removes a specified number of tokens to the place
	* @param rTokens number of tokens removed from the place
	*/
	
	public void remove(int rTokens) {
		this.setToken(this.getToken() - rTokens);
	}

}
