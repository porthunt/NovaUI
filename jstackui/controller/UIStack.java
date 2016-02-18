package jstackui.controller;

import java.util.Iterator;
import java.util.Stack;

import javax.swing.JPanel;

public class UIStack extends Stack<JPanel> {

	Stack<JPanel> stck;

	protected UIStack() {
		super();
	}

	protected void show() {
		Iterator<JPanel> iterator = this.iterator();

		while (iterator.hasNext()) {
			System.out.println(iterator.next().getName());
		}
	}

}
