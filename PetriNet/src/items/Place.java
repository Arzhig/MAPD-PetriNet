package items;

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
	
	public Place(int token) {
		this.token = token;
	}
	
	public int getToken() {
		return this.token;
	}
	
	private void setToken(int newToken) {
		this.token = newToken;
	}
	
	/**adds a specified number of tokens to the place*/
	
	public void add(int aTokens) {
		this.setToken(this.getToken() + aTokens); 
	}
	
	/*removes a specified numbers of tokens to the place*/
	
	public void remove(int rTokens) {
		this.setToken(this.getToken() - rTokens);
	}

}
