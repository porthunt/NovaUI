package view;

import java.util.HashMap;

import javax.swing.JPanel;

import model.CSS;

@SuppressWarnings("serial")
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
	
	public HashMap<String, String> getCSS() {
		return css.getProperties();
	}

}
