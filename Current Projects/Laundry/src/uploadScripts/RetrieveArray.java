package uploadScripts;

import java.io.BufferedReader;
//import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import objects.FileObj;
import objects.MachineOBJ;


public class RetrieveArray {
	
	//INPUT SYSTEM 
	
	// Pass Array Here and pull out Data into a 2D array easy but task worthy
	
	// Files are in array path
    
	//Data is currently in a FileOBJ Array before this which has the attributes for when the data was recorded
	//Here is where those recordings are opened and Processed into the the Database to be analyzed
	
    //[94] = time by 15 minute interval
	//[40] = max amount of machines in a room 
    
	
	
	/* TODO
	 * 
	 * When it prints the Machine Status make it create a new MAchineOBJ
	 * When Finished Pass it to ArrayUtil 
	 * From There Create new Class that takes MachineOBJ and Uploads the Data to the Database
	 * 
	 * This is is a Big task that is simple .... Here we go!!
	 * 
	 * if board **
	 * 
	 * can work on Data Analyzer which reads the Machine OBJ Array 
	 * and Displays the Dates which the Objects are recorded on 
	 * This system should also check if the dates in the Array (to be uploaded) are all ready uploaded
	 * so the Database does not get Duplicated Data 
	 * 
	 * 
	 * 
	 * When Finished with the Upload Start the Creation of the Configuration File and put the last date in the upload into the file
	 * 
	 * then have a small code open the file on Startup and if there is no file on start up warn the user and warn the User
	 * that data may be duplicated in the database,... **Idea** If there is no file have it then ask the database for the last file recorded.
	 * and Create a new File and put that data inside! 
	 * 
	 * 
	 * If no access to the database then Disable Upload and Download Buttons and Warn the user that 
	 * They are in offline mode and can only see the Current Data that is already analyzed if they want to upload and download
	 * they need Internet access and restart the program. If there is no Data file or Configuration File then Show the menu with all but the 
	 * Settings option selected and HAve a Configuration file created so when Internet or data is back if they made any changes to the settings
	 * they are saved.
	 * 
	 * 
	 * When the user is in a menu, if the cursor is over a button it will show (Description and help tips) below the button
	 * For the **browse button** add that the system will only take the files by the year selected. 
	 * also that is is recommended to select the lowest month in that year since the scanner will check 
	 * all months starting from the month of the file selected!
	 * 
	 * 
	 */
	
    private ArrayList<FileObj> Data = new ArrayList<FileObj>();
    private ArrayList<MachineOBJ> MachineData = new ArrayList<MachineOBJ>();
    
    String token = " "; //Overall line from the file
    
    String type; // Washer or Drier
	String ID; // ID number
	String ID2 = " ";
	String Available; // On or OFF
	String Available2;
    
	public int Washers, Driers;
	
	int error = 0;
	
	public void retrieve_from_txts()
	{
		System.out.println("[Data Extract] Gathering data from Text files");
		int files = Data.size();
		
		for(int i = 0; i < files; i++)
		{
			
			String Path = Data.get(i).getPath();
			
			//System.out.println("Reading file " + i);
			try {
				MachineStatus(Path, i);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				error++;
			}
			
		}
		//System.out.println("Errors: " + error);
	}
	

	
    @SuppressWarnings("resource")
	public void MachineStatus(String Path, int arrayNum) throws IOException
	{
		// need object array to put all the data in while reading each file.
    	// Key word to look for = ("type":"washFL")("appliance_desc":"14")("time_left_lite":"Available")
    	// find certain key words in the text file these 3 appear the same amount of times Drier is stacked on top of each other)
    	BufferedReader in = new BufferedReader(new FileReader(Path));
    	while(in.ready()){
    		token = in.readLine();
    	}
		
    	String pass = token;
    	
    	for(int i = 0; i < 16; i++) // Checks for washers 33 total machines
    	{
    		pass = Washers(pass, arrayNum);
    		
    	}
    	String pass2 = pass;
    	
    	
    	for(int i = 0; i < 9; i++) // Checks for Driers 33 total machines
    	{
    		pass2 = Driers(pass2, arrayNum);
    	}
    	//System.out.println(pass);
    	
    	// Now when Given details put the details into the Data Base!
    	
    	
	}
    
