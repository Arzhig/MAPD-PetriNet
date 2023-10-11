package items.edge;
import items.*;

public class EdgeIn extends Edge{

	public EdgeIn(int value, Transition transition, Place place) {
		super(value, transition, place);
	}
	
	public void trigger() {
		this.place.add(value);
	}

}
