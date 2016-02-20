package jstackui.controller;

import javax.swing.JPanel;

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

}
