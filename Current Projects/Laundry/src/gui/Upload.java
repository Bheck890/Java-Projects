package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
	ArrayUtil AU = new ArrayUtil();
	//***PUBLIC VARIABLES***
	
	
	
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
	static JLabel MonthStat = new JLabel();
	static JLabel DayStat = new JLabel();
	static JLabel FileStat = new JLabel();
	public static JButton btnLocation = new JButton("Browse Location");
	public static JButton btnShowStats = new JButton("ViewData");
	public static JButton btnUpload = new JButton("Upload Data");
	
	static JLabel lblMonth = new JLabel("Month");
	static JLabel lblDays = new JLabel("Days");
	static JLabel lblFiles = new JLabel("Files Found");
	
	//Class Panel Creation
	public static JPanel UploadPane = new JPanel();
	public static JPanel InvalidPane = new JPanel();
	public static JPanel ScannerPane = new JPanel();
	public static int content3; //which panel to display
	
	
	public static void main(String[] args) {
		Laundry.content = 6;
		Laundry.main(null);
	}
	
	public void EC(JFrame jf)
	{
		
		if(content3 == 1)
		{
			System.out.println("[Upload Pannel] Uploading System Initiated");
			
			//Panel Attributes
			UploadPane.setBackground(Color.LIGHT_GRAY);
			UploadPane.setLayout(null);
			UploadPane.setVisible(true);
			
			btnShowStats.setEnabled(false);
	    	btnUpload.setEnabled(false);
			
	    	//Labels
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
			JButton btnLocation = new JButton("Browse Location");
			btnLocation.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					System.out.println("[Load Data] Browse location");
					btnLocation.setEnabled(false);
					fold.select();
				}
			});
			btnLocation.setBounds(15, 100, 150, 25);
			UploadPane.add(btnLocation);
			
			JButton btnShowStats = new JButton("ViewData");
			btnShowStats.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
						
				}
			});
			btnShowStats.setBounds(15, 135, 150, 25);
			UploadPane.add(btnShowStats);
			
			JButton btnUpload = new JButton("Upload Data");
			btnUpload.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
						ArrayUtil.Upload();
				}
			});
			btnUpload.setBounds(15, 170, 150, 25);
			UploadPane.add(btnUpload);
			
			JButton btnExit = new JButton("Exit");
			btnExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					UploadPane.removeAll();
					Laundry.close(2);
				}
			});
			btnExit.setBounds(247, 170, 90, 25);
			UploadPane.add(btnExit);
			
			//Dynamic Labels
			Location_Dir.setBounds(117, 10, 145, 29);
			Location_Dir.setText("C:");
			Location_Dir.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
			UploadPane.add(Location_Dir);
			
			NumOfFiles.setText("0");
			NumOfFiles.setBounds(166, 52, 103, 24);
			NumOfFiles.setFont(new Font("Tahoma", Font.PLAIN, 18));
			NumOfFiles.setForeground(Color.RED);
			UploadPane.add(NumOfFiles);
			
			Status.setText("Waiting");
			Status.setBounds(90, 210, 247, 16);
			Status.setForeground(Color.RED);
			UploadPane.add(Status);
			
			
			//FileStat.setText("0000 / 0000");
			//UploadPane.add(FileStat);
			
			
			lblMonth.setBounds(188, 100, 46, 14);
			lblDays.setBounds(188, 121, 46, 14);
			lblFiles.setBounds(175, 146, 65, 14);
			MonthStat.setBounds(247, 100, 46, 14);
			DayStat.setBounds(247, 121, 46, 14);
			FileStat.setBounds(247, 146, 94, 14);
			
			
			UpDate(2,"Choose File Location",false);
			
		}
		else if(content3 == 2) //Scanner
		{
			
			
			UploadPane.add(lblMonth);
			UploadPane.add(lblDays);
			UploadPane.add(lblFiles);
			
			
			DayStat.setText("00 / 31");
			
			UploadPane.add(DayStat);
			
			MonthStat.setText("00 / 12");
			
			UploadPane.add(MonthStat);
			
			FileStat.setText("0000 / 0000");
			
			UploadPane.add(FileStat);
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
					Laundry.close(7);
					
				}
			});
			btnClose.setBounds(113, 94, 97, 25);
			InvalidPane.add(btnClose);
			
		}
		
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
		lblMonth.setText("Month:");
		lblDays.setText("Days:");
		lblFiles.setText("Files:");
		
		UploadPane.add(lblMonth);
		UploadPane.add(lblDays);
		UploadPane.add(lblFiles);
		
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
			UploadPane.add(MonthStat);
		}
		else if(type == 1) { 
			C_Month = 0;
			MonthStat.setText(C_Month + " / 12");
			UploadPane.add(MonthStat);
		}
		if(type == 2) {
			C_Day++;
			DayStat.setText(C_Day + " / 31");
			UploadPane.add(DayStat);
		}
		else if(type == 3) { 
			C_Day = 1;
			DayStat.setText(C_Day + " / 31");
			UploadPane.add(DayStat);
		}
		else if(type == 4) {
			C_File++; 
			if(C_File > C_TFile) //Just In Case!
			{
				System.out.println("(File) File Count OverLoad");
			}
			//FileStatus.setValue(C_File);
			FileStat.setText(String.valueOf(C_File + " /  " + C_TFile));
			//ScannerPane.add(FileStatus);
			UploadPane.add(FileStat);
		}
		else if(type == 5)
		{
			//FileStatus.setIndeterminate(false);
		}
		
	}

	public static void ScannerFinished(int type)
	{
		lblMonth.setText("");
		lblDays.setText("");
		lblFiles.setText("");
		MonthStat.setText("");
		DayStat.setText("");
		FileStat.setText("");
		
		UploadPane.add(lblMonth);
		UploadPane.add(lblDays);
		UploadPane.add(lblFiles);
		UploadPane.add(MonthStat);
		UploadPane.add(DayStat);
		UploadPane.add(FileStat);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
