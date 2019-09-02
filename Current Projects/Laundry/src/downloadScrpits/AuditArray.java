package downloadScrpits;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class AuditArray {
	
	// This Writes to a file!
	
	
	
	
	
	//String gameFolderPath = System.getenv().get("APPDATA") + "\\CooArcade" + "\\Leaderboard";
	String gameFolderPath = new File("").getAbsolutePath();
	String gameSubFolderPath = gameFolderPath + "\\DATA";
	
	//Need to write to place outside of this and the Jar
	String file = gameSubFolderPath +"/DATABASE.txt"; // Changing!!!
    //String fileEP = gameSubFolderPath +"/EasyPlayers.txt";
    
	public void write(String Data) {
		
		createFolders();
		
		
		
		System.out.println("Audit Scores and Players for Easy Rank for next Game");
			
		//Scores
			try {
				txtData(file,Data);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	public void txtData(String file,String Scores) throws FileNotFoundException
	{
		//PrintWriter PW = new PrintWriter(new File(getClass().getResource(file).getFile()));
		PrintWriter PW = new PrintWriter(file);
		
		///for(int i = 0; i < Scores.length ; i++)
		{
			//System.out.println(Scores[i]);
			//PW.println(Scores[i]);
		}
		
		PW.close();
	}
	
	public void txtName(String file,String[] Names) throws FileNotFoundException
	{
		PrintWriter PW = new PrintWriter(file);
		
		for(int i = 0; i < Names.length ; i++)
		{
			//System.out.println(Names[i]);
			PW.println(Names[i]);
		}
		
		PW.close();
	}
	
	
	public void createFolders()
	{
		File gameFolder = new File(gameSubFolderPath);
		//File gameFolder2 = new File(gameSubFilePath);
		System.out.println("Folder Begin");
		
		if (!gameFolder.exists()) {
		    // Folder doesn't exist. Create it
		    if (gameFolder.mkdir()) {
		        // Folder created
		    	System.out.println("Folder created");
		    }
		    else {
		        // Error
		    	System.out.println("AUD: Error Creating folder");
		    	
		    }
		}
		else {
		    // Folder exists
			System.out.println("Folder Exists");
		}
	}
	
}
