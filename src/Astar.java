import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Astar {
	
	Point start;
	Point end;
	char[][] grid;
	Point[][] grid_point = new Point[8][8];
	
	Point S;
	Point E;
	Point C;
	
	ArrayList<Point> open = new ArrayList<Point>();
	ArrayList<Point> closed = new ArrayList<Point>();
	ArrayList<Point> path = new ArrayList<Point>();
	
	public Astar(Point start, Point end, char[][] grid) {
		
		this.start = start;
		this.end = end;
		this.grid = grid;
			
	}
		
	public void generatePath(int Sx, int Sy, int Ex, int Ey) {
       
       Queue<Point> open = new LinkedList<Point>();

       open.add(grid_point[Sx][Sy]);

       while(true) {
           
    	   Point Point = open.poll();

           if(Point == null) {
        	   break;
           }
            
           if(Point == grid_point[Ex][Ey]) {
        	   closed.add(Point);
               break;
           }

           closed.add(Point);

          if(Point.y - 1 >= 0 && grid_point[Point.x][Point.y - 1].h != -1 && !open.contains(grid_point[Point.x][Point.y - 1]) && !closed.contains(grid_point[Point.x][Point.y - 1])) {
              grid_point[Point.x][Point.y - 1].g = Point.f;
              int f = grid_point[Point.x][Point.y - 1].h + grid_point[Point.x][Point.y - 1].g;
              if(grid_point[Point.x][Point.y - 1].f > f || !open.contains(grid_point[Point.x][Point.y - 1])) {
            	  grid_point[Point.x][Point.y - 1].f = f;
                  open.add(grid_point[Point.x][Point.y - 1]);
                  
                  grid[Point.x][Point.y - 1] = 'o'; 
                  grid_point[Point.x][Point.y - 1].parent = Point;
              }
          }
            

          if(Point.y + 1 < 8 && grid_point[Point.x][Point.y + 1].h != -1 && !open.contains(grid_point[Point.x][Point.y + 1]) && !closed.contains(grid_point[Point.x][Point.y + 1])) {
              grid_point[Point.x][Point.y + 1].g = Point.f;
              int f = grid_point[Point.x][Point.y + 1].h + grid_point[Point.x][Point.y + 1].g;
              if(grid_point[Point.x][Point.y + 1].f > f || !open.contains(grid_point[Point.x][Point.y + 1])) {
            	  grid_point[Point.x][Point.y + 1].f = f;
                  open.add(grid_point[Point.x][Point.y + 1]);
                  
                  grid[Point.x][Point.y + 1] = 'o';
                  grid_point[Point.x][Point.y + 1].parent = Point;  
              }
          }

          
          if(Point.x + 1 < 8 && grid_point[Point.x + 1][Point.y].h != -1 && !open.contains(grid_point[Point.x + 1][Point.y]) && !closed.contains(grid_point[Point.x + 1][Point.y])) {
              grid_point[Point.x + 1][Point.y].g = Point.f;
              int f = grid_point[Point.x + 1][Point.y].h + grid_point[Point.x + 1][Point.y].g ;
              if(grid_point[Point.x + 1][Point.y].f > f || !open.contains(grid_point[Point.x + 1][Point.y])) {
            	  grid_point[Point.x + 1][Point.y].f = f;
                  open.add(grid_point[Point.x + 1][Point.y]);
                  
                  grid[Point.x + 1][Point.y] = 'o';
                  grid_point[Point.x + 1][Point.y].parent = Point; 
              }
          }


          if(Point.x - 1 >= 0 && grid_point[Point.x - 1][Point.y].h != -1 && !open.contains(grid_point[Point.x - 1][Point.y]) && !closed.contains(grid_point[Point.x - 1][Point.y])) {
              grid_point[Point.x - 1][Point.y].g = Point.f;
              int f = grid_point[Point.x - 1][Point.y].h + grid_point[Point.x - 1][Point.y].g ;
              if(grid_point[Point.x - 1][Point.y].f > f || !open.contains(grid_point[Point.x - 1][Point.y])) {
            	  grid_point[Point.x - 1][Point.y].f = f;
            	  open.add(grid_point[Point.x - 1][Point.y]);
            	  
            	  grid[Point.x - 1][Point.y] = 'o';
            	  grid_point[Point.x - 1][Point.y].parent = Point; 
              }
          }
            
        }
        
        Point lastPoint = closed.get(closed.size() - 1);
        
        while(lastPoint.parent != null) {
            Point currentPoint = lastPoint;
            path.add(currentPoint);
            lastPoint = lastPoint.parent;
        }

        path.add(grid_point[Sx][Sy]);
        open.clear();

        if(grid_point[start.x][start.y].h != -1 && path.contains(grid_point[end.x][end.y])) {
            for (int i = 0; i < path.size() - 1; i++) {
            	grid[path.get(i).x][path.get(i).y] = 'a';
            }
        }
        
        grid[end.x][end.y] = 'e';
     

    }
	
	public void getG(char[][] grid, Point S) {
		
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				grid_point[i][j] = new Point(i, j);
				if(grid[i][j] != 'x') {
					grid_point[i][j].g = Math.abs(i - S.x) + Math.abs(j - S.y);
				}
			}
		}
	}
	
	public void getH(char[][] grid, Point E) {
		
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				grid_point[i][j] = new Point(i, j);
				if(grid[i][j] != 'x') {
					grid_point[i][j].h = Math.abs(i - E.x) + Math.abs(j - E.y);
				} else {
					grid_point[i][j].h = -1;
 				}
			}
		}
	}	

	
}
