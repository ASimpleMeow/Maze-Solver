package controllers;

import java.io.File;

import models.Maze;
import models.MazeSolver;
import views.UserInterface;

/**
 * The main class of the maze solver.
 * 
 * @author Oleksandr Kononov
 * @version 15-08-2017
 *
 */
public class Driver {
	
	Maze maze;			//The maze to be solved
	MazeSolver solver;	//Contains algorithm to solve the maze
	UserInterface gui;	//Graphical user interface for Maze Solver
	
	public static void main(String[] args){
		new Driver().run();
	}
	
	public void run(){
		//maze = new Maze(new File("mazeTest"));
		//System.out.println(maze.toString());
		gui = new UserInterface();
		/*maze = new Maze(input);
		System.out.print("Solve Maze with Stack Approach? (true/false)");
		solver = new MazeSolver(maze, input.nextBoolean());
		System.out.println(maze.toString());
		System.out.println("Does the maze have a finish? : "+solver.solveMaze());*/
	}
}
