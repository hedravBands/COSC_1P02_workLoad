package Assign_7;

import BasicIO.*;                // for IO classes
import static BasicIO.Formats.*; // for field formats
import static java.lang.Math.*;  // for math constants and functions


/** This class is a program that processes data files, prompt user to update data and writes on the same file.
  * 
  * @author Heduin R. B. de Morais (Brock_ID 6967483, Campus_ID hr19ut, Lab#09) 
  * @version 1.0 (Dec. 2020)
  * new concepts: multiple classes, data file processing i/o, basic forms w/ multiple buttons, 
  * 
  * @param nhlData, newNhlData file i/o
  * @param report reportPrinter for PDF
  * @param display basicForm
*/

public class Stats {
  
  private ASCIIDataFile    nhlData;     // input data file with the raw scores (reading .txt file)
  private BasicForm        display;     // form for user input
  private ASCIIOutputFile  newNhlData;  // new (updated) inventory file
  private ReportPrinter    report;      // printer for report

  
  
  /** The constructor updates score for, score against and points for NHL teams 
    * generating a PDF report and new File with the current Stats, after each round of games.                                                 
    */
    
  public Stats() {
    
    //Select nhlData.txt
    //Select output file newNhlData.txt (overwriting is ok)
    //You will be prompted to print (choose print to pdf)
    //Run the program and then it will prompt you to save the pdf 
    //Type the name of the output pdf
    
    nhlData = new ASCIIDataFile();
    newNhlData =  new ASCIIOutputFile(); 
    display = new BasicForm("Enter", "Bye"); // text of buttons
    report = new ReportPrinter();
    
    buildForm(); // form constructor 
    setupReport(); //report header
    
    
    //read from file, prompt user, write data    
    for ( ; ; ) {
            
      Team aTeam = new Team(nhlData);
      
      if (nhlData.isEOF()) break;
      
      fillForm(aTeam.getTeamName());
      int button = display.accept();
       
       //returns newPos newNeg, or bye (button is 1)
      if (button > 0){     // button == 1: bye button has been pressed
        aTeam.play(-1,-1); // value -1 means: Team did not play 
       } else { // button == 0: enter button has been pressed
         int newPos = display.readInt("pos");
         int newNeg = display.readInt("neg");
         aTeam.play(newPos, newNeg); // update data
        }
      aTeam.writeDataLine(newNhlData); // write line to file after being updated
      writeReportLine(aTeam); // print line to PDF after being updated
      
    } // end for

    display.close();
    nhlData.close();
    newNhlData.close();
    report.close();
    
  } // Constructor Stats

  
   /** This method creates the form for user interaction.                      */
  
  private void buildForm () {
    
    display.setTitle("NHL Stats");//the title of the window.

    display.addTextField("team","Team",10,30,10);
    display.setEditable("team",false);    
    display.addTextField("pos","For",3,10,40);    
    display.addTextField("neg","Against",3,120,40);
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
    report.addField("team", "Team", 10);
    report.addField("pos", "For", 3);
    report.addField("neg", "Against",7);
    report.addField("pts", "Points", 6);
  };  // setupReport
  
    
  
  /** This method writes the team's attributes to PDF report
    * 
    * @param  to  file to write the attributes of the teams. 
    */
  
  public void writeReportLine (Team team) {    
    report.writeString("team", team.getTeamName());     
    report.writeInt("pos", team.getGoalsFor());    
    report.writeInt("neg", team.getGoalsAgainst());    
    report.writeInt("pts", team.getPoints()); 
  };  // writeReportLine
   
       
    
// main function
public static void main ( String[] args ) { Stats s = new Stats(); };
  
} // Stats