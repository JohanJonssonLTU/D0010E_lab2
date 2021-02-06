package lab2.level;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class LevelGUI implements Observer {

	private Level lv;
	private Display d; 
	
	public LevelGUI(Level level, String name) {
		
		this.lv = level;
		
		d = new Display(lv,700,700);
		
		JFrame frame = new JFrame(name);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(d);
		frame.pack();
		frame.setLocation(0,0);
		frame.setVisible(true);
		
		lv.addObserver(this);
	}
	
	
	public void update(Observable arg0, Object arg1) {
		d.repaint();
	}
	
	private class Display extends JPanel {
		
		
		public Display(Level fp, int x, int y) {
			addKeyListener(new Listener());
			setBackground(Color.black);
			setPreferredSize(new Dimension(x+20,y+20));
			setFocusable(true);
		}
	
		public void paintComponent(Graphics g) {
			
			super.paintComponent(g);

			for (int i = 0; i < lv.numberOfRooms(); i++) {
				
				if (lv.getRoom(i).getPlayerStatus() == true){
					
					g.setColor(lv.getRoom(i).getColor());
					
					g.fillRect(
						lv.getRoom(i).getX(), 
						lv.getRoom(i).getY(), 
						lv.getRoom(i).getWidth(),
						lv.getRoom(i).getHeight()
						);
						
						g.setColor(Color.white);
					
					g.drawRect(
						lv.getRoom(i).getX()-10, 
						lv.getRoom(i).getY()-10, 
						lv.getRoom(i).getWidth() + 20,
						lv.getRoom(i).getHeight() + 20
						);
				
				} else {
					
					g.setColor(lv.getRoom(i).getColor());
					
					g.fillRect(
						lv.getRoom(i).getX(), 
						lv.getRoom(i).getY(), 
						lv.getRoom(i).getWidth(),
						lv.getRoom(i).getHeight()
						);
					
					g.setColor(Color.white);

					g.drawRect(
						lv.getRoom(i).getX(), 
						lv.getRoom(i).getY(), 
						lv.getRoom(i).getWidth(),
						lv.getRoom(i).getHeight()
						);
					
				}	
			}
			
		}
		
	 	private class Listener implements KeyListener {
	 		
	 		public void keyPressed(KeyEvent arg0) {
	 		}

	 		public void keyReleased(KeyEvent arg0) {
	 		}

	 		public void keyTyped(KeyEvent event) {
	 			
	 			switch (event.getKeyChar()) {
	 			
				case 'w':
					
					System.out.println("w is espresso");
					
					if (lv.playerLocation().northConnection() == null) {
						System.out.println("You hit a wall!");
					} else {
						lv.playerMoveNorth(lv.playerLocation());
					}
					
					lv.printPlayerLocation();
					
					break;
				
				case 'd':
					
					System.out.println("d is espresso");
					
					if (lv.playerLocation().eastConnection() == null) {
						System.out.println("You hit a wall!");
					} else {
						lv.playerMoveEast(lv.playerLocation());
					}
					
					lv.printPlayerLocation();
					
					break;
				
				case 's':
					
					System.out.println("s is espresso");
					
					if (lv.playerLocation().southConnection() == null) {
						System.out.println("You hit a wall!");
					} else {
						lv.playerMoveSouth(lv.playerLocation());
					}
					
					lv.printPlayerLocation();
					
					break;
					
				case 'a':
					
					System.out.println("a is espresso");
					
					if (lv.playerLocation().westConnection() == null) {
						System.out.println("You hit a wall!");
					} else {
						lv.playerMoveWest(lv.playerLocation());
					}
					
					lv.printPlayerLocation();
					
					break;
				}
	 		}
	 	}
	
	}
		
}
