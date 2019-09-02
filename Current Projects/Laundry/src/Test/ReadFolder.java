package Test;

/*
 * Folder has been identified as a folder with text documents 
 * 
 * This simply Looks inside the Specified folder with TextDocuments 
 * And adds each file into an array with attributes like (day/hour/minute/month/year)
 */
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import gui.Laundry;
import gui.Menu;
import gui.Upload;
import objects.FileObj;

import java.util.ArrayList;

public class ReadFolder {

	Laundry Fra = new Laundry();
	Menu CG = new Menu();
	//FolderSelect Fold = new FolderSelect();
	
	ArrayList<FileObj> Filez = new ArrayList<FileObj>();
	
	int Day,hour,min,month,year;
	int FileNum;
	String m2,h2,d2,mo2,y2;
	String Valid,Check,Path2;
	
	public void FindData(String Path)
	{	
		int length = Path.length()-29; // 25 for File name // 4 for extension (.txt)
		String PAth2 = Path.substring(0, length); //Parent Path
		Check = Path.substring(0,Path.length()-14);
		
		FileNum = NumOfFiles(PAth2); //Gives how many files are inside the directory
		
		//Updates the Total Files that exist Before Displaying Scanner
		Upload.C_TFile = FileNum;
		Upload.UpDate(1, Integer.toString(FileNum), true);
		
	}
	
	public int NumOfFiles(String PathFile)  //Finds total number of files (ALL FILES)
	{
		int index = 0;
		long count = 0;
		try (Stream<Path> files = Files.list(Paths.get(PathFile))) {
		    count = files.count();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error Counting Files");
		}
		index = (int)count;
		return index; 
	}
	
	void Array(String Path) //CORE // Searches Entire Year for files
	{
		System.out.println("Creating Array of FileOBJ");
		Path2 = Path; //Two path Names to compare
		
		String FileName2 = Path2.substring(Path.length()-29,Path2.length()-4); // Gets rid of the File Directory in the path and leaves the file name
		String FileNumbers2 = FileName2.substring(15, FileName2.length()); //Selects the numbers in the file Name //number format = dd/hh/mm/mo/yy
		
		year = Integer.parseInt(FileNumbers2.substring(8,FileNumbers2.length()));
		
	    Time(year); //CORE
	    
	    System.out.println("Total Files: " + FileNum + "\nFiles Archived: " + Filez.size());
	    
	    
	    if(Filez.size() != FileNum)
	    {
	    	//Upload.ScannerPane.removeAll();
			//Laundry.close(5); //Closes the Scanner Pane
			
	    	//Upload.UploadPane.removeAll();
			//Laundry.close(2); //Closes the Upload Menu
	    	//System.out.println("Miscalculation in Folder Directory,(Select New Directory and try again), (make sure all files have the same Year!)");
	    	
        	Laundry.ErrorNum = 1;
        	Laundry.content = 7;
    		Laundry.content(); //Display Error Frame for Error 1
	    }
	    else {
	    	//Closes the Scanner Pane if The scanner worked correctly
	    	Upload.ScannerPane.removeAll();
			Laundry.close(5);
	    }
	  	//If new year do a separate Upload
	}

	@SuppressWarnings({ })
	public boolean ValidFile(String Path)  //If File Exists (yes or no)
	{
		File file = new File(Path);
		return file.exists();
	}
	
	void Time(int year) //In given Year Calculates Every Single Date Possibility From the Months to Minutes 
	{
		for(int mo = 1; mo<=12;mo++)
		{   
			Upload.ScannerStatus(0);
			System.out.println("Month " + mo);
			for(int d = 1; d<=31;d++)
			{
				//Upload.ScannerStatus(2);
				for(int h = 0; h<24;h++)
				{
					for(int m = 0;m<60;m++)
					{
						//Debug ALL Time Variables under 10
						String mo3 = "00";
						String d3 = "00";
						String h3 = "00"; //if below 10 it adds a 0 in front instead of 8 it becomes 08
						String m3 = "00"; //same as above
						String Path3 = "";
						
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
						
						//Recreate Valid String to check if that time Exists? // Add Rearrange with Data selection Later
						Valid = Check+d3+h3+m3+mo3+year+".txt";
						if(ValidFile(Valid)) {
							//System.out.println("Found File: " + Valid);
							Path3 = Check+d3+h3+m3+mo3+year+".txt";
							Filez.add(new FileObj(Integer.parseInt(m3),Integer.parseInt(h3),Integer.parseInt(d3),Integer.parseInt(mo3),year,Path3));
						}
						else {} //System.out.println("Invalid File: " + Valid); 
						Upload.ScannerPane.repaint();
					}
					Upload.ScannerPane.repaint();
				}
				Upload.ScannerPane.repaint();
			}
			//Upload.ScannerStatus(3);
			Upload.ScannerPane.repaint();
		}
	}
	
	public ArrayList<FileObj> getArray()
	{
		return Filez;
	}
}