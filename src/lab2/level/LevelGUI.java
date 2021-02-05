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
		
		JFrame frame = new JFrame(name);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// TODO: You should change 200 to a value 
		// depending on the size of the level
		d = new Display(lv,600,600);
		
		frame.getContentPane().add(d);
		frame.pack();
		frame.setLocation(0,0);
		frame.setVisible(true);
	}
	
	
	public void update(Observable arg0, Object arg1) {
		
	}
	
	private class Display extends JPanel {
		
		
		public Display(Level fp, int x, int y) {
		

			addKeyListener(new Listener());
			
			setBackground(Color.GREEN);
			setPreferredSize(new Dimension(x+20,y+20));
			setFocusable(true);
		}
	
		
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			for (int i = 1; i < numberOfRooms(); i++) {
				g.fillRect(50, 50, 100, 100);
				g.setColor(Color.black);
				g.drawRect(50, 50, 100, 100);
			}
			
		}
		
		private int numberOfRooms() {
			return 0;
		}
		
		private Color currentRoomColor() {
			return Color.blue;
		}
		
		private int roomWidth() {
			return 0;
		}
		
	 	private class Listener implements KeyListener {

	 		
	 		public void keyPressed(KeyEvent arg0) {
	 		}

	 		public void keyReleased(KeyEvent arg0) {
	 		}

	 		public void keyTyped(KeyEvent event) {
	 		}
	 	}

	}
	
	public String toString() {
		return "";
	}
	
}