    public String Washers(String Line, int arrayNum) //Washer Decoder of XML File
    {
    	String Break;
    	
    	Break = Line;
    	
    	// find keywords here from the token line
    	String A = "{\"type";
    	String B = "appliance_desc";
    	String C = "time_left_lite";
    	String check;
    	
    	
    	//Sees what machine it is?
    	int ID_A = Break.indexOf(A);
    	
    	Break = Break.substring(ID_A);
    	//int ID_AA = Break.indexOf("washFL");
    	check = Break.substring(9, 15);
    	//System.out.println(ID_AA + " " + check);
    	
    	if(check.equalsIgnoreCase("washFL"))
    	{
    		type = "Washer";
    	}
    	else
    	{
    		type = "Drier";
    	}
    	
    	// Checks for the ID
    	int ID_B = Break.indexOf(B);
    	
    	Break = Break.substring(ID_B);
    	//int ID_BB = Break.indexOf("14");
    	check = Break.substring(47, 49);
    	//System.out.println(ID_BB + " " + check);
    	
    	ID = check;
    	
    	int ID_C = Break.indexOf(C);
    	try {
    		
    		Break = Break.substring(ID_C);
        	//int ID_CC = Break.indexOf("Available");
        	check = Break.substring(17, 26);
        	//System.out.println(ID_CC + " " + check);
        	
        	if(check.equals("Available"))
        	{
        		Available = "Off"; //Available to use
        	}
        	else if (check.equalsIgnoreCase("Ext. Cycl"))
        	{
        		Available = "Unavailable"; //Means either done the cycle or machine is broke
        	}
        	else
        	{
        		Available = "On"; //In Use
        	}
    	}
    	catch (Exception ex){
    		Available = "404";
    	}
    	
    	/*
    	System.out.println(Data.get(arrayNum).getMonth() + "/" + Data.get(arrayNum).getDay() + "/" +
    			Data.get(arrayNum).getYear() + " | " + Data.get(arrayNum).getHour() + ":" +
    			Data.get(arrayNum).getMin() + " | " +
    			"Machine: " + ID + " is a " + type + " that is " + Available);
    	*/
    	
    	//Washers
    	MachineData.add(new MachineOBJ(Data.get(arrayNum).getMin(),Data.get(arrayNum).getHour(),
    			Data.get(arrayNum).getDay(),Data.get(arrayNum).getMonth(),
    			Data.get(arrayNum).getYear(),ID,type,Available) );
    	
    	this.Washers++;
    	MachineOBJ.TotalMachines++;
    	Break = Break.substring(26);
    	return Break;
    }
    
