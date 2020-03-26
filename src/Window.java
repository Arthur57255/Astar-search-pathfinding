import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {
	
	public int mx = 0;
	public int my = 0;
	public int count = 0;
	
	public char[][] grid;

	JButton launch = new JButton("Launch");

	public Window(char[][] grid) {
		
		this.setTitle("A*");
		this.setSize(500, 510);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		launch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Point start = null, end = null;
				
				for(int i = 0; i < 8; i++) {
					for(int j = 0; j < 8; j++) {
						if(grid[i][j] == 's') {
							start = new Point(i, j);
						}
						if(grid[i][j] == 'e') {
							end = new Point(i, j);
						}
					}
				}
				
				Astar astar = new Astar(start, end, grid);
				astar.getG(grid, start);
				astar.getH(grid, end);
				astar.generatePath(start.x, start.y, end.x, end.y);
				
				repaint();
				
			}
		});
		
			
		Box box = new Box(grid);
		box.add(launch);
		this.setContentPane(box);
		Click click = new Click();
		this.addMouseListener(click);
		this.setVisible(true);
	}

	
	public class Box extends JPanel {
		
		public char[][] grid;
		
		public Box(char[][] grid) {
			this.grid = grid;
		}
		
		public void paintComponent(Graphics g) {
			
			g.setColor(Color.DARK_GRAY);
			g.fillRect(0, 0, 500, 510);
			g.setColor(Color.white);
			for(int i = 0; i < 8; i++) {
				for(int j = 0; j < 8; j++) {
					if(mx > i * 51 + 40 && mx < i * 51 + 51 + 40 && my >= j * 51 + 66 && my <  j * 51 + 51 + 66 && grid[j][i] != 'x') {
						if(count == 1 && grid[j][i] != 's') {
							grid[j][i] = 'e';
							count++;
						}
						if(count == 0) {
							grid[j][i] = 's';
							count++;
						}	
					}
					if(grid[j][i] == 'x') {
						g.setColor(Color.black);
					}
					if(grid[j][i] == 'o') {
						g.setColor(Color.magenta);
					}
					if(grid[j][i] == 'a') {
						g.setColor(Color.orange);
					}
					if(grid[j][i] == 's') {
						g.setColor(Color.green);
					}
					if(grid[j][i] == 'e') {
						g.setColor(Color.red);
					}
					
					g.fillRect(35 + i * 51, 25 + j * 51 + 10, 50, 50);
					g.setColor(Color.white);
				}
			}
		}
	}
	
	public class Click implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			mx = e.getX();
			my = e.getY();
			repaint();
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public char[][] getGrid() {
		return this.grid;
	}

	
}
