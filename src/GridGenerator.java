import java.util.Random;

public class GridGenerator {
	
	public char[][] grid = new char[8][8];
	
	public GridGenerator(char[][] grid) {
		this.grid = grid;
	}
	
	public void initGrid() {
		
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				grid[i][j] = '0';
			}
		}	
	}
	
	public void generateObstacle() {
		
		Random random = new Random();
		int posX, posY;
		posX = posY = 0;
		posX = random.nextInt(5 - 1) + 1;
		posY = random.nextInt(4 - 1) + 1;
		grid[posX][posY] = 'x';
		System.out.println(posX + " " + posY);
 
		int letter;
		letter = (int) (Math.random() * 3);
		switch(letter) {
			case 0: // T
				grid[posX][posY + 1] = 'x';
				grid[posX][posY + 2] = 'x';
				grid[posX + 1][posY + 1] = 'x';
				grid[posX + 2][posY + 1] = 'x';
				grid[posX + 3][posY + 1] = 'x';
				break;
			case 1: // L
				grid[posX + 1][posY] = 'x';
				grid[posX + 2][posY] = 'x';
				grid[posX + 3][posY] = 'x';
				grid[posX + 3][posY + 1] = 'x';
				grid[posX + 3][posY + 2] = 'x';
				break;
			case 2: // I
				grid[posX][posY + 1] = 'x';
				grid[posX][posY + 2] = 'x';
				grid[posX + 1][posY + 1] = 'x';
				grid[posX + 2][posY + 1] = 'x';
				grid[posX + 3][posY + 1] = 'x';
				grid[posX + 3][posY + 2] = 'x';
				grid[posX + 3][posY] = 'x';
				break;
		}		
	}
		
	public void displayGrid() {
		
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
	}
	
	

}
