package lab2.level;

import java.util.ArrayList;
import java.util.Observable;

public class Level extends Observable {

	// lista som innehåller alla rum
	ArrayList<Room> allRooms;
	boolean hasRooms;

	public Level() {
		// initierar listan
		this.allRooms = new ArrayList<Room>();
		this.hasRooms = false;
	}

	public boolean place(Room r, int x, int y) {
//		this.isRoom(r, y);
		this.hasRooms();

		if (this.hasRooms == true) {

			for (int i = 0; i <= this.allRooms.size() - 1; i++) {

				int prevRoomWidth = this.allRooms.get(i).width;
				int prevRoomHeight = this.allRooms.get(i).height;
				int prevRoomX = this.allRooms.get(i).posX;
				int prevRoomY = this.allRooms.get(i).posY;

				return x < prevRoomX
				// &&
				// y - r.height < prevRoomY
				// &&
				// x + r.width > prevRoomX &&
				// prevRoomX + prevRoomWidth > x &&
				// x > prevRoomX &&
				// y < prevRoomY &&
				// x < prevRoomWidth &&
				// y > prevRoomHeight
				;
				// if (prevRoomX < prevRoomY) {
				// return false;

			}
		}

		r.posX = x;
		r.posY = y;
		this.addRoom(r);
		return true;

//		int prevRoomWidth = (this.allRooms.get( this.allRooms.size()) ).width;
//		int prevRoomHeight = (this.allRooms.get( this.allRooms.size()) ).height;
//		
//		//testar om rum överlappar FUNKAR EJ
//		if (prevRoomWidth < x & prevRoomHeight > y) {
//			return false;

		// sätter korrdinater för övre vänstra hörnet av nytt rum
//		r.posX = x;
//		r.posY = y;
//		this.addRoom(r);
//		return true;

	}

	// appenderar till listan med rum
	private void addRoom(Room r) {
		this.allRooms.add(r);
	}

//	private boolean isRoom(Room r, int y) {
//		return r.height >= y;
//	}

	// tilldelar ett rum spelare
	public void firstLocation(Room r) {
		r.hasPlayer = true;
	}

	private void hasRooms() {
		if (this.allRooms.size() == 0) {
			this.hasRooms = false;
		} else {
			this.hasRooms = true;
		}
	}

	public String toString() {

//		for (int i = 0; i < this.allRooms.size(); i++) {
//			return this.allRooms.get(i) + "\n";
//		}

		return this.allRooms.size() + "";
	}

}
