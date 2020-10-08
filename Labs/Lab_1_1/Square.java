package Lab_1_1;

import Media.*;
import static java.lang.Math.*;
import static java.awt.Color.*;

public class Square {
  private TurtleDisplayer display;
  private Turtle yertle;

  public Square ( ) {
    
    display = new TurtleDisplayer();
    yertle = new Turtle();
    display.placeTurtle(yertle);
    
    yertle.penDown();
    yertle.forward(40);
    yertle.right(PI/2);
    yertle.forward(40);
    yertle.right(PI/2);
    yertle.forward(40);
    yertle.right(PI/2);
    yertle.forward(40);
    yertle.right(PI/2);
    yertle.penUp();
    
    display.close();
};
  
public static void main ( String[] args ) { Square s = new Square(); };

}