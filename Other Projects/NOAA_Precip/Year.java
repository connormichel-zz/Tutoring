package NOAA_Precip;

import java.util.Scanner;

public class Year implements Comparable<Year>  {

	private final double yearpr;
	private final int MONTHS_IN_YEAR = 12;
	private final int      year;
	private final double[] months; // numbered 0-11

	public Year(String line) {
		//System.out.println(line);
		Scanner tokens = new Scanner(line);
		year = Integer.parseInt(tokens.next());
		months = new double[MONTHS_IN_YEAR];
		for (int mnth = 0; mnth < 12; mnth++) {
			if (tokens.hasNext())
				months[mnth] = precipAsNumber(tokens.next());
			else
				months[mnth] = -1; // missing month
		} // for each month
		yearpr = totalPrecip();
	} // constructor

	private double precipAsNumber(String s) {
		// There is a much more reliable and simpler way to do this. We will
		// revisit this method after chapter 10.

		// Does the token look numeric?
		if (Character.isDigit(s.charAt(0)))
			return Double.parseDouble(s);
		else
			return -1;
	} // precipAsNumber()

	public int year() {
		return year;
	} // year()

	private double totalPrecip() {
		double sum = 0;

		// add up the months' data, skipping missing (negative) values
		for (int index = 0; index < MONTHS_IN_YEAR; index++)
			if (months[index] > 0)
				sum += months[index];

		return sum;
	} // totalPrecip()

	public double getterpr(){
		return yearpr;
	}

	public int compareTo (Year other){
		if(this.totalPrecip()>other.totalPrecip())
			return 1;
		else if(this.totalPrecip()==other.totalPrecip())
			return 0;
		else
			return -1;
	}
} // class Year