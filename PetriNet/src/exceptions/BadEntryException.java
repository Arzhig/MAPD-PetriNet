package exceptions;

/**
 * <i>BadEntryException</i> is raised when some <i>PetriNet</i> method is called
 * with a non-correct parameter value.
 * 
 */

@SuppressWarnings("serial")
public class BadEntryException extends Exception {

	public BadEntryException(String message) {
		super(message);
	}
}
