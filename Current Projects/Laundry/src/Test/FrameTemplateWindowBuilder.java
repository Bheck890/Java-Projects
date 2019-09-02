package Test;


import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class FrameTemplateWindowBuilder extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8519304513241168875L;
	//private JPanel contentPane;
	//private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		FrameTemplateWindowBuilder frame = new FrameTemplateWindowBuilder();
		//frame.setVisible(false);
	}

	/**
	 * Create the frame.
	 */
	
	JFrame jf = new JFrame();
	JPanel jp = new JPanel();
	
	public FrameTemplateWindowBuilder() 
	{
		jf.setTitle("Title");
		jf.setSize(450,300);
		jp.setForeground(Color.BLACK);
		jf.setContentPane(jp);
		jf.setVisible(true);
		jf.setResizable(false);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jp.setBackground(Color.WHITE);
		jp.setLayout(null);
		
		
		//Content
		JLabel lblTemplate = new JLabel("Template");
		lblTemplate.setBounds(84, 43, 56, 16);
		jp.add(lblTemplate);
		
	}
}
