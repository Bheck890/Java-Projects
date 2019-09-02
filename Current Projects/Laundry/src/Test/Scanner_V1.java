package Test;


//import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import java.awt.SystemColor;


public class Scanner_V1 extends JFrame {

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
		Scanner_V1 frame = new Scanner_V1();
		//frame.setVisible(false);
	}

	/**
	 * Create the frame.
	 */
	
	JFrame jf = new JFrame();
	JPanel jp = new JPanel();
	
	public Scanner_V1() 
	{
		jf.setTitle("Scaner");
		jf.setSize(450,300);
		jf.setContentPane(jp);
		jf.setVisible(true);
		jf.setResizable(false);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		jp.setBackground(SystemColor.activeCaptionBorder);
		jp.setLayout(null);
		
		JLabel MonthLabel = new JLabel("Months");
		MonthLabel.setBounds(41, 32, 46, 14);
		jp.add(MonthLabel);
		
		JProgressBar MonthStatus = new JProgressBar();
		MonthStatus.setValue(0);
		MonthStatus.setBounds(41, 47, 368, 30);
		jp.add(MonthStatus);
		
		JLabel CurrentMonth = new JLabel("0");
		CurrentMonth.setBounds(41, 76, 15, 14);
		jp.add(CurrentMonth);
		
		JLabel MonthDivider = new JLabel("/");
		MonthDivider.setBounds(51, 76, 15, 14);
		jp.add(MonthDivider);
		
		JLabel TotalMonths = new JLabel("12");
		TotalMonths.setBounds(61, 76, 15, 14);
		jp.add(TotalMonths);
		
		JLabel DayLabel = new JLabel("Days");
		DayLabel.setBounds(41, 113, 46, 14);
		jp.add(DayLabel);
		
		JProgressBar DayStatus = new JProgressBar();
		DayStatus.setValue(0);
		DayStatus.setBounds(41, 127, 368, 30);
		jp.add(DayStatus);
		
		JLabel CurrentDay = new JLabel("0");
		CurrentDay.setBounds(41, 154, 15, 14);
		jp.add(CurrentDay);
		
		JLabel DayDivider = new JLabel("/");
		DayDivider.setBounds(51, 154, 15, 14);
		jp.add(DayDivider);
		
		JLabel TotalDays = new JLabel("31");
		TotalDays.setBounds(61, 154, 15, 14);
		jp.add(TotalDays);
		
		JLabel FilesLabel = new JLabel("Files Found");
		FilesLabel.setBounds(41, 188, 88, 14);
		jp.add(FilesLabel);
		
		JProgressBar FileStatus = new JProgressBar();
		FileStatus.setValue(0);
		FileStatus.setBounds(41, 203, 368, 30);
		jp.add(FileStatus);
		
		JLabel Percentage = new JLabel("0%");
		Percentage.setHorizontalAlignment(SwingConstants.CENTER);
		Percentage.setBounds(193, 244, 56, 16);
		jp.add(Percentage);
		
		JLabel FileFound = new JLabel("0");
		FileFound.setBounds(41, 232, 15, 14);
		jp.add(FileFound);
		
		JLabel FileDivider = new JLabel("/");
		FileDivider.setBounds(51, 232, 15, 14);
		jp.add(FileDivider);
		
		JLabel TotalFiles = new JLabel("0");
		TotalFiles.setBounds(61, 232, 68, 14);
		jp.add(TotalFiles);
		
	}
}
