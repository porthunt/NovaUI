package jstackui.controller;

import javax.swing.JFrame;
import javax.swing.JPanel;

import jstackui.exceptions.UndefinedPanelException;

public class JStackUI extends JFrame {

	JPanel corePanel;
	UIStack uiStack;
	int WIDTH_DEFAULT = 900;
	int HEIGHT_DEFAULT = 600;

	public JStackUI() {

		defineCorePanel(createCorePanel());
		initialize();
		this.setVisible(true);

	}

	public JStackUI(String title) {

		this.setTitle(title);
		defineCorePanel(createCorePanel());
		initialize();
		this.setVisible(true);

	}

	public JStackUI(JPanel panel) {

		defineCorePanel(panel);
		initialize();
		this.setVisible(true);

	}

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

	private void initialize() {
		uiStack = new UIStack();
		uiStack.push(corePanel);

		this.setBounds(0, 0, WIDTH_DEFAULT, HEIGHT_DEFAULT);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}

	private JPanel createCorePanel() {
		JPanel panel = new JPanel();
		return panel;
	}

	private void defineCorePanel(JPanel panel) {
		corePanel = panel;
		corePanel.setName("CorePanel");
		panel.setBounds(0, 0, WIDTH_DEFAULT, HEIGHT_DEFAULT);
		this.add(panel);
	}

	public void showList() {
		uiStack.show();
	}
	
}
