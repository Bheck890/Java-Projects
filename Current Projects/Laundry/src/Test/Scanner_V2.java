package Test;


//import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import java.awt.SystemColor;


public class Scanner_V2 extends JFrame {

	/**
	 * Scanner Bar
	 */
	private static final long serialVersionUID = 8519304513241168875L;
	//private JPanel contentPane;
	//private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Scanner_V2 frame = new Scanner_V2();
		//frame.setVisible(false);
	}

	/**
	 * Create the frame.
	 */
	
	JFrame jf = new JFrame();
	JPanel jp = new JPanel();
	
	public Scanner_V2() 
	{
		jf.setTitle("Scaner");
		jf.setSize(450,220);
		jf.setContentPane(jp);
		jf.setVisible(true);
		jf.setResizable(false);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		jp.setBackground(SystemColor.activeCaptionBorder);
		jp.setLayout(null);
		
		JLabel lblMonth = new JLabel("Months");
		lblMonth.setBounds(41, 32, 46, 14);
		jp.add(lblMonth);
		
		JLabel lblDay = new JLabel("Days");
		lblDay.setBounds(41, 57, 46, 14);
		jp.add(lblDay);
		
		JLabel lblFiles = new JLabel("Files Found");
		lblFiles.setBounds(41, 82, 73, 14);
		jp.add(lblFiles);
		
		JLabel MonthStat = new JLabel("00 / 12");
		MonthStat.setBounds(138, 32, 46, 14);
		jp.add(MonthStat);
		
		JLabel DayStat = new JLabel("00 / 31");
		DayStat.setBounds(138, 57, 46, 14);
		jp.add(DayStat);
		
		JLabel FileStat = new JLabel("0000 / 0000");
		FileStat.setBounds(138, 82, 94, 14);
		jp.add(FileStat);
		
		JProgressBar FileStatus = new JProgressBar();
		FileStatus.setValue(0);
		FileStatus.setBounds(41, 107, 368, 30);
		jp.add(FileStatus);
		
		JLabel Percentage = new JLabel("0%");
		Percentage.setHorizontalAlignment(SwingConstants.CENTER);
		Percentage.setBounds(191, 148, 56, 16);
		jp.add(Percentage);
		
	}
}
