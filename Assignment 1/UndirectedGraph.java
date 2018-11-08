/*
 * Logan Thomas
 * CS-203 Fall 2016
 * Programming Assignment 1
 * UndirectedGraph class: Class to hold graph objects
 */

import java.util.*;

public class UndirectedGraph{
   
   // Adjacency matrix for holding the edges of the graph
   private boolean[][] vertexList;
   // List of nodes in the graph
   private GraphNode[] nodeList;
   
   // Constructor for the graph object
   public UndirectedGraph(Integer numNodes){
      // Instantiates the list of nodes
      this.nodeList = new GraphNode[numNodes];
      // Instantiates the adjacency matrix
      this.vertexList = new boolean[numNodes][numNodes];
      // Initializes the adjacency matrix to false
      initMatrix();
   }

   /*
    * Method: addEdge
    * Purpose: Adds an edge to two vertices
    * Parameters: Edge object
    * Returns: Nothing
    */
   public void addEdge(Edge vertex){
      // Gets the x value of the edge
      int x = vertex.getX();
      // Gets the y value of the edge
      int y = vertex.getY();
      
      // Changes the value to true in the adjacency matrixat the point (x,y) and (y,x) because it is an undirected graph
      this.vertexList[x][y] = true;
      this.vertexList[y][x] = true;
      
   }
   
   /*
    * Method: printGraph
    * Purpose: Recursively prints the graph
    * Parameters: none
    * Returns: Nothing
    */
   public void printGraph(){
      // Iterates through nodeList
      for(int i = 0; i < nodeList.length; i++){
         // Checks if the current node has been visited or not
         if(!nodeList[i].isVisited()){
            // Prints out the left curly brace
            System.out.print("{");
            // Marks the node as visited
            nodeList[i].visitNode();
            // Recursively calls the printGraph method on the current node position
            printGraph(i);
            // Prints i + 1 because i is 0 based, not 1 based
            System.out.print(i + 1);
            // Prints the right curly brace
            System.out.print("} ");
         }
      }
      System.out.println();
      printCycle();
   }
   
   /*
    * Method: printGraph
    * Purpose: Recursively prints the graph
    * Parameters: int containing the current vertex
    * Returns: Nothing
    */
   private void printGraph(int curVertex){
      // Iterates through the row of vertexList, passed as an argument, to find edges
      for(int i = 0; i < vertexList.length; i++){
         // If the current point in the matrix is an edge and the node has not been visited
         if(vertexList[curVertex][i] && !nodeList[i].isVisited()){
            // Mark the current node as visited
            nodeList[i].visitNode();
            // Recursively call printGraph with i
            printGraph(i);
            // Print i + 1 because i is 0 based, not 1 based
            System.out.print(i + 1 + ",");
         }
      }
   }
    
   /*
    * Method: printCycle
    * Purpose: Recursively prints the cycle if one is detected
    * Parameters: none
    * Returns: Nothing
    */
   private void printCycle(){
      // Resets the nodeList to not visited
      for(int i = 0; i < nodeList.length; i++){
         nodeList[i].resetVisited();
      }
      
      // Iterates through the nodeList and marks each node as a starting node
      for(int i = 0; i < nodeList.length; i++){
         nodeList[i].visitFirst();
         // If the node has not been visited, try to print the cycle.
         // If printing the cycle succeeds, then this node was a starting node so print it
         // Otherwise, move on to the next unvisited node
         if(!nodeList[i].isVisited() && printCycle(i, -1)){
            System.out.print(i + 1);
            // Cycle found, exit method
            return;
         }
         nodeList[i].resetVisitFirst();
      }
      // No cycles found, so it is Acyclic
      System.out.print("Acyclic");
   }
   
   /*
    * Method: printCycle
    * Purpose: Recursively prints the cycle if one is detected
    * Parameters: int the current vertex and the parent node that the recursive
    * 	function is coming from
    * Returns: boolean if a cycle was detected
    */
   private boolean printCycle(int curVertex, int parent){
      // Marks node as visited
      nodeList[curVertex].visitNode();
      
      // Iterates through the adjacency martix in the row of the vertex that was just visited
      for(int i = 0; i < vertexList.length; i++){
         // Makes sure the current spot in the list is not the node that it came from
         if(i != parent){
            // Checks if there is a node adjacent to the current node, the node is not visited, and if the node is not the first node
            if(vertexList[curVertex][i] && !nodeList[i].isVisited() && !nodeList[i].isVisitedFirst()){
               // Recursively calls itself passing the current adjacent node as curVertex and the current node as the parent
               if(printCycle(i, curVertex)){
                  // If the cycle works out, print the current adjacent node and return true
                  System.out.print((i + 1) + "-");
                  return true;
               }
            }
            // Checks if there is a node adjacent to the current node, the node is visited, and if the node is not the first node
            else if(vertexList[curVertex][i] && !nodeList[i].isVisitedFirst()){
               // If the node is visited but it is not the first node,
               // then there is a cycle but the first node was not a node that is part of the cycle
               // Mark the node as not visited so that it can be hit later in the main iteration and return false
               nodeList[curVertex].resetVisited();
               return false;
            }
            // If the node is visited and the first node, then there is a cycle and the first node started in the cycle
            else if(vertexList[curVertex][i]){
               // Print the node and return true
               System.out.print("Cycle: " + (i + 1) + "-");
               return true;
            }
         }
      }
      nodeList[curVertex].resetVisited();
      return false;
   }
   
   /*
    * Method: initMatrix
    * Purpose: Initializes the nodeList and vertexList 
    * 	with GraphNode objects and false values respectively
    * Parameters: none
    * Returns: Nothing
    */
   private void initMatrix(){
      // Iterate through each row of vertexList and through nodeList
      for (int i = 0; i < vertexList.length; i++){
         // Creates a new GraphNode object
         nodeList[i] = new GraphNode();
         // Iterates through each column of vertexList
         for (int j = 0; j < vertexList[0].length; j++){
            // Sets the position to false
            this.vertexList[i][j] = false;
         }
      }
   }
}