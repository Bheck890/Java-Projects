package Test;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

import uploadScripts.ArrayUtil;
import uploadScripts.FolderSelect;
import uploadScripts.ReadFolder;
import uploadScripts.RetrieveArray;

public class Upload extends JPanel implements ActionListener{
	public Upload() {
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	//Other Classes
	FolderSelect fold = new FolderSelect();
	ReadFolder RF = new ReadFolder();
	RetrieveArray RA = new RetrieveArray();
	//***PUBLIC VARIABLES***
	
	//Scanner Variables
	//Progress Bar
	public static JProgressBar FileStatus;
	//Dynamic Labels
	public static JLabel MonthStat = new JLabel();
	public static JLabel DayStat = new JLabel();
	public static JLabel FileStat = new JLabel();
	
	//Labels that get updated from other classes 
	public static int C_TFile;
	public static int C_Month = 0;
	
	//***CLASS VARIABLES***
	//Progress Bar Variables (That are For this Class)
	static int F_value = 0; //Percentage with ProgressBar
	
	
	static int C_Day = 0;
	static int C_File = 0;
	
	//Upload Menu Variables
	static JLabel Location_Dir = new JLabel();
	static JLabel NumOfFiles = new JLabel();
	static JLabel Status = new JLabel();    
	public static JButton btnLocation = new JButton("Browse Location");
	public static JButton btnShowStats = new JButton("ViewData");
	public static JButton btnUpload = new JButton("Upload Data");
	
	
	//Class Panel Creation
	public static JPanel UploadPane = new JPanel();
	public static JPanel InvalidPane = new JPanel();
	public static JPanel ScannerPane = new JPanel();
	public static int content3; //which panel to display
	
	
	public static void main(String[] args) {
		//Laundry.content = 6;
		//Laundry.main(null);
	}

	Timer timer; //Scanner
	
	public void EC(JFrame jf)
	{
		timer = new Timer(700, this::timerTwoMethod); //Scanner
		
		if(content3 == 1)
		{
			System.out.println("[Upload Pannel] Uploading System Initiated");
			
			//Panel Attributes
			UploadPane.setBackground(Color.LIGHT_GRAY);
			UploadPane.setLayout(null);
			UploadPane.setVisible(true);
			
			btnShowStats.setEnabled(false);
	    	btnUpload.setEnabled(false);
			
			//Static Labels
			JLabel lblLocationDir = new JLabel("Folder Location:");
			lblLocationDir.setBounds(15, 13, 103, 29);
			UploadPane.add(lblLocationDir);
			
			JLabel lblNumOfFiles = new JLabel("Number of files in Folder");
			lblNumOfFiles.setBounds(13, 53, 145, 29);
			UploadPane.add(lblNumOfFiles);
			
			JLabel lblStatus = new JLabel("Data Status:");
			lblStatus.setBounds(15, 206, 82, 29);
			UploadPane.add(lblStatus);
			
			//Buttons
			btnLocation.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					System.out.println("[Load Data] Browse location");
					btnLocation.setEnabled(false);
					fold.select();
				}
			});
			btnLocation.setBounds(75, 100, 150, 25);
			UploadPane.add(btnLocation);
			
