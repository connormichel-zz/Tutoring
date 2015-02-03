package NOAA_Precip;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;
import java.text.NumberFormat;
import java.util.ArrayList;

//NOAA_Precip reads and summarizes 
public class NOAA_Precip {

	public static void main(String[] args) throws IOException {
		NOAA_Precip np = new NOAA_Precip("bwiprecip.txt");
		np.run();
	} // main()

	private Scanner in;        // handle for the input file
	private Year[]  theYears;  // the data that was read
	private int     yearCount; // number of years of data read
	private ArrayList<Decade> theDecades;
	private Decade[] decades;

	public NOAA_Precip(String fileName) throws IOException {
		FileInputStream fin = new FileInputStream(fileName);
		in = new Scanner(fin);
		theYears = new Year[1000];
		yearCount = 0;
	} // constructor

	public void run() {
		readYears();
		loadDecades();
		summarize();
		summarizeDecades();
	} // run()

	private void readYears() {
		skipHeader();
		while (in.hasNextLine()) {
			String line = in.nextLine().trim();
			if (line.length() > 0) {
				theYears[yearCount] = new Year(line);
				++yearCount;
			} // if line not empty
		} // while more years of data
	} // readYears()

	private void skipHeader() {
		int blankLines = 0;
		while (blankLines < 2) {
			String line = in.nextLine().trim();
			if (line.length() == 0)
				++blankLines;
		} // while
	} // skipHeader()

	private void summarize() {

		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);

		treesort();

		System.out.println ("The three wettest years were: ");
		System.out.println (theYears[141].year() + "\t" + nf.format(theYears[141].getterpr()) + "\"");
		System.out.println (theYears[140].year() + "\t" + nf.format(theYears[140].getterpr()) + "\"");
		System.out.println (theYears[139].year() + "\t" + nf.format(theYears[139].getterpr()) + "\"");
		System.out.println ();
		System.out.println ("The three driest years were: ");
		System.out.println (theYears[2].year() + "\t" + nf.format(theYears[2].getterpr()) + "\"");
		System.out.println (theYears[1].year() + "\t" + nf.format(theYears[1].getterpr()) + "\"");
		System.out.println (theYears[0].year() + "\t" + nf.format(theYears[0].getterpr()) + "\"");
		System.out.println ();

	} // summarize()

	private YearDataPair findWettest() {
		int wettestYear = 0;
		double maxPrecip = -1;
		for (int index = 0; index < yearCount; index++) {
			double total = theYears[index].getterpr();
			if (total > maxPrecip) {
				maxPrecip = total;
				wettestYear = theYears[index].year();
			} // if
		} // for
		return new YearDataPair(wettestYear, maxPrecip);
	} // findWettest()

	public void treesort() {
		TreeSet<Year> t1 = new TreeSet<Year>();
		for (int index = 0; index < yearCount; ++index)
			t1.add(theYears[index]);
		int index = 0;
		theYears = new Year[t1.size()];
		for (Year yr: t1)
			theYears[index++] = yr;
	}//treesort()

	private void loadDecades() {
		theDecades = new ArrayList<Decade>();
		int index = 0;
		while (index < yearCount) {
			Year first = theYears[index];
			int decade = first.year() / 10; // ignore the ones place
			int firstIndex = index;

			// find the start of the next decade (or the end of time)
			do {
				++index;
			} while (index < yearCount && decade == (theYears[index].year() / 10));

			assert index-1 >= firstIndex;
			theDecades.add(new Decade(theYears, firstIndex, index-1));
		} // while more years to process
	}// loadDecades() 

	public void treesortDecades() {
		TreeSet<Decade> t2 = new TreeSet<Decade>(theDecades);
		int index = 0;
		decades = new Decade[t2.size()];
		for (Decade dc: t2)
			decades[index++] = dc;
	}//treesort()

	public void summarizeDecades() {

		treesortDecades();
		System.out.println("The five wettest decades were:");
		System.out.println(decades[decades.length-1]);
		System.out.println(decades[decades.length-2]);
		System.out.println(decades[decades.length-3]);
		System.out.println(decades[decades.length-4]);
		System.out.println(decades[decades.length-5]);

	}//summrizeDecades()

} // class NOAA_Precip} // class NOAA_Precip