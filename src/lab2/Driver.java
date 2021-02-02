package lab2;

import java.awt.Color;

import lab2.level.Level;
import lab2.level.LevelGUI;
import lab2.level.Room;

public class Driver {

	public static void run() {
//		System.out.println("This is a print-out from the driver.");
		Room room = new Room(40, 60, Color.blue);
		Room room1 = new Room(70, 80, Color.yellow);
		Room room2 = new Room(20, 100, Color.cyan);
		
		System.out.println(room);
		System.out.println(room.color);
		System.out.println(room1);
		System.out.println(room1.color);
		System.out.println(room2);
		System.out.println(room2.color);
	}
	
}
