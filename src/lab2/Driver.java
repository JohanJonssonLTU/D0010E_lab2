package lab2;

import java.awt.Color;

import lab2.level.Level;
import lab2.level.LevelGUI;
import lab2.level.Room;

public class Driver {

	public void run() {

		System.out.println("This is a print-out from the driver. \n");
		
		//Skapar nivå
		Level level1 = new Level();
		
		//Skapar rum
		Room room1 = new Room(50, 50, Color.cyan);
		Room room2 = new Room(90, 20, Color.green);
		Room room3 = new Room(20, 90, Color.darkGray);
		Room room4 = new Room(90, 20, Color.pink);
		Room room5 = new Room(90, 90, Color.red);
		Room room6 = new Room(20, 90, Color.yellow);
		Room room7 = new Room(70, 70, Color.red);
		
		//Placerar rum
		level1.place(room1, 100, 100);
		room1.connectEastTo(room2, level1);
		
		//Testrum för place()
		//1
		level1.place(room7, 105, 105);
		room1.connectEastTo(room1, level1);
		//2
		level1.place(room7, 95, 105);
		room1.connectEastTo(room1, level1);
		//3
		level1.place(room7, 95, 95);
		room1.connectEastTo(room1, level1);
		//4
		level1.place(room7, 105, 95);
		room1.connectEastTo(room1, level1);
		
		level1.place(room2, 150, 100);
		room2.connectWestTo(room1, level1);
		room2.connectEastTo(room3, level1);
		
		level1.place(room3, 240, 100);
		room3.connectWestTo(room2, level1);
		level1.firstLocation(room2); //start location
		room3.connectSouthTo(room4, level1);
		
		level1.place(room4, 170, 190);
		room4.connectNorthTo(room3, level1);
		room4.connectWestTo(room5, level1);
		
		level1.place(room5, 80, 190);
		room5.connectEastTo(room4, level1);
		room5.connectSouthTo(room6, level1);
		
		level1.place(room6, 80, 280);
		room6.connectNorthTo(room5, level1);
		
		//Skapar GUI
		new LevelGUI(level1, "Level 1");
		
		//printar misc info
		System.out.println(level1);
		
		System.out.println(room1);
		System.out.println(room2);
		System.out.println(room3);
		System.out.println(room4);
	  System.out.println(room5);
	  System.out.println(room6);
	  
	  level1.printPlayerLocation();
	  
	}

}
