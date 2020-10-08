package Assign_1_C;

import Media.*;                  // for Turtle and TurtleDisplayer
import static Media.Turtle.*;    // for Turtle speeds
import static java.lang.Math.*;  // for Math constants and functions
import static java.awt.Color.*;  // for Color constants


/** This class is a program to draw a sequence of Greek Key patterns by calling repeatly the function drawCell
  * created in the Assign_1_A and Assign_1_B
  * 
  * @author Heduin R. B. de Morais (Brock ID 6967483, Campus ID hr19ut, Lab#09) 
  * 
  * @version 1.0 (Oct 2020)
  *
  * new concepts: for loops, initial positioning, calling different functions    
  * 
  * @param nKey number of individual cells to form a Border
  * @param nSide number of sides to form the Frame                      */

public class Frame {
  private TurtleDisplayer display;
  private Turtle raphael; // (ninja) turtle needs to draw 4 sides of 8 greekKeys each
  private int nKey;
  private int nSide;

  public Frame (int nKey, int nSide ) {
    
    display = new TurtleDisplayer();
    raphael = new Turtle(1); // int = 1, rather than CONSTANT FAST for a much faster speed
    display.placeTurtle(raphael);
    int nS = nSide;
    int nK = nKey;
    
// initial position to start drawing;
    raphael.left(PI); //could be .right(Pi) due to angle Pi, now facing LEFT
    raphael.forward(16*nKey/2);  // half-side with side 16 each to LEFT
    raphael.right(PI/2); // now facing UP
    raphael.forward(16*nKey/2);  // moving half-side greekKeys UPWARDS
    raphael.right(PI/2); //turning half circle, now facing RIGHT
    
// drawing each nSide sides of the figure, and turn     
    for (int i = 0; i < nSide; i++ ) {     
      
      drawBorder(nKey);
      raphael.right(PI/2);
      
      
               
    }  // for nSide   
    
    
    
  /* 
 * before closing display, the 4th. ninja turtle is sad for not being part of this assignment,
 * so let's mention his creation here and practice the use of block comments:
 * 
 * private Turtle leonardo;
 * 
 * leonardo = new Turtle(FAST);
 * display.placeTurtle(leonardo);
 * 
 * leonardo.left(10*2*PI); // performing an impressive victory turn! =)
 * 
 * leonardo.penDown(); // practicing calling some methods
 * leonardo.penUp(); // leonardo is now happy eventhough there's no Assign_1_D
 * 
*/

    display.close();
     
};  // constructor
  
  /** This method draws each border or side of the big pattern.
    * It leaves the the turtle 16*nKey positions forward the original position
    * It does not change the direction of the turtle        */
  
  private void drawBorder (int nKey) {    
        
    for (int j = 0; j < nKey; j++){
    
      drawCell();
    
    }  // for nKey    
    
   
    
};  // drawBorder

  
  /** This method draws the internal pattern cell.
    * It leaves the the turtle 16 positions forward the original position
    * It does not change the direction of the turtle        */
                                                                          
  private void drawCell () {
    raphael.penDown();
    
    raphael.forward(2);
    raphael.left(PI/2);
    raphael.forward(12);
    raphael.right(PI/2);
    raphael.forward(12);
    raphael.right(PI/2);
    raphael.forward(8);
    raphael.right(PI/2);
    raphael.forward(4);
    raphael.right(PI/2);
    raphael.forward(4);
    raphael.left(PI/2);
    raphael.forward(4);
    raphael.left(PI/2);
    raphael.forward(8);
    raphael.left(PI/2);
    raphael.forward(10);
    
    raphael.penUp();
    
  
  }  // drawCell
  
  
  
  
// @var pipeLine is considering the full pipe where ninja turtles live with 8 greekKeys, and 4 sides as arguments
public static void main ( String[] args ) { Frame pipeLine = new Frame(8, 4); };

}  // Frame

