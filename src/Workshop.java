import java.util.ArrayList;


public class Workshop {
	
	String message; // Output of game outcome
	boolean finished; // True if game ends
	boolean[][] mirror; // Represents current generation, true/false for living/dead squares
	boolean[][] allFalse;
	
	ArrayList<boolean[][]> history;
	
	int rows, columns; // Grid dimensions
	
	int minLifeToLife, maxLifeToLife, minDeadToLife, maxDeadToLife; // Life paramaters
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public Workshop(int r, int col) {
		rows = r;
		columns = col;
	}
	
	public void resetMirror() {
		boolean[][] mirror = new boolean[rows][columns];
	}
	
	public void resetHistory() {
		history.clear();
	}
	
	private boolean isAlive(int k, int j) {
		boolean tf = false;
		if (mirror[k][j] == true) {
			tf = true;
		}
		return tf;
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
		
		for(int k = 0; k <= arrA.length || k <= arrB.length; k++) {
			for(int j = 0; j <= arrA.length || j <= arrB.length; j++) {
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
		int position = 0;
		return position;
	}
	
	public void nextGeneration() {
		
	}
	
	

}
