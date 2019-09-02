package objects;

public class MachineOBJ {

	
	// Be able to tell when this machine is on or off at a set time from data being pulled from a text file
	// can incorporate the data inputed into a array analyzing the times when on or off
	private String ID;
	private String Type;
	private String Status;
	private int min;
	private int hour;
	private int day;
	private int month;
	private int year;
	static public int TotalMachines;
	
	public MachineOBJ(int mi,int hr,int d,int mo,int yer,String id, String ty, String stat)
	{
		setMin(mi);
		setHour(hr);
		setDay(d);
		setMonth(mo);
		setYear(yer);
		setID(id);
		setType(ty);
		setStatus(stat);
	}

	/**
	 * @return the iD
	 */
	public String getID() {
		return ID;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(String iD) {
		ID = iD;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return Type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		Type = type;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return Status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		Status = status;
	}

	/**
	 * @return the min
	 */
	public int getMin() {
		return min;
	}

	/**
	 * @param min the min to set
	 */
	public void setMin(int min) {
		this.min = min;
	}

	/**
	 * @return the hour
	 */
	public int getHour() {
		return hour;
	}

	/**
	 * @param hour the hour to set
	 */
	public void setHour(int hour) {
		this.hour = hour;
	}

	/**
	 * @return the day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * @param day the day to set
	 */
	public void setDay(int day) {
		this.day = day;
	}

	/**
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * @param month the month to set
	 */
	public void setMonth(int month) {
		this.month = month;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}


	/**
	 * @return the Total Machines
	 */
	static public int getToalMachines() {
		return TotalMachines;
	}
	
	

	
}
