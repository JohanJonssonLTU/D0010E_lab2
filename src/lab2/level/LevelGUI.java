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
		d = new Display(lv,700,700);
		
		frame.getContentPane().add(d);
		frame.pack();
		frame.setLocation(0,0);
		frame.setVisible(true);
	}
	
	
	public void update(Observable arg0, Object arg1) {
//		d.repaint();
	}
	
	private class Display extends JPanel {
		
		
		public Display(Level fp, int x, int y) {
		

			addKeyListener(new Listener());
			
			setBackground(Color.white);
			setPreferredSize(new Dimension(x+20,y+20));
			setFocusable(true);
		}
	
		
		
		public void paintComponent(Graphics g) {
			
			super.paintComponent(g);
			
//			for (int i = 0; i < lv.numberOfRooms(); i++) {
//				
////				g.setColor(lv.getRoom(i).getColor());
//				
//				g.fillRect(lv.getRoom(i).getX(), 
//									lv.getRoom(i).getY(), 
//									lv.getRoom(i).getHeight(),
//									lv.getRoom(i).getHeight());
//				
//				g.setColor(lv.getRoom(i).getColor());
//				
//				g.drawRect(lv.getRoom(i).getX(), 
//									lv.getRoom(i).getY(), 
//									lv.getRoom(i).getHeight(),
//									lv.getRoom(i).getHeight());
				
//			}
			g.setColor(lv.getRoom(0).getColor());
			g.fillRect(lv.getRoom(0).getX(), lv.getRoom(0).getY(), lv.getRoom(0).getWidth(), -lv.getRoom(0).getHeight());
			g.setColor(lv.getRoom(0).getColor());
			g.drawRect(lv.getRoom(0).getX(), lv.getRoom(0).getY(), lv.getRoom(0).getWidth(), -lv.getRoom(0).getHeight());
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
