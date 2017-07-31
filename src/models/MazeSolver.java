package models;

import java.util.ArrayList;
import java.util.List;

import utils.Square;

public class MazeSolver {

	Agenda<Coordinate> stackAgenda;
	List<Coordinate> visited;
	Maze maze;
	
	public MazeSolver(Maze maze){
		stackAgenda = new Stack<Coordinate>();
		visited = new ArrayList<Coordinate>();
		this.maze = maze;
	}
	
	public boolean solveMaze(){
		Coordinate start = maze.getStart();
		if(start != null){
			stackAgenda.add(start);
			visited.add(start);
		}
		
		while(!stackAgenda.isEmpty()){
			Coordinate currentLocation = stackAgenda.remove();
			if(!visited.contains(currentLocation)){
				if (maze.getMaze()[currentLocation.getRow()][currentLocation.getColumn()] == Square.FINISH){
					return true;
				}
			}
			
			//Add other locations
			if(currentLocation.getRow()+1 < maze.getMaze().length){
				if(maze.getMaze()[currentLocation.getRow()+1][currentLocation.getColumn()] != Square.WALL
						&& !visited.contains(new Coordinate(currentLocation.getRow()+1,currentLocation.getColumn()))){
					stackAgenda.add(new Coordinate(currentLocation.getRow()+1,currentLocation.getColumn()));
				}
			}
			if(currentLocation.getRow()-1 >= 0){
				if(maze.getMaze()[currentLocation.getRow()-1][currentLocation.getColumn()] != Square.WALL
						&& !visited.contains(new Coordinate(currentLocation.getRow()-1,currentLocation.getColumn()))){
					stackAgenda.add(new Coordinate(currentLocation.getRow()-1,currentLocation.getColumn()));
				}
			}
			
			if(currentLocation.getColumn()+1 < maze.getMaze()[currentLocation.getRow()].length){
				if(maze.getMaze()[currentLocation.getRow()][currentLocation.getColumn()+1] != Square.WALL 
						&& !visited.contains(new Coordinate(currentLocation.getRow(),currentLocation.getColumn()+1))){
					stackAgenda.add(new Coordinate(currentLocation.getRow(),currentLocation.getColumn()+1));
				}
			}
			if(currentLocation.getColumn()-1 >= 0){
				if(maze.getMaze()[currentLocation.getRow()][currentLocation.getColumn()-1] != Square.WALL
						&& !visited.contains(new Coordinate(currentLocation.getRow(),currentLocation.getColumn()-1))){
					stackAgenda.add(new Coordinate(currentLocation.getRow(),currentLocation.getColumn()-1));
				}
			}
			
			visited.add(currentLocation);
		}
		
		return false;
		
	}
}
