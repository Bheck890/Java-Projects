/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package math.System;

import Console.*;
import math.System.Error_Check.Error_Control;
import Compiler.*;
        

/**
 * Purpose:
 * 
 * where all the systems come and 
 * tells what the system is doing 
 * 
 * CONSOLE
 * /**
 * Purpose:
 * 
 * where all the systems come and 
 * tells what the system is doing 
 * 
 * CONSOLE
 * 
 * @author Brandon
 */


public class Math_Solver {
    /**
     * @param problem
     * @param args the command line arguments
     */
    // Recieve Variables
    
    
    
    public String[] Math (String prob, String id) {
                
        // Class Input
        
        Output_Text inpu = new Output_Text();
        Error_Control EC = new Error_Control();
        Compile_out1 Co = new Compile_out1();
        
        


        // - Variables
        //     ints
        int ErrorC ;
        
        //     Strngs
        String sol = "Answer: Empty" ;
        String Error1 = "Error Check; Fail";
        String pID ;
        String Solution = "Solve: Fail";
        String Psolution ;
        String erro = "No Errors";
        // array
        String[] Output = new String[4];
        Output[0] = "Math code Sucess";
        Output[0] = "0";
        
        
        
        
        
        //***********************
        // Problem Input
        String problemv = prob;
        //***********************
        inpu.PrintCo("Input: " + prob);
        
        
        inpu.PrintEr("Phase: Check For Errors");
        // Check For Errors // ----------------------------------
        
        String ErrorLD = "Lower Case Letter Detection";
        String ErrorUD = "Upper Case Letter Detection";
        String Error_space2 = "Space Detection";
        String ErrorChar = "Un-wanted Characters Detection";
        String ErrorSign = "Incorect Sign Placement Detection";
        
        int ue = 0;// These vars get overritten
        int ae = 0;
        int qw = 0;
        int gh = 0;
        int fg = 0;
        int rt = 0;
        
        
        String[] er = EC.Error_check(problemv);
        // turns the 2 variables into 
        // Variables from Strings
         ue = Integer.valueOf(er[1]); // space
         //gh = Integer.valueOf(er[2]); // Sign
         ae = Integer.valueOf(er[3]); // L letter
         qw = Integer.valueOf(er[4]); // U letter
         
        
        
        if (ue == 0 && gh == 0 && ae == 0 && qw == 0) {// ErrorC 0; makes the System work
            ErrorC = 0;

        }
        else {
            ErrorC = 1;
            //inpu.print_int(ErrorC);
        }    
        
            
            
            
        if (ue == 1) {
             erro = Error_space2;   
        }
        else if (gh == 2) {
            erro = ErrorSign;
        }
        else if (ae == 3) {
            erro = ErrorLD;
        }
        else if (qw == 4) {
            erro = ErrorUD;
        }
        
        // Error Print Report 
        
        inpu.PrintEr_int("Space Check                = ", ue);
        //inpu.PrintEr_int("Sign Check                 = ", gh);
        inpu.PrintEr_int("Lowercase Letter Check     = ", ae);
        inpu.PrintEr_int("Uppercase Letter Check      = ", qw);
        inpu.PrintEr_int("([LATER])Algebra           = ", fg);
        inpu.PrintEr_int("PROBLEM CHECK DEBUG        = ", ErrorC);
        
        
        
        inpu.PrintSol("Phase: Solve");
        // PROBLEM SOLVE // --------------------------------------//
        
        
        String[] s0l = new String[25];
        //s0l[0] = Answer
        s0l[1] = "0"; // Problem ID
        if (ErrorC == 0) {
            
            
            s0l = Co.compile2(prob);
            //s0l = VC.ot(problemv);
            
        }
        
        
               
        Psolution = s0l[0];  // Answer
        
        if (s0l[4] == "1") { // Compile Error (Change system)
            ErrorC = 2;
        }
        else if (s0l[4] == "2") { // Compile Error (Change system)
            ErrorC = 2;
        }
        
        if (Psolution.endsWith(".0")){
            Psolution = Psolution.substring(0, (Psolution.length()-2));
        }
        
        
        
        
        // PRINT AREA (Console) // -------------------------------//

        //inpu.Print_Seperation("Intro");

        
        
        
        
        if (ErrorC == 1){
         //inpu.print("!!!!!ERROR!!!!!");
         inpu.PrintEr(erro);
         //inpu.PrintEr("Please check your problem and try again");
          Output[1] = "1";
          Output[0] = erro;
         }
        else if (ErrorC == 2){
            Output[1] = "2";
            Output[0] = Psolution;
            //inpu.PrintMS("Answer = " + Psolution);
        } 
         else {
          inpu.PrintMS("User Input = " + problemv); // Problem
          inpu.PrintMS("Answer = " + Psolution);    // answer
          inpu.PrintMS(s0l[4]);                     // Compile Errors
          Output[1] = "0";                          // GUI Error Name
          Output[0] = Psolution;                    // GUI Answer
        }
        
        
        
        
        
        /*
        OLD GUI Print
        
        // ---------------------------------------------------------//
        // First Checks for any errors then Prints the problem------//
         inpu.Print_Seperation("Solveing");
         inpu.print("What You Entered = " + problemv);
         inpu.print("");
         if (ErrorC == 1){
         //inpu.print("!!!!!ERROR!!!!!");
         inpu.print("Error Detect: " + erro);
         inpu.print("Please check your problem and try again");
         
         }
         
         else {
           
          inpu.print("Problem = " + problemv);
          inpu.Print_Seperation("Answer = " + Psolution);
          }


          */
         
         return(Output);
    }

    
}
