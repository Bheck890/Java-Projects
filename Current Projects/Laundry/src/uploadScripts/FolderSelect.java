package uploadScripts;

/*
 * This takes care of when the user is browsing the directory finding the text file
 * 
 * COULD ADD a quick check to see if that file is the actual first file before going further
 * HIGHLY RECOMENDED
 * 
 * 
 */
import java.io.File;
import javax.swing.JFileChooser;

import gui.Laundry;
import gui.Menu;
import gui.Upload;
public class FolderSelect {
	
	
	public JFileChooser fc = new JFileChooser();
	String dir;
	
	
	public String f_path;
	public String f_name;
	public int dotInd;
	public String f_Folder;
	
	
	public void select()
	{
		Upload.UpDate(2,"Loading",false);
		
		int returnVal = fc.showOpenDialog(Menu.MenuPane);
		
		// if user selects a file this is true else console spits invalid
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            
        	File file = fc.getSelectedFile();
            
            char dot = '.';
            String ext;
            
            f_Folder = file.getParent();
            f_name = file.getName(); // file Name
            
            dotInd = f_name.indexOf(dot);
            ext = f_name.substring(dotInd);
            
            //System.out.println("Opening: " + file.getName());
            //System.out.println("Opening: " + file.getPath());
            //System.out.println(ext);
            
            
            if(ext.equals(".txt"))
            {
                f_path = file.getPath();
            	System.out.println("Valid File Selected");
            	ArrayUtil.setDir(f_path); //Gives File Path to the Array Utility for the data to be put into an array
            	
            	Upload.btnLocation.setEnabled(false);
            	//Updates UI
            	Upload.UpDate(0,f_path,true);
            	
            	//Ask for what month to start at?
            	
            	
            	//Processed Passed into ArrayUtil
            	ArrayUtil.verify();
            	
            	fc.remove(fc);
            }
            else
            {
            	Upload.btnLocation.setEnabled(true);
            	Upload.UpDate(2,"Invalid File Selected, Make Sure it is a .txt file",false);
            	System.out.println("Invalid File Selected");
            	Laundry.ErrorNum = 0;
            	Laundry.content = 7;
        		Laundry.content(); //Display Error Frame for Error 0
            }
            
        } else {
        	System.out.println("Open command cancelled by user.");
        }
	}
	
	
	
	public boolean validDir(String file)
	{
		int ind = file.indexOf('.');
		
		if(file.substring(ind, file.length()) == ".txt")
		{System.out.println("Valid");return true;}
		else
			return false;
		
	}
}
