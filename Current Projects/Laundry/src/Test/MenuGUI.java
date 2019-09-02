package Test;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JButton;


public class MenuGUI{

	/**
	 * Main Menu
	 * 
	 */

	/**
	 * Launch the application.
	 */
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		MenuGUI frame = new MenuGUI();
		//frame.setVisible(false);
	}
	
	/**
	 * Create the frame.
	 */
	
	JFrame jf = new JFrame();
	JPanel jp = new JPanel();
	
	public MenuGUI() 
	{
		jf.setTitle("Laundry Analyzer");
		jf.setSize(450,300);
		
		jf.setContentPane(jp);
		jf.setVisible(true);
		jf.setResizable(false);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Panel Attributes
		jp.setBackground(Color.BLUE);
		jp.setLayout(null);
		
		//Create Public Dynamic Labels
		JLabel LatestStatistic = new JLabel();
		
		// Static Texts
		JLabel lblTitle = new JLabel("Laundry Analyzer");
		lblTitle.setForeground(Color.GREEN);
		lblTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(53, 13, 334, 47);
		jp.add(lblTitle);
		
		JLabel lblLatestStat = new JLabel("Latest Data Date:");
		lblLatestStat.setForeground(Color.GRAY);
		lblLatestStat.setBounds(118, 71, 100, 14);
		jp.add(lblLatestStat);
		
		JLabel lblCreatedBy = new JLabel("Created By: Brandon Heck");
		lblCreatedBy.setForeground(Color.WHITE);
		lblCreatedBy.setBounds(10, 246, 150, 14);
		jp.add(lblCreatedBy);
		
		
		//Buttons
		JButton btnUpload = new JButton("Upload");
		btnUpload.setBounds(175, 100, 100, 25);
		btnUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		jp.add(btnUpload);
		
		JButton btnDownload = new JButton("Pull From DataBase");
		btnDownload.setBounds(162, 135, 125, 25);
		btnDownload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		jp.add(btnDownload);
		
		JButton btnStatistics = new JButton("Show Laundry Statistics");
		btnStatistics.setBounds(150, 170, 150, 25);
		btnStatistics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		jp.add(btnStatistics);
		
		//Dynamic text
		LatestStatistic.setText("00/00/00 00:00");
		LatestStatistic.setForeground(Color.GRAY);
		LatestStatistic.setBounds(228, 71, 83, 14);
		jp.add(LatestStatistic);
		
	}
}
