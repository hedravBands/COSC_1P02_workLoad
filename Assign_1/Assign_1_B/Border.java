package Assign_1_B;

import Media.*;                  // for Turtle and TurtleDisplayer
import static Media.Turtle.*;    // for Turtle speeds
import static java.lang.Math.*;  // for Math constants and functions
import static java.awt.Color.*;  // for Color constants


/** This class is a program to draw a sequence of Greek Key patterns by calling repeatly the function drawCell
  * created in the Assign_1_A
  * 
  * @author Heduin R. B. de Morais (Brock ID 6967483, Campus ID hr19ut, Lab#09) 
  * 
  * @version 1.0 (Oct 2020)
  *
  * new concepts: for loops, initial positioning, parameter use    
  * 
  * @param nKey number of individual cells                                             */



public class Border {
  private TurtleDisplayer display;
  private Turtle michelangelo; 
  private int nKey;

  public Border (int nKey) {
    
    /*// parameter FAST is passed to constructor to accelerate the drawing process.
     * It was included by using "import static Media.Turtle.*", as per instructions.   
     * let's use NORTH-SOUTH, EAST-WEST convention                     */
    
    display = new TurtleDisplayer(); 
    michelangelo = new Turtle(FAST); // parameter FAST is passed to increase drawing speed
    display.placeTurtle(michelangelo);  // another (ninja) turtle is set on display
    
// initial positioning before .penDown(), to start drawing;
    michelangelo.left(PI); //could also be .right(Pi) due to angle PI (half-turn), now facing WEST
    michelangelo.forward(16*nKey/2);  // half-side of the border is moved to centralize the figure
    michelangelo.left(PI); // back to facing EAST, READY to draw
    
    for (int i = 0; i < nKey; i++){
    
      drawCell();
    
    }  // for    
    
    display.close();
    
};  // constructor

  /** This method draws the internal pattern.
    * It leaves the the turtle 16 positions forward the original position
    * It does not change the direction of the turtle        */
                                                                          
  private void drawCell () {
    michelangelo.penDown();
    
    michelangelo.forward(2);
    michelangelo.left(PI/2);
    michelangelo.forward(12);
    michelangelo.right(PI/2);
    michelangelo.forward(12);
    michelangelo.right(PI/2);
    michelangelo.forward(8);
    michelangelo.right(PI/2);
    michelangelo.forward(4);
    michelangelo.right(PI/2);
    michelangelo.forward(4);
    michelangelo.left(PI/2);
    michelangelo.forward(4);
    michelangelo.left(PI/2);
    michelangelo.forward(8);
    michelangelo.left(PI/2);
    michelangelo.forward(10);
    
    michelangelo.penUp();
    
  
  }  // drawCell
  

       

  //@var pipeSide is due to ninja turtles' habitat, nKey = 8 is passed as parameter
public static void main ( String[] args ) { Border pipeSide = new Border(8); };

}  // Border