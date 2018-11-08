/*
 * Logan Thomas
 * CS-203 Fall 2016
 * Programming Assignment 2
 * Main class: Class to hold the main method
 */

import java.util.*;

public class Main {
	private static final int LEN1 = 1000;
	private static final int LEN2 = 10000;
	private static final int LEN3 = 20000;
	private static final int LEN4 = 30000;
	private static final int LEN5 = 40000;
	private static final int LEN6 = 50000;
	
	// Master arrays to build the temporary arrays from
	private static int randomNumbers[] = new int[LEN6];
	private static int sortedNumbers[] = new int[LEN6];
	private static int revSortedNumbers[] = new int[LEN6];
	
	// Temporary arrays to be sorted and reset
	// Arrays holding random values
	private static int random1000[] = new int[LEN6];
	private static int random10000[] = new int[LEN6];
	private static int random20000[] = new int[LEN6];
	private static int random30000[] = new int[LEN6];
	private static int random40000[] = new int[LEN6];
	private static int random50000[] = new int[LEN6];
	
	// Arrays holding sorted values
	private static int sorted1000[] = new int[LEN6];
	private static int sorted10000[] = new int[LEN6];
	private static int sorted20000[] = new int[LEN6];
	private static int sorted30000[] = new int[LEN6];
	private static int sorted40000[] = new int[LEN6];
	private static int sorted50000[] = new int[LEN6];
	
	// Arrays holding reverse sorted values
	private static int revSorted1000[] = new int[LEN6];
	private static int revSorted10000[] = new int[LEN6];
	private static int revSorted20000[] = new int[LEN6];
	private static int revSorted30000[] = new int[LEN6];
	private static int revSorted40000[] = new int[LEN6];
	private static int revSorted50000[] = new int[LEN6];
	
	private static InsertionSort sorterInsertion = new InsertionSort();
	private static MergeSort sorterMerge = new MergeSort();
	private static QuickSort sorterQuick = new QuickSort();
	
	public static void main(String[] args) {
		
		Random rand = new Random();
		
		for (int i = 0; i < LEN6; i++) {
			// Makes indices from 0 to (LEN1-1) have values from 0 to LEN1
			if (i < LEN1) {
				randomNumbers[i] = rand.nextInt(LEN1 + 1);
			}
			// Makes indices from LEN1 to (LEN2-1) have values from 0 to LEN2
			else if (i < LEN2) {
				randomNumbers[i] = rand.nextInt(LEN2 + 1);
			}
			// Makes indices from LEN2 to (LEN3-1) have values from 0 to LEN3
			else if (i < LEN3) {
				randomNumbers[i] = rand.nextInt(LEN3 + 1);
			}
			// Makes indices from LEN3 to (LEN4-1) have values from 0 to LEN4
			else if (i < LEN4) {
				randomNumbers[i] = rand.nextInt(LEN4 + 1);
			}
			// Makes indices from LEN4 to (LEN5-1) have values from 0 to LEN5
			else if (i < LEN5) {
				randomNumbers[i] = rand.nextInt(LEN5 + 1);
			}
			// Makes indices from LEN5 to (LEN6-1) have values from 0 to LEN6
			else {
				randomNumbers[i] = rand.nextInt(LEN6 + 1);
			}
			sortedNumbers[i] = i;
			revSortedNumbers[i] = LEN6 - i;
		}
		
		// Prints the header of the table
		printTableRow("Sort Type",
				"Comps",
				"Swaps",
				"CPU Time\n");
		
		try {
			// ********************  Insertion Sort portion  ***********************
			// Resets the temporary arrays to their initial values
			resetArrays();
			// Prints the separating line in the table
			printTableRow("Insertion Sort",
					"************",
					"************",
					"********************\n");
			// Prints the insertion sort
			printInsertionSort();
			
			// **********************  Merge Sort portion  *************************
			// Resets the temporary arrays to their initial values
			resetArrays();
			// Prints the separating line in the table
			printTableRow("Merge Sort",
					"************",
					"************",
					"********************\n");
			// Prints the merge sort
			printMergeSort();
			
			// **********************  Quick Sort portion  *************************
			// Resets the temporary arrays to their initial values
			resetArrays();
			// Prints the separating line in the table
			printTableRow("Quick Sort",
					"************",
					"************",
					"********************\n");
			// Prints the quick sort
			printQuickSort();
			
		} catch (Exception e) {
			System.out.println("Main Function Error: " + e.getMessage());
		}
	}
	
	
	/*
	 * Method: MakeCopy
	 * Purpose: Copies the passed array into a new array
	 * Parameters: original array to copy
	 * Returns: int [] copy of the original
	 */
	public static int[] MakeCopy(int[] original) {
		try {
			// Instantiates the new array
			int newArray[] = new int[original.length];
			
			// Fills the new array with the values of the original array
			for (int i = 0; i < original.length; i++) {
				newArray[i] = original[i];
			}
			
			return newArray;
		} catch (Exception e) {
			System.out.println("Make Copy Method Error: " + e.getMessage());
			return null;
		}
	}
	
