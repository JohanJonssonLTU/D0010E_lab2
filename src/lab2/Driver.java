package lab2;

import java.awt.Color;

import lab2.level.Level;
import lab2.level.LevelGUI;
import lab2.level.Room;

public class Driver {

	public void run() {

		System.out.println("This is a print-out from the driver. \n");

		Room room1 = new Room(50, 50, Color.cyan);
		Room room2 = new Room(90, 20, Color.green);
		Room room3 = new Room(20, 90, Color.darkGray);
		Room room4 = new Room(90, 20, Color.pink);
		Room room5 = new Room(90, 90, Color.red);
		Room room6 = new Room(20, 90, Color.yellow);

		//Connections
		room1.connectEastTo(room2);
		
		room2.connectEastTo(room3);
		room2.connectWestTo(room1);
		
		room3.connectWestTo(room2);
		room3.connectSouthTo(room4);
		
		room4.connectNorthTo(room3);
		room4.connectWestTo(room5);
		
		room5.connectSouthTo(room6);
		room5.connectEastTo(room4);
		
		room6.connectNorthTo(room5);

		Level level1 = new Level();
		
		level1.place(room1, 100, 100);
		level1.place(room2, 150, 100);
		level1.place(room3, 240, 100);
		level1.place(room4, 170, 190);
		level1.place(room5, 80, 190);
		level1.place(room6, 80, 280);
		
		level1.firstLocation(room5);
		
		System.out.println(level1);
		
		System.out.println(room1);
		System.out.println(room2);
		System.out.println(room3);
		System.out.println(room4);
	  System.out.println(room5);
	  System.out.println(room6);
	  
	  new LevelGUI(level1, "Level 1");
	  
	  level1.printPlayerLocation();
	  
	}

}
