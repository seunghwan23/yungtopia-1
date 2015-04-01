package maze;

import java.util.ArrayList;
import java.util.List;

public class MazeRunner {

	private int[][] MAZE;
	private int SIZE;
	private int[] currentLocation;
	private List<int[]> tracks;

	public MazeRunner() {
		this.MAZE = new int[][] { { 0, 1, 1, 1, 1 }, { 1, 0, 1, 1, 1 },
				{ 0, 1, 1, 1, 1 }, { 0, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0 } };
		this.SIZE = this.MAZE.length - 1;
		this.currentLocation = new int[] { 0, 0 };
		tracks = new ArrayList<int[]>();

	}

	public void checkLocation() {
		// tracks.add(currentLocation());
		System.out.print(currentLocation[0] + "" + currentLocation[1] + " ");
	}

	public void escape() {
		checkLocation();
		while (true) {

			while (possible(right(currentLocation())))
				moveRight();

			while (possible(down(right(currentLocation()))))
				moveRightDown();

			while (possible(down(currentLocation())))
				moveDown();

			while (possible(left(down(currentLocation()))))
				moveLeftDown();

			while (possible(left(currentLocation())))
				moveLeft();

			while (possible(up(left(currentLocation()))))
				moveLeftUp();

			while (possible(up(currentLocation())))
				moveUp();

			while (possible(right(up(currentLocation()))))
				moveRightUp();

			if (isDestination()) break;
		}
	}

	// private from here

	private boolean isDestination() {
		return (this.currentLocation[0] == this.SIZE && this.currentLocation[1] == this.SIZE) ? true : false;
	}

	private int[] up(int[] location) {
		if (location == null)
			return null;
		if (0 < location[0]) {
			location[0] -= 1;
			return location;
		} else {
			return null;
		}
	}

	private int[] down(int[] location) {
		if (location == null)
			return null;
		if (location[0] < this.SIZE) {
			location[0] += 1;
			return location;
		} else {
			return null;
		}
	}

	private int[] left(int[] location) {
		if (location == null)
			return null;
		if (0 < location[1]) {
			location[1] -= 1;
			return location;
		} else {
			return null;
		}
	}

	private int[] right(int[] location) {
		if (location == null)
			return null;
		if (location[1] < this.SIZE) {
			location[1] += 1;
			return location;
		} else {
			return null;
		}
	}

	private void moveUp() {
		markHere();
		currentLocation[0] -= 1;
		checkLocation();
	}

	private void moveDown() {
		markHere();
		currentLocation[0] += 1;
		checkLocation();
	}

	private void moveLeft() {
		markHere();
		currentLocation[1] -= 1;
		checkLocation();
	}

	private void moveRight() {
		markHere();
		currentLocation[1] += 1;
		checkLocation();
	}

	private void moveRightUp() {
		markHere();
		currentLocation[1] += 1;
		currentLocation[0] -= 1;
		checkLocation();
	}

	private void moveLeftUp() {
		markHere();
		currentLocation[1] -= 1;
		currentLocation[0] -= 1;
		checkLocation();
	}

	private void moveLeftDown() {
		markHere();
		currentLocation[1] -= 1;
		currentLocation[0] += 1;
		checkLocation();
	}

	private void moveRightDown() {
		markHere();
		currentLocation[1] += 1;
		currentLocation[0] += 1;
		checkLocation();
	}


	private void markHere() {
		this.MAZE[currentLocation[0]][currentLocation[1]] = 2;
	}

	private int[] currentLocation() {
		return currentLocation.clone();
	}

	private boolean possible(int[] location) {
		boolean flag = false;
		if (location != null && valueOfLocation(location) == 0)
			flag = true;
		return flag;
	}

	private int valueOfLocation(int[] location) {
		return MAZE[location[0]][location[1]];
	}

}
