

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package math.System.Variable;

import Console.Output_Text;



/**
 * Purpose:
 * 
 * where the problem is sent to be 
 * Divided and broken down of the Problem 
 * 
 * 
 * 
 * @author Brandon
 */
public class Interger_Split {

    Problem_Solveing PS = new Problem_Solveing();
    Output_Text OT = new Output_Text();
    
    public String[] add (String problem) {
        OT.Printsplit("apart1" + " Prob: " + problem);
        // linking dynamic String with Arg
        String pro;
        pro = problem ;
        
        // Looking for the math Sign
        char plus = '+';
        
        
        // Finds place of Sign
        int v1 = pro.indexOf(plus);
        // FInds how long the problem is 
        int v5 = pro.length();
        
        // FInds the 2 integers
        String[] ver = new String[10];
        ver[0] = pro.substring(0, v1);
        ver[1] = pro.substring(v1+1, v5);
        
        // Prints the Status
        
        /*
        System.out.println("Variable Assign");
        System.out.println("----------------------------------");
        System.out.println("");
        System.out.println("position of the plus sign :" + v1);
        System.out.println("First variable :" + v2);
        System.out.println("Second variable :" + v3);
        System.out.println("Length :" + v5);
        System.out.println("");
        System.out.println("----------------------------------");
        System.out.println("");
        */

        
        OT.Printsplit("apart2" + " 1: " + ver[0] + " 2: " + ver[1]);
        
        return (ver);
    }
    
    String[] Subtract (String problem) {
        OT.Printsplit("apart1" + " Prob: " + problem);
        String pro;
        pro = problem ;
        
        // Looking for the math Sign
        char sub = '-';

        // Finds place of Sign
        int v1 = pro.indexOf(sub);
        // FInds how long the problem is 
        int v5 = pro.length();
        
        // FInds the 2 integers
        String[] ver = new String[5];
        ver[0] = pro.substring(0, v1);
        ver[1] = pro.substring(v1+1, v5);
        
        OT.Printsplit("apart2" + " 1: " + ver[0] + " 2: " + ver[1]);
        
        return (ver);
    }
    
    
    
    
    String[] Multi (String problem) {
        OT.Printsplit("apart1" + " Prob: " + problem);
        
        String pro;
        pro = problem ;
        
        // Looking for the math Sign
        char mul = '*';

        // Finds place of Sign
        int v1 = pro.indexOf(mul);
        // FInds how long the problem is 
        int v5 = pro.length();
        
        // FInds the 2 integers
        String[] ver = new String[5];
        ver[0] = pro.substring(0, v1);
        ver[1] = pro.substring(v1+1, v5);
        
        OT.Printsplit("apart1" + " Prob: " + problem);
        return (ver);
    }
        
    String[] Divide (String problem) {
        OT.Printsplit("apart1" + " Prob: " + problem);
        String pro;
        pro = problem ;
        
        // Looking for the math Sign
        char div = '/';

        // Finds place of Sign
        int v1 = pro.indexOf(div);
        // FInds how long the problem is 
        int v5 = pro.length();
        
        // FInds the 2 integers
        String[] ver = new String[5];
        ver[0] = pro.substring(0, v1);
        ver[1] = pro.substring(v1+1, v5);
        OT.Printsplit("apart1" + " Prob: " + problem);
        return (ver);
    }
}
