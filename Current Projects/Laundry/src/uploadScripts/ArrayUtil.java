package uploadScripts;

import java.util.ArrayList;

import gui.Laundry;
import gui.Upload;
import objects.FileObj;
import objects.MachineOBJ;;

public class ArrayUtil {
 // AUTOMATION Script System
	
	/*
	 * this is first called
	 * this commands the loading system to choose where to get the
	 * files and what processes go in what order
	 * 
	 * Folder
	 * Verify
	 * Analyze
	 * 
	 * Log location of previous settings
	 * use settings in next boot 
	 * ask user for input while booting if there is an error or missing data
	 * 
	 */
	
	static ArrayList<FileObj> AFil3s = new ArrayList<FileObj>();
	static ArrayList<MachineOBJ> MachineData = new ArrayList<MachineOBJ>();
	
	DB_Upload DB = new DB_Upload();
	Laundry fr = new Laundry();
	static ReadFolder RF = new ReadFolder();
	static RetrieveArray RA = new RetrieveArray();
	public static String F_Dir;
	
	
	//ContentChange.p_up();   // Every progress to showing analysis
	/*
	public static void main(String[] args) {
		
		// Display loading screen
		// Show loading Frame
		Laundry.content = 1;
		Laundry.content(); //Display Loading Screen
	}
	*/
	public static void GatherData()
	{
		//Close Scanner
		//Upload.ScannerPane.removeAll();
		//Laundry.close(5);
		
		//Open each file and Array the Data
		System.out.println("[Array Utility] Extracting Data from Found Files");
		Upload.UpDate(2,"Extracting Data from Found Files",false);
		
		analyze();
		
		//System.out.println("[Array Utility] Driers: " + RA.Driers + " | Washers: " + RA.Washers + " |"); //
		Upload.UpDate(2,"Data is Ready: Select View or Uplod Data.",true);
		Upload.btnShowStats.setEnabled(true);
    	Upload.btnUpload.setEnabled(true);
    	
    	Upload.ScannerFinished(AFil3s.size());
	}
	
	public static void verify() //Verify and Array Files inside folder Path 
	{
		System.out.println("[Array Utility] Verifying text Files in Folder");
		Upload.UpDate(2,"Verifying text Files in Folder",false);
		RF.FindData(F_Dir);
		
		//Display Scanner
		//Laundry.LoadNum = 0;
		//Laundry.content = 5;
		//Laundry.content();
		
		
		try {
            Thread.sleep(1000);
        } catch (InterruptedException ignore) {}
		
		RF.Array(F_Dir); //CORE // Searches Entire Year (from file selected) for files in that folder //Does a lot of Processing
		//Calls Gather Data after Data is found and Verified 
	}
	
	public static void analyze() //Opens Files and reads the data inside and put them into Arrays
	{
		RA.setData(AFil3s);
		RA.retrieve_from_txts();
		
	}
	public static void Upload() //Passes the Array from RA to the class that Uploads all of the attributes into the Database 
	{
		MachineData = RA.getMachineData();
		DB_Upload.Upload(MachineData);
	}
	
	
	public static void setDir(String di)
	{
		F_Dir = di;
	}

	public static void setArray(ArrayList<FileObj> File)
	{
		AFil3s = File;
		//System.out.println("[AFil3s] Array size: " + AFil3s.size());
	}
	
	public static void DelArray()
	{
		AFil3s.clear();;
		//System.out.println("[AFil3s] Array size: " + AFil3s.size());
	}
	
}
