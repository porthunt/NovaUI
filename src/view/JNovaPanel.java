package jstackui.view;

import javax.swing.JPanel;

import jstackui.model.CSS;

public class JNovaPanel extends JPanel {
	
	private CSS css;
	private String name;

	public JNovaPanel(String name) {
		super();
		this.name = name;
		css = new CSS(this);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void addCSS(String key, String value) {
		css.add(key, value);
	}

}
