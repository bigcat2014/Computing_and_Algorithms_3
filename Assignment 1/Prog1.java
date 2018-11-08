/*
 * Logan Thomas
 * CS-203 Fall 2016
 * Programming Assignment 1
 * Prog1 class: Class containing the main method
 */

import java.util.*;
import java.io.*;

public class Prog1{
   public static void main(String []args){
      // File object to hold the input file from the run arguments
      File inputFile;
      // Scanner to scan the file
      Scanner fileScanner;
      // Number of graphs
      int graphNum = 0;
      
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
      
      // While the file contains lines to scan, continue scanning
      while(fileScanner.hasNextLine()){
         // Incriment the number of graphs in the file
         graphNum++;
         // Print the graph number to be scanned
         System.out.println("Graph " + graphNum);
         // Create a graph from the line scanned
         createGraph(fileScanner.nextLine());
         // Print a blank row to separate graphs
         System.out.println("\n");
      }
      
   }
   
   /*
    * Method: createGraph
    * Purpose: creates a graph from the string passed from the file
    * Parameters: String containing the graph data from the file
    * Returns: Nothing
    */
   private static void createGraph(String graphRep){
      // Scanner for one line of the file
      Scanner graphScanner = new Scanner(graphRep);
      // Sets the delimiters to be used in scanning the file
      graphScanner.useDelimiter("\\) \\(| \\(|,|\\)|\\n");
      
      // The graph to be created by this string
      UndirectedGraph graph = null;
      
      // If the graph has a value, read it and store it in the numNodes variable
      if(graphScanner.hasNext()){
         // Holds the number of nodes in the graph
         Integer numNodes = new Integer(graphScanner.next());
         // Instantiates the graph with the number of nodes
         graph = new UndirectedGraph(numNodes);
      }
      
      // While the graph has more values to scan, keep making points
      while(graphScanner.hasNextInt() && graph != null){
         // Take the first value and store it in x
         Integer x = new Integer(graphScanner.next());
         // Take the second value and store it in y
         Integer y = new Integer(graphScanner.next());
         // Create an edge object with x and y
         Edge vertex = new Edge(x, y);
         // Add the connection to the graph using the point object
         graph.addEdge(vertex);
      }
      // Print the graph
      graph.printGraph();
   }
}