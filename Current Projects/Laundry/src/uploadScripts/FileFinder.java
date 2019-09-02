package uploadScripts;

import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.SwingWorker;

import gui.Laundry;
import gui.Upload;
import objects.FileObj;

public class FileFinder extends SwingWorker<Void, Void> {
    /*
     * Main task. Executed in background thread.
     */
	static ReadFolder RF = new ReadFolder();
	static Upload UP = new Upload();
	String Path;
	int yr;
	int TFiles = 0;
	int FilesFound = 0;
	ArrayList<FileObj> Filez2 = new ArrayList<FileObj>();
	int mo;
	int MoStart = 0;
	boolean setMonth = false;
	boolean foundAFile = false;
	
    @Override
    public Void doInBackground() {
    	
    	int short_sleep = 50;
    	int sleep = 200;
    	
    	Upload.content3 = 2;
    	UP.EC(Laundry.jf2);
    	
        while (TFiles != FilesFound) { //until (Total Files in folder matches Valid Files) (While the pool is not filed, fill the pool)
        	//Sleep for at least one second to simulate "startup".
        	
    		for(mo = 1; mo<=12;mo++)
    		{   
    			//Set the month to the month of the file selected
    			if(!setMonth) {
    				Upload.C_Month = MoStart - 1;
    				mo = MoStart;
    				System.out.println("[Scanner] Changing month to " + mo);
    				setMonth = true;
    			}
    			//Sleep for up to one second.
    			try {
                    Thread.sleep(short_sleep);
                } catch (InterruptedException ignore) {}
    			Upload.ScannerStatus(0);
    			System.out.println("[Scanner] Checking Month: " + mo + " | Files Found: " + FilesFound);
    			
    			for(int d = 1; d<=31;d++)
    			{
    				try {
                        Thread.sleep(sleep);
                    } catch (InterruptedException ignore) {}
    				Upload.ScannerStatus(2);
    				for(int h = 0; h<24;h++)
    				{
    					for(int m = 0;m<60;m++)
    					{
    						//Debug ALL Time Variables under 10
    						String mo3 = "00";
    						String d3 = "00";
    						String h3 = "00"; //if below 10 it adds a 0 in front instead of 8 it becomes 08
    						String m3 = "00"; //same as above
    						
    						if(mo<10)
    							mo3 = "0"+mo; 
    						else
    							mo3 = String.valueOf(mo);
    						if(d<10)
    							d3 = "0"+d; 
    						else
    							d3 = String.valueOf(d);
    						if(h<10)
    							h3 = "0"+h; 
    						else
    							h3 = String.valueOf(h);
    						if(m<10)
    							m3 = "0"+m; 
    						else
    							m3 = String.valueOf(m);
    						
    						
    						if(RF.DomesticClassCheck(d3, h3, m3, mo3,yr,Path)) {
    							
    							String Valid2 = Path+d3+h3+m3+mo3+yr+".txt";
    							Filez2.add(new FileObj(Integer.parseInt(m3),Integer.parseInt(h3),Integer.parseInt(d3),Integer.parseInt(mo3),yr,Valid2));
    							
    							RF.AddToArray(d3, h3, m3, mo3,yr,Path);
    							FilesFound++;
    							Upload.ScannerStatus(4);
    							try {Thread.sleep(10);}
    							catch (InterruptedException ignore) {}
    							
    							if(!foundAFile) {
    								foundAFile = true;
    								Upload.ScannerStatus(5);
    			    			}
    						}
    						else {
    							//System.out.println("Not Found");
    						}
    					}
    				}
    				//End of Loop for 12 Hours
    				if(TFiles == FilesFound) {mo = 13;d=32;} //After every hour it will check if it should stop
    			}
    			//End of Loop for 31 Days
    			try {
                    Thread.sleep(sleep);
                } catch (InterruptedException ignore) {}
    			Upload.ScannerStatus(3); //Resets Day
    			//the Month Keeps the Days Repeating
    		}
    		//End of loop for 12 Months
    		try {
                Thread.sleep(sleep);
            } catch (InterruptedException ignore) {}
			Upload.ScannerStatus(1); //Resets Month
			mo = 1;
        }
        //System.out.println("[Scanner] Valid Files: " + Filez2.size());
        //ArrayUtil.setArray(Filez2);
        
        return null;
    }

    /*
     * Executed in event dispatching thread
     */
    @Override
    public void done() {
    	Toolkit.getDefaultToolkit().beep();
    	System.out.println("[Scanner] Valid Files: " + Filez2.size());
        ArrayUtil.setArray(Filez2);
        //RF.setArray(Filez2);
        
        
		
        //****** DEBUG *******
        ArrayUtil.GatherData();
        
        //System.out.println("Total Files: " + TFiles + " | Files Found " + FilesFound);
    }
}