	/*
	 * Method: printTableRow
	 * Purpose: Prints one row of the table based on the column values passed
	 * Parameters: column 1 string, column 2 string, column 3 string, column 4 string
	 * Returns: Nothing
	 */
	private static void printTableRow(String col1, String col2, String col3, String col4) {
		System.out.format("%20s%11s%11s%20s", col1,
				col2,
				col3,
				col4);
	}
	
	/*
	 * Method: resetArrays
	 * Purpose: Resets all of the temporary arrays to the original values from the original 3 arrays
	 * Parameters: none
	 * Returns: Nothing
	 */
	private static void resetArrays() {
		// Resets the random arrays
		random1000 = MakeCopy(randomNumbers);
		random10000 = MakeCopy(randomNumbers);
		random20000 = MakeCopy(randomNumbers);
		random30000 = MakeCopy(randomNumbers);
		random40000 = MakeCopy(randomNumbers);
		random50000 = MakeCopy(randomNumbers);
		
		// Resets the sorted arrays
		sorted1000 = MakeCopy(sortedNumbers);
		sorted10000 = MakeCopy(sortedNumbers);
		sorted20000 = MakeCopy(sortedNumbers);
		sorted30000 = MakeCopy(sortedNumbers);
		sorted40000 = MakeCopy(sortedNumbers);
		sorted50000 = MakeCopy(sortedNumbers);
		
		// Resets the reverse sorted arrays
		revSorted1000 = MakeCopy(revSortedNumbers);
		revSorted10000 = MakeCopy(revSortedNumbers);
		revSorted20000 = MakeCopy(revSortedNumbers);
		revSorted30000 = MakeCopy(revSortedNumbers);
		revSorted40000 = MakeCopy(revSortedNumbers);
		revSorted50000 = MakeCopy(revSortedNumbers);
	}
	
