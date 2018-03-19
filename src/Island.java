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
	
	public Island(int rows, int columns, Workshop shop) {
		super(">>>>> LIFE GAME BOARD <<<<<");
		shop = new Workshop(rows,columns);
		JButton[][] population = new JButton[rows][columns];
		for(int k = 0; k <= population.length; k++) {
			for(int j = 0; j < population.length; j++) {
				population[k][j].setText(String.valueOf(k) + ", " + String.valueOf(j));
			}
		}
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
