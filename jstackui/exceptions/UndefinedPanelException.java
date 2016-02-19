package jstackui.exceptions;

import jstackui.view.JStackUI;

/**
 * This exception was created to avoid a null inserted on the stack. If the user
 * tries to use a null as the panel, this exception is raised.
 * 
 * @author porthunt
 * @see JStackUI
 * @since 0.1
 */

@SuppressWarnings("serial")
public class UndefinedPanelException extends Exception {

	public UndefinedPanelException() {
		super();
		System.err.println("Panel can't be null.");
	}

}
