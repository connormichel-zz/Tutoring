package SimpleDate;

public class SimpleDateMain {

	public static void main(String[] args){
		SimpleDate date1 = new SimpleDate("2014-03-17");
		SimpleDate date2 = new SimpleDate("1837-12-07");
		System.out.println(date2.isAfter(date1)); 
		System.out.println(date1.isBefore(date2));
		System.out.println(date1.equals(date2));
		System.out.println(date1);
	}
}

