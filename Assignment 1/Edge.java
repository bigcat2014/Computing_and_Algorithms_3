/*
 * Logan Thomas
 * CS-203 Fall 2016
 * Programming Assignment 1
 * Edge class: Class containing an ordered pair
 */

public class Edge{
   
   // Holds the x and y coordinates of the point
   private int x;
   private int y;
   
   // Constructor for the Edge object, storing x and y values as 0 based numbers to be used as indices
   public Edge(Integer x, Integer y){
      this.x = x - 1;
      this.y = y - 1;
   }
   
   // Returns the x coordinate
   public int getX(){
      return this.x;
   }
   
   // Returns the y coordinate
   public int getY(){
      return this.y;
   }
   
}