    public String Driers(String Line, int arrayNum) //Drier Decoder of XML File
    {
    	String Break;
    	
    	Break = Line;
    	
    	// find keywords here from the token line
    	String A = "{\"type";
    	String B = "appliance_desc";
    	String C = "time_left_lite";
    	String D = "time_left_lite2";
    	String E = "appliance_desc2";
    	String check;
    	
    	
    	//Sees what machine it is?
    	int ID_A = Break.indexOf(A);
    	
    	Break = Break.substring(ID_A);
    	//int ID_AA = Break.indexOf("washFL");
    	check = Break.substring(9, 15);
    	//System.out.println(ID_AA + " " + check);
    	
    	if(check.equalsIgnoreCase("washFL"))
    	{
    		type = "Washer";
    	}
    	else
    	{
    		type = "Drier";
    	}
    	
    	// Checks for the ID
    	int ID_B = Break.indexOf(B);
    	
    	Break = Break.substring(ID_B);
    	//int ID_BB = Break.indexOf("14");
    	check = Break.substring(47, 49);
    	//System.out.println(ID_BB + " " + check);
    	
    	ID = check;
    	
    	int ID_C = Break.indexOf(C);
    	
    	try {
    		Break = Break.substring(ID_C);
        	//int ID_CC = Break.indexOf("Available");
        	check = Break.substring(17, 26);
        	//System.out.println(ID_CC + " " + check);
        	
        	if(check.equals("Available"))
        	{
        		Available = "Off"; //Available to use
        	}
        	else if (check.equalsIgnoreCase("Ext. Cycl"))
        	{
        		Available = "Unavailable"; //Means either done the cycle or machine is broke
        	}
        	else
        	{
        		Available = "On"; //In Use
        	}
    	}
    	catch (Exception ex){
    		Available = "404";
    	}
    	
    	
    	int ID_D = Break.indexOf(D);
    	
    	try {
    		Break = Break.substring(ID_D);
        	//int ID_DD = Break.indexOf("Available");
        	check = Break.substring(18, 27);
        	//System.out.println(ID_DD + " " + check);
        	
        	if(check.equals("Available"))
        	{
        		Available2 = "Off"; //Available to use
        	}
        	else if (check.equalsIgnoreCase("Ext. Cycl"))
        	{
        		Available2 = "Unavailable"; //Means either done the cycle or machine is broke
        	}
        	else
        	{
        		Available2 = "On"; //In Use
        	}
    	}
    	catch (Exception ex){
    		Available = "404";
    	}
    	
    	
    	int ID_E = Break.indexOf(E);
    	
    	Break = Break.substring(ID_E);
    	//int ID_EE = Break.indexOf("22");
    	check = Break.substring(18, 20);
    	//System.out.println(ID_EE + " " + check);
    	
    	ID2 = check;
    	
    	//Showing Data this is where the code Stops 
    	//From here Set up so that it inputs this into the Machine OBJ then
    	//Upload the Machine OBJ array into the Database. 
    	
    	/*
    	System.out.println(Data.get(arrayNum).getMonth() + "/" + Data.get(arrayNum).getDay() + "/" +
    			Data.get(arrayNum).getYear() + " | " + Data.get(arrayNum).getHour() + ":" +
    			Data.get(arrayNum).getMin() + " | " +
    			"Machine: " + ID + " is a " + type + " that is " + Available);
    	
    	System.out.println(Data.get(arrayNum).getMonth() + "/" + Data.get(arrayNum).getDay() + "/" +
    			Data.get(arrayNum).getYear() + " | " + Data.get(arrayNum).getHour() + ":" +
    			Data.get(arrayNum).getMin() + " | " +
    			"Machine: " + ID2 + " is a " + type + " that is " + Available2);
    	*/
    	
    	//Driers
    	MachineData.add(new MachineOBJ(Data.get(arrayNum).getMin(),Data.get(arrayNum).getHour(),
    			Data.get(arrayNum).getDay(),Data.get(arrayNum).getMonth(),
    			Data.get(arrayNum).getYear(),ID,type,Available) );
    	
    	MachineData.add(new MachineOBJ(Data.get(arrayNum).getMin(),Data.get(arrayNum).getHour(),
    			Data.get(arrayNum).getDay(),Data.get(arrayNum).getMonth(),
    			Data.get(arrayNum).getYear(),ID2,type,Available2) );
    	
    	
    	this.Driers += 2;
    	MachineOBJ.TotalMachines +=2;
    	Break = Break.substring(20);
    	return Break;
    }
    
    
	/**
	 * @return the Data Array
	 */
	public ArrayList<FileObj> getData() {
		return Data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(ArrayList<FileObj> data) {
		Data = data;
	}
	
	
	/**
	 * @param data the data to set
	 */
	public void delData() {
		Data.clear();;
	}
	
	public ArrayList<MachineOBJ> getMachineData() {
		return MachineData;
	}
	

	

}
