package items.edge;
import items.*;

public class EdgeEmpty extends EdgeOut{

	public EdgeEmpty(int value, Place place) {
		super(value, place);
	}
	
	public boolean isTriggerable() {
		return(this.getPlace().getToken()>0);
	}
	
	public void trigger() {
		this.getPlace().remove(this.getPlace().getToken());
	}
}
