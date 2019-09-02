package Test;


import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Font;


public class UploadDebug{

	/**
	 * Upload Menu!
	 * This is a Step by Step process to make sure all methods perform Correctly 
	 * 
	 * Launch the application.
	 */
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		UploadDebug frame = new UploadDebug();
		//frame.jp.setVisible(false);
		
	}
	
	/**
	 * Create the frame.
	 */
	JFrame jf = new JFrame();
	JPanel jp = new JPanel();
	boolean valid = false;
	
	public UploadDebug() 
	{
		jf.setTitle("Upload");
		jf.setSize(450,300);
		jf.setContentPane(jp);
		jf.setVisible(true);
		jf.setResizable(false);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Panel Attributes
		jp.setBackground(Color.LIGHT_GRAY);
		jp.setLayout(null);
		
		
		//Create Public Dynamic Labels
		JLabel Location_Dir = new JLabel();
		JLabel NumOfFiles = new JLabel();
		JLabel Status = new JLabel();
		JLabel MonthStat = new JLabel();
		JLabel DayStat = new JLabel();
		JLabel FileStat = new JLabel();
		
		
		//Static Labels
		JLabel lblLocationDir = new JLabel("Folder Location:");
		lblLocationDir.setBounds(13, 13, 105, 29);
		jp.add(lblLocationDir);
		
		JLabel lblNumOfFiles = new JLabel("Number of files in Folder");
		lblNumOfFiles.setBounds(13, 53, 140, 29);
		jp.add(lblNumOfFiles);
		
		JLabel lblStatus = new JLabel("Data Status:");
		lblStatus.setBounds(27, 233, 76, 29);
		jp.add(lblStatus);
		
		JLabel lblMonth = new JLabel("Month");
		lblMonth.setBounds(174, 160, 46, 14);
		jp.add(lblMonth);
		
		JLabel lblDays = new JLabel("Days");
		lblDays.setBounds(174, 185, 46, 14);
		jp.add(lblDays);
		
		JLabel lblFiles = new JLabel("Files Found");
		lblFiles.setBounds(174, 210, 73, 14);
		jp.add(lblFiles);
		
		//Buttons
		JButton btnLocation = new JButton("Browse Location");
		btnLocation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("[Load Data] Browse location");
				
				//fold.select();
			}
		});
		btnLocation.setBounds(13, 93, 140, 25);
		jp.add(btnLocation);
		
		JButton btnLoadFiles = new JButton("Scan the Folder");
		btnLoadFiles.setBounds(174, 93, 140, 25);
		btnLoadFiles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*
				if(ArrayUtil.F_Dir != null)
				{
					System.out.println("[Load Data] Verifying Folder Data");
					ArrayUtil.verify();
				}
				else
					System.out.println("[Load Data] Invalid Directory");	
				*/
			}
		});
		jp.add(btnLoadFiles);
		
		JButton btnLoadMachines = new JButton("Analyze Data");
		btnLoadMachines.setBounds(174, 129, 140, 25);
		btnLoadMachines.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//ArrayUtil.analyze();
				
			}
		});
		jp.add(btnLoadMachines);
		
		JButton btnUpload = new JButton("Upload Data");
		btnUpload.setBounds(13, 165, 140, 25);
		btnUpload.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		JButton btnShowStats = new JButton("ViewData");
		btnShowStats.setBounds(13, 129, 140, 25);
		btnShowStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		jp.add(btnShowStats);
		jp.add(btnUpload);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//UploadPane.removeAll();
				//Laundry.close(2);
				
			}
		});
		btnExit.setBounds(344, 205, 90, 25);
		jp.add(btnExit);
		
		//Dynamic Labels
		Location_Dir.setText("C:");
		Location_Dir.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		Location_Dir.setBounds(128, 13, 270, 29);
		jp.add(Location_Dir);
		
		NumOfFiles.setText("0");
		NumOfFiles.setFont(new Font("Tahoma", Font.PLAIN, 18));
		NumOfFiles.setForeground(Color.RED);
		NumOfFiles.setBounds(164, 52, 89, 24);
		jp.add(NumOfFiles);
		
		Status.setText("Waiting");
		Status.setForeground(Color.RED);
		Status.setBounds(113, 239, 285, 16);
		jp.add(Status);
		
		DayStat.setText("00 / 31");
		DayStat.setBounds(271, 185, 46, 14);
		jp.add(DayStat);
		
		FileStat.setText("0000 / 0000");
		FileStat.setBounds(271, 210, 94, 14);
		jp.add(FileStat);
		
		MonthStat.setText("00 / 12");
		MonthStat.setBounds(271, 160, 46, 14);
		jp.add(MonthStat);
		
		
		
	}
}
