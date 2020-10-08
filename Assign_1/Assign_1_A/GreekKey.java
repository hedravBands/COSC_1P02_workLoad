package Assign_1_A;

import Media.*;
import static java.lang.Math.*;
import static java.awt.Color.*;

public class GreekKey {
  private TurtleDisplayer display;
  private Turtle donatello;

  public GreekKey ( ) {
    
    display = new TurtleDisplayer();
    donatello = new Turtle();
    display.placeTurtle(donatello);
    
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
    
    display.close();
};
  
public static void main ( String[] args ) { GreekKey splinter = new GreekKey(); };

}