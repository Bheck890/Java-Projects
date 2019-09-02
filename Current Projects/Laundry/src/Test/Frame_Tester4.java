package Test;


import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JButton;


public class Frame_Tester4 extends JFrame {

	/**
	 * Invalid Box
	 */
	private static final long serialVersionUID = 8519304513241168875L;
	//private JPanel contentPane;
	//private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Frame_Tester4 frame = new Frame_Tester4();
		//frame.setVisible(false);
	}

	/**
	 * Create the frame.
	 */
	
	JFrame jf = new JFrame();
	JPanel jp = new JPanel();
	
	public Frame_Tester4() 
	{
		jf.setTitle("Invalid");
		jf.setSize(350,201);
		jp.setForeground(Color.BLACK);
		jf.setContentPane(jp);
		jf.setVisible(true);
		//jf.setResizable(false);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jp.setBackground(Color.BLACK);
		jp.setLayout(null);
		
		
		//Content
		JLabel lblTemplate = new JLabel("Invalid Please Try Again");
		lblTemplate.setForeground(Color.RED);
		lblTemplate.setFont(new Font("Comic Sans MS", Font.ITALIC, 25));
		lblTemplate.setBounds(12, 13, 308, 55);
		jp.add(lblTemplate);
		
		JButton btnClose = new JButton("Close");
		btnClose.setBounds(113, 94, 97, 25);
		jp.add(btnClose);
		
	}
}