	/*
	 * Method: printInsertionSort
	 * Purpose: Prints the Insertion sort and compartmentalizes the main method
	 * Parameters: none
	 * Returns: Nothing
	 */
	private static void printInsertionSort() {
		// ********************  Random  ***********************
		// Array 1
		sorterInsertion.SortLowToHigh(random1000, LEN1);
		printTableRow("Random " + LEN1, // The length of the array
				String.valueOf(sorterInsertion.getComparisons()), // The number of comparisons
				String.valueOf(sorterInsertion.getSwaps()), // The number of swaps
				sorterInsertion.getCpuTime() + "\n"); // The CPU elapsed time
		
		// Array 2
		sorterInsertion.SortLowToHigh(random10000, LEN2);
		printTableRow("Random " + LEN2, // The length of the array
				String.valueOf(sorterInsertion.getComparisons()), // The number of comparisons
				String.valueOf(sorterInsertion.getSwaps()), // The number of swaps
				sorterInsertion.getCpuTime() + "\n"); // The CPU elapsed time
		
		// Array 3
		sorterInsertion.SortLowToHigh(random20000, LEN3);
		printTableRow("Random " + LEN3, // The length of the array
				String.valueOf(sorterInsertion.getComparisons()), // the number of comparisons
				String.valueOf(sorterInsertion.getSwaps()), // The number of swaps
				sorterInsertion.getCpuTime() + "\n"); // The CPU elapsed time
		
		// Array 4
		sorterInsertion.SortLowToHigh(random30000, LEN4);
		printTableRow("Random " + LEN4, // The length of the array
				String.valueOf(sorterInsertion.getComparisons()), // the number of comparisons
				String.valueOf(sorterInsertion.getSwaps()), // The number of swaps
				sorterInsertion.getCpuTime() + "\n"); // The CPU elapsed time
		
		// Array 5
		sorterInsertion.SortLowToHigh(random40000, LEN5);
		printTableRow("Random " + LEN5, // The length of the array
				String.valueOf(sorterInsertion.getComparisons()), // the number of comparisons
				String.valueOf(sorterInsertion.getSwaps()), // The number of swaps
				sorterInsertion.getCpuTime() + "\n"); // The CPU elapsed time
		
		// Array 6
		sorterInsertion.SortLowToHigh(random50000, LEN6);
		printTableRow("Random " + LEN6, // The length of the array
				String.valueOf(sorterInsertion.getComparisons()), // the number of comparisons
				String.valueOf(sorterInsertion.getSwaps()), // The number of swaps
				sorterInsertion.getCpuTime() + "\n"); // The CPU elapsed time
		
		
		// ********************  Pre-sorted  ***********************
		// Array 7
		sorterInsertion.SortLowToHigh(sorted1000, LEN1);
		printTableRow("Sorted " + LEN1, // The length of the array
				String.valueOf(sorterInsertion.getComparisons()), // The number of comparisons
				String.valueOf(sorterInsertion.getSwaps()), // The number of swaps
				sorterInsertion.getCpuTime() + "\n"); // The CPU elapsed time
		
		// Array 8
		sorterInsertion.SortLowToHigh(sorted10000, LEN2);
		printTableRow("Sorted " + LEN2, // The length of the array
				String.valueOf(sorterInsertion.getComparisons()), // The number of comparisons
				String.valueOf(sorterInsertion.getSwaps()), // The number of swaps
				sorterInsertion.getCpuTime() + "\n"); // The CPU elapsed time
		
		// Array 9
		sorterInsertion.SortLowToHigh(sorted20000, LEN3);
		printTableRow("Sorted " + LEN3, // The length of the array
				String.valueOf(sorterInsertion.getComparisons()), // the number of comparisons
				String.valueOf(sorterInsertion.getSwaps()), // The number of swaps
				sorterInsertion.getCpuTime() + "\n"); // The CPU elapsed time
		
		// Array 10
		sorterInsertion.SortLowToHigh(sorted30000, LEN4);
		printTableRow("Sorted " + LEN4, // The length of the array
				String.valueOf(sorterInsertion.getComparisons()), // the number of comparisons
				String.valueOf(sorterInsertion.getSwaps()), // The number of swaps
				sorterInsertion.getCpuTime() + "\n"); // The CPU elapsed time
		
		// Array 11
		sorterInsertion.SortLowToHigh(sorted40000, LEN5);
		printTableRow("Sorted " + LEN5, // The length of the array
				String.valueOf(sorterInsertion.getComparisons()), // the number of comparisons
				String.valueOf(sorterInsertion.getSwaps()), // The number of swaps
				sorterInsertion.getCpuTime() + "\n"); // The CPU elapsed time
		
		// Array 12
		sorterInsertion.SortLowToHigh(sorted50000, LEN6);
		printTableRow("Sorted " + LEN6, // The length of the array
				String.valueOf(sorterInsertion.getComparisons()), // the number of comparisons
				String.valueOf(sorterInsertion.getSwaps()), // The number of swaps
				sorterInsertion.getCpuTime() + "\n"); // The CPU elapsed time
		
		
		// ********************  Sorted H to L  ***********************
		// Array 13
		sorterInsertion.SortLowToHigh(revSorted1000, LEN1);
		printTableRow("Rev. Sorted " + LEN1, // The length of the array
				String.valueOf(sorterInsertion.getComparisons()), // The number of comparisons
				String.valueOf(sorterInsertion.getSwaps()), // The number of swaps
				sorterInsertion.getCpuTime() + "\n"); // The CPU elapsed time
		
		// Array 14
		sorterInsertion.SortLowToHigh(revSorted10000, LEN2);
		printTableRow("Rev. Sorted " + LEN2, // The length of the array
				String.valueOf(sorterInsertion.getComparisons()), // The number of comparisons
				String.valueOf(sorterInsertion.getSwaps()), // The number of swaps
				sorterInsertion.getCpuTime() + "\n"); // The CPU elapsed time
		
		// Array 15
		sorterInsertion.SortLowToHigh(revSorted20000, LEN3);
		printTableRow("Rev. Sorted " + LEN3, // The length of the array
				String.valueOf(sorterInsertion.getComparisons()), // the number of comparisons
				String.valueOf(sorterInsertion.getSwaps()), // The number of swaps
				sorterInsertion.getCpuTime() + "\n"); // The CPU elapsed time
		
		// Array 16
		sorterInsertion.SortLowToHigh(revSorted30000, LEN4);
		printTableRow("Rev. Sorted " + LEN4, // The length of the array
				String.valueOf(sorterInsertion.getComparisons()), // the number of comparisons
				String.valueOf(sorterInsertion.getSwaps()), // The number of swaps
				sorterInsertion.getCpuTime() + "\n"); // The CPU elapsed time
		
		// Array 17
		sorterInsertion.SortLowToHigh(revSorted40000, LEN5);
		printTableRow("Rev. Sorted " + LEN5, // The length of the array
				String.valueOf(sorterInsertion.getComparisons()), // the number of comparisons
				String.valueOf(sorterInsertion.getSwaps()), // The number of swaps
				sorterInsertion.getCpuTime() + "\n"); // The CPU elapsed time
		
		// Array 18
		sorterInsertion.SortLowToHigh(revSorted50000, LEN6);
		printTableRow("Rev. Sorted " + LEN6, // The length of the array
				String.valueOf(sorterInsertion.getComparisons()), // the number of comparisons
				String.valueOf(sorterInsertion.getSwaps()), // The number of swaps
				sorterInsertion.getCpuTime() + "\n"); // The CPU elapsed time
	}
	
