package controllers;

import java.util.Scanner;

import models.Maze;
import models.MazeSolver;

public class Driver {
	
	Scanner input;
	Maze maze;
	MazeSolver solver;
	
	public static void main(String[] args){
		new Driver().run();
	}
	
	public void run(){
		input = new Scanner(System.in);
		maze = new Maze(input);
		solver = new MazeSolver(maze);
		System.out.println(maze.toString());
		System.out.println("Does the maze have a finish? : "+solver.solveMaze());
	}
}
