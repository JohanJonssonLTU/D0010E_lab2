package lab2.level;

import java.awt.Color;

public class Room {

	private int posX, posY, width, height;
	private Color color;
	private Room northWall, eastWall, southWall, westWall;
	private boolean hasPlayer;
	private int id;
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
	
	int getId() {
		return this.id;
	}
	
	Color getColor() {
		return this.color;
	}
	
	//Är spelare i rum?
	boolean getPlayerStatus() {
		return this.hasPlayer;
	}
	
	void setPlayerStatus(boolean hasPlayer) {
		this.hasPlayer = hasPlayer;
	}
	
	//Get position
	int getX() {
		return this.posX;
	}
	
	int getY() {
		return this.posY;
	}
	
	//Set position
	void setX(int x) {
		this.posX = x;
	}
	
	void setY(int y) {
		this.posY = y;
	}
	
	//Get dimensions
	int getHeight() {
		return this.height;
	}
	
	int getWidth() {
		return this.width;
	}
	
	//Koppla samman med existerande rum
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
	
	//Vägar mellan rum
	
	public String toString() {
		return 
				"id = " + this.id + "\n" +
				"width = " + this.width + "\n" +
				"height = " + this.height + "\n" ;
	}

}
