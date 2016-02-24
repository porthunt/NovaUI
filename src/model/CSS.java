package model;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.lang.reflect.Field;
import java.util.HashMap;

import exceptions.CSSNotValidException;

/**
 * This class allows the user to insert CSS properties into a swing component.
 * You can set a width to your frame, change the color of a label or put
 * margin/padding into your panel. Although this class allows the use of CSS,
 * not all properties are available.
 * 
 * Available properties:
 * 
 * - background-color
 * - width
 * - height
 * - font-size
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
	 * @throws CSSNotValidException raised when the CSS property value is not valid
	 */
	public void add(String key, String value) throws CSSNotValidException {
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

		// case "background-image":
		// if(addBackgroundImage(value)) {
		// properties.put(key, value);
		// }
		// break;

		case "height":
			if (addHeight(value)) {
				properties.put(key, value);
			}
			break;

		case "font-size":
			if (addFontSize(value)) {
				properties.put(key, value);
			}
			break;

		default:
			break;
		}

	}

	/**
	 * Adds a background-color to a component. The value can be given in rgb,
	 * hexadecimal, percentage, name.
	 * 
	 * @param value
	 *            The value of your color (rgb, hex, name or percentage).
	 * @throws CSSNotValidException raised when the CSS property value is not valid
	 */
	public boolean addBackgroundColor(String value) throws CSSNotValidException {
		try {
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
			 * value = "yellow" > Color.yellow, value = "blue" > Color.blue
			 *
			 * so on and so forth
			 */
			else {
				Color color;
				Field field = Class.forName("java.awt.Color").getField(value);
				color = (Color) field.get(null);
				component.setBackground(color);
				return true;

			}
		} catch (Exception e) {
			throw new CSSNotValidException(value);
		}
	}

	/**
	 * Adjusts the width of your component.The value can be given in pixels or
	 * percentage.
	 * 
	 * @param value
	 *            the value of your width (px or percentage).
	 * @throws CSSNotValidException raised when the CSS property value is not valid
	 */
	public boolean addWidth(String value) throws CSSNotValidException {
		Integer width = 0;
		try {
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
			} else
				return false;
		} catch (Exception e) {
			throw new CSSNotValidException(value);
		}
	}

	/**
	 * Adjusts the height of your component.The value can be given in pixels or
	 * percentage.
	 * 
	 * @param value
	 *            the value of your height (px or percentage).
	 * @throws CSSNotValidException raised when the CSS property value is not valid
	 */
	public boolean addHeight(String value) throws CSSNotValidException {
		Integer height = 0;
		try {
			if (value.contains("px")) {
				height = Integer.parseInt(value.substring(0, value.indexOf("px")));
			} else if (value.contains("%")) {
				double preHeight = Double.parseDouble(value.substring(0, value.indexOf("%"))) / 100;
				double systemHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
				height = new Double(systemHeight * preHeight).intValue();
			}

			if (height > 0) {
				component.setBounds(0, 0, component.getWidth(), height);
				return true;
			} else
				return false;
		} catch (Exception e) {
			throw new CSSNotValidException(value);
		}
	}
	
	/**
	 * Adjusts the font size of a component (px, small, x-small, xx-small, large, x-large, xx-large, medium, initial).
	 * 
	 * @param value
	 *            the value of your font size
	 * @throws CSSNotValidException raised when the CSS property value is not valid
	 */

	public boolean addFontSize(String value) throws CSSNotValidException {
		Integer fontSize = component.getFont().getSize();
		try {
			if (value.contains("px")) {
				fontSize = Integer.parseInt(value.substring(0, value.indexOf("px")));

			} else if (value.contains("small") || value.contains("large")) {
				Integer countX = countChars(value, 'x');
				if (countX < 0 || countX > 2) {
					throw new CSSNotValidException(value);
				} else {
					if (value.contains("small")) {
						fontSize = fontSize - countX - 1; // If countX is 0
															// (small),
															// it removes 1 from
															// font size.
					} else if (value.contains("large")) {
						fontSize = fontSize + countX + 1; // If countX is 0
															// (large),
															// it adds 1 from
															// font
															// size.
					} else {

					}
				}
			} else if (!value.equals("medium") && !value.equals("initial")) {
				throw new CSSNotValidException(value);
			}

			component.setFont(new Font(component.getFont().getFamily(), component.getFont().getStyle(), fontSize));
			return true;
		} catch (Exception e) {
			throw new CSSNotValidException(value);
		}

	}

	private int countChars(String word, char letter) {
		int counter = 0;
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == letter) {
				counter++;
			}
		}
		return counter;
	}

	public HashMap<String, String> getProperties() {
		return properties;
	}
}
