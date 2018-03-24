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
	
	private static int rows = 4, columns = 5;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		rows = 4;
		columns = 5;
		Island is = new Island(rows, columns, shop);
		is.buildWindow(rows, columns);
	}
	
	public Island(int rows, int columns, Workshop shop) { // Constructor
		// Creates title
		super(">>>>> LIFE GAME BOARD <<<<<");
		
		// Initializes shop
		this.shop = new Workshop(rows,columns);
		
		// Sets frame parameters
		setSize(800,450);
		setLocation(25, 15);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		// Instantiates population to dimensions rows and columns
		population = new JButton[rows][columns]; 
		
		
		// Iterates over population and instantiates each population entry
		for(int k = 0; k < rows; k++) {
			for(int j = 0; j < columns; j++) {
				population[k][j] = new JButton(String.valueOf(k) + ", " + String.valueOf(j));
				//population[k][j].setText(String.valueOf(k) + ", " + String.valueOf(j));
				
				// Background is set to light gray for each button
				population[k][j].setBackground(Color.LIGHT_GRAY); 
			}
		}
		
		// This registered to the array entries
		
	}
	
	private void enableBoard(boolean flag) {
		for(int k = 0; k < rows; k++) {
			for(int j = 0; j < columns; j++) {
				population[k][j].setEnabled(flag);
			}
		}
	}
	
	private void resetBoard() {
		for(int k = 0; k < rows; k++) {
			for(int j = 0; j < columns; j++) {
				population[k][j].setBackground(Color.LIGHT_GRAY); 
			}
		}
		enableBoard(true);
		markButton.setEnabled(true);
	}
	
	public void buildWindow(int rows, int columns) {
		north = new JPanel();
		//north.setBackground(Color.LIGHT_GRAY);
		south = new JPanel();
		//south.setBackground(Color.LIGHT_GRAY);
		center = new JPanel();
		//center.setBackground(Color.LIGHT_GRAY);
		
		markLabel = new JLabel("Click for marking initial life");
		nextLabel = new JLabel("See the next generation");
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
		
		// Population action listener
		for(int k = 0; k < rows; k++) {
			for(int j = 0; j < columns; j++) {
				population[k][j].addActionListener(this);
			}
		}

		setVisible(true);
	}
	
	private void displayGeneration(boolean[][] mirror) {
		for(int k = 0; k < rows; k++) {
			for(int j = 0; j < columns; j++) {
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
		JButton source = (JButton) event.getSource();
		if(source.getBackground() == Color.LIGHT_GRAY) {
			source.setBackground(Color.YELLOW);
		}
		else if(source.getBackground() == Color.YELLOW) {
			source.setBackground(Color.LIGHT_GRAY);
		}
		else if(source.getText() == "Mark") {
			enableBoard(true);
			nextButton.setEnabled(true);
			shop.resetHistory();
		}
		else if(source.getText() == "Next") {
			enableBoard(false);
			markButton.setEnabled(false);
			shop.resetMirror();
			
			for(int k = 0; k < rows; k++) {
				for(int j = 0; j < columns; j++) {
					if(population[k][j].getBackground() == Color.YELLOW) {
						shop.mirror[k][j] = true;
					}
					else if(population[k][j].getBackground() == Color.LIGHT_GRAY) {
						shop.mirror[k][j] = false;
					}
				}
			}
			
			shop.nextGeneration();
			northField.setText(shop.message);
			displayGeneration(shop.mirror);
			if(shop.finished == true) {
				nextButton.setEnabled(false);
			}
			
		}
		else if(source.getText() == "Reset") {
			shop.resetHistory();
			northField.setText("");
			resetBoard();
		}
		
	}

}

class ButtonListener extends Island implements ActionListener {
	
	public ButtonListener(int rows, int columns, Workshop shop) {
		super(rows, columns, shop);
		// TODO Auto-generated constructor stub
	}

	public void actionPerformed(ActionEvent event2) {
		if("Mark".equals(event2.getActionCommand())) {
			System.out.println("Mark button pressed");
		}
		else if("Next".equals(event2.getActionCommand())) {
			System.out.println("Next button pressed");
		}
		else if("Reset".equals(event2.getActionCommand())) {
			System.out.println("Reset button pressed");
		}
		System.out.println("A button was pressed");
		
		// When we did the lab over this I was told to just use one ActionListener in the original class instead of doing this?
		// It's honestly the only way I know how to do it, I can't get this second class listener to work.
	}
	
}