	/*
	 * Method: printMergeSort
	 * Purpose: Prints the merge sort and compartmentalizes the main method
	 * Parameters: none
	 * Returns: Nothing
	 */
	private static void printMergeSort() {
		// Array 1
		sorterMerge.SortLowToHigh(random1000, LEN1);
		printTableRow("Random " + LEN1, // The length of the array
				String.valueOf(sorterMerge.getComparisons()), // The number of comparisons
				String.valueOf(sorterMerge.getSwaps()), // The number of swaps
				sorterMerge.getCpuTime() + "\n"); // The CPU elapsed time
		
		// Array 2
		sorterMerge.SortLowToHigh(random10000, LEN2);
		printTableRow("Random " + LEN2, // The length of the array
				String.valueOf(sorterMerge.getComparisons()), // The number of comparisons
				String.valueOf(sorterMerge.getSwaps()), // The number of swaps
				sorterMerge.getCpuTime() + "\n"); // The CPU elapsed time
		
		// Array 3
		sorterMerge.SortLowToHigh(random20000, LEN3);
		printTableRow("Random " + LEN3, // The length of the array
				String.valueOf(sorterMerge.getComparisons()), // the number of comparisons
				String.valueOf(sorterMerge.getSwaps()), // The number of swaps
				sorterMerge.getCpuTime() + "\n"); // The CPU elapsed time
		
		// Array 4
		sorterMerge.SortLowToHigh(random30000, LEN4);
		printTableRow("Random " + LEN4, // The length of the array
				String.valueOf(sorterMerge.getComparisons()), // the number of comparisons
				String.valueOf(sorterMerge.getSwaps()), // The number of swaps
				sorterMerge.getCpuTime() + "\n"); // The CPU elapsed time
		
		// Array 5
		sorterMerge.SortLowToHigh(random40000, LEN5);
		printTableRow("Random " + LEN5, // The length of the array
				String.valueOf(sorterMerge.getComparisons()), // the number of comparisons
				String.valueOf(sorterMerge.getSwaps()), // The number of swaps
				sorterMerge.getCpuTime() + "\n"); // The CPU elapsed time
		
		// Array 6
		sorterMerge.SortLowToHigh(random50000, LEN6);
		printTableRow("Random " + LEN6, // The length of the array
				String.valueOf(sorterMerge.getComparisons()), // the number of comparisons
				String.valueOf(sorterMerge.getSwaps()), // The number of swaps
				sorterMerge.getCpuTime() + "\n"); // The CPU elapsed time
		
		
		// ********************  Pre-sorted  ***********************
		// Array 7
		sorterMerge.SortLowToHigh(sorted1000, LEN1);
		printTableRow("Sorted " + LEN1, // The length of the array
				String.valueOf(sorterMerge.getComparisons()), // The number of comparisons
				String.valueOf(sorterMerge.getSwaps()), // The number of swaps
				sorterMerge.getCpuTime() + "\n"); // The CPU elapsed time
		
		// Array 8
		sorterMerge.SortLowToHigh(sorted10000, LEN2);
		printTableRow("Sorted " + LEN2, // The length of the array
				String.valueOf(sorterMerge.getComparisons()), // The number of comparisons
				String.valueOf(sorterMerge.getSwaps()), // The number of swaps
				sorterMerge.getCpuTime() + "\n"); // The CPU elapsed time
		
		// Array 9
		sorterMerge.SortLowToHigh(sorted20000, LEN3);
		printTableRow("Sorted " + LEN3, // The length of the array
				String.valueOf(sorterMerge.getComparisons()), // the number of comparisons
				String.valueOf(sorterMerge.getSwaps()), // The number of swaps
				sorterMerge.getCpuTime() + "\n"); // The CPU elapsed time
		
		// Array 10
		sorterMerge.SortLowToHigh(sorted30000, LEN4);
		printTableRow("Sorted " + LEN4, // The length of the array
				String.valueOf(sorterMerge.getComparisons()), // the number of comparisons
				String.valueOf(sorterMerge.getSwaps()), // The number of swaps
				sorterMerge.getCpuTime() + "\n"); // The CPU elapsed time
		
		// Array 11
		sorterMerge.SortLowToHigh(sorted40000, LEN5);
		printTableRow("Sorted " + LEN5, // The length of the array
				String.valueOf(sorterMerge.getComparisons()), // the number of comparisons
				String.valueOf(sorterMerge.getSwaps()), // The number of swaps
				sorterMerge.getCpuTime() + "\n"); // The CPU elapsed time
		
		// Array 12
		sorterMerge.SortLowToHigh(sorted50000, LEN6);
		printTableRow("Sorted " + LEN6, // The length of the array
				String.valueOf(sorterMerge.getComparisons()), // the number of comparisons
				String.valueOf(sorterMerge.getSwaps()), // The number of swaps
				sorterMerge.getCpuTime() + "\n"); // The CPU elapsed time
		
		
		// ********************  Sorted H to L  ***********************
		// Array 13
		sorterMerge.SortLowToHigh(revSorted1000, LEN1);
		printTableRow("Rev. Sorted " + LEN1, // The length of the array
				String.valueOf(sorterMerge.getComparisons()), // The number of comparisons
				String.valueOf(sorterMerge.getSwaps()), // The number of swaps
				sorterMerge.getCpuTime() + "\n"); // The CPU elapsed time
		
		// Array 14
		sorterMerge.SortLowToHigh(revSorted10000, LEN2);
		printTableRow("Rev. Sorted " + LEN2, // The length of the array
				String.valueOf(sorterMerge.getComparisons()), // The number of comparisons
				String.valueOf(sorterMerge.getSwaps()), // The number of swaps
				sorterMerge.getCpuTime() + "\n"); // The CPU elapsed time
		
		// Array 15
		sorterMerge.SortLowToHigh(revSorted20000, LEN3);
		printTableRow("Rev. Sorted " + LEN3, // The length of the array
				String.valueOf(sorterMerge.getComparisons()), // the number of comparisons
				String.valueOf(sorterMerge.getSwaps()), // The number of swaps
				sorterMerge.getCpuTime() + "\n"); // The CPU elapsed time
		
		// Array 16
		sorterMerge.SortLowToHigh(revSorted30000, LEN4);
		printTableRow("Rev. Sorted " + LEN4, // The length of the array
				String.valueOf(sorterMerge.getComparisons()), // the number of comparisons
				String.valueOf(sorterMerge.getSwaps()), // The number of swaps
				sorterMerge.getCpuTime() + "\n"); // The CPU elapsed time
		
		// Array 17
		sorterMerge.SortLowToHigh(revSorted40000, LEN5);
		printTableRow("Rev. Sorted " + LEN5, // The length of the array
				String.valueOf(sorterMerge.getComparisons()), // the number of comparisons
				String.valueOf(sorterMerge.getSwaps()), // The number of swaps
				sorterMerge.getCpuTime() + "\n"); // The CPU elapsed time
		
		// Array 18
		sorterMerge.SortLowToHigh(revSorted50000, LEN6);
		printTableRow("Rev. Sorted " + LEN6, // The length of the array
				String.valueOf(sorterMerge.getComparisons()), // the number of comparisons
				String.valueOf(sorterMerge.getSwaps()), // The number of swaps
				sorterMerge.getCpuTime() + "\n"); // The CPU elapsed time
	}
	
