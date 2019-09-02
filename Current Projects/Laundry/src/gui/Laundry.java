package gui;


//import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;

/*
 * Frames Directory
 * 
 * Loading system
 * Enter Data GUI (based on need)
 * 
 * Main Screen Of Data (After you get the data analyzed)
 *  w/ tabs and Graphics
 * 
 * This is the Core of the GUI interfaces
 * Where they are called to be deployed
 * 
 * 
 */
public class Laundry {

	public static JFrame jf1; // Menu
	public static JFrame jf2; // Upload
	public static JFrame jf3; // Download
	public static JFrame jf4; // Statistics
	public static JFrame jf5; // Loading screen
	public static JFrame jf6; // Settings
	public static JFrame jf7; // Errors
	
	public static int content;
	public static int ErrorNum;
	public static int LoadNum;
	public static String FrameName = "Laundry Analyzer";
	
	
	public static void main(String[] args) 
	{
		//When done with Database and have local Statistic file 
		//Run it here before it Loads up to get the last Data Date on Record
		content = 1;
		content();
		
		//LoadNum = 0;
		//content = 5;
		//content();
		
	}
	
	
	
	public static void content()
	{
		jf1 = new JFrame(); //Menu
		jf2 = new JFrame(); //Upload
		jf3 = new JFrame(); //Download
		jf4 = new JFrame(); //Statistics
		jf5 = new JFrame(); //Loading screen (Calculation Progress.. Etc)
		jf6 = new JFrame(); //Settings
		jf7 = new JFrame(); //Errors
		// 7 = Testing (Uses Error Frame)
		
		// Different panels to create
		Menu MP = new Menu();
		Upload UP = new Upload();
		
		//Shut Down on Exit
		jf1.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentHidden(ComponentEvent e) {
            	System.exit(0);
                ((JFrame)(e.getComponent())).dispose();
            }
        });
		jf2.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentHidden(ComponentEvent e) {
            	System.exit(0);
                ((JFrame)(e.getComponent())).dispose();
            }
        });
		jf3.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentHidden(ComponentEvent e) {
            	System.exit(0);
                ((JFrame)(e.getComponent())).dispose();
            }
        });
		jf4.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentHidden(ComponentEvent e) {
            	System.exit(0);
                ((JFrame)(e.getComponent())).dispose();
            }
        });
		jf5.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentHidden(ComponentEvent e) {
            	System.exit(0);
                ((JFrame)(e.getComponent())).dispose();
            }
        });
		jf6.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentHidden(ComponentEvent e) {
            	System.exit(0);
                ((JFrame)(e.getComponent())).dispose();
            }
        });
		jf7.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentHidden(ComponentEvent e) {
            	System.exit(0);
                ((JFrame)(e.getComponent())).dispose();
            }
        });
		
		
		if(content == 1)//Main Menu
		{
			System.out.println("[Frame] Menu Screen");
			//Set these Window Attributes then add the parts to the Container Class
			jf1.setTitle(FrameName);
			jf1.setSize(450,300);
			jf1.setVisible(true);
			jf1.setResizable(false);
			jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			Menu.content2 = 1;
			MP.CP(jf1);
			jf1.setContentPane(Menu.MenuPane);
			
		}
		if(content == 2)//Upload Menu
		{
			System.out.println("[Frame] Upload Menu");
			
			jf2.setTitle("Upload");
			jf2.setSize(388,288);
			//jf2.setSize(450,300);
			jf2.setVisible(true);
			jf2.setResizable(false);
			jf2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			Upload.content3 = 1;
			UP.EC(jf2);
			jf2.setContentPane(Upload.UploadPane);
		}
		if(content == 3)//Download Menu
		{ 
			System.out.println("[Frame] Download Menu");
			jf3.setTitle("Download");
			jf3.setSize(350,201);
			jf3.setVisible(true);
			jf3.setResizable(false);
			jf3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			//Upload.content3 = 4;
			//UP.EC(jf3);
			//jf3.setContentPane(Upload.InvalidPane);
		}
		if(content == 4)//Statistics Screen
		{
			System.out.println("[Frame] Statistics Menu");
			jf4.setTitle(FrameName);
			jf4.setSize(1420,1020);
			jf4.setVisible(true);
			jf4.setResizable(false);
			jf4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			Upload.content3 = 4;
			UP.EC(jf4);
			jf4.setContentPane(Upload.InvalidPane);
		}
		if(content == 5)//Loading
		{
			jf5.setVisible(true);
			jf5.setResizable(false);
			jf5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			if(LoadNum == 0) { //Displays Scanner
				System.out.println("[Frame] Loading: Scanner");
				jf5.setTitle("Scanner");
				jf5.setSize(450,220);
				
				
				Upload.content3 = 2;
				UP.EC(jf5);
				jf5.setContentPane(Upload.ScannerPane);
			}
		}
		if(content == 6)//Settings
		{
			System.out.println("[Frame] Settings)");
			jf6.setTitle("Loading");
			jf6.setSize(450,300);
			jf6.setVisible(true);
			jf6.setResizable(false);
			jf6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			Menu.content2 = 2;
			MP.CP(jf6);
			jf6.setContentPane(Menu.MenuPane);
			
		}
		if(content == 7)//Errors 
		{
			System.out.println("[Frame] Error Num " + ErrorNum);
			jf7.setSize(350,201);
			jf7.setVisible(true);
			jf7.setResizable(false);
			jf7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			if(ErrorNum == 0)
			{
				jf7.setTitle("Error " + ErrorNum);
				Upload.content3 = 3;
				UP.EC(jf7);
				jf7.setContentPane(Upload.InvalidPane);
			}
			
			
		}
		if(content == 8)//Testing
		{
			jf7.setTitle("Testing");
			jf7.setSize(450,300);
			jf7.setVisible(true);
			jf7.setResizable(false);
			jf7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			//Menu.content2 = 3;
			//Upload.content3 = 5;
			
			//MP.CP(jf7); //Menu
			//UP.EC(jf7); //Upload
			
			//jf7.setContentPane(Menu.contentPane);
			//jf7.setContentPane(Upload.ScannerPane);
		}
		if(content == 9)//ADD-ON?
		{
			System.out.println("[Frame] ...");
			jf7.setSize(350,200);
			jf7.setVisible(true);
			jf7.setResizable(false);
			jf7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			Menu.content2 = 2;
			MP.CP(jf7);
			jf7.setContentPane(Menu.MenuPane);
			
			
		}
	}
	


	public static void close(int frame) 
	{
		//Magic! This closes the Windows without shutting down the program
		//Activated by a button on the Content Work on if Press X button it also does this!
		if(frame == 1) 
		{
			System.out.println("[Frame] Closing Main Menu");
			jf1.dispose();
		}
		else if(frame == 2)
		{
			System.out.println("[Frame] Closing Upload Menu");
			jf2.dispose();
		}
		else if(frame == 3)
		{
			System.out.println("[Frame] Closing Download Menu");
			jf3.dispose();
		}
		else if(frame == 4)
		{
			System.out.println("[Frame] Closing Statistics Screen");
			jf4.dispose();
		}
		else if(frame == 5)
		{
			System.out.println("[Frame] Closing Loading Screen");
			jf5.dispose();
		}
		else if(frame == 6)
		{
			System.out.println("[Frame] Closing Error Screen");
			jf6.dispose();
		}
		else if(frame == 7)
		{
			System.out.println("[Frame] Closing Test Pannel");
			jf7.dispose();
		}
	}
}



