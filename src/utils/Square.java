package utils;

public enum Square {
	WALL ('#'),
	OPEN ('.'),
	START ('o'),
	FINISH ('*');
	
	private final char symbol;	//Symbol for square
	
	Square(char symbol){
		this.symbol = symbol;
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
	
	
}
