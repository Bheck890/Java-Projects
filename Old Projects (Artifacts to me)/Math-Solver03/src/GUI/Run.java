/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.Scanner;

import Console.Output_Text;

/**
 * Process
 * Run this file 
 * 
 * Loads GUI and send info to Console
 * after all loads and GUI is present
 * User types in Problem 
 * problem Gets sent to Math Solver
 * Math solver returns: Error Status, and Answer
 * 
 * 
 * @author Brandon
 */
public class Run {
    
    
    public static void main(String[] args) {
        

        //Meathod Classify
        Meathod_Caller MC = new Meathod_Caller();
        Output_Text inpu = new Output_Text();
        
        @SuppressWarnings("resource")
        Scanner scan = new Scanner(System.in);
        
        
        // d99 = (-99)
        // the d in a number can cause a crash
        // make sure GUI dose not alow variable d in here
        // except when a negative whole number
        
        
        
        
        
        // Strings
        String Problem = "100+34-8";
        
        
        
        
        // Arrays
        String[] answer = new String[3];
        
        
        // Begin
        inpu.PrintCo("******************Begin: Calculation");
        inpu.PrintCo("Title: Math Helper");
        inpu.PrintCo("Made By: Brandon Heck");
        inpu.PrintCo("Version (1.0)");
        inpu.PrintCo("Maximum 25 signs");
        
        //GUI INFO
        
        
        
        
        System.out.print("Enter Problem:");
        
        Problem = scan.nextLine();
        
        scan.close();
        
        
        
        
        answer = MC.Mathsolve(Problem);
        
        inpu.PrintCo("GUI Output ");
        inpu.PrintCo(answer[1]);
        inpu.PrintCo(answer[0]);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
}
