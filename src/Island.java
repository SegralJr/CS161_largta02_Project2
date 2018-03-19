import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;

public class Island extends JFrame implements ActionListener {
	
	Workshop shop;
	JButton[][] population;
	JTextField northFIeld;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
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
		
		// INstantiates population to dimensions rows and columns
		JButton[][] population = new JButton[rows][columns]; 
		
		// Iterates over population and instantiates each population entry
		for(int k = 0; k <= population.length; k++) {
			for(int j = 0; j < population.length; j++) {
				population[k][j].setText(String.valueOf(k) + ", " + String.valueOf(j));
				
				// Background is set to light gray for each button
				population[k][j].setBackground(Color.LIGHT_GRAY); 
			}
		}
		
		// This registered to the array entries
		
	}
	
	private void enableBoard(boolean flag) {
		
	}
	
	private void resetBoard() {
		
	}
	
	public void buildWindow() {
		
	}
	
	private void displayGeneration(boolean[][] mirror) {
		
	}
	
	public void actionPerformed(ActionEvent event) {
		
		
	}

}

class ButtonListener implements ActionListener {
	
	public void actionPerformed(ActionEvent event) {
		
	}
	
}
