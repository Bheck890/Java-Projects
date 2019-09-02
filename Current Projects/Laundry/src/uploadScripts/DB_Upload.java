/**
 * 
 */
package uploadScripts;

import java.sql.*;
import java.util.ArrayList;

import objects.MachineOBJ;
/**
 * SQL Communication
 *
 */
public class DB_Upload {
	
	static String ID;
	static String Type;
	static String Status;
	static int min;
	static int hour;
	static int day;
	static int month;
	static int year;
	
	
	public static void Upload(ArrayList<MachineOBJ> machineData)
	{
		for(int i = 0; i < MachineOBJ.getToalMachines(); i++)
		{
			ID = machineData.get(i).getID();
			Type = machineData.get(i).getType();
			Status = machineData.get(i).getStatus();
			min = machineData.get(i).getMin();
			hour = machineData.get(i).getHour();
			day = machineData.get(i).getDay();
			month = machineData.get(i).getMonth();
			year = machineData.get(i).getYear();
			
			//Commands to upload all the data.
			Command(" ");
		}
		
		System.out.println("END: " + MachineOBJ.getToalMachines());
	}
	
	public static void Command(String cmd)
	{
		String dbURL = "jdbc:mysql://DB_SERVER:3306/";
		String db = "Laundry";
		String dbUserName = "Laundry";
		String dbPassword = "fgcu2028";
		String dbTable = "Data";
		
		
		
		try {
			// Connect to Database
			Connection myConn = DriverManager.getConnection(dbURL + db, dbUserName, dbPassword);
			
			// Create Statement
			Statement myStmt = myConn.createStatement();
			
			// Execute SQL
			ResultSet myRs = myStmt.executeQuery("select * from " + dbTable);
			//ResultSet myRs = myStmt.executeQuery(cmd);
			
			// Process Result Set
			while (myRs.next()) {
				System.out.println(myRs.getString("ID") + ", " + myRs.getString("Type"));
			}
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}
