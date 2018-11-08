/*
 * Logan Thomas
 * CS-203 Fall 2016
 * Programming Assignment 3
 * Word class: Class for creating word objects and holds the sorted key value
 */

public class Word implements Comparable<Word>{
   // Holds the unchanged word
   private String word;
   // Holds the sorted letters of the word
   private String key;
   // Holds whether or not the word has already been printed
   private boolean printed;
   
   public Word(String word){
      this.word = word;
      this.key = calcKey(this.word);
      this.printed = false;
   }
   
   /*
    * Method: GetKey
    * Purpose: Returns the key of the string
    * Parameters: Nothing
    * Returns: The key of the word
    */
   public String GetKey(){
      return this.key;
   }
   
   /*
    * Method: print
    * Purpose: Prints the original word and saves it as printed
    * Parameters: Nothing
    * Returns: Boolean if the word was printed
    */
   public boolean print(){
      if(!this.printed){
         System.out.println(this.word);
         this.printed = true;
         return true;
      }
      else{
         return false;
      }
   }
   
   /*
    * Method: compareTo
    * Purpose: Overrides the compareTo method of the Comparable interface to use the key values to compare words
    * Parameters: Word to compare to
    * Returns: Int of the comparison value of the string
    */
   @Override
   public int compareTo(Word compareWord) {
       String compareKey = compareWord.GetKey();
       return this.key.compareTo(compareKey);
   }

   private String calcKey(String word){
      // Sorter for sorting the word
      QuickSort<Character> sorter = new QuickSort<Character>();
      
      // Holds the word as lowercase and removes the "'"
      String lowerCase = word.toLowerCase().replace("'","");
      
      // Holds the new sorted array
      String sorted = "";
      
      // Converts the word into a char array
      char[] charArray = lowerCase.toCharArray();
      
      // Creates a Character array to be sorted
      Character[] unsortedArray = new Character[charArray.length];
      
      // Copies the char array into to Character array using Character objects
      for(int i = 0; i < charArray.length; i++){
         unsortedArray[i] = new Character(charArray[i]);
      }
      
      // Sorts the Character array
      sorter.Sort(unsortedArray);
      
      // Concantenates the Characters into a string
      for(Character c : sorter.getSorted()){
         sorted += c;
      }
      
      // Returns the array as a string
      return sorted;
   }
}