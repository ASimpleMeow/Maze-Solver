package models;

import java.util.Scanner;

import utils.Square;

public class Maze {
	
	private Square[][] maze;
	
	/**
	 * Initialise the maze size
	 * @param rows
	 * @param columns
	 */
	public Maze(Scanner input){
		System.out.println("Input rows and columns Eg: 4 7\nInput: ");
		int rows = Integer.valueOf(input.next());
		int columns = Integer.valueOf(input.next());
		maze = new Square[rows][columns];
		buildMaze(input);
	}
	
	private void buildMaze(Scanner input){
		System.out.println("MAZE MAP : \n'#' = Wall\n'.' = Open Space\n'o' = Start\n'*' = Finish\n");
		String rowString = "";
		for(int row = 0; row < maze.length; ++row){
			System.out.printf("Enter row %d :",row+1);
			rowString = input.next();
			for(int column = 0; column < maze[row].length; ++column){
				maze[row][column] = Square.fromChar(rowString.charAt(column));
			}
			rowString = "";
		}
	}
	
	@Override
	public String toString(){
		String mazeDisplay = "";
		for(int row = 0; row < maze.length; ++row){
			for(int column = 0; column < maze[row].length; ++column){
				mazeDisplay += maze[row][column];
			}
			mazeDisplay+="\n";
		}
		return mazeDisplay;
	}
	
}
