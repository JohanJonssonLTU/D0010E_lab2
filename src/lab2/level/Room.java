package lab2.level;

import java.awt.Color;

public class Room {

	int posX, posY, width, height;
	Color color;
	Room northWall, eastWall, southWall, westWall;
	boolean hasPlayer;
	int id;
	private static int counter = 0;

	public Room(int dx, int dy, Color color) {
		
		counter++;
		this.id = currentNum();
		
		this.posX = 0;
		this.posY = 0;
		this.width = dx;
		this.height = -dy;
		this.color = color;
		
		this.northWall = null;
		this.eastWall = null;
		this.southWall = null;
		this.westWall = null;
		
		this.hasPlayer = false;
		
	}

	private int currentNum() {
		return counter;
	}
	
	public void connectNorthTo(Room r) {
		this.northWall = r;
	}

	public void connectEastTo(Room r) {
		this.eastWall = r;
	}

	public void connectSouthTo(Room r) {
		this.southWall = r;
	}

	public void connectWestTo(Room r) {
		this.westWall = r;
	}
	
	public String toString() {
		return 
				"id = " + this.id + "\n" +
				"width = " + this.width + "\n" +
				"height = " + this.height + "\n" ;
	}

}
