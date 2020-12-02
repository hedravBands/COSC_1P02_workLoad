package Assign_6;

import BasicIO.*;                // for IO classes
import static BasicIO.Formats.*; // for field formats
import static java.lang.Math.*;  // for math constants and functions


/** This class is a program that processes data files and writes reports.
  * 
  * @author Heduin R. B. de Morais (Brock_ID 6967483, Campus_ID hr19ut, Lab#09) 
  * @version 1.0 (Dec. 2020)
  * new concepts: data file processing in, pdf out 
  * 
  * @param stData file in
  * @param report pdf out
*/

public class Data {
  
  private ASCIIDataFile    stData;     // input data file with the raw scores (reading .txt file)
  private ReportPrinter    report;     // printer for report (creating and writing to new .pdf file)
  
  
  /** The constructor does the weigthed average of scores for students 
    * of a given course generating a PDF report.                                                  
    */
    
  public Data() {
    
    //Select stData.txt
    //You will be prompted to print (choose print to pdf)
    //Run the program and then it will prompt you to save the pdf
    //Type the name of the output pdf
   
    stData = new ASCIIDataFile();
    report = new ReportPrinter();

    String courseName = ""; 
    String stCode = ""; 
    String stName = "";
    double a1 = 0;
    double a2 = 0; 
    double test = 0;
    double exam = 0;
    
    double wAvg = 0;
    double tAvg = 0;

    int seq = 0; // column counter
     
    courseName = stData.readString();    
    setupReport(courseName);
    
    
    //individual final score and  total sum of total scores    
    for ( ; ; ) {
      
      if ( stData.isEOF() ) { break; }
      
      //iterate a row of a given student, calculate one's weighted average and add it to totalAverage tAvg
      switch ( seq % 6 ) { 
        case 0: 
          stCode = stData.readString(); 
          break;
        case 1: 
          stName = stData.readString(); 
          break;
        case 2: 
          a1 = stData.readDouble(); 
          wAvg += 10*a1/10;
          break; 
        case 3: 
          a2 = stData.readDouble(); 
          wAvg += 10*a2/10; 
          break; 
        case 4: 
          test = stData.readDouble(); 
          wAvg += 30*test/50; 
          break;
        case 5: 
          exam = stData.readDouble(); 
          wAvg += 50*exam/100; 
          // add each student's weigthed average wAvg to total score tAvg
          tAvg += wAvg;        
          // insert one row containing all student data on file and report    
          writeStData(stCode, stName, a1, a2, test, exam, wAvg);
          // reset wAvg for the next student
          wAvg = 0; 
      
      } // end switch
      
      // keep tracking of the column
      ++seq;      
         
    } // end for
    
    // add last 2 lines in the pdf 
    // total # of student is "seq/6".
    // Average score is tAvg/(seq/6)
    writeSummary(tAvg/(seq/6), seq/6);
    
    stData.close();
    report.close();
    
  } // Constructor Data
  
  
    /** This method sets up the report, adding title, subtitle, and all colum names 
      * 
      * @param name String name of course (faculty + course code)
      */  
  private void setupReport(String name){
    report.setTitle(name, "Final Grades");
    report.addField("stCode", "Student #", 9);
    report.addField("stName", "Name", 20);
    report.addField("a1", "A1", 5);
    report.addField("a2", "A2", 5);
    report.addField("test", "Test", 5);
    report.addField("exam", "Exam", 5);
    report.addField("final", "Final", 5);   
  };  // setupReport
  
       
  /** This method writes a record to PDF report
    * 
    * @param stCode String student code
    * @param stName String student name 
    * @param a1 double student score for assign 1
    * @param a2 double student score for assign 2
    * @param test double student score for test
    * @param exam double student score for exam
    */  
  private void writeStData (String stCode, String stName,
  double a1, double a2, double test, double exam, double avg) {    
    
    report.writeString("stCode", stCode);     
    report.writeString("stName", stName);    
    report.writeDouble("a1", a1);    
    report.writeDouble("a2", a2);    
    report.writeDouble("test", test);    
    report.writeDouble("exam", exam);    
    report.writeDouble("final", avg);
      
  };  // writeStData
   
  
  
    
  /** This method generates the report summary.
    * 
    * @param average double total of weighted final scores / total number of students 
    * @param nStudent int total number of students
    * To fix format of @param average with 1 decimal, I used String.format then I used Double.parseDouble
    * to bring back to double and adjust the alignment
    */
  
  private void writeSummary ( double average,  int nStudent ) {
    report.writeString("stCode", "Average");
    report.writeDouble("final",  Double.parseDouble(String.format("%.1f", average)));
    report.writeLine("Number of students: " + nStudent);
  };  // writeSummary
  
  
    
// main function
public static void main ( String[] args ) { Data d = new Data(); };
  
} // Data