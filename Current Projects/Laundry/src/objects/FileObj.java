package objects;





public class FileObj {
	
	//The Static data inside the text file
	private int min;
	private int hour;
	private int day;
	private int month;
	private int year;
	private String Path;	
	
	// File OBJECT
	public FileObj(int mi,int hr,int d,int mo,int yer,String pat)
	{
		min = mi;
		hour = hr;
		day = d;
		month = mo;
		year = yer;
		Path = pat;  // Using this info to pull the data out of this file from this file path
	}
	public FileObj(String pat)
	{
		Path = pat;
	}
	
	/**
	 * @return the minute
	 */
	public int getMin() {
		return min;
	}
	/**
	 * @param min the minute to set
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
	 * @return the path
	 */
	public String getPath() {
		return Path;
	}
	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		Path = path;
	}
	/**
	 * @return the iD
	 */
	
}
