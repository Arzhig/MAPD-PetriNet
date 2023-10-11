package items.edge;
import items.*;

public class EdgeZero extends EdgeOut{

	public EdgeZero(int value, Place place) {
		super(value, place);
	}
	
	public boolean isTriggerable() {
		return(this.place.getToken()==0);
	}
	
	public void trigger() {
		this.place.remove(0);
	}

}
