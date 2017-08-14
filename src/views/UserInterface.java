package views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import utils.Square;

public class UserInterface implements ActionListener{
	
	private JFrame frame;
	private JPanel mazePanel;
	private JPanel optionPanel;
	
	public UserInterface(int rows, int columns){
		makeFrame(rows, columns);
		frame.setVisible(true);
	}
	
	private void makeFrame(int rows, int columns){
		frame = new JFrame("Maze Solver");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel contentPane = (JPanel)frame.getContentPane();
		contentPane.setLayout(new BorderLayout(20, 20));
		contentPane.setBorder(new EmptyBorder( 10, 10, 10, 10));
		
		optionPanel = new JPanel(new GridLayout(1, 3));
		addButton(optionPanel, "Stack Solution");
		addButton(optionPanel, "Queue Solution");
		addButton(optionPanel, "Exit");
		
		mazePanel = new JPanel(new GridLayout(rows,columns));
		makeMaze(mazePanel, rows, columns);
		
		contentPane.add(optionPanel, BorderLayout.NORTH);
		contentPane.add(mazePanel);
		frame.pack();
		frame.setPreferredSize(new Dimension(400, 600));
	}
	
	private void addButton(Container panel, String buttonText)
	{
		JButton button = new JButton(buttonText);
		button.addActionListener(this);
		panel.add(button);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private void makeMaze(JPanel mazeFields, int rows, int columns){
		Font font = new Font("SansSerif", Font.BOLD, 20);
		for(int i = 0; i < rows*columns; ++i){
			JTextField t = new JTextField(Square.WALL.toString());
			t.setForeground(Square.WALL.getColor());
			t.setFont(font);
			t.setHorizontalAlignment(JTextField.CENTER);
			t.setEditable(false);
			t.addMouseListener(new MouseAdapter(){
				public void mouseReleased(MouseEvent e){
					cycleField(t);
				}
			});
			mazeFields.add(t);
		}
	}
	
	private void cycleField(JTextField t){
		for(int i=0; i<Square.values().length; ++i){
			if (t.getText().equals(Square.values()[i].toString())){
				Square temp = (Square.values()[++i % Square.values().length]);
				t.setForeground(temp.getColor());
				t.setText(temp.toString());
				break;
			}
		}
	}
}
