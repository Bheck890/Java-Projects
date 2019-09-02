/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package math.System.Variable;

import Console.Output_Text;



/**
 * Purpose:
 * this is how the problem is solved with
 * the variables that are broken down  
 * 
 * 
 * @author Brandon
 */
public class Problem_Solveing {
    
    
    
    
    public String[] Solve (String v1, String v2, int id) {
        
        //String answ = "0";  
        
        Output_Text OT = new Output_Text();
        
        
        String[] Signs = new String[7]; 
        Signs[0] = "+"; // add
        Signs[1] = "-"; // subtract
        Signs[2] = "*"; // Multipy
        Signs[3] = "/"; // Divide
        Signs[4] = "^"; // exponent
        Signs[5] = "&"; // fraction
        
        
        /*
        int i;
        for (i = 0; i < 10; i++) {
            
        if (v1.contains("+")) {
            id = 50;
            i = 50;
        }
        else if (v2.contains("+")) {
            id = 50;
            i = 49;
        }   
        else if (v1.contains("-")) {
            id = 50;
            i = 50;
        }    
        else if (v2.contains("-")) {
            id = 50;
            i = 49;
        }     
            
            
            
            
        }
        */
        
        
        if(v2.startsWith("d")){
            v2 = "-" + v2.substring(1, v2.length());
            OT.Printsolce("d = a negative number2");
        }
            
        if(v1.startsWith("d")){
            OT.Printsolce("d = a negative number1");
            v1 = "-" + v1.substring(1, v1.length());
        }
        
        
        
        
        
        
        
        
        
        String[] Answ = new String[5];
        Answ[0] = "0";
        Answ[4] = "0";
        
        if (id == 1) {
            
            
            double solve = Double.valueOf(v1) + Double.valueOf(v2);
            
            Answ[0] = Double.toString(solve);

            // ****OLD CODE****
            /*
            
            double v5 = Double.valueOf(v1);
            double v6 = Double.valueOf(v2);
           
            
            int v3 = Integer.valueOf(v2);
            int v4 = Integer.valueOf(v1);
            
            
            OT.Printsolce("INT: " + v4 + " " + v3);
            OT.Printsolce("DOUBLE: " + v5 + " " + v6);
            
            
            int solve = v4 * v3;
            
            String S = Integer.toString(solve);
            
            Answ[0] = S;
            */

        }
        else if (id == 2){
            
            double solve = Double.valueOf(v1) - Double.valueOf(v2);
            
            Answ[0] = Double.toString(solve);
            
        }
        else if (id == 3){
            
            double solve = Double.valueOf(v1) * Double.valueOf(v2);
            
            Answ[0] = Double.toString(solve);
            
        }
        else if (id == 4){
            
            double solve = Double.valueOf(v1) / Double.valueOf(v2);
            
            Answ[0] = Double.toString(solve);
            
        }
        else {
            Answ[4] = "1";
            //answ = "Answer=Null";  
        }
        
        //System.out.println(id + " space2 " + i);
        
        return(Answ);
    }
     
    public String[] negativeag (String sol1, String sol2) {
        
        // This is not in use
        // Function: check value of 2 numbers and if ones a negative 
        // thast sapose to be "d" it changes it
        
        Output_Text OT = new Output_Text();
        
        String[] chk1 = new String[10];
        chk1[0] = "10"; // these two numbers subtracted equal 0 
        chk1[1] = "10";
        
        
        if (sol1.startsWith("-")){
            OT.Printsolce("There is a negative in 1 ERROR Answer = 0");
            sol1 = "d" + sol1.substring(1, sol1.length());
            chk1[0] = sol1;
            chk1[1] = sol2;
        }
        else if (sol2.startsWith("-")){
            OT.Printsolce("There is a negative in 2 ERROR Answer = 0");
            OT.Printsolce(sol2);
            sol2 = "d" + sol2.substring(1, sol2.length());
            OT.Printsolce(sol2);
            chk1[0] = sol1; 
            chk1[1] = sol2;
        }
        else {
            OT.Printsolce("The variables are negative free");
            chk1[0] = sol1; 
            chk1[1] = sol2;
            
        }
        
        
        chk1[0] = sol1; 
        chk1[1] = sol2;
        
        return(chk1);
    }
    
    
    
    public String negativeag2 (String prob) {
        
        Output_Text OT = new Output_Text();
        
        
        if (prob.startsWith("-")){
            prob = "d" + prob.substring(1, prob.length());
            OT.Printsolce("d has changed");
        }

        return(prob);
    }
     
     
     
}
