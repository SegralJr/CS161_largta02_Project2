import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Island extends JFrame implements ActionListener {
	
	private static Workshop shop;
	private JButton[][] population;
	private JTextField northField;
	
	private JPanel north, south, center;
	private JLabel markLabel, nextLabel, resetLabel;
	private JButton markButton, nextButton, resetButton;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Test");
		Island is = new Island(4, 4, shop);
		is.buildWindow(4, 4);
	}
	
	public Island(int rows, int columns, Workshop shop) { // Constructor
		// Creates title
		super(">>>>> LIFE GAME BOARD <<<<<");
		
		// Initializes shop
		shop = new Workshop(rows,columns);
		
		// Sets frame parameters
		setSize(800,450);
		setLocation(25, 15);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		// Instantiates population to dimensions rows and columns
		population = new JButton[rows][columns]; 
		
		
		// Iterates over population and instantiates each population entry
		for(int k = 0; k < population.length; k++) {
			for(int j = 0; j < population.length; j++) {
				population[k][j] = new JButton(String.valueOf(k) + ", " + String.valueOf(j));
				//population[k][j].setText(String.valueOf(k) + ", " + String.valueOf(j));
				
				// Background is set to light gray for each button
				population[k][j].setBackground(Color.LIGHT_GRAY); 
			}
		}
		
		// This registered to the array entries
		
	}
	
	private void enableBoard(boolean flag) {
		for(int k = 0; k <= population.length; k++) {
			for(int j = 0; j <=population.length; j++) {
				population[k][j].setEnabled(flag);
			}
		}
	}
	
	private void resetBoard() {
		for(int k = 0; k <= population.length; k++) {
			for(int j = 0; j <= population.length; j++) {
				population[k][j].setBackground(Color.LIGHT_GRAY); 
			}
		}
	}
	
	public void buildWindow(int rows, int columns) {
		north = new JPanel();
		//north.setBackground(Color.LIGHT_GRAY);
		south = new JPanel();
		//south.setBackground(Color.LIGHT_GRAY);
		center = new JPanel();
		//center.setBackground(Color.LIGHT_GRAY);
		
		markLabel = new JLabel("Click for marking initial life");
		nextLabel = new JLabel("See the nexgt generation");
		resetLabel = new JLabel("Reset the game");
		northField = new JTextField("");
		
		markButton = new JButton("Mark");
		nextButton = new JButton("Next");
		resetButton = new JButton("Reset");
	
		center.setLayout(new GridLayout(rows, columns));
		south.setLayout(new GridLayout(4, 2));
			
		south.add(markLabel);
		south.add(markButton);
		south.add(nextLabel);
		south.add(nextButton);
		south.add(resetLabel);
		south.add(resetButton);
		north.add(northField);
		
		add(north, BorderLayout.NORTH);
		add(south, BorderLayout.SOUTH);
		add(center, BorderLayout.CENTER);
		
		for(int k = 0; k < rows; k++) {
			for(int j = 0; j < columns; j++) {
				center.add(population[k][j]);
			}
		}
		
		markButton.addActionListener(this);
		nextButton.addActionListener(this);
		resetButton.addActionListener(this);

		setVisible(true);
	}
	
	private void displayGeneration(boolean[][] mirror) {
		for(int k = 0; k <= mirror.length; k++) {
			for(int j = 0; j <= mirror.length; j++) {
				if(mirror[k][j] == true) {
					population[k][j].setBackground(Color.yellow);
				}
				else {
					population[k][j].setBackground(Color.LIGHT_GRAY);
				}
			}
		}
	}
	
	public void actionPerformed(ActionEvent event) {
		
	}

}

class ButtonListener implements ActionListener {
	
	public void actionPerformed(ActionEvent event) {
		if("Mark".equals(event.getActionCommand())) {
			
		}
		else if("Next".equals(event.getActionCommand())) {
			
		}
		else if("Reset".equals(event.getActionCommand())) {
			
		}
	}
	
}
