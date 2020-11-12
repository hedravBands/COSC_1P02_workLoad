package Assign_4_A;

import Media.*;             


/** This class is a program to convert to negative color a given  picture 
 
  * @author Heduin R. B. de Morais (Brock_ID 6967483, Campus_ID hr19ut, Lab#09) 
  * @version 1.0 (Nov. 2020)
  * new concepts: pixels and color channels
  * 
  * @param display to exibit the pictures
  * @param pic picture file to be shown
*/

public class Negative {
  PictureDisplayer display;
  Picture pic;

  public Negative() {
    pic = new Picture();  // user select the picture
    //pic = new Picture("mission_beach.jpg"); // DEBUG: pre-defined picture
    display = new PictureDisplayer(pic);
   
    display.waitForUser(); // Await users see the original, then press OK
    makeNegative(pic);  // non-destructive
    
    //saving before closing makes more sense
    pic.save(); // let's user to pick a name and folder
    //pic.save("negative.jpg"); // DEBUG: pre-defined output name.jpg (destructive)
    
    display.close();
    
   };  // constructor Negative
  

  /** This method converts a pixel to its NEGATIVE by makin each [R,G,B] = 255-X, where X = [R,G,B]    
    * @paran aPic : The original picture
    * @param p : each pixel with RGB values
    */ 
  
  private void makeNegative (Picture aPic){
    Pixel p;
    while(aPic.hasNext()){
      p = aPic.next();
      p.setRed  (255-p.getRed());
      p.setGreen(255-p.getGreen());
      p.setBlue (255-p.getBlue());
    } // end while
    
  } //end makeNegative  
    
    
// main function
public static void main ( String[] args ) { Negative n  = new Negative(); };


}  // Negative
    