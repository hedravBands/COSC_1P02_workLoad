package Assign_1_C;

import Media.*;
import static java.lang.Math.*;
import static java.awt.Color.*;
import static Media.Turtle.*;

public class Frame {
  private TurtleDisplayer display;
  private Turtle raphael; //draws 4 sides of 8 squares each
  

  public Frame ( ) {
    
    display = new TurtleDisplayer();
    raphael = new Turtle(FAST); //parameter FAST is passed to constructor
    display.placeTurtle(raphael);
    
// initial position to start drawing;
    raphael.left(PI); //could be .right(Pi) due to angle Pi, now facing LEFT
    raphael.forward(16*4);  // 4 greekKeys with side 16 each to LEFT
    raphael.right(PI/2); // now facing UP
    raphael.forward(16*4);  // moving 4 greekKeys UPWARDS
    raphael.right(PI/2); //turning half circle, now facing RIGHT
    

//turtle is positioned on TOP LEFT CORNER facing RIGHT and ready to draw
    raphael.penDown();
    
    // 4 sides need to be drawn, var i as outer counter
    for(int i = 0; i < 4; i++) {
    
    //drawing of 8 greek keys, a.k.a. side, var j as nested counter
      for(int j = 0; j < 8; j++) {  
        
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
        
      } //end of nested loop 

//let's turn the (ninja) turtle 90 degrees to the RIGHT
      raphael.right(PI/2);
      
    } // end of outter loop
    
// now 4 sides are drawn, pen must be set UP to avoid further marks on display        
    raphael.penUp();
    
    
/* 
 * before closing display, the forth ninja turtle is sad for not being part of this assignment,
 * so let's mention his creation here and practice the use of block comments:
 * 
 * private Turtle leonardo;
 * 
 * leonardo = new Turtle(FAST);
 * display.placeTurtle(leonardo);
 * 
 * leonardo.left(4*2*PI); // performing an impressive victory turn!
 * 
 * leonardo.penDown(); // practicing calling some methods
 * leonardo.penUp(); // leonardo is now happy eventhough there's no Assign_1_D
 * 
*/
    display.close();
};
  
//var pipeLine is considering the full pipe where ninja turtles live
public static void main ( String[] args ) { Frame pipeLine = new Frame(); };

}