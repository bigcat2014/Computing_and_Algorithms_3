/*
 * Logan Thomas
 * CS-203 Fall 2016
 * Programming Assignment 1
 * GraphNode class: Class for the node objects
 */

public class GraphNode{
   
   // Holds the value if the node has been visited or not
   private boolean visited;
   private boolean visitedFirst;
   
   // Constructor and initializes "visited" to false
   public GraphNode(){
      this.visited = false;
      this.visitedFirst = false;
   }
   
   // Returns if the node has been visited or not
   public boolean isVisited(){
      return visited;
   }
   
   // Visits the node
   public void visitNode(){
      this.visited = true;
   }
   
   // Marks node as unvisited
   public void resetVisited(){
      this.visited = false;
   }
   
   // Returns if the node has been visited or not
   public boolean isVisitedFirst(){
      return visitedFirst;
   }
   
   // Visits the node
   public void visitFirst(){
      this.visitedFirst = true;
   }
   
   // Marks node as unvisited first
   public void resetVisitFirst(){
      this.visitedFirst = false;
   }
}