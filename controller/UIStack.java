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
	
	JPanel current;

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
			JPanel next = iterator.next();
			if(next != current) {
				System.out.println(next.getName());
			} else {
				System.out.println(next.getName()+" <");
			}
		}
		
		System.out.println("-END-\n");
	}
	
	protected void addToStack(JPanel panel) {
		this.push(panel);
		current = panel;
	}
	
	protected JPanel removeFromStack() {
		JPanel panel =  this.pop();
		current = this.peek();
		return panel;
	}
	
	protected JPanel removeAllFromStack() {
		
		for(int i=0; i <= this.size(); i++) {
			this.pop();
		}
		
		current = this.peek();
		return current;
	}
	
	protected JPanel getLastElement() {
		return this.peek();
	}

}
