package Assign_3;

import Media.*;                  // for Turtle and TurtleDisplayer
import static Media.Turtle.*;    // for Turtle speeds
import static java.lang.Math.*;  // for Math constants and functions
import static java.awt.Color.*;  // for Color constants



/** This class is a program to build a Forest in the Fall season by using 
  * randomly generated numbers to produce different number and sizes of trees within given ranges.
  * It also select the color of the leaves between green and red with a proportion 3:1
  * The layout is horizontally symetric and the ground is vertically centred.
  * 
  * @author Heduin R. B. de Morais (Brock_ID 6967483, Campus_ID hr19ut, Lab#09) 
  * 
  * @version 1.0 (Oct 2020)
  *
  * new concepts: attributes selected by a probabilistic share
  * 
  * @param sizeSpoke ramdomly set [10,20] = 11 possibilities (10+0 .. 10+11)
  * @param heigthTrunk ramdomly set [40,100] = 61 possibilities (40+0 .. 40+60)
  * @param nTree ramdomly set [5,10] = 6 possibilities (5+0 .. 5+5)
  * @param canvasSide set by default as 300 pxl, customizable 
*/

public class Forest {
  private TurtleDisplayer display; //standard display (300,300) pxl
  private Turtle ttl; // the drawing turtle
  private int canvasSide; // the side of canvas
  private double sizeSpoke; // randomly generated
  private int heightTrunk;  // randomly generated
  private double spaceX; // returned by method moveToStart() 

  public Forest ( ) {
    
    ttl = new Turtle(0); // constructor of the drawing turtle "ttl" with super speed (int lower the faster)
    canvasSide = 300; //  Let's setup the default, but it is now customizable, e.g. try 500 or 800 
    display = new TurtleDisplayer(ttl, canvasSide, canvasSide);  // no parameters = 300 x 300    
    display.placeTurtle(ttl);    
    
    //ramdon number of trees
    int nTree = 5 + randomNumber(5); // [5..10]    
    System.out.println("Number of trees: " + nTree);    //debug
    
    // Move the turtle to initial drawing position for evenly-spaced trees
    
    // Move the turtle to initial point, receives spaces in-between trees
    double spaceX = moveToStart(canvasSide, nTree);  //moveToStart() returns in-between trees lenght
    
    // Ready to draw the Forest    
    drawForest(nTree, spaceX);    
    
    // Ready to close display    
    display.close();
    
   };  // constructor Forest
  
  
  /*
   * The method uses a for loop to draw nTree trees
   * They need to be evenly distributed to be horizontally spaced 
   * The turtle ends at the same position/orientation where it started  
   * @param nTree randomly generated
   * @param sizeSpoke randomly generated
   * @param heightTrunk randomly generated
  */  
  private void drawForest (int nTree, double spaceX){
    for (int i = 0; i < nTree; i++) {  
      double sizeSpoke = 10 + randomNumber(11); // each spoke lenght  [10..20]
      int heightTrunk = 40 + randomNumber(61);  // height of Trunk   [40..100]
      
      drawTree(heightTrunk, sizeSpoke);  // draw each individual tree
      
      //repostition to draw the following tree
      ttl.forward(spaceX);
      
    } // end for
    
    // Recentre the turtle when finish all trees - {good practice: return to the origin)
    ttl.moveTo(0,0);   
  
  } // end drawForest
 
  
   /*
   * The method moves the turtle to the proper initial point
   * It keeps the trees evenly spaced (horizontally)    
   * The turtle ends at the same orientation where it started, i.e. EAST
   * @param canvas is the side of the canvas in pixels 
   * @param nTree is the number of tree randomly generated 
   * @param inBetween holds the space in between trees
   * @param startX initial position to start drawing symmetrically
   */    
  private double moveToStart (int canvas, int nTree) {
    // Find the space inBetween trees to be evenly spaced
    double inBetween = (canvas / (nTree + 1) );  // There are (nTree +1 ) empty spages in-btw the nTree.
    System.out.println("inBetween: " + inBetween);  
    
    double startX = (-1)*canvasSide/2 + inBetween; // Go to the extreme left of the canvas and move 1 space EAST
    double startY = 0; // not changed at all
    System.out.println("StartX: "+ startX);        // debug  
    ttl.moveTo(startX, startY);      
    
    return inBetween;   

  } // end moveToStart
  
