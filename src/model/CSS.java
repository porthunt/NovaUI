package model;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.font.TextAttribute;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;

import exceptions.CSSNotValidException;

/**
 * This class allows the user to insert CSS properties into a swing component.
 * You can set a width to your frame, change the color of a label or put
 * margin/padding into your panel. Although this class allows the use of CSS,
 * not all properties are available.
 * 
 * Available properties:
 * 
 * - background-color - width - height - font-size
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
	 * @throws CSSNotValidException
	 *             raised when the CSS property value is not valid
	 */
	public void add(String key, String value) throws CSSNotValidException {

		key = key.toLowerCase();
		value = value.toLowerCase();

		switch (key) {

		case "background-color":
			addBackgroundColor(value);
			break;

		case "width":
			addWidth(value);
			break;

		// case "background-image":
		// addBackgroundImage(value);
		// break;

		case "height":
			addHeight(value);
			break;

		case "font-size":
			addFontSize(value);
			break;

		case "letter-spacing":
			addLetterSpacing(value);
			break;

		case "cursor":
			addCursor(value);
			break;

		case "border-color":
			addBorderColor(value);
			break;

		default:
			break;
		}

		properties.put(key, value);

	}

	/**
	 * Adds a background-color to a component. The value can be given in rgb,
	 * hexadecimal or name.
	 * 
	 * @param value
	 *            The value of your color (rgb, hex, name).
	 * @throws CSSNotValidException
	 *             raised when the CSS property value is not valid
	 */
	public void addBackgroundColor(String value) throws CSSNotValidException {
		try {
			component.setBackground(findColor(value));
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
	 * @throws CSSNotValidException
	 *             raised when the CSS property value is not valid
	 */
	public void addWidth(String value) throws CSSNotValidException {
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
			}
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
	 * @throws CSSNotValidException
	 *             raised when the CSS property value is not valid
	 */
	public void addHeight(String value) throws CSSNotValidException {
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
			}
		} catch (Exception e) {
			throw new CSSNotValidException(value);
		}
	}

	/**
	 * Adjusts the font size of a component (px, small, x-small, xx-small,
	 * large, x-large, xx-large, medium, initial).
	 * 
	 * @param value
	 *            the value of your font size
	 * @throws CSSNotValidException
	 *             raised when the CSS property value is not valid
	 */

	public void addFontSize(String value) throws CSSNotValidException {
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
		} catch (Exception e) {
			throw new CSSNotValidException(value);
		}

	}

	/**
	 * Method to add letter-spacing into a component.
	 * 
	 * @param value
	 *            css cursor property
	 * @throws CSSNotValidException
	 *             raised when the CSS property value is not valid
	 */

	public void addLetterSpacing(String value) throws CSSNotValidException {
		try {
			if (value.contains("px")) {
				Map<TextAttribute, Object> attr = new HashMap<TextAttribute, Object>();
				attr.put(TextAttribute.TRACKING, value.substring(0, value.indexOf("px")));
				component.setFont(component.getFont().deriveFont(attr));
			}

			if (!value.equals("normal") && !value.equals("initial")) {
				throw new CSSNotValidException(value);
			}

		} catch (Exception e) {
			throw new CSSNotValidException(value);
		}
	}

	/**
	 * Method to add a cursor on your component. Valid cursors: crosshair,
	 * default, pointer, text, wait, e-resize, n-resize, ne-resize, s-resize,
	 * se-resize, sw-resize, nw-resize
	 * 
	 * @param value
	 *            css cursor property
	 * @throws CSSNotValidException
	 *             raised when the CSS property value is not valid
	 */
	public void addCursor(String value) throws CSSNotValidException {
		try {
			if (value.equals("pointer")) {
				component.setCursor(new Cursor(Cursor.HAND_CURSOR));
			} else {
				Integer cursor;
				System.out.println(value.toUpperCase().replace("-", "_") + "_CURSOR");
				Field field = Class.forName("java.awt.Cursor")
						.getField(value.toUpperCase().replace("-", "_") + "_CURSOR");
				cursor = (Integer) field.get(null);
				component.setCursor(new Cursor(cursor));

			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new CSSNotValidException(value);
		}
	}

	/**
	 * Adds a border-color to a component. The value can be given in rgb,
	 * hexadecimal, name.
	 * 
	 * One parameter: all the borders will have the same color. Two parameters:
	 * top and bottom will share the first parameter. Left and right will have
	 * the other. Three parameters: Top will have the first color, right and
	 * left the second one and down, the third. Four parameters: all borders
	 * will have different colors (top, right, bottom, left).
	 * 
	 * @param value
	 *            The value of your color (rgb, hex or name).
	 * @throws CSSNotValidException
	 *             raised when the CSS property value is not valid
	 */
	public void addBorderColor(String value) throws CSSNotValidException {
		try {
			String[] borderColors = value.split(" ");

			if (borderColors.length == 1) {
				((JPanel) component).setBorder(BorderFactory.createLineBorder(findColor(borderColors[0]))); // adds
																											// first
																											// color
																											// on
																											// all
																											// sides
			} else if (borderColors.length == 2) {
				((JPanel) component).setBorder(
						new CompoundBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, findColor(borderColors[0])), // adds
																													// first
																													// color
																													// on
																													// top/bottom
								BorderFactory.createMatteBorder(0, 1, 0, 1, findColor(borderColors[1])))); // adds
																											// second
																											// color
																											// on
																											// left/right
			} else if (borderColors.length == 3) {
				((JPanel) component).setBorder(new CompoundBorder(
						new CompoundBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, findColor(borderColors[0])), // adds
																													// first
																													// color
																													// on
																													// top
								BorderFactory.createMatteBorder(0, 0, 0, 1, findColor(borderColors[1]))), // adds
																											// second
																											// color
																											// on
																											// right
						new CompoundBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, findColor(borderColors[2])), // adds
																													// third
																													// color
																													// on
																													// bottom
								BorderFactory.createMatteBorder(0, 1, 0, 0, findColor(borderColors[1]))))); // adds
																											// second
																											// color
																											// on
																											// left
			} else if (borderColors.length == 4) {
				((JPanel) component).setBorder(new CompoundBorder(
						new CompoundBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, findColor(borderColors[0])), // adds
																													// first
																													// color
																													// on
																													// top
								BorderFactory.createMatteBorder(0, 0, 0, 1, findColor(borderColors[1]))), // adds
																											// second
																											// color
																											// on
																											// right
						new CompoundBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, findColor(borderColors[2])), // adds
																													// third
																													// color
																													// on
																													// bottom
								BorderFactory.createMatteBorder(0, 1, 0, 0, findColor(borderColors[3]))))); // adds
																											// fourth
																											// color
																											// on
																											// left
			} else {
				throw new CSSNotValidException(value);
			}
		} catch (Exception e) {
			throw new CSSNotValidException(value);
		}
	}

	/**
	 * Returns a Color object given an rgb, hex or name color.
	 * 
	 * @param value
	 *            the rgb/hex/name of the color.
	 * @return the Color object based on the value
	 * @throws CSSNotValidException
	 *             raised when the CSS property value is not valid
	 */
	private Color findColor(String value) throws CSSNotValidException {
		try {
			if (value.contains("rgb")) {
				String rgb = value.substring(value.indexOf("(") + 1, value.indexOf(")"));
				Integer red = Integer.parseInt(rgb.split(",")[0].trim());
				Integer green = Integer.parseInt(rgb.split(",")[1].trim());
				Integer blue = Integer.parseInt(rgb.split(",")[2].trim());

				return new Color(red, green, blue);
			}

			else if (value.contains("#")) {
				return Color.decode(value);
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
				return color;

			}
		} catch (Exception e) {
			throw new CSSNotValidException(value);
		}
	}

	/**
	 * Method to count how many letters there is in a word
	 * 
	 * @param word
	 *            the word from where you want to count the letters
	 * @param letter
	 *            the letter
	 * @return the number of instancies of that letter in the word
	 */

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
