package jstackui.controller;

import java.util.EmptyStackException;

import javax.swing.JPanel;

import jstackui.exceptions.UndefinedPanelException;

/**
 * This class consists exclusively to create an interface between JStackUI (the
 * frame) and UIStack (stack of panels).
 * 
 * @author porthunt
 * @see JStackUI
 * @see UIStack
 * @since 0.1
 */

public class JStackCore {

	UIStack uiStack;

	/**
	 * Creates an empty UIStack stack, pushing <b>panel</b> as the first panel
	 * on the stack.
	 * 
	 * @param panel
	 *            the panel to push as the first item on your stack.
	 */

	public JStackCore(JPanel panel) {
		uiStack = new UIStack();
		uiStack.push(panel);
	}

	/**
	 * Prints the name of all the panels of your stack.
	 */

	public void show() {
		uiStack.show();
	}

	/**
	 * Adds a panel on the stack.
	 * 
	 * @param panel
	 *            the panel to be pushed to the stack.
	 */
	public void addPanel(JPanel panel) {
		uiStack.addToStack(panel);
	}

	/**
	 * Gets the current panel of your stack.
	 * 
	 * @return the current panel
	 */
	public JPanel getCurrentPanel() {
		return uiStack.getLastElement();
	}

	/**
	 * Removes the last item from the stack. Uses the next panel as the panel
	 * frame.
	 */
	public JPanel back() {
		uiStack.removeFromStack();
		return uiStack.getLastElement();
	}

	/**
	 * Removes n panels from the stack. Uses the next panel as the panel frame.
	 * If n is bigger than the stack size, it removes everything but the first
	 * inserted panel.
	 * 
	 * @param n number of elements to be popped of the stack.
	 */
	public JPanel back(int n) {

		if (n > uiStack.size()) {
			n = uiStack.size() - 1;
		}

		for (int i = 0; i < n-1; i++) {
			this.back();
		}
		
		return this.back();

	}

	/**
	 * Removes every panel of the stack, but leaves the first inserted.
	 * @return
	 */
	public JPanel restart() {
		return uiStack.removeAllFromStack();
	}

}
