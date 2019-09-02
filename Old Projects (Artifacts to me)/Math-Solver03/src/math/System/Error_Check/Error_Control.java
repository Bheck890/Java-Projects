/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package math.System.Error_Check;


/**
 * Purpose:
 * Checks for Errors
 * 
 * @author Brandon
 */

 

public class Error_Control {
    
    
    
    Spell_Check sc = new Spell_Check();
    
    
    //String Error_check (String prob , boolean alg)
    public String[] Error_check (String prob) {
        String[] free = new String[10];
        free[0] = "0"; // Used
        free[1] = "0"; // Used
        free[2] = "0"; // Used
        free[3] = "0"; // Used
        free[4] = "0"; // Used
        free[5] = "0"; // Used
        free[6] = "0"; // Empty
        free[7] = "0"; // Empty
        free[8] = "0"; // Empty
        
        
        
        
        
        
        
        
        int Error1 = 0; // space check
        int Error2 = 0; // Inproper pos of Sign Check
        int Error3 = 0; // Lowercase letter check
        int Error4 = 0; // Upercase letter check
        int Error5 = 0; // Characters Check 
        int Error6 = 0; // alg; // algebra Variables FUTURE 
        
        // Checks for Spell errors
        // Checks little Leters
        
        
        // works by useing the meathod then moving to the next one 
        
        
        
        Error1 = sc.Space_Check(prob); // Space Meathod
          if (Error1 == 0 ) { // Space Check
            
            //Error2 = sc.Sign_Check(prob); // sign meathod
              if (Error2 == 0) {
                    
                Error3 = sc.LLetter_Check(prob); // Lowecase Meathod
                  if (Error3 == 0){ // Letter Check
              
                    Error4 = sc.ULetter_Check(prob); // Upercase Meathod
                     if (Error4 == 0){
                         
                       
                      /*Error4 = sc.--------(prob);
                         if (Error4 == 0) {
                    
                    
                    
                        }*/                       
                  
                    }
                  
                }
              
            }
 
        }
        
        
        // Free array has six slots
        
        // Clasifys the Lowercase
        
        if (Error1 == 1 ) { // Space
            free[1] = "1";
        }
        else if (Error2 == 1) { // Sign Pos
            free[2] = "2";
        }
        else if (Error3 == 1) { // Low Letter
            free[3] = "3";
        }
        else if (Error4 == 1) { // Up Letter
            free[4] = "4";
        }
        else if (Error5 == 1) { // Character
            free[5] = "5";
        }

        
        
        
        
        
        //System.out.println("Lower Case: " + Error1);
        //System.out.println("Space: " + Error3);
        
        
       return (free);
    }
    
    
}
/*

**Error Needs **

add THese

- Unknown Characters
- Unknown Uppercase Letters
- More lowercase Letters
- make a Dictionary for the Calculator
- make it know what char was misplace there 
- Make it so that if there is a sign on either ends it is a error






*/



/* 
                   
                  Error4 = sc.--------(a1);
                  if (Error4 == 0) {
                    
                    
                    
                  }
                  
                 */ 