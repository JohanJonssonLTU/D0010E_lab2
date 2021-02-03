package lab2;

import java.awt.Color;

import lab2.level.Level;
import lab2.level.LevelGUI;
import lab2.level.Room;

public class Driver {

	public void run() {

//		task1
//		System.out.println("This is a print-out from the driver.");

		
//		task2 and 3
		Room room1 = new Room(4, 1, Color.cyan);
		Room room2 = new Room(6, 9, Color.green);
		Room room3 = new Room(5, 3, Color.darkGray);
		Room room4 = new Room(2, 4, Color.pink);
		Room room5 = new Room(5, 3, Color.red);
		Room room6 = new Room(6, 9, Color.yellow);
//		Room room7 = new Room(60, 90, Color.purple);
		
//			task2
		room1.connectNorthTo(room2);
		room2.connectNorthTo(room3);
		room3.connectWestTo(room1);
		room4.connectWestTo(room1);
			
//		System.out.println(room1);
//		System.out.println(room2);
//		System.out.println(room3);
//		System.out.println(room4);
		
		Level level1 = new Level();
		level1.place(room1, 3, 6);
		level1.place(room2, 20, 20);
		level1.place(room3, 70, 90);
		level1.place(room4, 100, 100);
		level1.place(room5, 9, 11);
		level1.place(room6, 9, 11);
		System.out.println(level1);
		

	}

}
