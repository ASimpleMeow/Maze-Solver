package utils;

import java.awt.Color;

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
	
	@Override
	public String toString(){
		return String.valueOf(symbol);
	}
	
	public Color getColor(){
		return color;
	}
	
}
