package controller;

import java.util.Iterator;
import java.util.Stack;

import view.JNovaPanel;

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
public class UIStack extends Stack<JNovaPanel> {

	JNovaPanel current;

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
		Iterator<JNovaPanel> iterator = this.iterator();

		while (iterator.hasNext()) {
			JNovaPanel next = iterator.next();
			if (next != current) {
				System.out.println(next.getName());
			} else {
				System.out.println(next.getName() + " <");
			}
		}

		System.out.println("-END-\n");
	}

	/**
	 * Adds a panel on the stack.
	 * 
	 * @param panel
	 *            the panel to be added on the stack.
	 */
	protected void addToStack(JNovaPanel panel) {
		this.push(panel);
		current = panel;
	}

	/**
	 * Pops the element of the stack and sets the new current.
	 * 
	 * @return the popped element
	 */
	protected JNovaPanel removeFromStack() {
		JNovaPanel panel = this.pop();
		current = this.peek();
		return panel;
	}

	/**
	 * Gets the last element added on the stack.
	 * 
	 * @return the last element of the stack
	 */
	protected JNovaPanel getLastElement() {
		return this.peek();
	}

}
