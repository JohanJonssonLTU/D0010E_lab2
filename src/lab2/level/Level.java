package lab2.level;

import java.util.ArrayList;
import java.util.Observable;

public class Level extends Observable {

	//lista som innehåller alla rum
	ArrayList<Room> allRooms;
	
	public Level() {
		//initierar listan
		this.allRooms = new ArrayList<Room>();
	}
	
	public boolean place(Room r, int x, int y) {

		//testar om rum överlappar FUNKAR EJ
		if (x < r.width & -y > r.height) {
			return false;
		}

		//sätter korrdinater för övre vänstra hörnet av nytt rum
		r.posX = x;
		r.posY = y;
		this.addRoom(r);
		return true;

	}
	
	//appenderar till listan med rum
	private void addRoom(Room r) {
		this.allRooms.add(r);
	}

	//tilldelar ett rum spelare
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
