package Assign_1_B;

import Media.*;
import static java.lang.Math.*;
import static java.awt.Color.*;
import static Media.Turtle.*;

public class Border {
  private TurtleDisplayer display;
  private Turtle michelangelo; //draws 8 squares

  public Border ( ) {
    
    display = new TurtleDisplayer();
    michelangelo = new Turtle(FAST); //parameter FAST is passed to constructor
    display.placeTurtle(michelangelo);
    
// initial position to start drawing;
    michelangelo.left(PI); //could be .right(Pi) due to angle Pi, facing left
    michelangelo.forward(16*4);  // 4 greek keys with side 16 each
    michelangelo.left(PI); // back to face right side

// turtle.penup() and turtle.pendown() could be inside for loop
    michelangelo.penDown();
    
    //drawing of 8 greek squares
    for(int i = 0; i < 8; i++) {
    
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

     }
    
    michelangelo.penUp();
    
    
    display.close();
};
  //var pipeSide is considering that ninja turtles live in the sewers
public static void main ( String[] args ) { Border pipeSide = new Border(); };

}