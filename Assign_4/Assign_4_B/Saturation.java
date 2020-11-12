package Assign_4_B;

import Media.*; 
import static java.lang.Math.*; // max(a,b) to be used



/** This class is a program to SATURATE a picture without extrapolate the 255 RGB value 
 
  * @author Heduin R. B. de Morais (Brock_ID 6967483, Campus_ID hr19ut, Lab#09) 
  * @version 1.0 (Nov. 2020)
  * new concepts: pixels and color channels
  * 
  * @param display to exibit the pictures
  * @param pic picture file to be shown
*/

public class Saturation {
  PictureDisplayer display;
  Picture pic;

  public Saturation() {
    pic = new Picture();  // user select the picture
    //pic = new Picture("mission_beach_darker.jpg"); // DEBUG: pre-defined picture
    display = new PictureDisplayer(pic);
   
    display.waitForUser(); // Await users see the original, then press OK
    normIntensity(pic);  // non-destructive
    
    //saving before closing makes more sense
    pic.save(); // let's user to pick a name and folder
    //pic.save("saturated.jpg"); // DEBUG: pre-defined output name.jpg (destructive)
    
    display.close();
    
   };  // constructor Saturation
  
  /* This methose determines the largest channel value of the three channels (R, G and B) of the pixel p
   and returns that value.
   @param p pixel to be analized
   @return the max value of {R, G, B} by using Math.max funcion of two values
   */
  
  private int maxChannel ( Pixel p ) {
    return max(p.getRed(),max(p.getGreen(),p.getBlue()));
    
    
  } // end maxChannel  
    
    
  /* This method normalizes the intensities of the channels of all pixels by finding the maximum
   * intensity of any channel, determining the factor necessary to raise this intensity to 255,
   * and then multiplying each channel value of every pixel by this value.
   * @param aPic picture to be saturated
   * @param p pixel to analized for max [R,G,B] = 255
   * @param maxRGB int returned by maxChannel()
   * @param factor int that multiplies RGB to make values [0,255]
   */

  private void normIntensity ( Picture aPic ) {
    Pixel p;
    int maxRGB;
    int factor;
    while(aPic.hasNext()){
      p = aPic.next();
      
      maxRGB = maxChannel(p); 
      // to avoid factor to be divided by zero, when pixel is black maxRGB != 0
      if (maxRGB == 0) { maxRGB++; } 
      
      //find the factor
      factor = (int)255/maxRGB; 
 
      //one of [R,G,B] must be 255, the others [0,255]      
      p.setRed  (factor*p.getRed());
      p.setGreen(factor*p.getGreen());
      p.setBlue (factor*p.getBlue());
      
    } // end while
    
    
    
  } // end normIntensity

  
// main function
public static void main ( String[] args ) { Saturation s  = new Saturation(); };


}  // Saturation
    