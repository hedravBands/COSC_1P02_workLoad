package Fractals;

import Media.*;                  // for Turtle and TurtleDisplayer
import static Media.Turtle.*;    // for Turtle speeds
import static java.lang.Math.*;  // for Math constants and functions
import static java.awt.Color.*;  // for Color constants



/** This class is a program to build fractal patterns and 'Hildert Curve' for space-filling purposes.
  * 
  * @author Heduin R. B. de Morais (Brock_ID 6967483, Campus_ID hr19ut, Lab#09) 
  * 
  * @version 1.0 (Nov. 2020)
  *
  * new concepts: Fractal Patterns, Hilbert Curve, Space Filling
  * 
  * @param 

*/

public class Fractals {
  private TurtleDisplayer display; //standard display (300,300) pxl
  private Turtle h; // the drawing turtle to draw a Hilbert Curve
  private int canvasSide; // the side of canvas
  //private int nLevel; // equals 4^levels (resolution)
  

  public Fractals ( ) {
    
    h = new Turtle(50); // constructor of the drawing turtle "ttl" with super speed (int lower the faster)
    canvasSide = 400; //  Let's setup the default, but it is now customizable
    display = new TurtleDisplayer(h, canvasSide, canvasSide);  //  default 300, 300    
    display.placeTurtle(h); 
    //nLevel = 1; //pow(4,1); // 4 to the power of n, element of [1,k], max(4^k) is canvasSide (number of pixels per side)
    
    drawGrid(canvasSide);
    
    //set initial position
    //hilbert.moveTo(-canvasSide/2,-canvasSide/2);
    //hilbert.penDown(); // penUp only when finish
    

    
      
    drawSeed(canvasSide);
    
    
    // Ready to close display    
    display.close();
    
   };  // constructor Hilbert
  
  /* This method draw the grid that will be filled by the Hilbert Curve
   * @param side (of the square) that must be divided by 4
   * // @param subSpace number of subspaces to divide the canvas on
  */
  private void drawGrid(int side){
    
   //horizontal line
   h.backward(side/2); h.penDown();
   h.forward(side);    h.penUp();
   h.backward(side/2); //centre  
   //vertical line
   h.left(PI/2);
   h.backward(side/2);  h.penDown();
   h.forward(side);     h.penUp();
   h.backward(side/2);  //centre   
   h.right(PI/2);
   
  
  } // end drawGrid
  
  
  
  /*
   * The method the atomic part of the drawing
   * @param side is the side of 2 squares   
  */  
  private void drawSeed (int side){
    
    
    h.moveTo(h.getScreenX() - side/4, h.getScreenY() - side/4); //get to the centre of corner left quarter
    h.left(PI/2);
    h.penDown();
    //for (i=0;i<3;i++){
      h.forward(side/2);
      h.right(PI/2);
      h.forward(side/2);
      h.right(PI/2);
      h.forward(side/2);
      
      h.left(PI/2); //final orientation      
      h.penUp();
      h.moveTo(h.getScreenX() - side/4, h.getScreenY()+ side/4); //get to original position before method
    //}
    
   
 
  
  } // end drawSeed
 


    
// main function
public static void main ( String[] args ) { Fractals fractal  = new Fractals(); };


}  // Fractals
    