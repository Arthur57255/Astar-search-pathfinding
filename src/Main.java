import java.util.Random;

public class Main {
	
	public static char[][] grid = new char[8][8];

	public static void main(String[] args) {
		
		GridGenerator gridGen = new GridGenerator(grid);
		
		gridGen.initGrid();
		gridGen.generateObstacle();
		
		Window window = new Window(grid);
		
	}
	
	

}