  /*
   * The method calls two other methods to draws a tree and return the turtle to initial position/orientation. 
   * The turtle ends at the same position/orientation where it started 
   * @param radius (double as requested) is the size of each spoke
   * @param height lenght of the trunk
   */      
  private void drawTree(int height, double radius){
    
    drawTrunk(height);
    drawSpokes(radius);
  
    //return to original position
    ttl.right(PI/2);
    ttl.forward(height);
    ttl.left(PI/2);
  
  } //end drawTree 
  
  
  /* This method sets the pen color to green with a 75% probability and red with a 25% probability
  * To make the random selection of color, use Math.random() to generate a random number between 0.0 and 1.0 
  * If the value is less than 0.75 choose green otherwise choose red
  */  
  private void chooseColor(){
    if (random() < 0.75) { 
      ttl.setPenColor(green);
    } else {
      ttl.setPenColor(red);
    } // end else    
  } // end chooseColor
  
  
  /* This method draws the canopy of a given tree
   * Turtle ends and the same position and orientation as usual
   * It also changes (and unchange) color and width of the pen
   * @param radius of canopy.
   */      
  private void drawSpokes (double radius){
    // change pen color and width    
    ttl.setPenWidth((int)radius*2);
    
    //initial orientation adjustment
    ttl.left(PI/6);
    // draw 6 Spokes space by 2*PI/6 radians = i*PI/3, from 0*PI/6 to 5*PI/6
    for (int i=0; i<6; i++){
      // choose the proper collor
      chooseColor();      
      // turn and draw it      
      ttl.penDown();     
      ttl.forward(radius);      
      // return and turn
      ttl.penUp();
      ttl.backward(radius);
      ttl.left(PI/3); //back to initial orientation to avoid       
    } // end for
    //final orientation adjustment look EAST
    ttl.right(PI/6);
    
    // unchange pen color and width
    ttl.setPenColor(black);
    ttl.setPenWidth(1);
    
  } // end drawSpokes
  
  
  /* This method draws the trunk of a given tree
   * Notice that the turtle DOES NOT RETURN to be original position
   * It is ready to draw the Canopy
   * It also changes (and unchange) color and width of the pen
   * Turtle ends and the same orientation though, AS USUAL.
   * @param heigth (of a trunk) without canopy.
   */  
  private void drawTrunk (int heigth){
    // change pen color and width
    ttl.setPenColor(gray);    
    ttl.setPenWidth(10);
    
    // rotate
    ttl.left(PI/2);
    
    // draw
    ttl.penDown();
    ttl.forward(heigth);
    ttl.penUp();
    
    // (un)rotate
    ttl.right(PI/2);
    
    // unchange pen color and width
    ttl.setPenColor(black);
    ttl.setPenWidth(1);
  
  } // end drawTrunk
  
  
  /** This method finds a (pseudo) random integer from 0 to @number (exclusive) 
    * In a total of @number of possiblities  
    * Returns a random number by using the remainder (%) operator so the quantity is defined by it
    * @param number quantity of possibilities to be chosen from 0 to (Number -1), i.e. Number possibilities
    * @param d to convert the range (0,1) into 10^6 possibilities (arbitrary) to be chosen from
    * @param n to be used in the remainder operation to pick a number from @param d.
    */   
    private int randomNumber(int number){
      double d =(random()*1000000); //integer part of d ranges from 0 to 999,999
      int n = (int)d%number;  // remainder of (casting d to integer) modulus (qtd of numbers) 
      //System.out.println("double is " + d);  // debug
      //System.out.println("integer returned is  "+ n);  // debug
      return n;
    } // end randomNumber
  
  
// main function
public static void main ( String[] args ) { Forest amazon  = new Forest(); };


}  // Forest
    