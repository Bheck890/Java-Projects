package Test;


import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Font;


public class UploadGUI{

	/**
	 * Upload Menu!
	 * Finalized Menu
	 * 
	 *  First select Location
	 *  then program arrays the files
	 *  then creates machine objects
	 *  
	 *  Second the user has ability to see what Data is being uploaded
	 *  (With Data Download UI)
	 *  
	 *  Third is the Data is updated to the Database
	 * 
	 * Launch the application.
	 */
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		UploadGUI frame = new UploadGUI();
		//frame.jp.setVisible(false);
		
	}
	
	/**
	 * Create the frame.
	 */
	JFrame jf = new JFrame();
	JPanel jp = new JPanel();
	boolean valid = false;
	
	public UploadGUI() 
	{
		jf.setTitle("Upload");
		jf.setSize(388,288);
		jf.setContentPane(jp);
		jf.setVisible(true);
		jf.setResizable(false);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jp.setBackground(Color.LIGHT_GRAY);
		jp.setLayout(null);
		
		//Create Public Dynamic Labels
		JLabel MonthStat = new JLabel();
		JLabel DayStat = new JLabel();
		JLabel FileStat = new JLabel();
		JLabel Location_Dir = new JLabel();
		JLabel Status = new JLabel();
		JLabel NumOfFiles = new JLabel();
		
		//Labels
		JLabel lblLocationDir = new JLabel("Folder Location:");
		lblLocationDir.setBounds(15, 13, 103, 29);
		jp.add(lblLocationDir);
		
		JLabel lblNumOfFiles = new JLabel("Number of files in Folder");
		lblNumOfFiles.setBounds(13, 53, 145, 29);
		jp.add(lblNumOfFiles);
		
		JLabel lblStatus = new JLabel("Data Status:");
		lblStatus.setBounds(15, 206, 82, 29);
		jp.add(lblStatus);
		
		JLabel lblMonth = new JLabel("Month");
		lblMonth.setBounds(188, 100, 46, 14);
		jp.add(lblMonth);
		
		JLabel lblDays = new JLabel("Days");
		lblDays.setBounds(188, 121, 46, 14);
		jp.add(lblDays);
		
		JLabel lblFiles = new JLabel("Files Found");
		lblFiles.setBounds(175, 146, 65, 14);
		jp.add(lblFiles);
		
		//Buttons
		JButton btnLocation = new JButton("Browse Location");
		btnLocation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("[Load Data] Browse location");
				btnLocation.setEnabled(false);
				//fold.select();
			}
		});
		btnLocation.setBounds(15, 100, 150, 25);
		jp.add(btnLocation);
		
		JButton btnShowStats = new JButton("ViewData");
		btnShowStats.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
					
			}
		});
		btnShowStats.setBounds(15, 135, 150, 25);
		jp.add(btnShowStats);
		
		JButton btnUpload = new JButton("Upload Data");
		btnUpload.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
					
			}
		});
		btnUpload.setBounds(15, 170, 150, 25);
		jp.add(btnUpload);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//UploadPane.removeAll();
				//Laundry.close(2);
			}
		});
		btnExit.setBounds(247, 170, 90, 25);
		jp.add(btnExit);
		
		
		//Dynamic Variables
		Location_Dir.setBounds(117, 10, 145, 29);
		Location_Dir.setText("C:");
		Location_Dir.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		jp.add(Location_Dir);
		
		NumOfFiles.setText("0");
		NumOfFiles.setBounds(166, 52, 103, 24);
		NumOfFiles.setFont(new Font("Tahoma", Font.PLAIN, 18));
		NumOfFiles.setForeground(Color.RED);
		jp.add(NumOfFiles);
		
		Status.setText("Waiting");
		Status.setBounds(90, 210, 247, 16);
		Status.setForeground(Color.RED);
		jp.add(Status);
		
		DayStat.setText("00 / 31");
		DayStat.setBounds(247, 121, 46, 14);
		jp.add(DayStat);
		
		
		FileStat.setText("0000 / 0000");
		FileStat.setBounds(247, 146, 94, 14);
		jp.add(FileStat);
		
		MonthStat.setText("00 / 12");
		MonthStat.setBounds(247, 100, 46, 14);
		jp.add(MonthStat);
		
		//UpDate(2,"Choose File Location",false);
	}
	
}
