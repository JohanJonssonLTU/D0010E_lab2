package lab2.level;

import java.util.List;
import java.util.Observable;

public class Level extends Observable {

	List<Room> rooms;
	
	public Level() {
		this.rooms = null;
	}
	
	public boolean place(Room r, int x, int y) {

		if (x < r.width & -y > r.height) {
			return false;
		}

		r.posX = x;
		r.posY = y;
		this.addRoom(r);
		return true;

	}
	
	private void addRoom(Room r) {
		this.rooms.add(r);
	}

	public void firstLocation(Room r) {
		r.hasPlayer = true;
	}
	

}
