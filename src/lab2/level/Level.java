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
		
		//Finns rum i level?
		this.hasRooms();
		
		//Kör överlappkoll om rum finns
		if (this.hasRooms == true) {

			int i = 0;
			
			while (i < this.allRooms.size()) {
				
				//Använder ny metod som kollar overlap
				if (this.overlap(r, i, x, y) == true) {
					return false;
				}
				
				i++;

			}
		}
		
	// sätter korrdinater för övre vänstra hörnet av nytt rum
		r.posX = x;
		r.posY = y;
		this.addRoom(r);
		return true;

	}

	// appenderar till listan med rum
	private void addRoom(Room r) {
		this.allRooms.add(r);
	}

	// tilldelar ett rum spelare
	public void firstLocation(Room r) {
		r.hasPlayer = true;
	}

	//Kollar om rum finns
	private void hasRooms() {
		if (this.allRooms.size() == 0) {
			this.hasRooms = false;
		} else {
			this.hasRooms = true;
		}
	}
	
	//Kollar overlap
	private boolean overlap(Room r, int i, int x, int y) {
		
		int placedRoomWidth = this.allRooms.get(i).width;
		int placedRoomHeight = this.allRooms.get(i).height;
		int placedRoomX = this.allRooms.get(i).posX;
		int placedRoomY = this.allRooms.get(i).posY;
		
		//Overlapkoll
		return
				//Ny punkt sydöst 
				(
				x >= placedRoomX
				&&
				x < placedRoomX + placedRoomWidth
				&&
				y <= placedRoomY
				&&
				y > placedRoomY + placedRoomHeight
				)
				||
				//Existerande punkt sydöst
				(
				placedRoomX >= x
				&&
				placedRoomX < x + r.width
				&&
				placedRoomY <= y
				&&
				placedRoomY > y + r.height
				)
				||
				//Ny punkt sydväst
				(
				x <= placedRoomX
				&&
				y <= placedRoomY
				&&
				x + r.width > placedRoomX
				&&
				y > placedRoomY + placedRoomHeight
				)
				||
				//Ny punkt nordöst
				(
				x >= placedRoomX
				&&
				y >= placedRoomY
				&&
				x < placedRoomX + placedRoomWidth
				&&
				y + r.height < placedRoomY
				);
	}

	//Visar listan
	public String toString() {
		return this.allRooms.size() + "";
	}

}
