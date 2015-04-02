package antena;

import java.util.ArrayList;
import java.util.List;

public class Field {
	
	private int size;
	private String[][] self;
	String[] antenas= {"A", "B", "C"};
	private List<int[]> antenaLocations = new ArrayList<int[]>();
	public List<int[]> targets = new ArrayList<int[]>();
			
	// public
	public Field(int size) {	
		this.size = size;
		this.self = new String[][]{
				{"A","H","H","H","H"},
				{"A","H","H","H","H"},
				{"A","H","H","H","H"},
				{"A","H","H","H","H"},
				{"A","H","H","H","H"}
			};
	}
	
	public String[][] self() {
		return self;
	}
	
	public int getSize() {
		return size;
	}
	
	public void print(){
		for (String[] row : self) {
			for (String cell : row) {
				System.out.print(cell + "");
			}
			System.out.println();
		}
	}

	public void run() {
		findAntenaPoints();
		removeTargets();
	}
	
	// private
	private List<int[]> findAntenaPoints() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if(include(antenas, self[i][j])) antenaLocations.add(new int[]{i , j});
			} 
		}
		return antenaLocations;
	}
	
	private void removeTargets() {
		for (int[] location : antenaLocations) {
			String antena = self[location[0]][location[1]];
			addAntenaTargets(location, antenaCoverage(antena));
		}

	}

	private void addAntenaTargets(int[] location, int coverage){
		int currentRow = location[0];
		int currentCol = location[1];
		//System.out.println(currentRow + " " + currentCol);
		for (int i = 1; i <= coverage; i++) {
			//up
			if(currentRow - i > 0 && self[currentRow - i][currentCol].equals("H")) targets.add(new int[]{currentRow - i, currentCol});
			//down
			if(currentRow + i < size && self[currentRow + i][currentCol].equals("H")) targets.add(new int[]{currentRow + i, currentCol});
			//left
			if(currentCol - i > 0 && self[currentRow][currentCol - i].equals("H")) targets.add(new int[]{currentRow, currentCol - i});	
			//right
			if(currentCol + i < size && self[currentRow][currentCol + i].equals("H")) targets.add(new int[]{currentRow, currentCol + i});
			//System.out.println("add Done!!");
		}

	}
	
	private boolean include(String[] arr, String str) {
		boolean flag = false;
		for (String string : arr) {
			if (string.equals(str)) flag= true; break;
		}
		return flag;
	}
	
	private int antenaCoverage(String antena){
		if(antena.equals("A")) return 1;
		if(antena.equals("B")) return 2;
		if(antena.equals("C")) return 3;
		return 0;
	}

}
