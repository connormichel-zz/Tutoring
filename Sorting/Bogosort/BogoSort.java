package Bogosort;

import java.util.Random;


public class BogoSort {

	private final int[] theNumbers;
	private final Random rng;

	public BogoSort (int n) {
		rng = new Random();
		theNumbers = new int[n];
		for (int index = 0; index < n; ++index)
			theNumbers[index] = rng.nextInt(1000);
	} // constructor

	public void sort() {
		while (!isSorted())
			shuffle();
	} // sort()

	public boolean isSorted() {
		for (int index = 1; index < theNumbers.length; index++)
			if (theNumbers[index - 1] > theNumbers[index])
				return false;
		return true;
	} // isSorted() 

	public void shuffle() {
		for (int i = 0; i < theNumbers.length; ++i)
			swap(i, rng.nextInt(theNumbers.length));
	} // shuffle()

	public void swap(int m, int n) {
		int oldM = theNumbers[m];
		theNumbers[m] = theNumbers[n];
		theNumbers[n] = oldM;
	} // swap()

	public static void main(String[] args) {
		int n = 2;
		StopWatch stopwatch = new StopWatch();
		while (true) {
			BogoSort bogosorter = new BogoSort(n);
			stopwatch.restart();
			bogosorter.sort();
			stopwatch.read();
			//System.out.println(n + "  integers sorted " + "bogusly in " + stopwatch.elapsedS() + stopwatch.elapsedMs() + " seconds.");
			System.out.println((n >= 10) ? n + " integers sorted " + "bogusly in " + stopwatch.elapsedS() + stopwatch.elapsedMs() + " seconds." 
					: n + "  integers sorted " + "bogusly in " + stopwatch.elapsedS() + stopwatch.elapsedMs() + " seconds.");
			n += 1;
		} // while()
	} // main()

}
