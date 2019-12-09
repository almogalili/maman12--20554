

import java.util.Calendar;

public class BirthDay {

	private int year;
	private int month;
	private int day;

	public BirthDay(int day, int month, int year) {
		
		this.year = year;
		this.month = month;
		this.day = day;

	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}
	
	public String toString()
	{
	  return String.format("%d/%d/%d", getDay(), getMonth(), getYear());	
	}

	public boolean isBirthDayThisMonth() {
		
		
		return this.month == Calendar.getInstance().get(Calendar.MONTH) + 1;
		
	}

}
