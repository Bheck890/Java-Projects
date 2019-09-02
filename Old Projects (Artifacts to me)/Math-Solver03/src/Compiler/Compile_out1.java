/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Compiler;

import Console.Output_Text;
import math.System.Variable.Variable_Carrier;



/**
 *
 * @author bheck
 */
public class Compile_out1 {
    public String[] compile2 (String Prob){
        
        Variable_Carrier VC = new Variable_Carrier();
        Output_Text OT = new Output_Text();
        
        String main_num = "1110" ; // 1110 is E for Error  in binary
        String last_num = "110010"; 
        
        int total_s = 25;
        String[] Re = new String[25]; // The Output Array
        
        String[] Prob_Cat = new String[total_s]; // This catches the provlems needed to solve the problem
        String[] Var_Car = new String[total_s]; // Collects the answer and add it to the next prob
        String[] numbers = new String[total_s]; // Digit Numbers
        String[] signspos = new String[total_s]; // Position of the Signs
        String[] signs = new String[total_s]; // the diffrent signs to be indexed
        String[] out_pro = new String[total_s]; // the Problems together
        
        signs[0] = "+";
        signs[1] = "-";
        signs[2] = "*";
        signs[3] = "/";
        
        int Error = 0;
        
        int sign = 0; // amount of signs 
        int ar = 0; // Array number
        int len; // lenght of problem 
        int sio = 1110; // int value of pos of first sign
        int sio2 = 1100; // int value of pos of first sign
        
        String Let = "";
        int num = 0;
        
        
        len = Prob.length();
        
        OT.Printcomp("Problem: " + Prob); //Problem INFO
        OT.Printcomp("Length: " + len);
        
        
        
        
        for(int a = 0; a < len; a++){               // FINDS number of Signs and where they are
           
            Let = Prob.substring(a, a+1);
            //System.out.println("a:" + a);
            //System.out.println("letter:" + Let);
            
           for(int b = 0; b < 4; b++){
              if (Let.equals(signs[b])){ // this is the action everytime is sees a sign
                  sign = sign + 1;
                  //System.out.println("Sign");
                  
                  //System.out.println(sign);
                  
                  
                if(sign >= 26){
                    Error = 2;
                }  
                else {
                    signspos[ar] = Integer.toString(a);
                    ar = ar + 1;
                }
                  
                  
              }
              else { //this is run for every number
                  
              }
               
               
               
               
               
           }
            
        }
        
       
        
        
        
        
        //System.out.println(sign);
        
        
        
        if(sign >= 26){
            Error = 2; // (Remove space before Problem Error)
        }
        
        
        
        
        
        
        
        
        
        //System.out.println("First Pos: " + signspos[0] + " " + sio);
        if (Error == 2){
            
        }
        else{
            for(int d = 0; d < ar; d++){                    // finding the main number 
                
                
               sio = Integer.valueOf(signspos[0]); 
               main_num = Prob.substring(0, sio);
               
        
        
               int k = 0;
               int sp = 11000; //Sign position
               int sp2 = 11010; // Variable end position
        
               for(int e = 0; e < ar ; e++){             // Set the Numbers into a array
                //System.out.println("E: " + e);
                k = k + 1;
            
                sp = Integer.valueOf(signspos[e]);
            
            
          
                 //System.out.println("K: " + k);
            
                if (k >= ar){
                    //System.out.println("K -1: " + k + ar);
                    k = k-1;
                }
            
                sp2 = Integer.valueOf(signspos[k]);  
                                                          
                                                          
                    //System.out.println("ar: " + ar);
                    //System.out.println("numb: " + sp + " " + sign+ " " + ar+ " " + sp2);
                
                
                
                if (sp == sp2){ // How it adds last Number
                    //System.out.println("Kuco");
                    numbers[e] = Prob.substring(sp, len);
                }
                else {
                    numbers[e] = Prob.substring(sp, sp2);
                }
            
           
            
                 }
        
        
                 
                 
                 
                 
                 sio2 = Integer.valueOf(signspos[(sign-1)]);
        
                for (int l = 0; l< ar; l++){                // Finds last num
                        last_num = Prob.substring(sio2, len);
                 }
        
               
                 }
        }
        
        
        
        
        for (int m = 0; m < sign ; m++){
            int n = 0;
              
            n = numbers[m].length();
            
            
            
            if(n <= 1 ){
                String o = Integer.toString(n);
                OT.Printcomp(o);
                Error = 3;
                
            }
            
            
        }
        
        if (sign == 0 ){
            main_num = Prob.substring(0, len);
        }
        
        
        
        
        OT.Printcomp("Problem DATA");
        OT.Printcomp("ERROR: " + Error);
        OT.Printcomp("# of signs: " + (sign));
        // for(int c = 0; c < ar;c++){
        //   System.out.println("signs Pos " + signspos[c]);
        // }
        OT.Printcomp("First digit: " + main_num);
        
        if (Error == 2) {
            
        }
        else if (Error == 3){
            
        }
        else {
            int g = 2;
            for(int f = 0; f < ar - 1; f++){ 
            
            
                OT.Printcomp("Digit " + g + " : " + numbers[f]);
                //System.out.println("Digit " + g + " : " );
                 g = g + 1;
            }
            
            //for(int i = 0; i<sign; i++){
        
            
            
            
            
            
            for (int h = 0; h< ar; h++){
            
            main_num = main_num + numbers[h];
            
            Prob_Cat[h] = main_num;
            Var_Car = VC.VarCenter(main_num);
            //System.out.println("1:" + Var_Car[0]);
            out_pro[h] = Var_Car[0]; 
            main_num = Var_Car[0];
            
            
             }
        
             //}
        
        
        
             OT.Printcomp("Last Digit: " + last_num);
             OT.Printcomp("FINAL OUTPUT");
             //System.out.println("2:" + Var_Car[0]);
        
            for(int j = 0; j< ar; j++){
                 OT.Printcomp(Prob_Cat[j] + " = " + out_pro[j]);
             }
            
            
            
            
        }
        
       
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        if(Error == 2){
            Re[4] = "1";
            Re[0] = "Over 25 Signs Detected";
        }
        else if (Error == 3){
            Re[4] = "2";
            Re[0] = "Please fix the Missing Number";
        }
        else{
            Re[0] = main_num;
            Re[4] = "0";
        }
        
        
        
        return(Re);
    }
}
