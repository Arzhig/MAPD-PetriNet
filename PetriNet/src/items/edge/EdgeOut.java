package items.edge;
import items.*;

public class EdgeOut extends Edge{

	public EdgeOut(int value, Place place) {
		super(value, place);
	}

	public boolean isTriggerable() {
		return(this.getPlace().getToken()>=this.getValue());
	}
	
	public void trigger() {
		this.getPlace().remove(this.getValue());
	}

}
