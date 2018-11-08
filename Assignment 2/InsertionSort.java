/*
 * Logan Thomas
 * CS-203 Fall 2016
 * Programming Assignment 2
 * InsertionSort class: Class to define the insertion sort object
 */

public class InsertionSort {
	private int[] sortedArray;
	private int comparisons;
	private int swaps;
	private long cpuTime;
	
	public InsertionSort() {
		this.sortedArray = null;
		this.comparisons = 0;
		this.swaps = 0;
		this.cpuTime = 0;
	}
	
	/*
	 * Method: printArray
	 * Purpose: Prints the sorted array
	 * Parameters: none
	 * Returns: Nothing
	 */
	public void printArray() {
		for (int i = 0; i < this.sortedArray.length; i++) {
			System.out.print(this.sortedArray[i] + ",");
		}
	}
	
	public int getValue(int index) {
		return this.sortedArray[index];
	}
	
	public int getComparisons() {
		return this.comparisons;
	}
	
	public int getSwaps() {
		return this.swaps;
	}
	
	public long getCpuTime() {
		return this.cpuTime;
	}
	
	/*
	 * Method: SortLowToHigh
	 * Purpose: Sorts the passed array
	 * Parameters: number array and length
	 * Returns: Nothing
	 */
	public void SortLowToHigh(int[] num, int length) {
		// Sets the sorted array stored in the object to point to the passed array
		this.sortedArray = num;
		// Keeps track of the number of swaps
		this.swaps = 0;
		// Keeps track of the number of comparisons
		this.comparisons = 0;
		// Holds the current number and iteration
		int j;
		int currNum;
		
		long cpuTimeStart = 0, cpuTimeStop = 0;
		
		
		try {
			cpuTimeStart = System.nanoTime();// Stores the start time
			for (int i = 1; i < length; i++) {
				currNum = num[i]; // Stores the number at the current index into currNum
				// Compares the currNum to the number before it and shifts the number before it to the right
				// until the number before currrNum is smaller than currNum
				for (j = i - 1; (j >= 0) && (num[j] >= currNum); j--) {
					num[j + 1] = num[j];
					swaps++;
					this.comparisons++;
				}
				// Sets the current i value to currNum
				num[j + 1] = currNum;
				this.comparisons++;
			}
			cpuTimeStop = System.nanoTime();// Stores the end time
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		this.cpuTime = cpuTimeStop - cpuTimeStart;// Computes the time difference
	}
	
	/*
	 * Method: SortHighToLow
	 * Purpose: Sorts the passed array
	 * Parameters: number array and length
	 * Returns: Nothing
	 */
	public void SortHighToLow(int[] num, int length) {
		// Sets the sorted array stored in the object to point to the passed array
		this.sortedArray = num;
		// Keeps track of the number of swaps
		this.swaps = 0;
		// Keeps track of the number of comparisons
		this.comparisons = 0;
		// Holds the current number and iteration
		int j;
		int currNum;
		
		long cpuTimeStart = 0, cpuTimeStop = 0;
		
		
		try {
			cpuTimeStart = System.nanoTime(); // Stores the start time
			for (int i = 1; i < length; i++) {
				currNum = num[i]; // Stores the number at the current index into currNum
				// Compares the currNum to the number before it and shifts the number before it to the right
				// until the number before currrNum is smaller than currNum
				for (j = i - 1; (j >= 0) && (num[j] < currNum); j--) {
					num[j + 1] = num[j];
					this.swaps++;
					this.comparisons++;
				}
				// Sets the current i value to currNum
				num[j + 1] = currNum;
				this.comparisons++;
			}
			cpuTimeStop = System.nanoTime();// Stores the end time
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		this.cpuTime = cpuTimeStop - cpuTimeStart; // Computes the time difference
	}
}