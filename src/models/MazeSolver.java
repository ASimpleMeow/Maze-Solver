package models;

import java.util.ArrayList;
import java.util.List;

import utils.Square;

public class MazeSolver {

	Agenda<Coordinate> agenda;
	List<Coordinate> visited;
	Coordinate start;
	Maze maze;
	
	public MazeSolver(Maze maze, boolean solveStack){
		agenda = (solveStack ? new Stack<Coordinate>() : new Queue<Coordinate>());
		visited = new ArrayList<Coordinate>();
		this.maze = maze;
		start = maze.getStart();
		if(start != null){
			agenda.add(start);
			visited.add(start);
		}
	}
	
	public boolean solveMaze(boolean step){
		
		while(!agenda.isEmpty() && step){
			Coordinate currentLocation = agenda.remove();
			if(!visited.contains(currentLocation)){
				if (maze.getMaze()[currentLocation.getRow()][currentLocation.getColumn()] == Square.FINISH){
					return true;
				}
			}
			
			//Add other locations
			if(currentLocation.getRow()+1 < maze.getMaze().length){
				if(maze.getMaze()[currentLocation.getRow()+1][currentLocation.getColumn()] != Square.WALL
						&& !visited.contains(new Coordinate(currentLocation.getRow()+1,currentLocation.getColumn()))){
					agenda.add(new Coordinate(currentLocation.getRow()+1,currentLocation.getColumn()));
				}
			}
			if(currentLocation.getRow()-1 >= 0){
				if(maze.getMaze()[currentLocation.getRow()-1][currentLocation.getColumn()] != Square.WALL
						&& !visited.contains(new Coordinate(currentLocation.getRow()-1,currentLocation.getColumn()))){
					agenda.add(new Coordinate(currentLocation.getRow()-1,currentLocation.getColumn()));
				}
			}
			
			if(currentLocation.getColumn()+1 < maze.getMaze()[currentLocation.getRow()].length){
				if(maze.getMaze()[currentLocation.getRow()][currentLocation.getColumn()+1] != Square.WALL 
						&& !visited.contains(new Coordinate(currentLocation.getRow(),currentLocation.getColumn()+1))){
					agenda.add(new Coordinate(currentLocation.getRow(),currentLocation.getColumn()+1));
				}
			}
			if(currentLocation.getColumn()-1 >= 0){
				if(maze.getMaze()[currentLocation.getRow()][currentLocation.getColumn()-1] != Square.WALL
						&& !visited.contains(new Coordinate(currentLocation.getRow(),currentLocation.getColumn()-1))){
					agenda.add(new Coordinate(currentLocation.getRow(),currentLocation.getColumn()-1));
				}
			}
			
			visited.add(currentLocation);
			step = false;
		}
		
		return false;
	}
	
	public List<Coordinate> getVisited(){
		return visited;
	}
	
	public boolean isAgendaEmpty(){
		return agenda.isEmpty();
	}
}
