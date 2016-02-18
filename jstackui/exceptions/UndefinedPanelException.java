package jstackui.exceptions;

@SuppressWarnings("serial")
public class UndefinedPanelException extends Exception {

	public UndefinedPanelException(){
		super();
		System.err.println("Panel can't be null.");
	}
	
}
