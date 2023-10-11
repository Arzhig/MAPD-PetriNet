package items.edge;
import items.*;

public class EdgeOut extends Edge{

	public EdgeOut(int value, Transition transition, Place place) {
		super(value, transition, place);
	}

	public boolean isTriggerable() {
		return(this.place.getToken()>=this.value);
	}
	
	public void trigger() {
		this.place.remove(value);
	}

}
