/*
 * Logan Thomas
 * CS-203 Fall 2016
 * Programming Assignment 3
 * QuickSort class: Class to define the quick sort object
 */

public class QuickSort <T extends Comparable>{
   private T[] sorted;
   
   public QuickSort(){
      this.sorted = null;
   }
   
   /*
    * Method: getSorted
    * Purpose: Gets the sorted array
    * Parameters: Nothing
    * Returns: The sorted array
    */
   public T[] getSorted(){
      return this.sorted;
   }
   
   /*
    * Method: printSorted
    * Purpose: Prints the sorted array
    * Parameters: Nothing
    * Returns: Nothing
    */
   public void printSorted(){
      for(int i = 0; i < this.sorted.length; i++){
         System.out.println(this.sorted[i]);
      }
   }
   
   /*
    * Method: Sort
    * Purpose: Starts the recursive quicksorting algorithm
    * Parameters: Generic array of unsorted values
    * Returns: Nothing
    */
   public void Sort(T[] unsorted){
      this.sorted = unsorted;
      try{
         Sort(0, unsorted.length - 1); // Calls the sort method with 0 as the starting index and the length of the array
      }
      catch (Exception e){
         System.out.println("Exception message: " + e.getMessage());
      }
   }
   
   /*
    * Method: Sort
    * Purpose: Recursively quicksorts an array based on the indices passed
    * Parameters: int low and int high to act as the low and high indices of the array to sort
    * Returns: Nothing
    */
   private void Sort(int low, int high){
      int i = low;// set i as the low index of the array
      int j = high;// set j as the high index of the array
      
      // calculate pivot number, the middle
      T pivot = this.sorted[low+(high-low)/2];
      
      // Divide into two sortedWords
      while (i <= j){
         // Find a number from the left that is greater than the pivot
         while (this.sorted[i].compareTo(pivot) < 0){
            i++;
         }
         // Find a number from the right that is less than the pivot
         while (this.sorted[j].compareTo(pivot) > 0){
            j--;
         }
         // swap the numbers found
         if (i <= j) {
            swap(i, j);
            //move index to next position on both sides
            i++;
            j--;
         }
      }
      // call sorting method recursively
      if (low < j)
         Sort(low, j);
      if (i < high)
         Sort(i, high);
   }
   
   /*
    * Method: swap
    * Purpose: Swaps two array values based on the indices passed
    * Parameters: int i and int j to act as the indices of the elements to swap of the array
    * Returns: Nothing
    */
   private void swap(int i, int j) {
      T temp = this.sorted[i];
      this.sorted[i] = this.sorted[j];
      this.sorted[j] = temp;
   }
}