package lab2.level;

import java.awt.Color;

public class Room {

	int dx, dy; 
	int lowerLeft, upperRight, upperLeft;
	double lowerRight;
	Color color;
	Room northWall, eastWall, southWall, westWall;

	public Room(int dx, int dy, Color color) {
		this.dx = dx;
		this.dy = dy;
		this.color = color;
		this.northWall = null;
		this.eastWall = null;
		this.southWall = null;
		this.westWall = null;
		this.lowerRight = -(Math.sqrt(Math.pow(dx, 2)+Math.pow(dy, 2)));
		this.lowerLeft = -dy;
		this.upperRight = dx;
		this.upperLeft = 0;
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

//	public String toString() {
//		return this.northWall;
//	}

}
