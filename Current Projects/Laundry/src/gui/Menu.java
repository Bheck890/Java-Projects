package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Menu extends JPanel{
	public Menu() {
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Requaired Panel Variables
	public static int content2; //Content Indicator
	public static JPanel MenuPane = new JPanel();
	
	//Dynamic Text //Recent Data Log
	public static JLabel LatestStatistic = new JLabel();
	public static String RecentDate = "00/00/00 00:00";
    
	/*
	public static void main(String[] args) {
		Laundry.main(null);
		
		//Testing:
		//Frame.content = 6;
		//Frame.content();
	}
	*/
	
	public void CP(JFrame jf)
	{
		MenuPane.setLayout(null);
		MenuPane.setVisible(true);
		
		if(content2 == 1) //Menu
		{
			//Panel Attributes
			MenuPane.setBackground(Color.BLUE);
			MenuPane.setLayout(null);
			
			// Static Texts
			JLabel lblTitle = new JLabel("Laundry Analyzer");
			lblTitle.setForeground(Color.GREEN);
			lblTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
			lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitle.setBounds(53, 13, 334, 47);
			MenuPane.add(lblTitle);
			
			JLabel lblLatestStat = new JLabel("Latest Data Date:");
			lblLatestStat.setForeground(Color.GRAY);
			lblLatestStat.setBounds(118, 71, 100, 14);
			MenuPane.add(lblLatestStat);
			
			JLabel lblCreatedBy = new JLabel("Created By: Brandon Heck");
			lblCreatedBy.setForeground(Color.WHITE);
			lblCreatedBy.setBounds(10, 246, 150, 14);
			MenuPane.add(lblCreatedBy);
			
			//Buttons
			JButton btnUpload = new JButton("Upload");
			btnUpload.setBounds(175, 100, 100, 25);
			btnUpload.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Laundry.content = 2;
					Laundry.content();
				}
			});
			MenuPane.add(btnUpload);
			
			JButton btnDownload = new JButton("Pull From DataBase");
			btnDownload.setBounds(162, 135, 125, 25);
			btnDownload.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
				}
			});
			MenuPane.add(btnDownload);
			
			JButton btnStatistics = new JButton("Show Laundry Statistics");
			btnStatistics.setBounds(150, 170, 150, 25);
			btnStatistics.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Laundry.content = 4;
					Laundry.content();
				}
			});
			MenuPane.add(btnStatistics);
			
			//Dynamic text
			LatestStatistic.setText(RecentDate);
			LatestStatistic.setForeground(Color.GRAY);
			LatestStatistic.setBounds(228, 71, 83, 14);
			MenuPane.add(LatestStatistic);
			
		}
		if(content2 == 2)
		{
			//Settings
			/* Server URL and Login Info
			 * Different GUI Colors
			 * ETC
			 */
			
			
		}
		if(content2 == 3)
		{
			//Testing Panels
		}
	}
	
	public static void LatestData(String Date)
	{ 
		LatestStatistic.setText(Date);
		MenuPane.add(LatestStatistic);
	}
}
