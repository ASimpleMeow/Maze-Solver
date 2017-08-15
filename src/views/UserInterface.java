package views;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;
import javax.swing.border.*;

import models.Maze;
import utils.Square;

/**
 * Graphical User Interface for the MazeSolver. No calculation is done here.
 * This class is responsible only for displaying and taking information to and from 
 * the user, and refers to MazeSolver to solve the maze.
 * 
 * @author Oleksandr Kononov
 * @version 15-08-2017
 *
 */

public class UserInterface implements ActionListener{
	
	private JFrame frame;
	
	private JPanel optionPanel;			//Option panel which contains buttons and text fields
	private JTextField rowsTextField;
	private JTextField columnsTextField;
	
	private JLabel statusLabel;			//Will report to the user the status
	
	private JPanel mazePanel;			//Maze panel contains non-editable grid of text field
										//used to display the maze to the user
	
	public UserInterface(){
		makeFrame(1,1);
		frame.setVisible(true);
	}
	
	/**
	 * Create a JFrame window and setup all it's respective panels
	 * 
	 * @param rows Integer value for rows the maze has
	 * @param columns Integer value for columns the maze has
	 */
	private void makeFrame(int rows, int columns){
		
		frame = new JFrame("Maze Solver");
		rowsTextField = new JTextField("",5);
		columnsTextField = new JTextField("",5);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		statusLabel = new JLabel("No Maze Loaded");
		
		JPanel contentPane = (JPanel)frame.getContentPane();
		contentPane.setLayout(new BorderLayout(20, 20));
		contentPane.setBorder(new EmptyBorder( 10, 10, 10, 10));
		
		///////////////Options///////////////
		optionPanel = new JPanel(new GridLayout(3, 0));
		JPanel top = new JPanel(new GridLayout(1, 4));
		JPanel middle = new JPanel(new FlowLayout());
		JPanel bottom = new JPanel(new FlowLayout());
		
		addButton(top, "Stack Solution");
		addButton(top, "Queue Solution");
		addButton(top, "About");
		addButton(top, "Exit");
		
		middle.add(new JLabel("Rows:"));
		middle.add(rowsTextField);
		middle.add(new JLabel("Columns:"));
		middle.add(columnsTextField);
		addButton(middle, "Resize/Reset");
		
		bottom.add(statusLabel);
		
		optionPanel.add(top);
		optionPanel.add(middle);
		optionPanel.add(bottom);
		/////////////////////////////////////
		
		
		//Create the maze grid using row and column
		//makeMaze(rows, columns);
		makeMaze(new Maze(new File("mazeTest")));
		
		
		//Finalise frame
		contentPane.add(optionPanel, BorderLayout.NORTH);
		contentPane.add(mazePanel);
		frame.pack();
		frame.setPreferredSize(new Dimension(500, 800));
		frame.setLocationRelativeTo(null);
	}
	
	/**
	 * Creates a button with an action listener and adds to the panel given in 
	 * parameters
	 * @param panel Which panel to add the button to
	 * @param buttonText Text on the button
	 */
	private void addButton(Container panel, String buttonText){
		JButton button = new JButton(buttonText);
		button.addActionListener(this);
		panel.add(button);
	}
	
	/**
	 * Catches action events sent by the buttons and responds to them
	 * accordingly
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		if(command.equals("Resize/Reset")){		//Resize button pressed
												//Resize maze with new rows and columns
			if(rowsTextField.getText().isEmpty() || columnsTextField.getText().isEmpty()) return;
			int newRows = Integer.parseInt(rowsTextField.getText());
			int newColumns = Integer.parseInt(columnsTextField.getText());
			resizeMaze(newRows, newColumns);
		}else if(command.equals("Exit")){	//Exit button pressed
											//Close frame and exit program
			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			System.exit(0);
		}else if(command.equals("About")){	//About button pressed
											//Display the about information about MazeSolver
			openAbout();
		}
		
	}
	
	/**
	 * Makes a grid maze of non-editable, non-focusable text fields given the 
	 * rows and columns Integer values - Uses the default WALL Square type to fill
	 * each text field
	 * @param rows
	 * @param columns
	 */
	private void makeMaze(int rows, int columns){
		
		mazePanel = new JPanel(new GridLayout(rows,columns));
		mazePanel.setPreferredSize(new Dimension(0,columns*100));
		
		//For every maze Square, setup it's values and parameters
		for(int i = 0; i < rows*columns; ++i){
			JTextField t = new JTextField();						//Set Square type to WALL
			t.setBackground(Square.WALL.getColor());				//Set text colour
			t.setEditable(false);									//Set text field non-editable
			t.setFocusable(false);									//Set text field non-focusable
			t.addMouseListener(new MouseAdapter(){					//Add mouse click listener
				public void mouseReleased(MouseEvent e){			//To change Square type
					changeSquareType(t);
				}
			});
			mazePanel.add(t);
		}
	}
	
	/**
	 * Makes a grid maze of non-editable, non-focusable text fields given the
	 * constructed Maze object
	 * 
	 * @param maze A constructed Maze object
	 */
	private void makeMaze(Maze maze){
		
		int rows = maze.getMaze().length;
		int columns = maze.getMaze()[0].length;
		
		mazePanel = new JPanel(new GridLayout(rows,columns));
		mazePanel.setPreferredSize(new Dimension(0,columns*50));
		
		for(int i = 0; i < rows; ++i){
			for (int j=0; j < columns; ++j){
				JTextField t = new JTextField();
				t.setBackground(maze.getMaze()[i][j].getColor());		//Set colour depending on Square type
				t.setEditable(false);									//Set text field non-editable
				t.setFocusable(false);									//Set text field non-focusable
				mazePanel.add(t);
			}
		}
	}
	
	/**
	 * Resizes the maze text field grid given new row and column Integer values
	 * @param newRows
	 * @param newColumns
	 */
	private void resizeMaze(int newRows, int newColumns){
		mazePanel.setVisible(false);
		frame.getContentPane().remove(mazePanel);
		makeMaze(newRows, newColumns);
		frame.getContentPane().add(mazePanel);
		frame.getContentPane().invalidate();
		frame.getContentPane().validate();
	}
	
	/**
	 * Changes Square type to the next in-line Square type from enums of 
	 * textfield t given
	 * @param t
	 */
	private void changeSquareType(JTextField t){
		//Loop through all Square types until you meet current type
		//increment to next index and set it as new Square type
		for(int i=0; i<Square.values().length; ++i){
			if (t.getBackground().equals(Square.values()[i].getColor())){
				Square temp = (Square.values()[++i % Square.values().length]);
				t.setBackground(temp.getColor());
				break;
			}
		}
	}
	
	/**
	 * Open information dialog window and display About text
	 */
	private void openAbout(){
		String about = 
				"Maze Solver\n"+
				"Author: Oleksandr Kononov\n\n"+
				"Description: Click on the square to change the square type, create a maze\n"+
				"solve the maze by clicking the button\n\n"+
				"Square Types:\n"+
				"Black = WALL\n"+
				"White = OPEN\n"+
				"Green = START\n"+
				"Red = FINISH\n";
		JOptionPane.showMessageDialog(frame, about,"About",
		        JOptionPane.INFORMATION_MESSAGE);
	}
}
