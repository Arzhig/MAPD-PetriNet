package items.edge;
import items.*

public class EdgeEmpty extends EdgeOut{

	public EdgeEmpty(int value, Transition transition, Place place) {
		super(value, transition, place);
	}
	
	public boolean isTriggerable() {
		return(this.place.getToken()>0);
	}
	
	public void trigger() {
		this.place.remove(this.place.getToken());
	}
}
