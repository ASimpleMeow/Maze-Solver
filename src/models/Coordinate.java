package models;


public class Coordinate {
	
	private int row;
	private int column;
	
	public Coordinate(int row, int column){
		this.row = row;
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof Coordinate){
			Coordinate temp = (Coordinate) o;
			if(row == temp.row && column == temp.column) return true;
		}
		return false;
	}

}
