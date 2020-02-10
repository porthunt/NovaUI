package view;

import java.util.HashMap;

import javax.swing.JFrame;

import controller.JStackCore;
import exceptions.CSSNotValidException;
import exceptions.UndefinedPanelException;
import model.CSS;

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
public class JNovaUI extends JFrame {

	private JNovaPanel corePanel;
	private JStackCore jcore;
	private CSS css;
	public int WIDTH_DEFAULT = 900;
	public int HEIGHT_DEFAULT = 600;

	/**
	 * Creates a frame and an empty JNovaPanel as the first item of the UIStack
	 * stack.
	 * 
	 */
	public JNovaUI() {

		defineCorePanel(createCorePanel());
		initialize();

	}

	/**
	 * Creates a frame and an empty JNovaPanel as the first item of the UIStack
	 * stack.
	 * 
	 * @param title
	 *            the title of your frame.
	 */
	public JNovaUI(String title) {

		this.setTitle(title);
		defineCorePanel(createCorePanel());
		initialize();

	}

	/**
	 * Creates a frame and uses the panel parameter as the first item of the
	 * UIStack stack.
	 * 
	 * @param panel
	 *            the first item of the UIStack stack.
	 */
	public JNovaUI(JNovaPanel panel) throws UndefinedPanelException {

		if (panel != null) {
			defineCorePanel(panel);
			initialize();
		} else {
			throw new UndefinedPanelException();
		}

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

	public JNovaUI(JNovaPanel panel, String title) throws UndefinedPanelException {

		if (panel != null) {
			this.setTitle(title);
			defineCorePanel(panel);
			initialize();
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
		css = new CSS(this);
		this.setBounds(0, 0, WIDTH_DEFAULT, HEIGHT_DEFAULT);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	/**
	 * Creates a panel to be used as the first item on the stack.
	 * 
	 * @return the new panel created.
	 */

	private JNovaPanel createCorePanel() {
		JNovaPanel panel = new JNovaPanel("Core");
		return panel;
	}

	/**
	 * Defines a panel as the first panel of the JStackUI frame.
	 * 
	 * @param panel
	 *            panel to be used as the first one.
	 */

	private void defineCorePanel(JNovaPanel panel) {
		corePanel = panel;
		panel.setBounds(0, 0, WIDTH_DEFAULT, HEIGHT_DEFAULT);
		this.add(panel);
	}

	/**
	 * Prints the name of the panels on the stack.
	 */
	public void showList() {
		jcore.show();
	}

	/**
	 * Gets the current panel on the stack.
	 * 
	 * @return the current panel
	 */
	public JNovaPanel getCurrentPanel() {
		return jcore.getCurrentPanel();
	}

	/**
	 * Pushes the <b>panel</b> into the stack and changes the panel of the frame
	 * to this new one.
	 * 
	 * @param panel
	 *            the panel you want to move to
	 */
	public void next(JNovaPanel panel) {
		jcore.getCurrentPanel().setVisible(false);
		panel.setVisible(true);
		jcore.addPanel(panel);
		this.add(panel);
	}

	/**
	 * Goes back on the stack and shows the previous panel
	 * 
	 */
	public void back() {
		jcore.getCurrentPanel().setVisible(false);
		JNovaPanel panel = jcore.back();
		panel.setVisible(true);
		this.add(panel);
	}

	/**
	 * Goes back on the stack and shows the nth previous panel
	 * 
	 * @param n
	 *            the number of panels you want to go back
	 */
	public void back(int n) {
		if (n > 0) {
			jcore.getCurrentPanel().setVisible(false);
			JNovaPanel panel = jcore.back(n);
			panel.setVisible(true);
			this.add(panel);
		}
	}

	/**
	 * Goes back on the stack to the first panel of the stack.
	 */
	public void restart() {
		jcore.restart().setVisible(true);

	}

	public void addCSS(String key, String value) throws CSSNotValidException {
		css.add(key, value);
	}

	public HashMap<String, String> getCSS() {
		return css.getProperties();
	}

}
