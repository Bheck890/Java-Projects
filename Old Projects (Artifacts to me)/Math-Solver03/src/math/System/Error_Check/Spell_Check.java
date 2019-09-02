/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package math.System.Error_Check;



/**
 * Purpose:
 *  Checks for un-necessary Characters that are
 * not valid for a problem
 * 
 * 
 * @author Brandon
 */
public class Spell_Check {
    
  
    
        
        
        
        
        
    int Space_Check (String prob) {
        int ch = 0;
        
        if (prob.contains(" ")) {
          ch = 1;
          //System.out.println("Space error");
        }
        else {
          
        }
        
        return(ch);
    } 
    
    int Sign_Check (String prob) {
        int check = 0;
        String[] SI = new String[10];
        SI[0] = "+";
        SI[1] = "-";
        SI[2] = "*";
        SI[3] = "/";
        //LL[4] = "";
        //LL[5] = "";
        //LL[6] = "";
        //LL[7] = "";
        //LL[8] = "";
        
        
        
        // what to do if found a match
        int i = 0;
        for (i=0; i < 9; i++) {
            
        if (prob.contains(SI[i])) {
         //System.out.println("2 Yes" + i);
            i = 50; // kills the FOR system
            check = 1; // sets its invalid
        }
         else if (prob.endsWith(SI[i])) {
            i = 50; // kills the FOR system
            check = 1;  // sets its invalid
         }
        }
        
        return(check);
    }
    
    int LLetter_Check (String prob) {
        
        
        int check = 0; // sets no Lowercase
        
        // Variables to check 
        String[] LL = new String[30];
        LL[0] = "a";
        LL[1] = "b";
        LL[2] = "c";
        LL[3] = "dd";
        LL[4] = "e";
        LL[5] = "f";
        LL[6] = "g";
        LL[7] = "h";
        LL[8] = "i";
        LL[9] = "j";
        LL[10] = "k";
        LL[11] = "l";
        LL[12] = "m";
        LL[13] = "n";
        LL[14] = "o";
        LL[15] = "p";
        LL[16] = "q";
        LL[17] = "r";
        LL[18] = "s";
        LL[19] = "t";
        LL[20] = "u";
        LL[21] = "v";
        LL[22] = "w";
        LL[23] = "x";
        LL[24] = "y";
        LL[25] = "z";
        
        
        // what to do if found a match
        int i = 0;
        for (i=0; i < 26; i++) {
            
         if (prob.contains(LL[i])) {
         //System.out.println("2 Yes" + i);
            i = 50; // kills the FOR system
            check = 1; // Sets it has a capitol
        }
        
        }
        
        

        
      
        
        
        
        
        
        return (check);
    }
 
    int ULetter_Check (String prob) {
        
        
        int check = 0; // sets no Capital
        
        // Variables to check 
        String[] LL = new String[30];
        LL[0] = "A";
        LL[1] = "B";
        LL[2] = "C";
        LL[3] = "D";
        LL[4] = "E";
        LL[5] = "F";
        LL[6] = "G";
        LL[7] = "H";
        LL[8] = "I";
        LL[9] = "J";
        LL[10] = "K";
        LL[11] = "L";
        LL[12] = "M";
        LL[13] = "N";
        LL[14] = "O";
        LL[15] = "P";
        LL[16] = "Q";
        LL[17] = "R";
        LL[18] = "S";
        LL[19] = "T";
        LL[20] = "U";
        LL[21] = "V";
        LL[22] = "W";
        LL[23] = "X";
        LL[24] = "Y";
        LL[25] = "Z";
        
        
        
        // what to do if found a match
        int i = 0;
        for (i=0; i < 26; i++) {
            
         if (prob.contains(LL[i])) {
         //System.out.println("2 Yes" + i);
            i = 50; // kills the FOR system
            check = 1; // Sets it has a capitol
        }
        
        }
        
            
        

        
        
        
        return(check);
    }
    
    
}
