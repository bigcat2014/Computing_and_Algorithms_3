/*
 * Logan Thomas
 * CS-203 Fall 2016
 * Programming Assignment 2
 * QuickSort class: Class to define the quick sort object
 */

public class QuickSort {
	private int[] sortedArray;
	private int comparisons;
	private int swaps;
	private long cpuTime;
	
	public QuickSort() {
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
			cpuTimeStart = System.nanoTime();// Keeps track of the start time
			SortLowToHigh(0, length - 1); // Calls the sort method with 0 as the starting index and the length of the array
			cpuTimeStop = System.nanoTime();// keeps track of the end time
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		this.cpuTime = cpuTimeStop - cpuTimeStart;// computes the time difference
	}
	
	private void SortLowToHigh(int low, int high) {
		int i = low;// set i as the low index of the array
		int j = high;// set j as the high index of the array
		// calculate pivot number, the middle
		int pivot = sortedArray[low + (high - low) / 2];
		// Divide into two sortedArrays
		while (i <= j) {
			// Find a number from the left that is greater than the pivot
			while (sortedArray[i] < pivot) {
				i++;
			}
			// find a number from the right that is less than the pivot
			while (sortedArray[j] > pivot) {
				j--;
			}
			// swap the numbers found
			if (i <= j) {
				swap(i, j);
				this.swaps++;
				//move index to next position on both sides
				i++;
				j--;
			}
			this.comparisons++;
		}
		// call sorting method recursively
		if (low < j)
			SortLowToHigh(low, j);
		if (i < high)
			SortLowToHigh(i, high);
	}
	
	// Swaps two array values passed as indices
	private void swap(int i, int j) {
		int temp = sortedArray[i];
		sortedArray[i] = sortedArray[j];
		sortedArray[j] = temp;
	}
}