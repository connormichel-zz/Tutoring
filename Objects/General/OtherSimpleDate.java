package General;

import java.text.SimpleDateFormat;

public class OtherSimpleDate {

	protected int year, month,day;

	public OtherSimpleDate(String date){

		char[] array = new char [10];

		for (int count = 0; count <=9; count ++) {

			array [count] = date.charAt(count);

		}// end of for
		StringBuilder sb = new StringBuilder(); 

		String yeartemp = sb.append (array[0]).append(array[1]).append(array[2]).append(array[3]).toString();

		StringBuilder sb1 = new StringBuilder();
		String monthtemp =sb1.append(array[5]).append(array[6]).toString();

		StringBuilder sb2 = new StringBuilder();
		String daytemp =sb2.append(array[8]).append(array[9]).toString();

		year = Integer.parseInt(yeartemp);
		month = Integer.parseInt(monthtemp);
		day = Integer.parseInt(daytemp);


	}//end of constructor
	public boolean isBefore(OtherSimpleDate other) {
		if ( this.year > other.year) 
			return false;
		else if (this.year < other.year)
			return true;
		else if (this.month >other.month)
			return false;
		else if(this.month > other.month)
			return true;
		else if (this.day > other.day)
			return false;
		else 
			return true;
	}//end isBefore
	public boolean isAfter(OtherSimpleDate other) {
		if ( this.year > other.year) 
			return true;
		else if (this.year < other.year)
			return false;
		else if (this.month >other.month)
			return true;
		else if(this.month > other.month)
			return false;
		else if (this.day > other.day)
			return true;
		else 
			return false;
	}//end isAfter
	public boolean equals(OtherSimpleDate other) {
		if ( this.year == other.year&&this.month == other.month && this.day == other.day)
			return true;
		else 
			return false;

	}//end equal

	private static String monthToString(int month) { 
		final String[] months = 
			{"", "January", "February", "March", "April", "May", "June", 
				"July", "August", "September", "October", "November", 
			"December"}; 
		return months[month]; 
	} // monthToString()

	public String toString(){
		String s = day+" "+monthToString(month)+" "+year;
		return s;
	}

	public static void main(String[] args) {
		OtherSimpleDate date1 = new OtherSimpleDate("2014-03-17");
		OtherSimpleDate date2 = new OtherSimpleDate("1837-12-07");
		System.out.println(date1.isBefore(date2));
		System.out.println(date1.isAfter(date2));
		System.out.println(date1.equals(date2));
		System.out.println(date1);
	}	


}//end of class
