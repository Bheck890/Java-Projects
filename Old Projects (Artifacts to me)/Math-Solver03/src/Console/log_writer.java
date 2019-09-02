/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Console;
import java.io.*;
import java.util.Date;
/**
 *
 * @author bheck
 */
public class log_writer {
    
    public void Text (String text){
        
        // name of file
        String time ;
        
        Date da = new Date();
        time = da.toString();
        
        time = time.substring(4, 11) + time.substring(24, time.length());
                //+ ", " + time.substring(11, 16);
        
        // location
        String file = "Logs/Test/" + time + ".txt";
        
       // writes
       log_writer.this.write(file, text);
       
       
       
        
    }
    
    
    public void write(String file, String text){
        
        try{
            FileWriter fw = new FileWriter(file,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(fw);
            
            int line = 1;
            
            
            //bw.write(text+"\n");
            //bw.newLine();
            
           // bw.close();
            
           
            //pw.println("test");
           // pw.println(text+"\n");
            pw.println(text);
            pw.close();
            
            
            
            //System.out.println("line Written");
        }
        catch(IOException e){
            System.out.println("Error Writing to: " + file);
            
        }
        
        
        
        
        
        
    }
    
    
    
    
    
    
    
}
