import java.util.ArrayList;


public class Workshop {
	
	String message; // Output of game outcome
	boolean finished; // True if game ends
	boolean[][] mirror; // Represents current generation, true/false for living/dead squares
	boolean[][] allFalse; // False array used for comparison
	
	ArrayList<boolean[][]> history = new ArrayList<boolean[][]>();
	
	int rows, columns; // Grid dimensions
	
	int minLifeToLife, maxLifeToLife, minDeadToLife, maxDeadToLife; // Life parameters
	
	public Workshop(int r, int col) {
		rows = r;
		columns = col;
	}
	
	public void resetMirror() {
		mirror = new boolean[rows][columns];
	}
	
	public void resetHistory() {
		history = new ArrayList<boolean[][]>();
		history.clear();
	}
	
	private boolean isAlive(int k, int j) {
		boolean alive = false;
		if(k < rows && j < columns && k >= 0 && j >= 0) {
			if (mirror[k][j] == true && k >= 0 && j >= 0) {
				alive = true;
			}
		}
		else {
			alive = false;
		}
		return alive;
	}
	
	private int neighborCount(int k, int j) {
		int count = 0;
		
		if(isAlive(k-1,j-1) == true) {
			count++;
		}
		if(isAlive(k-1, j) == true) {
			count++;
		}
		if(isAlive(k-1, j+1) == true) {
			count++;
		}
		if(isAlive(k, j-1) == true) {
			count++;
		}
		if(isAlive(k, j+1) == true) {
			count++;
		}
		if(isAlive(k+1, j-1) == true) {
			count++;
		}
		if(isAlive(k+1, j) == true) {
			count++;
		}
		if(isAlive(k+1, j+1) == true) {
			count++;
		}
		
		return count;
	}
	
	private boolean equals(boolean[][] arrA, boolean[][] arrB) {
		boolean tf = false;
		
		for(int k = 0; k < arrA.length || k < arrB.length; k++) {
			for(int j = 0; j < arrA.length || j < arrB.length; j++) {
				if(arrA[k][j] == arrB[k][j]) {
					tf = true;
					if(tf == false) { // Basically a break statement, if one false statement then whole search ends and returns false
						k = arrA.length + arrB.length;
					}
				}
			}
		}
		
		return tf;
	}
	
	private int listPositionOf(boolean[][] target) {
		int position = 0, counter = 1;
		for(int k = 0; k < target.length; k++) {
			for(int j = 0; j < target.length; j++) {
				if(target[k][j] == mirror[k][j]) {
					counter = 1;
				}
				else {
					counter = 0;
				}
			}
		}
		if(counter == 1) {
			return position;
		}
		else {
			return counter;
		}
	}
	
	public void nextGeneration() {
		int aliveNeighbors = 0;
		
		history.add(mirror);
		finished = false;
		boolean[][] next = new boolean[rows][columns];
		
		for(int k = 0; k < rows; k++) {
			for(int j = 0; j < columns; j++) { // Nested for loop, iterate through the mirror values
				aliveNeighbors = neighborCount(k, j);
				
				if(mirror[k][j] == true) { // If square is alive
					if(aliveNeighbors == 2 || aliveNeighbors == 3) { // If two or three living neighbors
						next[k][j] = true; // Remains alive
					}
					else if(aliveNeighbors < 2) { // If fewer than two living neighbors
						next[k][j] = false; // Dies of loneliness
					}
					else if(aliveNeighbors >= 4) { // If four or more living neighbors
						next[k][j] = false; // Dies of overpopulation
					}
				}
				
				else if(mirror[k][j] == false) { // If square is dead
					if(aliveNeighbors == 2 || aliveNeighbors == 3) { // If exactly two or three living neighbors
						next[k][j] = true; // Comes to life
					}
					else { // If any other cases
						next[k][j] = false; // Remains dead
					}
				}
				
			}
		}
		if(next.equals(allFalse)) { // Extinct message
			message = "After " + history.size() + " generations life is extinct in Island";
			mirror = next;
			finished = true;
		}
		else {
			int posOfNext = listPositionOf(next);
			if(posOfNext > 0) {
				message = "After " + (posOfNext-1) + " generations life is cyclic of length " + (history.size() - posOfNext + 1);
				mirror = next;
				finished = true;
			}
			else {
				mirror = next;
				message = "Go on!!";
			}
			
		}
		
	}
	
	

}
