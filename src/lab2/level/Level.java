package lab2.level;

import java.util.ArrayList;
import java.util.Observable;

public class Level extends Observable {

	ArrayList<Room> allRooms;
	
	public Level() {
		this.allRooms = new ArrayList<Room>();
	}
	
	public boolean place(Room r, int x, int y) {

//		if (x < r.width & -y > r.height) {
//			return false;
//		}

		r.posX = x;
		r.posY = y;
		this.addRoom(r);
		return true;

	}
	
	private void addRoom(Room r) {
		this.allRooms.add(r);
	}

	public void firstLocation(Room r) {
		r.hasPlayer = true;
	}
	
//	public Room getRooms() {
//		
//		for (int i = 0; i < this.allRooms.size(); i++) {
//			return this.allRooms.get(i);
//		}
//		
//	}
	
	public String toString() {
		return this.allRooms.size() + "\n";
	}

}
