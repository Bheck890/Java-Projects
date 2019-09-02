/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Console;


import java.util.Date;


/**
 *
 * @author Brandon
 */
public class Time {
    /*
    public String Date () throws ParseException {
        
        String format="MM/dd/yyyy";

        Scanner sc=new Scanner(System.in);
        Date d= new SimpleDateFormat("MM/dd/yyyy").parse("12/10/1994");
        Calendar cal=Calendar.getInstance();

        String output=new SimpleDateFormat(format).format(cal.getTime());
        
        return(output);
    }
    */
    public String time12 () {
        String time ;
        
        Date da = new Date();
        
        //System.out.println(da.toString());
        
        time = da.toString();
        
        return(time);
    } 
    
    
}
