package utils;

import java.awt.Color;

/**
 * Enum for Square which defines the Square types with 
 * characters and color value
 * 
 * @author Oleksandr Kononov
 * @version 14-08-2017
 *
 */

public enum Square {
	WALL ('#', Color.BLACK),
	OPEN ('.', Color.WHITE),
	START ('o', Color.GREEN),
	FINISH ('*', Color.RED);
	
	private final char symbol;	//Symbol for square
	private final Color color;	//Colour for the square
	
	Square(char symbol, Color color){
		this.symbol = symbol;
		this.color = color;
	}
	
	/**
	 * Takes in a character and returns the equivalent Square type
	 * @param ch Character
	 * @return
	 */
	public static Square fromChar(char ch){
		switch(ch){
		case '#':
			return WALL;
		case '.':
			return OPEN;
		case 'o':
			return START;
		case '*':
			return FINISH;
		default:
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * 	 
	 * Takes in a color and returns the equivalent Square type
	 * @param c Color
	 * @return
	 */
	public static Square fromColor(Color c){
		if(c.equals(Color.BLACK)) return WALL;
		else if(c.equals(Color.WHITE)) return OPEN;
		else if(c.equals(Color.GREEN)) return START;
		else if(c.equals(Color.RED)) return FINISH;
		throw new IllegalArgumentException();
	}
	
	/**
	 * Return string value of Square
	 */
	@Override
	public String toString(){
		return String.valueOf(symbol);
	}
	
	/**
	 * 
	 * @return Color for awt GUI
	 */
	public Color getColor(){
		return color;
	}
	
}
