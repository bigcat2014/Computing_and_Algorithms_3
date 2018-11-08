/*
 * Logan Thomas
 * CS-203 Fall 2016
 * Programming Assignment 3
 * Main class: Class containing the main method
 */

import java.util.*;
import java.io.*;

public class Main{
   /*
    * Method: main
    * Purpose: The main method of the class which is called when the program runs
    * Parameters: String array of arguments that are passed to the program as runtime arguments
    * Returns: Nothing
    */
   public static void main(String []args){
      // File object to hold the input file from the run arguments
      File inputFile;
      // Scanner to scan the file
      Scanner fileScanner;
      
      // Unsorted list of sorted words
      ArrayList<Word> sortedWords = new ArrayList<Word>();
      // Sorted list of sorted words
      Word[] sortedList;
      
      // Holds the current sorted String in the sorted array
      String curr;
      // Holds the previous sorted String in the sorted array
      String prev;
      // Holds the value returned when comparing strings
      int comparison;
      
      // Tries to instantiate the file and scanner objects
      try{
         // Creates the file object from the file specified in the command line
         inputFile = new File(args[0]);
         // Creates a scanner from the file object
         fileScanner = new Scanner(inputFile);
      }
      // Catches exceptions with file handling and reports it to the user
      catch(Exception e){
         System.out.println(e.getMessage() + "\nProblem, exiting");
         return;
      }
      
      // Scans the entire file getting each word and putting them into the sortedWords ArrayList
      while(fileScanner.hasNextLine()){
         sortedWords.add(new Word(fileScanner.nextLine()));
      }
      
      // Sorts the list of words and stores them into an array
      sortedList = Sort(sortedWords);
      
      // Iterates through each word in the list
      for(int i = 0; i<sortedList.length;i++){
         // Stores the key of the first word
         prev = sortedList[i].GetKey();
         // Prints the first word
         if(sortedList[i].print()){
            // Iterates through the rest of the list and compares the keys of the other words
            for(int j = i+1; j<sortedList.length;j++){
               curr = sortedList[j].GetKey();
               comparison = prev.compareTo(curr);
               // If the keys are the same, print the second word
               if(comparison == 0){
                  sortedList[j].print();
               }
               // If the second key is larger lexicographically, break out of the inner loop
               else if(comparison < 0){
                  break;
               }
            }
            // Print an extra line to separate groups of anagrams
            System.out.println();
         }
      }
   }
   
   /*
    * Method: Sort
    * Purpose: Sorts the array of words
    * Parameters: ArrayList of the words to sort
    * Returns: Sorted array
    */
   private static Word[] Sort(ArrayList<Word> words){
      // QuickSorter object to sort the array
      QuickSort<Word> sorter = new QuickSort<Word>();
      // Instatniates the array
      Word[] sortedList = new Word[words.size()];
      // Points the array to an array created from the ArrayList passed
      sortedList = words.toArray(sortedList);
      // Sorts the ArrayList
      sorter.Sort(sortedList);
      // Returns the sorted array
      return sorter.getSorted();
   }
}