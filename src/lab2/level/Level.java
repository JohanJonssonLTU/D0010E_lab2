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
		
		for (int i = 0; i <= this.allRooms.size(); i++) {
			int prevRoomWidth = this.allRooms.get(i).width;
			int prevRoomHeight = this.allRooms.get(i).height;
			
			if (prevRoomWidth < x & prevRoomHeight > y) {
				return false;
			}
		}
		
//		int prevRoomWidth = (this.allRooms.get( this.allRooms.size()) ).width;
//		int prevRoomHeight = (this.allRooms.get( this.allRooms.size()) ).height;
//		
//		//testar om rum överlappar FUNKAR EJ
//		if (prevRoomWidth < x & prevRoomHeight > y) {
//			return false;
		
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
	
	public String toString() {
		
//		for (int i = 0; i < this.allRooms.size(); i++) {
//			return this.allRooms.get(i) + "\n";
//		}
		
		return this.allRooms.get(0) +  "\n" +
					this.allRooms.get(1) +  "\n" +
					this.allRooms.get(2) +  "\n" +
					this.allRooms.get(3) +  "\n" +
					this.allRooms.get(4) +  "\n" +
					this.allRooms.get(5);
	}

}
