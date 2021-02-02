package lab2.level;

import java.util.Observable;

public class Level extends Observable {

	public boolean place(Room r, int x, int y) {
		
		if (x > r.dx & -y < r.dy) {
			return false;
		}
		r.dx = x;
		r.dy = y;
		return true;
	}

	public void firstLocation(Room r) {

	}

}
