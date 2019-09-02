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
public class Variable_Carrier {
    
     
     
     public String[] VarCenter (String prob) {
        Identifyer id = new Identifyer();
        Interger_Split v = new Interger_Split();
        Problem_Solveing PS = new Problem_Solveing();

        String[] probID = new String[5]; 
        String[] negc = new String[10];
        
        
        probID[0] = "ERROR";

         
        int fun = 0;
        
        //Identifys what problem it has
        
        fun = id.ID(prob);
        
        
        // what to do 
        if (fun == 1) {
               
        // Tear numbers apart
        String[] a3 = v.add(prob);
        
        probID = PS.Solve(a3[0], a3[1], fun);   
        
        // ADDING ID
        }
        else if (fun == 2) {
        
        prob = PS.negativeag2(prob);
            
        String[] a3 = v.Subtract(prob);
         
        probID = PS.Solve(a3[0], a3[1], fun);    
        // Subtracting ID
        
        }
        else if (fun == 3) {
            
         String[] a3 = v.Multi(prob);
            
         probID = PS.Solve(a3[0], a3[1], fun);   
            
            
            
        }
        else if (fun == 4) {
         String[] a3 = v.Divide(prob);
            
         probID = PS.Solve(a3[0], a3[1], fun);   
            
            
            
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
        
        
        // [1] Returns the ID code 
        // [0] returns the answer 
        
        
        
        // turns the ID number into a string
        String we;
        
        we = Integer.toString(fun);
        
        probID[1] = we; 
     
     return(probID);
    }
}