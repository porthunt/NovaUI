package exceptions;

import view.JNovaUI;

/**
 * This exception was created to avoid a null inserted on the stack. If the user
 * tries to use a null as the panel, this exception is raised.
 * 
 * @author porthunt
 * @see JNovaUI
 * @since 0.1
 */

@SuppressWarnings("serial")
public class CSSNotValidException extends Exception {

	public CSSNotValidException(String message) {
		super();
		System.err.println("\n"+message+" is not a valid CSS property. [ERROR]");
	}

}
