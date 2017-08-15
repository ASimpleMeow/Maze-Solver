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
	OPEN ('.', Color.BLUE),
	START ('o', Color.ORANGE),
	FINISH ('*', Color.RED);
	
	private final char symbol;	//Symbol for square
	private final Color color;	//Colour for the square
	
	Square(char symbol, Color color){
		this.symbol = symbol;
		this.color = color;
	}
	
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
