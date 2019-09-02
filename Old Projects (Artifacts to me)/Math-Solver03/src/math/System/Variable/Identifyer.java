/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package math.System.Variable;

/**
 * Purpose:
 * This Identify what problem 
 * the user entered
 * 
 * 
 * @author Brandon
 */
public class Identifyer {
    
    

    
    
    
        
        
        
        
        
        
        
        
    
    public int ID (String prob) {
        
        

        /*
        String add = "+";
        String add = "+";
        String add = "+";
        String add = "+";
        String add = "+";
        String add = "+";
        */
        
        

        String add = "+";
        String sub = "-";
        String multi = "*";
        String div = "/";
        String exponent = "^";
        String Peren = "(" + ")";
        String Fraction = "&";
        String add2 = "+" + "+";
        
        
        
        
        
        
        // Sign Identify
        int var1 = 0;
        
        if (prob.contains(add)) {
            var1 = 1;
        }
        else if(prob.contains(sub)) {
            var1 = 2;
        }
        else if(prob.contains(multi)) {
            var1 = 3;
        }
        else if(prob.contains(div)) {
            var1 = 4;
        }
        else if(prob.contains(exponent)) {
            var1 = 5;
        }
        else if(prob.contains(Peren)) {
            var1 = 6;
        }
        else if(prob.contains(Fraction)) {
            var1 = 6;
        }
        else if(prob.contains(add2)) {
            var1 = 7;
        }
        else {
            var1 = 0;
        }
        
        
        
        
        

        
        
        
        
        
        
        return(var1); 
    }
    
    
}
