/*
 * Logan Thomas
 * CS-203 Fall 2016
 * Programming Assignment 2
 * MergeSort class: Class to define the merge sort object
 */

public class MergeSort {
	private int[] sortedArray;
	private int comparisons;
	private int swaps;
	private long cpuTime;
	
	public MergeSort() {
		this.sortedArray = null;
		this.comparisons = 0;
		this.swaps = 0;
		this.cpuTime = 0;
	}
	
	public void printArray() {
		for (int i = 0; i < this.sortedArray.length; i++) {
			System.out.print(this.sortedArray[i] + ",");
		}
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
	
	// ********************  Sort Low To High  ***********************
	public void SortLowToHigh(int[] num, int length) {
		this.sortedArray = num;
		this.swaps = 0;
		this.comparisons = 0;
		long cpuTimeStart = 0, cpuTimeStop = 0;
		try {
			cpuTimeStart = System.nanoTime();// stores the start time
			SortLowToHigh(0, length - 1); // Calls the sorting method with 0 starting index and the length of the array
			cpuTimeStop = System.nanoTime();// stores the end time
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		this.cpuTime = cpuTimeStop - cpuTimeStart; // Computes the time difference
	}
	
	private void SortLowToHigh(int low, int high) {
		if (low < high) {
			int middle = low + (high - low) / 2;// Picks the middle value
			// Sorts the left side of the this.sortedArray
			SortLowToHigh(low, middle);
			// Sorts the right side of the this.sortedArray
			SortLowToHigh(middle + 1, high);
			// Merge both this.sortedArrays
			MergeLowToHigh(low, middle, high);
		}
	}
	
	private void MergeLowToHigh(int low, int middle, int high) {
		int tempArray[] = Main.MakeCopy(sortedArray);
		
		// Start i at the beginning of the array
		int i = low;
		// start j at the first number after the middle
		int j = middle + 1;
		int k = low;
		
		while (i <= middle && j <= high) {
			// If the value at i is <= the value at j, then insert i into the sorted array at k
			if (tempArray[i] <= tempArray[j]) {
				this.sortedArray[k] = tempArray[i];
				i++;
			}
			// otherwise, insert j into the array at k
			else {
				this.sortedArray[k] = tempArray[j];
				j++;
				this.swaps++;
			}
			// incriment k
			k++;
			this.comparisons++;
		}
	}
}