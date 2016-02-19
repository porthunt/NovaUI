package jstackui.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import jstackui.controller.JStackCore;
import jstackui.exceptions.UndefinedPanelException;

/**
 * This class is the main class of the library. It is responsible to interact
 * with the user, giving the possibility to use as a default frame of a project.
 * The JStackCore deals with the stack, therefore this class is the interface
 * with the programmer.
 *
 * @author porthunt
 * @see JStackCore
 * @since 0.1
 */

@SuppressWarnings("serial")
public class JStackUI extends JFrame {

	JPanel corePanel;
	JStackCore jcore;
	int WIDTH_DEFAULT = 900;
	int HEIGHT_DEFAULT = 600;

	/**
	 * Creates a frame and an empty JPanel as the first item of the UIStack
	 * stack.
	 *
	 */
	public JStackUI() {

		defineCorePanel(createCorePanel());
		initialize();
		this.setVisible(true);

	}

	/**
	 * Creates a frame and an empty JPanel as the first item of the UIStack
	 * stack.
	 *
	 * @param title
	 *            the title of your frame.
	 */
	public JStackUI(String title) {

		this.setTitle(title);
		defineCorePanel(createCorePanel());
		initialize();
		this.setVisible(true);

	}

	/**
	 * Creates a frame and uses the panel parameter as the first item of the
	 * UIStack stack.
	 *
	 * @param panel
	 *            the first item of the UIStack stack.
	 */
	public JStackUI(JPanel panel) {

		defineCorePanel(panel);
		initialize();
		this.setVisible(true);

	}

	/**
	 * Creates a frame and uses the panel parameter as the first item of the
	 * UIStack stack.
	 *
	 * @param panel
	 *            the first item of the UIStack stack cannot be NULL.
	 * @param title
	 *            the title of your frame.
	 */

	public JStackUI(JPanel panel, String title) throws UndefinedPanelException {

		if (panel != null) {
			this.setTitle(title);
			defineCorePanel(panel);
			initialize();
			this.setVisible(true);
		} else {
			throw new UndefinedPanelException();
		}

	}

	/**
	 * Creates the JStackCore object, sets the size of the frame with a default
	 * size (900x600). Centralizes the frame on the center of the screen and
	 * puts EXIT_ON_CLOSE as the default close operation.
	 */

	private void initialize() {
		jcore = new JStackCore(corePanel);
		this.setBounds(0, 0, WIDTH_DEFAULT, HEIGHT_DEFAULT);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}

	/**
	 * Creates a panel to be used as the first item on the stack.
	 *
	 * @return the new panel created.
	 */

	private JPanel createCorePanel() {
		JPanel panel = new JPanel();
		return panel;
	}

	/**
	 * Defines a panel as the first panel of the JStackUI frame.
	 *
	 * @param panel
	 *            panel to be used as the first one.
	 */

	private void defineCorePanel(JPanel panel) {
		corePanel = panel;
		corePanel.setName("CorePanel");
		panel.setBounds(0, 0, WIDTH_DEFAULT, HEIGHT_DEFAULT);
		this.add(panel);
	}

	/**
	 * Prints the name of the panels on the stack.
	 */
	public void showList() {
		jcore.show();
	}
	
}