			btnShowStats.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
				}
			});
			btnShowStats.setBounds(75, 135, 150, 25);
			UploadPane.add(btnShowStats);
			
			btnUpload.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					
				}
			});
			btnUpload.setBounds(75, 170, 150, 25);
			UploadPane.add(btnUpload);
			
			JButton btnExit = new JButton("Exit");
			btnExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					UploadPane.removeAll();
					ScannerPane.removeAll();
					ArrayUtil.DelArray();
					//RF.task.cancel(true);
					RA.delData();
					fold.fc.removeAll();
					//Laundry.close(5);
					//Laundry.close(2);
				}
			});
			btnExit.setBounds(100, 235, 90, 25);
			UploadPane.add(btnExit);
			
			//Dynamic Labels
			Location_Dir.setText("C:");
			Location_Dir.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
			Location_Dir.setBounds(117, 10, 145, 29);
			UploadPane.add(Location_Dir);
			
			NumOfFiles.setText("0");
			NumOfFiles.setFont(new Font("Tahoma", Font.PLAIN, 18));
			NumOfFiles.setForeground(Color.RED);
			NumOfFiles.setBounds(166, 52, 103, 24);
			UploadPane.add(NumOfFiles);
			
			Status.setText("Waiting");
			Status.setForeground(Color.RED);
			Status.setBounds(90, 210, 184, 16);
			UploadPane.add(Status);
			
			UpDate(2,"Choose File Location",false);
		}
		else if(content3 == 2) //Scanner
		{
			//Start
			//ScannerPane.removeAll();
			System.out.println("[Upload Pannel] Showing Scanner");
			
			//Panel Attributes
			ScannerPane.setBackground(SystemColor.activeCaptionBorder);
			ScannerPane.setLayout(null);
			ScannerPane.setVisible(true);
			ScannerPane.setOpaque(true);
			
			
			
			
			//Variables
			JLabel lblMonth = new JLabel("Months");
			lblMonth.setBounds(41, 32, 46, 14);
			ScannerPane.add(lblMonth);
			
			JLabel lblDay = new JLabel("Days");
			lblDay.setBounds(41, 57, 46, 14);
			ScannerPane.add(lblDay);
			
			JLabel lblFiles = new JLabel("Files Found");
			lblFiles.setBounds(41, 82, 73, 14);
			ScannerPane.add(lblFiles);
			
			MonthStat.setText("00 / 12");
			MonthStat.setBounds(138, 32, 46, 14);
			ScannerPane.add(MonthStat);
			
			DayStat.setText("00 / 31");
			DayStat.setBounds(138, 57, 46, 14);
			ScannerPane.add(DayStat);
			
			FileStat.setText(C_File + " / " + C_TFile);
			FileStat.setBounds(138, 82, 94, 14);
			ScannerPane.add(FileStat);
			
			//Progress bar Initiate
			FileStatus = new JProgressBar(C_File, C_TFile);
			FileStatus.setValue(F_value);
			FileStatus.setIndeterminate(true); //Bar Loading State
			FileStatus.setStringPainted(true); //Shows Percentage
			FileStatus.setBounds(41, 107, 368, 30);
			ScannerPane.add(FileStatus);
			
		}
		else if(content3 == 3) //Error Invalid File Selected
		{
			//Panel Attributes
			InvalidPane.setBackground(Color.BLACK);
			InvalidPane.setLayout(null);
			
			//Error Message
			JLabel lblTemplate = new JLabel
					("Invalid File Selected\nPlease Try Again");
			lblTemplate.setForeground(Color.RED);
			lblTemplate.setFont(new Font("Comic Sans MS", Font.ITALIC, 25));
			lblTemplate.setBounds(12, 13, 308, 55);
			InvalidPane.add(lblTemplate);
			
			//Close Button
			JButton btnClose = new JButton("Close");
			btnClose.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					System.out.println("Close Invalid Box");
					
					InvalidPane.removeAll();
					//Laundry.close(7);
					
				}
			});
			btnClose.setBounds(113, 94, 97, 25);
			InvalidPane.add(btnClose);
			
		}
		
	}
	
	private void timerTwoMethod(ActionEvent e) // Alien Ship Move
	 {
		
	 }
	
	//Changes the dynamic text on the Upload Menu
	public static void UpDate(int i, String m, boolean c) // I for index, m for message, c for color (red or green)
	{
		if(i == 0) //Update Valid Data Location
		{
			Location_Dir.setText(m);
			if(c)
			{Location_Dir.setForeground(Color.GREEN);}
			else
				Location_Dir.setForeground(Color.RED);
			UploadPane.add(Location_Dir);
		}
		else if(i == 1) //Update how many Files
		{
			NumOfFiles.setText(m);
			if(c)
			{NumOfFiles.setForeground(Color.GREEN);}
			else
				NumOfFiles.setForeground(Color.RED);
			UploadPane.add(NumOfFiles);
		}
		else if(i == 2) //Update if Analysis Compared Correctly  
		{
			Status.setText(m);//Valid or invalid results
			if(c)
			{Status.setForeground(Color.GREEN);}
			else
				Status.setForeground(Color.RED);
			UploadPane.add(Status);
		}
	}
	
	//Changes the Variables of the Scanner when it Scans for Files That Exist
	public static void ScannerStatus(int type)
	{
		/*
		 * if type = 0 it Increases the month status bar
		 * if type = 1 it resets the month status bar
		 * if type = 2 it Increases the day Status Bar
		 * if type = 3 it resets the day status bar
		 * if type = 4 it Increases the file status bar
		 * 
		 * FYI: (Integer type) is a Parameter and it is Called/Passed with Arguments
		 */
		if(type == 0) {
			C_Month++;
			MonthStat.setText(C_Month + " / 12");
			ScannerPane.add(MonthStat);
		}
		else if(type == 1) { 
			C_Month = 0;
			MonthStat.setText(C_Month + " / 12");
			ScannerPane.add(MonthStat);
		}
		if(type == 2) {
			C_Day++;
			DayStat.setText(C_Day + " / 31");
			ScannerPane.add(DayStat);
		}
		else if(type == 3) { 
			C_Day = 1;
			DayStat.setText(C_Day + " / 31");
			ScannerPane.add(DayStat);
		}
		else if(type == 4) {
			C_File++; 
			if(C_File > C_TFile) //Just In Case!
			{
				System.out.println("(File) Progressbar OverLoad");
			}
			FileStatus.setValue(C_File);
			FileStat.setText(String.valueOf(C_File + " /  " + C_TFile));
			ScannerPane.add(FileStatus);
			ScannerPane.add(FileStat);
		}
		else if(type == 5)
		{
			FileStatus.setIndeterminate(false);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
