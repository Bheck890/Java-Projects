/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package math.System.Variable;

/**
 *
 * @author Brandon
 */
public class Problem_Tear {
    
     
     
     public String[] ProblemCenter (String prob) {
        Identifyer id = new Identifyer();
        Interger_Split v = new Interger_Split();
        Problem_Solveing PS = new Problem_Solveing();

        String[] probID = new String[5]; 
        String[] a = new String[10];
        
        probID[0] = "ERROR";

         
        int fun = 0;
        
        //Identifys what problem it has
        
        fun = id.ID(prob);
        
        
        // what to do 
        if (fun == 1) {
               
        // Tear numbers apart
        a = v.add(prob);
        
        // ADDING ID
        }
        else if (fun == 2) {
        a = v.Subtract(prob);
             
        // Subtracting ID
        }
        else if (fun == 3) {
        a = v.Multi(prob);
            
            
            
        }
        else if (fun == 4) {
        a = v.Divide(prob);
            
            
            
        }
        else if (fun == 5) {
            
            
            
            
        }
        else if (fun == 6) {
            
            
            
            
        }
        else if (fun == 7) {
            
            
            
            
        }
        else if (fun == 8) {
            
            
            
            
        }
        else if (fun == 9) {
            
            
            
            
        }   
        else {
            
        }
        
        
        
        
        // a[0] FIrst Integer 
        // a[1] Second Interger
        
     
     return(a);
    }
}