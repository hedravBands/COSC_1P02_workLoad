package Assign_1_A;

import Media.*;                  // for Turtle and TurtleDisplayer
import static Media.Turtle.*;    // for Turtle speeds
import static java.lang.Math.*;  // for Math constants and functions
import static java.awt.Color.*;  // for Color constants


/** This class is a program to draw a pattern called Greek Key using different turns
  * 
  * @author Heduin R. B. de Morais (Brock ID 6967483, Campus ID hr19ut, Lab#09) 
  * 
  * @version 1.0 (Oct 2020)
  *
  * new concepts: constructor function method    */


public class GreekKey {
  private TurtleDisplayer display;    // display to draw on
  private Turtle donatello;           // (ninja) turtle to do the drawing
  private int x, y, sideLength;
  
  /** The constructor draws a Greek Key pattern using repeated method calls for moving and turning.      */
  
  public GreekKey ( ) {
    
    display = new TurtleDisplayer();
    donatello = new Turtle(FAST);  // for faster drawing
    display.placeTurtle(donatello);  // @var named after the ninja turtle
    
    drawCell(); 
   
    display.close();
    
};  // constructor
  

  /** This method draws the internal pattern.
    * It leaves the the turtle 16 positions forward the original position
    * It does not change the direction of the turtle                                */
                                                                          
  private void drawCell () {
    donatello.penDown();
    
    donatello.forward(2);
    donatello.left(PI/2);
    donatello.forward(12);
    donatello.right(PI/2);
    donatello.forward(12);
    donatello.right(PI/2);
    donatello.forward(8);
    donatello.right(PI/2);
    donatello.forward(4);
    donatello.right(PI/2);
    donatello.forward(4);
    donatello.left(PI/2);
    donatello.forward(4);
    donatello.left(PI/2);
    donatello.forward(8);
    donatello.left(PI/2);
    donatello.forward(10);
    
    donatello.penUp();
    
  
  } // drawCell
  
  
  
  //@var splinter is due to ninja turtles' master name
public static void main ( String[] args ) { GreekKey splinter = new GreekKey(); 
};

}  // GreekKey