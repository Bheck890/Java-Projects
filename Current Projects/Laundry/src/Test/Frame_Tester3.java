package Test;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;


public class Frame_Tester3 extends JFrame {

	/**
	 *  Data Viewer (FAR FROM IT) 
	 */
	private static final long serialVersionUID = 8519304513241168875L;
	//private JPanel contentPane;
	//private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Frame_Tester3 frame = new Frame_Tester3();
		//frame.setVisible(false);
	}

	/**
	 * Create the frame.
	 */
	public static JMenuBar menuBar = new JMenuBar();
	//JMenuBar menuBar = new JMenuBar()
	JFrame jf = new JFrame();
	JPanel jp = new JPanel();
	
	
    
    JMenu menu, submenu;
    JMenuItem menuItem;
	
	public Frame_Tester3() 
	{
		jf.setTitle("Title");
		jf.setSize(1420,1020);
		jp.setForeground(Color.BLACK);
		jf.setContentPane(jp);
		
		jf.setVisible(true);
		jf.setResizable(false);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//Dynamic Components
		//*****
		jf.setJMenuBar(menuBar);
		//******
		
		
		
		jp.setBackground(Color.WHITE);
		jp.setLayout(null);
		
		// Random Text
		JLabel lblEmpty = new JLabel("Empty");
		lblEmpty.setBounds(136, 321, 56, 16);
		jp.add(lblEmpty);
		
		//Build the first menu.
        menu = new JMenu("A Menu");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription(
                "The only menu in this program that has menu items");
        menuBar.add(menu);

        //a group of JMenuItems
        menuItem = new JMenuItem("A text-only menu item",
                                 KeyEvent.VK_T);
        //menuItem.setMnemonic(KeyEvent.VK_T); //used constructor instead
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription(
                "This doesn't really do anything");
        menu.add(menuItem);

        menuItem = new JMenuItem("Both text and icon");
        menuItem.setMnemonic(KeyEvent.VK_B);
        menu.add(menuItem);

        menuItem = new JMenuItem("selection 2");
        menuItem.setMnemonic(KeyEvent.VK_D);
        menu.add(menuItem);
        
		
	}
}

/*
 * 
 * 
 * 
		JMenuBar menuBar = new JMenuBar();
		jf.setJMenuBar(menuBar);
		
		JMenuItem mntmDryers = new JMenuItem("Dryers");
		menuBar.add(mntmDryers);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		menuBar.add(mntmAbout);
		
		JMenuItem mntmFile = new JMenuItem("File");
		menuBar.add(mntmFile);
		
		JMenuItem mntmHelp = new JMenuItem("Help");
		menuBar.add(mntmHelp);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Washers");
		menuBar.add(mntmNewMenuItem);
		
 * 
 * 
 * 
 * 
 * 
 */ 
