package Test;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Frame_Template_Basic extends JFrame {
	public Frame_Template_Basic() {
	}

	/**
	 *  Blank Template
	 */
	private static final long serialVersionUID = 8519304513241168875L;
	//private JPanel contentPane;
	//private final Action action = new SwingAction();

	/**
	 * Launch the application / Create Frame.
	 */
	static JFrame frame = new JFrame();
	static JPanel content = new JPanel(new BorderLayout());
	
	public static void main(String[] args) {
		
		//Create and set up the window.
        
        
        frame.setTitle("Title");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(content);
        

        //Display the window.
        frame.setSize(450,300);
        frame.setVisible(true);
        frame.setResizable(false);
        
		
	}

	/**
	 * Create the Content.
	 */
	public Container createContentPane() {
		
		content.setForeground(Color.BLACK);
		content.setBackground(Color.WHITE);
		content.setLayout(null);
		
		
		
		JLabel lblLaundryAnalyzer = new JLabel("Empty");
		lblLaundryAnalyzer.setBounds(155, 107, 111, 16);
		content.add(lblLaundryAnalyzer);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(174, 222, 90, 25);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		content.add(btnExit);
		
		return content;
	}
	
	
	
	
}
