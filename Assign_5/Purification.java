package Assign_5;

import Media.*; 
import static java.lang.Math.*; // 


/** This class is a program that reduces noise on a sound file
 
  * @author Heduin R. B. de Morais (Brock_ID 6967483, Campus_ID hr19ut, Lab#09) 
  * @version 1.0 (Nov. 2020)
  * new concepts: sound sample, rate, fluctuation over sound waves
  * 
  * @param player SoundPlayer to play the sound file
  * @param snd sound sample to be purified
*/

public class Purification {
  SoundPlayer player;
  Sound snd;

  public Purification() {
    snd  = new Sound();  // user select the sound sample
    player = new SoundPlayer(snd);
   
    player.waitForUser(); // Await users hear the original, then press OK
    snd = clean(snd, 2);  // non-destructive
    
    //new sound placed on player for user's evaluation
    player.placeSound(snd); // user can hear the new sound
    player.waitForUser();  // click ok to save it
    
    //user chooses name and directory
    snd.save(); 
    
    
    player.close();
    
  };  // constructor Purification
  
    
  /* This method reduce the noise over a sound sample based on the original sound with specified noise reduction factor
   * @param sound file to be analized and cleaned
   * @param factor integer number of samples, i.e. margin to be considered before and after to be averaged
   * @return sound new file after cleaning method being applied.
   */

  private Sound clean ( Sound sound, int factor ) {
    Sample spl;
    int ns = sound.getNumSamples();
    System.out.println("NumSamples: " + ns + "\n***************\n");
    //int sr = sound.getSampleRate();
    
    // scan .wav excluding initial/ending #factor samples
    for(int i = factor; i < ns-factor; i++){
      spl = sound.getSample(i);
      
      double newAmp = 0;
      // get the average from -factor to +factor (total of (2*factor + 1) samples) and avarege them
      for (int j = -factor; j <= factor; j++ ){
        newAmp += sound.getSample(i+j).getAmp()/(2*factor+1);  
        //System.out.println("Sample Pos #" + (i+j) + ": " + sound.getSample(i+j).getAmp());
      }
      // set the new Amp
      spl.setAmp((int)newAmp); // set the average to the center sample
      
      // a little of progress output every 1000 samples
      if (i%1000 == 0){
        System.out.println("Sample Pos #" + i + ": " + newAmp + "\n* * * * * * \n");
      }
      
    } // end for
    
    // Dealing with inital / ending samples: requested to be muted, i.e., amp = 0
    System.out.println("\nFixing Borderline Disorder: (start && end) set to zero \n");
    // handling border cases
    for (int j = 0; j < factor; j++){
      sound.getSample(j).setAmp(0); // # of initial 'factor' samples set to 0
      System.out.println("Sample Pos #" + (j) + ": " + sound.getSample(j).getAmp());
      sound.getSample(ns - 1 - j).setAmp(0); // # of last 'factor' samples set to 0
      System.out.println("Sample Pos #" + (ns - 1 - j) + ": " + sound.getSample(ns - 1 - j).getAmp());
    } // end for
    
    // little cheers when finish
    System.out.println("\nYAYYY ALL DONE! \n");
    
    return sound; // to be placed on player for user's appreciation / saved .
  } // end clean

  
// main function
public static void main ( String[] args ) { Purification p = new Purification(); };


}  // Purification
    