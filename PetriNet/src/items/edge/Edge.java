package items.edge;
import items.*;

public class Edge {
	protected int value;
	protected Transition transition;
	protected Place place;
	
	
	public Edge(int value, Transition transition, Place place) {
		this.value = value;
		this.transition = transition;
		this.place = place;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}

	public Transition getTransition() {
		return transition;
	}

	public void setTransition(Transition transition) {
		this.transition = transition;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}
}
