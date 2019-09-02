/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Console;
import Console.*;



/**
 * Purpose:
 * 
 * This is where the input will come from the user
 * and what he will see
 * 
 * To Do:
 *  - Fix Bugs
 *  - Add GUI
 *  - Make a application
 * 
 * 
 * GOALS:
 * - Unknown Characters
   EXTRA:
 * - make a Dictionary for the Calculator
   - make it know what char was misplace there 
 * 
   * @
   *  
   * 
   * 
   * 
   * 
   * 
 * 
 * @version 2.0
 * @author Brandon
 */
public class Output_Text {
    log_writer lw = new log_writer();
    Time ti = new Time();
    String Out = "Test";
    
    String time = ti.time12();
    String MathS = "[Math System] ";
    String conso = " [Console] ";
    String er = "[Error Detect] ";
    String Solv = "[Solve] ";
    String OneTwo = "[One Two] ";
    String TwoThr = "[Two Three] ";
    String Comp = "[Compiler] ";
    String solve = "[Solver] ";
    String split = "[Variable-Splitter] ";
    String diag = "[Diagnose] ";
    
    

            
    
    

    
    public void PrintCo(String print) {
        
        
        Out = (time + conso + print);
        System.out.println(Out);
        lw.Text(Out);
        
        
       /**
        * 
        * @param print Console print
        * 
        * 
        */
    }
    

    
    public void PrintMS(String print) {
        
        
        Out = (time + conso + MathS + print);
        System.out.println(Out);
        lw.Text(Out);
        
    }
    
    public void PrintEr(String print) {
        
        
        Out = (time + conso + MathS +  er + print);
        System.out.println(Out);
        lw.Text(Out);
        
    }
    
    public void PrintEr_int(String print, int num ) {
        
        
        Out = (time + conso + MathS +  er + print + num);
        System.out.println(Out);
        lw.Text(Out);
        
    }
    
    
    public void PrintSol(String print) {
        
        
        Out = (time + conso + MathS +  Solv + print);
        System.out.println(Out);
        lw.Text(Out);
        
    }
    public void PrintMSol(String print) {
        
        
        Out = (time + conso + MathS +  Solv + OneTwo + print);
        System.out.println(Out);
        lw.Text(Out);
        
    }
    public void PrintM2Sol(String print) {
        
        
        Out = (time + conso + MathS +  Solv + TwoThr + print);
        System.out.println(Out);
        lw.Text(Out);
        
    }
    
    public void Printcomp(String print) {
        
        Out = (time + conso + MathS +  Solv + Comp + print);
        System.out.println(Out);
        lw.Text(Out);
        
        
    }
    
    public void Printsolce(String print) {
        
        Out = (time + conso + MathS +  diag + solve + print);
        System.out.println(Out);
        lw.Text(Out);
        
        
    }
    
    public void Printsplit(String print) {
        
        Out = (time + conso + MathS +  diag + split + print);
        System.out.println(Out);
        lw.Text(Out);
        
        
    }
    
    
}
