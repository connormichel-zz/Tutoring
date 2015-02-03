package SimpleDate;

class SimpleDate{
	protected int year;
	protected int month;
	protected int day;


	public SimpleDate(String Date){

		String y = Date.substring(0,4);
		String m = Date.substring(5,7);
		String d = Date.substring(8);

		year = Integer.parseInt(y);
		month = Integer.parseInt(m);
		day = Integer.parseInt(d);
		System.out.println(year + " " + month + " " + day);
	}
	public boolean isBefore(SimpleDate other){
		if(year >= other.year)
		{
			if(month >= other.month)
			{
				if(day > other.day)
				{
					return true;
				}
			}
		}
		else if(other.year > year){
			return true;
		}
		return false;
	}

	public boolean isAfter(SimpleDate other){
		if(year < other.year)
		{
			if(month < other.month)
			{
				if(day < other.day)
				{
					return true;
				}
			}
		}
		else if(other.year < year){
			return true;
		}
		return false;
	}

	public boolean equals(SimpleDate other){
		if(year == other.year)
		{
			if(month == other.year)
			{
				if(day == other.day)
				{

					return true;
				}
			}
		}


		return false;
	}

	private static String monthToString(int month){
		final String[] months = {"", "January" , "February" , "March" , "April" , "May" ,"June" , "July", "August" , "September" , "October" , "November" , "December"};
		return months[month];
	} 

	public String toString(){
		String s = day + " " + monthToString(month) + " " + year;
		return s;
	}
}