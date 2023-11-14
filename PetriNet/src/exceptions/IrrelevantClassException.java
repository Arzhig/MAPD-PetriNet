package exceptions;

/**
 * @author Quentin Rabilloud
 *
 * <i>IrrelevantClassException</i> is raised when an instance is created with an irrelevant type, for example an 
 * <i>EdgeOut</i> instead of an <i>EdgeEmpty</i>.
 *
 */

@SuppressWarnings("serial")
public class IrrelevantClassException extends StructureException {
	
	public IrrelevantClassException(String msg) {
		super(msg);
	}
}
