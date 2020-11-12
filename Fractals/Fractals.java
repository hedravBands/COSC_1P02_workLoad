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
  private Turtle h; // the drawing turtle to draw a Pseudo-Hilbert Curve
  private int canvasSide; // the side of canvas
  private int order; // Pseud-Hilbert Curve has a total of (2^order)^2 squares to be filled up
  

  public Fractals ( ) {
    
    h = new Turtle(20); // constructor of the drawing turtle "h" with super speed (int lower the faster)
    canvasSide = 450; //  Let's setup the default, but it is now customizable
    display = new TurtleDisplayer(h, canvasSide, canvasSide);  //  default 300, 300    
    display.placeTurtle(h); 
    order = 3;  
    int canvas = 400;
    
    drawGrid(canvas);

    
    // Ready to close display    
    display.close();
    
   };  // constructor Hilbert
  
  /* This method draw the grid that will be filled by the Hilbert Curve
   * @param step in-between spacement of lined of grid, or side of small squares   
  */
  
  private void drawGrid (int side){
    if (side <= canvasSide/pow(2,order)){
      // do not draw here, go back
      h.moveTo(h.getScreenX()+ side/4, h.getScreenY() + side/4);
      
    } else {  
      
      h.moveTo(h.getScreenX()-side/4, h.getScreenY() - side/4);
      drawSet(side/2); // draw 4 squares;
      
      drawGrid(side/2);
      h.moveTo(h.getScreenX()+side/4, h.getScreenY() + side/4);
    }        
    
   
/*
        
//horizontal lines
   h.moveTo(-canvasSide/2,-canvasSide/2); //left bottom corner
   for (int j=0; j< pow(2,order)-1; j++){ 
     h.moveTo(h.getScreenX(), h.getScreenY() + step);
     h.penDown();
     h.forward(canvasSide);
     h.penUp();
     h.backward(canvasSide);
   } // end for horizontal
   h.moveTo(-canvasSide/2,-canvasSide/2); //left bottom corner
   //vertical lines
   h.left(PI/2);
   for (int j=0; j< pow(2,order)-1; j++){ 
     h.moveTo(h.getScreenX() + step, h.getScreenY());    
     h.penDown();
     h.forward(canvasSide);     
     h.penUp();
     h.backward(canvasSide);
   } // end for horizontal
   h.right(PI/2);
   h.moveTo(0,0); //back to centre of canvas
  */
        
        
  } // end drawGrid
  

/* this method draws 4 squares sith side half of the parameter
 * @param side lenght of the outer square
 * */
private void drawSet(int side) {
 //bottom-left
 h.moveTo(h.getScreenX()-side/2, h.getScreenY() - side/2);
 //draw a single square
 h.penDown(); for (int k=0;k<4;k++){h.forward(side/2); h.left(PI/2);} h.penUp();
 
 //bottom-right
 h.moveTo(h.getScreenX()+side/2, h.getScreenY());
 //draw a single square
 h.penDown(); for (int k=0;k<4;k++){h.forward(side/2); h.left(PI/2);} h.penUp();
 
 //up-left
 h.moveTo(h.getScreenX()-side/2, h.getScreenY() + side/2);
 //draw a single square
 h.penDown(); for (int k=0;k<4;k++){h.forward(side/2); h.left(PI/2);} h.penUp();
 
 //up-right
 h.moveTo(h.getScreenX()+side/2, h.getScreenY());
 //draw a single square
 h.penDown(); for (int k=0;k<4;k++){h.forward(side/2); h.left(PI/2);} h.penUp();
 
} //end drawSet
  
  
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
    