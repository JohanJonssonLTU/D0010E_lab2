package lab2.level;

import java.util.ArrayList;
import java.util.Observable;

public class Level extends Observable {

	// lista som innehåller alla rum
	private ArrayList<Room> allRooms;
	private boolean hasRooms;
	private int roomCount = 1;

	public Level() {
		
		this.allRooms = new ArrayList<Room>();
		this.hasRooms = false;
		
	}

	private void addRoom(Room r) {
		roomCount++;
		this.allRooms.add(r);
	}
	
	Room getRoom(int i) {
		return this.allRooms.get(i);
	}
	
	int numberOfRooms() {
		return this.allRooms.size();
	}
	
	//Kollar om rum finns i level
	private boolean hasRooms() {
		
		if (numberOfRooms() == 0) {
			return false;
		} else {
			return true;
		}
		
	}
	
	boolean hasFirstLocation() {
		
		int i = 0;
		
		while (i < numberOfRooms()) {
			
			if (getRoom(i).isFirstLocation() == true) {
				return true;
			}
			
			i++;
			
		}
		
		return false;
		
	}
	
	//Kollar overlap
	private boolean overlap(Room r, int i, int x, int y) {
		
		int placedWidth = this.getRoom(i).getWidth();
		int placedHeight = this.getRoom(i).getHeight();
		int placedX = this.getRoom(i).getX();
		int placedY = this.getRoom(i).getY();
		
		int newHeight = r.getHeight();
		int newWidth = r.getWidth();
		int newX = x;
		int newY = y;
		
		return
			//Ny punkt sydöst 
			(
			newX >= placedX
			&&
			newX < placedX + placedWidth
			&&
			newY >= placedY
			&&
			newY < placedY + placedHeight
			)
			||
			//Existerande punkt sydöst/Ny punkt nordväst
			(
			placedX >= newX
			&&
			placedX < newX + newWidth
			&&
			placedY >= newY
			&&
			placedY < newY + newHeight
			)
			||
			//Ny punkt sydväst
			(
			newX <= placedX
			&&
			newY >= placedY
			&&
			newX + newWidth > placedX
			&&
			newY < placedY + placedHeight
			)
			||
			//Ny punkt nordöst
			(
			newX >= placedX
			&&
			newY <= placedY
			&&
			newX < placedX + placedWidth
			&&
			newY + newHeight > placedY
			)
		;
	}
	
	public boolean place(Room r, int x, int y) {
		
		//Kör överlappkoll om rum finns
		if (hasRooms() == true) {

			int i = 0;
			
			while (i < this.allRooms.size()) {
				
				if (this.overlap(r, i, x, y) == true) {
					return false;
				}
				
				i++;

			}
		}
		
		if (hasFirstLocation() == true) {
			return false;
		} else {
		
			// sätter koordinater för övre vänstra hörnet av nytt rum
			r.setX(x);
			r.setY(y);
			r.setId(roomCount);
			this.addRoom(r);
			return true;
			
		}
	}
	
//tilldelar ett rum ursprunglig spelare
	public boolean firstLocation(Room r) {
		
		int i = 0;
		
		while (i < numberOfRooms()) {
			
			if (getRoom(i).isFirstLocation() == true) {
				return false;
			} 
			
			i++;
			
		}
		
		r.setPlayerStatus(true);
		r.setFirstLocation(true);
		return true;
		
	}

	public Room playerLocation() {
		
		int i = 0;
		
		while (i < numberOfRooms()) {
			
			if (getRoom(i).getPlayerStatus() == true) {
				break;
			}
			
			i++;
			
		}
		
		return getRoom(i);
		
	}
	
	//Move player
	void playerMoveNorth(Room r) {
		r.setPlayerStatus(false);
		r.northConnection().setPlayerStatus(true);
		setChangedNotify();
	}
	
	void playerMoveEast(Room r) {
		r.setPlayerStatus(false);
		r.eastConnection().setPlayerStatus(true);
		setChangedNotify();
	}
	
	void playerMoveSouth(Room r) {
		r.setPlayerStatus(false);
		r.southConnection().setPlayerStatus(true);
		setChangedNotify();
	}
	
	void playerMoveWest(Room r) {
		r.setPlayerStatus(false);
		r.westConnection().setPlayerStatus(true);
		setChangedNotify();
	}
	
	private void setChangedNotify() {
		setChanged();
		notifyObservers();
	}
	
	public void printPlayerLocation() {
	 		
	 		String playerRoomS = "";
	 		
	 		for (int i = 0; i < this.numberOfRooms(); i++) {
	 			if (this.getRoom(i).getPlayerStatus() == true ) {
		 			playerRoomS +=
						"Player in room " + this.getRoom(i).getId() + "\n";
	 			} else {
	 				continue;
	 			}
	 		}
	 		
	 		System.out.println(playerRoomS);
	 	}
	
	private String roomPositions() {
		
		String coordinatesById = "";
		
		for (int i = 0; i < this.numberOfRooms(); i++) {
			coordinatesById +=
			"iD = " + this.getRoom(i).getId() + "\n" +
			"X = " + this.getRoom(i).getX() + "\n" +
			"Y = " + this.getRoom(i).getY() + "\n" + "\n";
		}
		
		return coordinatesById;
		
	}
	
	public String toString() {
		return 
			roomPositions() +
			"Number of rooms = " + numberOfRooms() + "\n";
	}

}
