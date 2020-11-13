package Assign_4_B;

import Media.*; 
import static java.lang.Math.*; // max(a,b) to be used
//import static java.util.*; // to interate the picture one more time;



/** This class is a program to Normalize the intensity of brightness of a picture without extrapolate the 255 RGB value 
 
  * @author Heduin R. B. de Morais (Brock_ID 6967483, Campus_ID hr19ut, Lab#09) 
  * @version 1.0 (Nov. 2020)
  * new concepts: pixels and color channels
  * 
  * @param display to exibit the pictures
  * @param pic picture file to be shown
*/

public class Normalize {
  PictureDisplayer display;
  Picture pic;

  public Normalize() {
    pic = new Picture();  // user select the picture
    //pic = new Picture("mission_beach_darker.jpg"); // DEBUG: pre-defined picture
    display = new PictureDisplayer(pic);
   
    display.waitForUser(); // Await users see the original, then press OK
    normIntensity(pic);  // non-destructive
    
    //saving before closing makes more sense
    pic.save(); // let's user to pick a name and folder
    //pic.save("normalized.jpg"); // DEBUG: pre-defined output name.jpg (destructive)
    
    display.close();
    
   };  // constructor Normalize
  
  /* This methose determines the largest channel value of the three channels (R, G and B) of the pixel p
   and returns that value.
   @param p pixel to be analized
   @return max of pixels values of {R, G, B} by using Math.max funcion of two values
   */
  private int maxChannel ( Pixel p ) {
    return max(p.getRed(),max(p.getGreen(),p.getBlue()));
  } // end maxChannel  
    
    
  /* This method normalizes the intensities of the channels of all pixels by finding the maximum
   * intensity of any channel, determining the factor necessary to raise this intensity to 255,
   * and then multiplying each channel value of every pixel by this value.
   * @param aPic picture to be saturated
   * @param p pixel to analized for max [R,G,B] = 255
   * @param maxLocal int returned by maxChannel()
   * @param maxRGB int max of all maxLocal pixels
   * @param factor int that multiplies RGB to make values [0,255]. 
   * @param H int height of the picture
   * @param W int width of the picture
   */

  private void normIntensity ( Picture aPic ) {
    Pixel p;
    int maxRGB = 1;
    int maxLocal;
    int factor;
    int H = aPic.getHeight();
    int W = aPic.getWidth();
    
    // collect maximum value
    while(aPic.hasNext()){
      p = aPic.next();
      maxLocal = maxChannel(p); // max value per pixel 
      if ( maxLocal > maxRGB){
        maxRGB = maxLocal; //  max of all pixels
        //System.out.println("New MaxRG: " + maxRGB); // DEBUG
      } //end if
    } // end while
      
    // find the factor
    factor = (int)255.0*1000/maxRGB;  //get the factor with 3 decimal places as an integer number
    System.out.println("Factor: " + factor); //DEBUG
    
    // apply normalization  (nested FOR running through ALL pixels)
    for(int h = 0; h < H; h++){
      for (int w = 0; w < W; w++){
        p = aPic.getPixel(w, h);
        p.setRed((int)(factor*p.getRed()/1000));     // precision of 3 decimals
        p.setGreen((int)(factor*p.getGreen()/1000));
        p.setBlue((int)(factor*p.getBlue()/1000));
        
      } // end for widht    
    } //end for height
    
  } // end normIntensity

  
// main function
public static void main ( String[] args ) { Normalize n = new Normalize(); };


}  // Normalize
    