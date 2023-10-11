package items.edge;
import items.*;

public class EdgeIn extends Edge{

	public EdgeIn(int value, Place place) {
		super(value, place);
	}
	
	public void trigger() {
		this.getPlace().add(this.getValue());
	}

}
