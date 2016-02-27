package exceptions;

import model.CSS;

/**
 * This exception is raised when the user tries to
 * use an invalid CSS property on a component.
 * 
 * @author porthunt
 * @see CSS
 * @since 0.2
 */

@SuppressWarnings("serial")
public class CSSNotValidException extends Exception {

	public CSSNotValidException(String message) {
		super();
		System.err.println("\n"+message+" is not a valid CSS property. [ERROR]");
	}

}