	/*
	 * Method: printQuickSort
	 * Purpose: Prints the quick sort and compartmentalizes the main method
	 * Parameters: none
	 * Returns: Nothing
	 */
	private static void printQuickSort() {
		// Array 1
		sorterQuick.SortLowToHigh(random1000, LEN1);
		printTableRow("Random " + LEN1, // The length of the array
				String.valueOf(sorterQuick.getComparisons()), // The number of comparisons
				String.valueOf(sorterQuick.getSwaps()), // The number of swaps
				sorterQuick.getCpuTime() + "\n"); // The CPU elapsed time
		
		// Array 2
		sorterQuick.SortLowToHigh(random10000, LEN2);
		printTableRow("Random " + LEN2, // The length of the array
				String.valueOf(sorterQuick.getComparisons()), // The number of comparisons
				String.valueOf(sorterQuick.getSwaps()), // The number of swaps
				sorterQuick.getCpuTime() + "\n"); // The CPU elapsed time
		
		// Array 3
		sorterQuick.SortLowToHigh(random20000, LEN3);
		printTableRow("Random " + LEN3, // The length of the array
				String.valueOf(sorterQuick.getComparisons()), // the number of comparisons
				String.valueOf(sorterQuick.getSwaps()), // The number of swaps
				sorterQuick.getCpuTime() + "\n"); // The CPU elapsed time
		
		// Array 4
		sorterQuick.SortLowToHigh(random30000, LEN4);
		printTableRow("Random " + LEN4, // The length of the array
				String.valueOf(sorterQuick.getComparisons()), // the number of comparisons
				String.valueOf(sorterQuick.getSwaps()), // The number of swaps
				sorterQuick.getCpuTime() + "\n"); // The CPU elapsed time
		
		// Array 5
		sorterQuick.SortLowToHigh(random40000, LEN5);
		printTableRow("Random " + LEN5, // The length of the array
				String.valueOf(sorterQuick.getComparisons()), // the number of comparisons
				String.valueOf(sorterQuick.getSwaps()), // The number of swaps
				sorterQuick.getCpuTime() + "\n"); // The CPU elapsed time
		
		// Array 6
		sorterQuick.SortLowToHigh(random50000, LEN6);
		printTableRow("Random " + LEN6, // The length of the array
				String.valueOf(sorterQuick.getComparisons()), // the number of comparisons
				String.valueOf(sorterQuick.getSwaps()), // The number of swaps
				sorterQuick.getCpuTime() + "\n"); // The CPU elapsed time
		
		
		// ********************  Pre-sorted  ***********************
		// Array 7
		sorterQuick.SortLowToHigh(sorted1000, LEN1);
		printTableRow("Sorted " + LEN1, // The length of the array
				String.valueOf(sorterQuick.getComparisons()), // The number of comparisons
				String.valueOf(sorterQuick.getSwaps()), // The number of swaps
				sorterQuick.getCpuTime() + "\n"); // The CPU elapsed time
		
		// Array 8
		sorterQuick.SortLowToHigh(sorted10000, LEN2);
		printTableRow("Sorted " + LEN2, // The length of the array
				String.valueOf(sorterQuick.getComparisons()), // The number of comparisons
				String.valueOf(sorterQuick.getSwaps()), // The number of swaps
				sorterQuick.getCpuTime() + "\n"); // The CPU elapsed time
		
		// Array 9
		sorterQuick.SortLowToHigh(sorted20000, LEN3);
		printTableRow("Sorted " + LEN3, // The length of the array
				String.valueOf(sorterQuick.getComparisons()), // the number of comparisons
				String.valueOf(sorterQuick.getSwaps()), // The number of swaps
				sorterQuick.getCpuTime() + "\n"); // The CPU elapsed time
		
		// Array 10
		sorterQuick.SortLowToHigh(sorted30000, LEN4);
		printTableRow("Sorted " + LEN4, // The length of the array
				String.valueOf(sorterQuick.getComparisons()), // the number of comparisons
				String.valueOf(sorterQuick.getSwaps()), // The number of swaps
				sorterQuick.getCpuTime() + "\n"); // The CPU elapsed time
		
		// Array 11
		sorterQuick.SortLowToHigh(sorted40000, LEN5);
		printTableRow("Sorted " + LEN5, // The length of the array
				String.valueOf(sorterQuick.getComparisons()), // the number of comparisons
				String.valueOf(sorterQuick.getSwaps()), // The number of swaps
				sorterQuick.getCpuTime() + "\n"); // The CPU elapsed time
		
		// Array 12
		sorterQuick.SortLowToHigh(sorted50000, LEN6);
		printTableRow("Sorted " + LEN6, // The length of the array
				String.valueOf(sorterQuick.getComparisons()), // the number of comparisons
				String.valueOf(sorterQuick.getSwaps()), // The number of swaps
				sorterQuick.getCpuTime() + "\n"); // The CPU elapsed time
		
		
		// ********************  Sorted H to L  ***********************
		// Array 13
		sorterQuick.SortLowToHigh(revSorted1000, LEN1);
		printTableRow("Rev. Sorted " + LEN1, // The length of the array
				String.valueOf(sorterQuick.getComparisons()), // The number of comparisons
				String.valueOf(sorterQuick.getSwaps()), // The number of swaps
				sorterQuick.getCpuTime() + "\n"); // The CPU elapsed time
		
		// Array 14
		sorterQuick.SortLowToHigh(revSorted10000, LEN2);
		printTableRow("Rev. Sorted " + LEN2, // The length of the array
				String.valueOf(sorterQuick.getComparisons()), // The number of comparisons
				String.valueOf(sorterQuick.getSwaps()), // The number of swaps
				sorterQuick.getCpuTime() + "\n"); // The CPU elapsed time
		
		// Array 15
		sorterQuick.SortLowToHigh(revSorted20000, LEN3);
		printTableRow("Rev. Sorted " + LEN3, // The length of the array
				String.valueOf(sorterQuick.getComparisons()), // the number of comparisons
				String.valueOf(sorterQuick.getSwaps()), // The number of swaps
				sorterQuick.getCpuTime() + "\n"); // The CPU elapsed time
		
		// Array 16
		sorterQuick.SortLowToHigh(revSorted30000, LEN4);
		printTableRow("Rev. Sorted " + LEN4, // The length of the array
				String.valueOf(sorterQuick.getComparisons()), // the number of comparisons
				String.valueOf(sorterQuick.getSwaps()), // The number of swaps
				sorterQuick.getCpuTime() + "\n"); // The CPU elapsed time
		
		// Array 17
		sorterQuick.SortLowToHigh(revSorted40000, LEN5);
		printTableRow("Rev. Sorted " + LEN5, // The length of the array
				String.valueOf(sorterQuick.getComparisons()), // the number of comparisons
				String.valueOf(sorterQuick.getSwaps()), // The number of swaps
				sorterQuick.getCpuTime() + "\n"); // The CPU elapsed time
		
		// Array 18
		sorterQuick.SortLowToHigh(revSorted50000, LEN6);
		printTableRow("Rev. Sorted " + LEN6, // The length of the array
				String.valueOf(sorterQuick.getComparisons()), // the number of comparisons
				String.valueOf(sorterQuick.getSwaps()), // The number of swaps
				sorterQuick.getCpuTime() + "\n"); // The CPU elapsed time
	}
}