package jstackui.controller;

import java.util.Iterator;
import java.util.Stack;

import javax.swing.JPanel;

/**
 * This class consists of a stack to push your panels when you want to move
 * forward/backward. This class is only accessible by the JStackCore. JStackCore
 * controls how the frame will check the Object of this class.
 * 
 * @author porthunt
 * @see JStackCore
 * @since 0.1
 */

@SuppressWarnings("serial")
public class UIStack extends Stack<JPanel> {

	Stack<JPanel> stck;

	/**
	 * Creates a stack of JPanels.
	 */

	protected UIStack() {
		super();
	}

	/**
	 * Prints all panel names of the stack.
	 */

	protected void show() {
		Iterator<JPanel> iterator = this.iterator();

		while (iterator.hasNext()) {
			System.out.println(iterator.next().getName());
		}
	}

}
