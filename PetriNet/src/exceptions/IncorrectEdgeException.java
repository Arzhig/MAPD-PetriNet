package exceptions;


/**
 * @author Quentin Rabilloud
 *
 * <i>IncorrectEdgeException</i> is the mother class for BadEntryException and DoubleEdgeException.
 *
 */

@SuppressWarnings("serial")
public class IncorrectEdgeException extends Exception {
	
	public IncorrectEdgeException(String msg) {
		super(msg);
	}

}
