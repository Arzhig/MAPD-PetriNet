package exceptions;

/**
 * @author Quentin Rabilloud
 * 
 * <i>IncorrectArgumentException</i> is raised when a method from an item from a <i>PetriNet</i> is called
 * with an incorrect parameter value.
 * 
 */

@SuppressWarnings("serial")
public class IncorrectArgumentException extends PetriNetException {
	
	public IncorrectArgumentException(String msg) {
		super(msg);
	}

}