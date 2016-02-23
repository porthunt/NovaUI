package model;

import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;
import java.lang.reflect.Field;
import java.util.HashMap;

/**
 * This class allows the user to insert CSS properties into a swing component.
 * You can set a width to your frame, change the color of a label or put
 * margin/padding into your panel. Although this class allows the use of CSS,
 * not all properties are available.
 * 
 * Available properties:
 * 
 * - background-color - width
 * 
 * @author porthunt
 * @since 0.2
 */
public class CSS {

	private Component component;
	private HashMap<String, String> properties;

	public CSS(Component component) {
		this.component = component;
		properties = new HashMap<String, String>();
	}

	/**
	 * Adds a CSS property to a component.
	 * 
	 * e.g.: key = background-color value = yellow
	 * 
	 * @param key
	 *            the property you want to change
	 * @param value
	 *            the value for that property
	 */
	public void add(String key, String value) {
		switch (key) {

		case "background-color":
			if (addBackgroundColor(value)) {
				properties.put(key, value);
			}
			break;

		case "width":
			if (addWidth(value)) {
				properties.put(key, value);
			}
			break;
		}

	}

	/**
	 * Adds a background-color to a component. The value can be given in rgb,
	 * hexadecimal, percentage, name.
	 * 
	 * @param value
	 *            The value of your color (rgb, hex, name or percentage).
	 */
	public boolean addBackgroundColor(String value) {
		if (value.contains("rgb")) {
			String rgb = value.substring(value.indexOf("(") + 1, value.indexOf(")"));
			Integer red = Integer.parseInt(rgb.split(",")[0].trim());
			Integer green = Integer.parseInt(rgb.split(",")[1].trim());
			Integer blue = Integer.parseInt(rgb.split(",")[2].trim());

			component.setBackground(new Color(red, green, blue));
			return true;
		}

		else if (value.contains("#")) {
			component.setBackground(Color.decode(value));
			return true;
		}

		/*
		 * Creates a Color.value element
		 * 
		 * value = "yellow" > Color.yellow value = "blue" > Color.blue
		 *
		 * so on and so forth
		 */
		else {
			Color color;
			try {
				Field field = Class.forName("java.awt.Color").getField(value);
				color = (Color) field.get(null);
				component.setBackground(color);
				return true;
			} catch (Exception e) {
				color = Color.BLACK;
				return false;
			}

		}
	}

	/**
	 * Adjusts the width of your component.The value can be given in pixels or
	 * percentage.
	 * 
	 * @param value
	 *            the value of your width (px or percentage).
	 */
	public boolean addWidth(String value) {
		Integer width = 0;
		if (value.contains("px")) {
			width = Integer.parseInt(value.substring(0, value.indexOf("px")));
		} else if (value.contains("%")) {
			double preWidth = Double.parseDouble(value.substring(0, value.indexOf("%"))) / 100;
			double systemWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
			width = new Double(systemWidth * preWidth).intValue();
		}

		if (width > 0) {
			component.setBounds(0, 0, width, component.getHeight());
			return true;
		} else return false;
	}
	
	public HashMap<String, String> getProperties() {
		return properties;
	}
}
