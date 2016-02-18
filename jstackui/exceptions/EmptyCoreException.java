package jstackui.exceptions;

@SuppressWarnings("serial")
public class EmptyCoreException extends Exception {

	public EmptyCoreException(){
		super();
		System.err.println("No frame instantiated as a default frame.");
	}
	
}
