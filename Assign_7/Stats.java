package Assign_7;

import BasicIO.*;                // for IO classes
import static BasicIO.Formats.*; // for field formats
import static java.lang.Math.*;  // for math constants and functions


/** This class is a program that processes data files, prompt user to update data and writes on the same file.
  * 
  * @author Heduin R. B. de Morais (Brock_ID 6967483, Campus_ID hr19ut, Lab#09) 
  * @version 1.0 (Dec. 2020)
  * new concepts: data file processing i/o, basic forms, 
  * 
  * @param nhlData, newNhlData file i/o
  * @param display form
*/

public class Stats {
  
  private ASCIIDataFile    nhlData;     // input data file with the raw scores (reading .txt file)
  private BasicForm        display;     // form for user input
  private ASCIIOutputFile  newNhlData;  // new (updated) inventory file
  private ReportPrinter    report;      // printer for report

  
  
  /** The constructor updates score for, score against and points for NHL teams 
    * generating a PDF report with the current Stats, after each round of games.                                                 
    */
    
  public Stats() {
    
    //Select nhlData.txt
    //You will be prompted to print (choose print to pdf)
    //Run the program and then it will prompt you to save the pdf
    //Type the name of the output pdf
   
    nhlData = new ASCIIDataFile();
    newNhlData =  new ASCIIOutputFile();  //make to be the same~~ 
    display = new BasicForm("Enter", "Bye");
    report = new ReportPrinter();
    
    //initialize variables
    String team = ""; 
    int pos = 0; // score for
    int neg = 0; // score against
    int pts = 0; // balance of points    
    
    buildForm();   
    setupReport(); //report header
    
    
    //read from file, prompt user, write data    
    for ( ; ; ) {
      
      if ( nhlData.isEOF() ) { break; }

      //read line
       team = nhlData.readString();  
       pos = nhlData.readInt();
       neg = nhlData.readInt();
       pts = nhlData.readInt();
       
      fillForm(team);
      int button = display.accept();
       
       //returns newPos newNeg, or bye (button is 1)
       if (button <> 0){ // bye button
         writeNhlData (team, pos, neg, pts);
       } else { // enter button
         int newPos = display.readInt("pos");
         int newNeg = display.readInt("neg");
         if (newPos > newNeg){pts += 2;}
         if (newPos == newNeg){pts++;}
         writeNhlData(team, pos+newPos, neg+newNeg, pts);
       }
      
    } // end for

    display.close();
    nhlData.close();
    newNhlData.close();
    report.close();
    
  } // Constructor Stats

  
   /** This method creates the form for user interaction.                      */
  
  private void buildForm () {
    
    display.setTitle("NHL Stats");//the title of the window.

    display.addTextField("team","Team",20,30,10);
    display.setEditable("team",false);    
    display.addTextField("pos","For",3,10,40);    
    display.addTextField("neg","Against",3,50,40);
  };  // buildForm
  
  
  /** This method enters the item data into the form.
    * 
    * @param  team String name of the team
 */
  
  private void fillForm(String team) {
    
    display.clearAll();
    display.writeString("team", team);

  };  // fillForm
  
  
    /** This method sets up the report, adding title and all colum names 
      * 
      */  
  private void setupReport(){
    report.setTitle("NHL Hockey Statistics");
    report.addField("team", "  Team", 10);
    report.addField("pos", "For", 3);
    report.addField("neg", "Against",7);
    report.addField("pts", "Points", 6);
  };  // setupReport
  
       
  /** This method writes a record to PDF report/ newFile
    * 
    * @param team String Team name 
    * @param pos int score for total
    * @param neg int score against total
    * @param pts int accumulated points
    */  
  
  private void writeNhlData (String team, int pos, int neg, int pts) {    
    //writes for PDF
    report.writeString("team", team);     
    report.writeInt("pos", pos);    
    report.writeInt("neg", neg);    
    report.writeInt("pts", pts); 
    
    //writes for file        
    newNhlData.writeString(team);
    newNhlData.writeInt(pos);
    newNhlData.writeInt(neg);
    newNhlData.writeInt(pts);
    newNhlData.newLine();
    
  };  // writeStData
   
    
// main function
public static void main ( String[] args ) { Stats s = new Stats(); };
  
} // Stats