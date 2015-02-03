package NOAA_Precip;

public class YearDataPair {

	private final int    year;
	private final double data;

	public YearDataPair(int year, double data) {
		this.data = data;
		this.year = year;
	} // constructor

	public int year() {
		return year;
	} // year()

	public double data() {
		return data;
	} // data() 

} // class YearDataPair