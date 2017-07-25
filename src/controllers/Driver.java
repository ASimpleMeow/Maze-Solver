package controllers;

import java.util.Scanner;

import models.Maze;

public class Driver {
	
	Scanner input;
	Maze maze;
	
	public static void main(String[] args){
		new Driver().run();
	}
	
	public void run(){
		input = new Scanner(System.in);
		maze = new Maze(input);
		System.out.println(maze.toString());
	}
}
