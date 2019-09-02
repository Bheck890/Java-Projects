/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import math.System.Math_Solver;

/**
 *
 * @author Brandon
 */
public class Meathod_Caller {
    
    
    
    
    
    String[] Mathsolve (String Prob){
        Math_Solver solver = new Math_Solver();
                
        String ES = "Error Check Successful";
        String EE= "Error Below";
        String A= "Answer: ";
        String E = "Error: ";
        String AA ;
        
        
        
        String[] ER_AN = new String[5];
        
        ER_AN[0] = "Math Code Error"; // Send into and Return answer
        ER_AN[1] = "0"; // Send into // ID
        
        ER_AN = solver.Math(Prob, "0");
        
        //Problem Add on 
        AA = ER_AN[0]; 
         
        
        
        
        
        // ID Check
        int AID;
        
        AID = Integer.valueOf(ER_AN[1]);
        
        
        
        if (AID == 0){
            // Answer
            ER_AN[1] = "0"; // Console Item
            ER_AN[1] = ES;
            ER_AN[0] = A + AA ; 
            
        }
        else if (AID == 1) {
            // Error
            ER_AN[1] = "1"; // Console Item
            ER_AN[1] = EE;
            ER_AN[0] = E + AA ;
        }    
        else if (AID == 2) {
            // Error
            ER_AN[1] = "1"; // Console Item
            ER_AN[1] = EE;
            ER_AN[0] = E + AA ;    
            
            
        }
        else {
            // Problem 
        }
        
        
        return(ER_AN);
    }
    
}
