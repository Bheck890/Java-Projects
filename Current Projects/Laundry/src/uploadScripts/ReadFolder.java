package uploadScripts;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import gui.Upload;
import objects.FileObj;

import java.util.ArrayList;

public class ReadFolder implements ActionListener {

	public FileFinder task;
	
	ArrayList<FileObj> Filez = new ArrayList<FileObj>();
	
	public int Day,hour,min,month,year;
	public int FileNum;
	String m2,h2,d2,mo2,y2;
	public String Valid,Check,Path2;
	
	public void FindData(String Path)
	{	
		int length = Path.length()-29; // 25 for File name // 4 for extension (.txt)
		String PAth2 = Path.substring(0, length); //Parent Path
		Check = Path.substring(0,Path.length()-14);
		//System.out.println("Parent Location: " + Check);
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
		//System.out.println("Creating Array of FileOBJ");
		Path2 = Path; //Two path Names to compare
		
		String FileName2 = Path2.substring(Path.length()-29,Path2.length()-4); // Gets rid of the File Directory in the path and leaves the file name
		String FileNumbers2 = FileName2.substring(15, FileName2.length()); //Selects the numbers in the file Name //number format = dd/hh/mm/mo/yy
		
		month = Integer.parseInt(FileNumbers2.substring(6,8));
		year = Integer.parseInt(FileNumbers2.substring(8,FileNumbers2.length()));
		
		//System.out.println("Month:" + month);
		//System.out.println("Year:" + year);
		
		//CORE OF THE SYSTEM THAT SCANS FOR THE FILES
		// Running in different swing class, this way it updates the GUI as well
		
		task = new FileFinder();
		task.TFiles = FileNum;
		task.MoStart = month;
		task.yr = year;
		task.Path = Check;
		try {Thread.sleep(100);}
		catch (InterruptedException ignore) {}
		task.execute();
		
		try {Thread.sleep(100);}
		catch (InterruptedException ignore) {}
		
		task.removePropertyChangeListener(null);
		
	}
	
	
	
	
	@SuppressWarnings({ })
	public boolean ValidFile(String Path)  //If File Exists (yes or no)
	{
		File file = new File(Path);
		return file.exists();
	}
	
	void Time(int year) //In given Year Calculates Every Single Date Possibility From the Months to Minutes 
	{
		//Sleep for at least one second to simulate "startup".
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignore) {}
        
		for(int mo = 8; mo<=12;mo++)
		{   
			//Sleep for up to one second.
			try {
				Upload.ScannerStatus(0);
				Upload.ScannerPane.repaint();
                Thread.sleep(2000);
            } catch (InterruptedException ignore) {}
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
					}
				}
			}
			//Upload.ScannerStatus(3);
		}
	}
	
	public boolean DomesticClassCheck(String d3,String h3, String m3, String mo3,int Yr, String Parent) 
	{
		Valid = Parent+d3+h3+m3+mo3+Yr+".txt";
		if(ValidFile(Valid)) {
			//System.out.println("Found File: " + Valid);
			return true;
		}
		else {return false;} //System.out.println("Invalid File: " + Valid); 
	}
	
	public void AddToArray(String d3,String h3, String m3, String mo3,int Yr, String Parent) 
	{
		Valid = Parent+d3+h3+m3+mo3+Yr+".txt";
		Filez.add(new FileObj(Integer.parseInt(m3),Integer.parseInt(h3),Integer.parseInt(d3),Integer.parseInt(mo3),Yr,Valid));
	}
	
	public ArrayList<FileObj> getArray()
	{
		return Filez;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Upload.ScannerPane.repaint();
	}
	
	public void setArray(ArrayList<FileObj> File)
	{
		Filez = File;
		//System.out.println("[File] Array size: " + Filez.size());
	}
}