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
		Room room1 = new Room(5, 5, Color.cyan);
		Room room2 = new Room(5, 5, Color.green);
		Room room3 = new Room(5, 5, Color.darkGray);
		Room room4 = new Room(5, 5, Color.pink);
		Room room5 = new Room(5, 5, Color.red);
		Room room6 = new Room(5, 5, Color.yellow);

//			task2
		room1.connectNorthTo(room2);
		room2.connectNorthTo(room3);
		room3.connectWestTo(room4);
		room4.connectWestTo(room5);
		room5.connectWestTo(room6);
		room6.connectWestTo(room2);

		System.out.println(room1);
		System.out.println(room2);
		System.out.println(room3);
		System.out.println(room4);
	  System.out.println(room5);
	  System.out.println(room6);

		// ny place() om nya x är mindre än de existerande.
		Level level1 = new Level();
		level1.place(room1, 50, 50);
		level1.place(room2, 100, 100);
		level1.place(room3, 200, 200);
		level1.place(room4, 300, 300);
		level1.place(room5, 400, 400);
		level1.place(room6, 500, 500);
		System.out.println(level1);

	}

}
