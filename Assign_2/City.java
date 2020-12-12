package Assign_2;

import Media.*;                  // for Turtle and TurtleDisplayer
import static Media.Turtle.*;    // for Turtle speeds
import static java.lang.Math.*;  // for Math constants and functions
import static java.awt.Color.*;  // for Color constants


/** This class is a program a City as a sequence side-by-side 2D buildings
  * created for the Assign_2
  * 
  * @author Heduin R. B. de Morais (Brock_ID 6967483, Campus_ID hr19ut, Lab#09) 
  * 
  * @version 1.0 (Oct 2020)
  *
  * new concepts: ramdomly generated numbers
  * 
  * @param nBuilding ramdomly set [3,6]
  * @param nLevel ramdomly set [5,15] w/ 2 (fixed) windows each        
  * @param windowSize set the side of the square fixed at 20x20 (four squares of side 10 pxl each  */

public class City {
  private TurtleDisplayer display;
  private Turtle ttl; // the drawing turtle
  private int nBuilding;
  private int nLevel;
  private int windowSize;
  private int buildingWidth;
  private int buildingHeight;

  public City ( ) {
    
    ttl = new Turtle(2); // constructor of the drawing turtle "ttl" with super speed (int lower the faster)
    display = new TurtleDisplayer(ttl, 500, 500);  //arguments Turtle, canvas size (pxl x pxl)
    
    display.placeTurtle(ttl);
    int windowSize = 20;  // each side has 20 pxl, i.e. 2 sides of 10 pxl
        
    drawCity();          
   
    display.close();
    
   };  // constructor 
    
    
  /* This method determines the number of buildings to be drawn
   * As well as the initial position the pen to its initial drawing point
   * Draws a random number of rectangles (buildings), with a random number of levels
   * @param buildingWidth width of each building
   * @param startX/Y the initial position to stard drawing for being horizontally centred in the display
   * @method randomNumber is called to define the number of buildings
  
  */
  private void drawCity(){
    
    int buildingWidth = 70; //2*20 pxl for windows and 3 spaces (10 pxl each)
    
    int nBuilding = 3 + randomNumber(4); // from 3 to 6 (4 options: 3+0 to 3+3)
    System.out.println("This city has "+nBuilding+" buildings.");  // debug
    System.out.println("##########################");  // debug
    
    //initial position TTL    
    double startX = (-1)*70*nBuilding/2;  // horizontally centred
    double startY = -220; //ground level
    ttl.moveTo(startX, startY); //-220 is 30 pxl above the bottom (which is y = -250)
   
    
    for (int i = 0; i < nBuilding; i++){
      
        int nLevel = 5 + randomNumber(11); // from 5 to 15 (11 options: 5+0 to 5+10)
      
        System.out.println("Building #"+(i+1)+" has "+nLevel+" levels." );  // debug        
        int buildingHeight = 10 + (20 + 10)*nLevel; // initial space from ground + (window plus space up)per floor
        //draw rectangle for nLevels
        drawRectangle(buildingWidth, buildingHeight);
        
        // move to windows' position
        double newX = ttl.getScreenX()+10;
        double newY = ttl.getScreenY()+10;
        ttl.moveTo(newX, newY); 
        
        // start to draw pairs of windows
        
        for (int j = 0; j < nLevel; j++){          
          drawWindow(); // 1st window of a Level
          newX = ttl.getScreenX()+30;
          newY = ttl.getScreenY();
          ttl.moveTo(newX, newY); // ready to draw second window
          drawWindow(); // 2nd window of a Level
          newX = ttl.getScreenX()-30;
          newY = ttl.getScreenY()+30;
          ttl.moveTo(newX, newY); // ready to draw the next floor's windows      
          
        }        
        
        // reposition TTL for the next building        
        // ttl. back to start
        ttl.moveTo(startX, startY); //-210 is 40 pxl above the bottom (to avoid misposition)
        // ttl move to the next building
        ttl.forward(buildingWidth * (i+1));
    }
    
  } // end drawBuilding
  
 /* This method draws 4 small squares with 10 pxl of side, each
  * The FOR loop draws the bottom layer first, then the Upper layer
  * Turtle always start and ends a method at the same position and orientation.
  * @method drawRectangle is called to draw a simple rectangle with width=height=10
  * */
  private void drawWindow(){
   
    for(int i=0; i<2; i++){
      drawRectangle(10,10); //LEFT
      ttl.forward(10);        
      drawRectangle(10,10); //RIGHT
      ttl.backward(10); 
      ttl.left(PI/2);
      ttl.forward(10);
      ttl.right(PI/2);  //ready to draw upper part of the window   
    }
   ttl.right(PI/2);
   ttl.forward(20);
   ttl.left(PI/2);
  }
  
  
  
  /* This method draws a rectangle given width and height
   * Turtle ends at the same position and orientation 
   * Turtle puts penDown at the begining and penUp at the end to avoid not-requested ink
   * It draws anti-clock wise from bottom left
   * @param width size of base and roof
   * @param heigth both right and left sides
   */
  private void drawRectangle(int width, int height){
    
    ttl.penDown();
    
    ttl.forward(width);     //BASE
    ttl.left(PI/2);        
    ttl.forward(height); // UP for RIGHT-SIDE
    ttl.left(PI/2);    
    ttl.forward(width);     // ROOF
    ttl.left(PI/2);    
    ttl.forward(height); //DOWN for LEFT-SIDE
    ttl.left(PI/2);    
    
    ttl.penUp();
  } // end drawRectangle
  
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
//      System.out.println("double is " + d);  // debug
//      System.out.println("integer returned is  "+ n);  // debug
      return n;
    }// end randomNumber
   
   


  
// main function
public static void main ( String[] args ) { City city  = new City(); };

}  // City