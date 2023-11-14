package exceptions;

/**
 * @author Quentin Rabilloud
 *
 * <i>PetriNetException</i> is a mother class for all the exceptions used in <i>PetriNet</i>.
 *
 */

@SuppressWarnings("serial")
public class PetriNetException extends Exception {
	
	public PetriNetException(String msg) {
		super(msg);
	}

}
