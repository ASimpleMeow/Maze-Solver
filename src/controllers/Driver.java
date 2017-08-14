package controllers;

import java.util.Scanner;

import models.Maze;
import models.MazeSolver;
import views.UserInterface;

public class Driver {
	
	Scanner input;
	Maze maze;
	MazeSolver solver;
	UserInterface gui;
	
	public static void main(String[] args){
		new Driver().run();
	}
	
	public void run(){
		input = new Scanner(System.in);
		gui = new UserInterface(4,7);
		/*maze = new Maze(input);
		System.out.print("Solve Maze with Stack Approach? (true/false)");
		solver = new MazeSolver(maze, input.nextBoolean());
		System.out.println(maze.toString());
		System.out.println("Does the maze have a finish? : "+solver.solveMaze());*/
	}
}
