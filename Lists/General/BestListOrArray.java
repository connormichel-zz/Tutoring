package General;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BestListOrArray {

	private static long startTaskTime;

	public static void main(String[] args) {

		int numNumbers = 50000;
		ArrayList<Integer> aList = new ArrayList<Integer>();
		LinkedList<Integer> lList = new LinkedList<Integer>();

		// Fill from the back
		startTimer("Fill time for ArrayList (back) is ");
		fillByBack(aList, numNumbers);
		stopTimer();
		startTimer("Fill time for LinkedList (back) is");
		fillByBack(lList, numNumbers);
		stopTimer();
		System.out.println("The List type that is faster at growing a large list " + 
				"by adding elements to the back is: " + getBestForAddingToBack());
		System.out.println();

		// reset the lists
		removeAllElements(aList);
		removeAllElements(lList);

		// Fill from the front
		startTimer("Fill time for ArrayList (front) is ");
		fillByFront(aList, numNumbers);
		stopTimer();
		startTimer("Fill time for LinkedList (front) is");
		fillByFront(lList, numNumbers);
		stopTimer();
		System.out.println("The List type that is faster at growing a large list " + 
				"by adding elements to the front is: " + getBestForAddingToFront());
		System.out.println();

		// Traverse using index
		startTimer("Traverse time (ArrayList) using index is ");
		traverseByIndex(aList);
		stopTimer();
		startTimer("Traverse time (LinkedList) using index is");
		traverseByIndex(lList);
		stopTimer();
		System.out.println("The List type that is faster at traversing a large list " + 
				"by index is: " + getBestForTraversingByIndex());
		System.out.println();

		// Traverse using Iterator
		startTimer("Traverse time (ArrayList) using iterator is ");  
		traverseByIterator(aList);
		stopTimer();
		startTimer("Traverse time (LinkedList) using iterator is");  
		traverseByIterator(lList);
		stopTimer();
		System.out.println("The List type that is faster at traversing a large list " + 
				"by using an iterator is: " + getBestForTraversingWithIterator());
		System.out.println();

		System.out.println("Goodbye!");
	}

	/**
	 * Helper method for recording elapsed time 
	 * Starts the timer.  <BR> 
	 * This method should not be modified in any way.
	 * 
	 * @param message a string to print to the console about what is being timed
	 */
	private static void startTimer(String message) {
		System.out.print(message +  " ");
		startTaskTime = System.currentTimeMillis();
	}

	/**
	 * Helper method for recording elapsed time.
	 * Stops the timer and computes and prints elapsed time in milliseconds.  <BR> 
	 * This method should not be modified in any way.
	 */
	private static long stopTimer(){
		long endTaskTime = System.currentTimeMillis();
		long elapsed = endTaskTime - startTaskTime;
		System.out.println(elapsed + " ms");
		return elapsed;
	}

	/**
	 * Adds numNumbers Integers to the provided list by adding elements to the front of the list.<BR> 
	 * This method should be completed by the student.
	 * 
	 * @param list the list to fill from the front.
	 * @param numNumbers the number of Integers to add to the list
	 */
	private static void fillByFront(List<Integer> list, int numNumbers) {
		//TODO complete method body here
		for(int i = 0; i < numNumbers; i++){
			list.add(i, 0);
		}
	}

	/**
	 * Adds numNumbers Integers to the provided list by adding elements to the back of the list.<BR> 
	 * This method should be completed by the student.
	 * 
	 * @param list the list to fill from the back.
	 * @param numNumbers the number of Integers to add to the list
	 */
	private static void fillByBack(List<Integer> list, int numNumbers) {
		//TODO complete method body here
		for(int i = 0; i < numNumbers; i++){
			list.add(i);
		}
	}

	/**
	 * Removes all the elements from the provided list without iterating over elements .<BR> 
	 * This method should be completed by the student.
	 * 
	 * @param list the list to remove all elemements from.
	 */
	private static void removeAllElements(List<Integer> list) {
		//TODO complete method body here
		list.removeAll(list);
	}

	/**
	 * Loops over all the elements in the provided list accessing each value by index.<BR> 
	 * This method should be completed by the student.
	 * 
	 * @param list the list to traverse by index.
	 */
	private static void traverseByIndex(List<Integer> list) {
		//TODO complete method body here
		for(int i = 0, n = list.size(); i < n; i++) {
			//System.out.println(list.get(i));
			list.get(i);
		}
	}

	/**
	 * Loops over all the elements in the provided list accessing each value using an iterator.<BR> 
	 * This method should be completed by the student.
	 * 
	 * @param list the list to traverse by iterator.
	 */
	private static void traverseByIterator(List<Integer> list) {
		//TODO complete method body here
		Iterator it = list.iterator();       
		while(it.hasNext()){
			//System.out.println(it.next());
			it.next();
		}
	}

	/**
	 * Returns the name of the List type best suited for 
	 * filling a very large list by adding elements to the end.
	 * 
	 * @return either "ArrayList" or "LinkedList"
	 */
	private static String getBestForAddingToBack() {
		//TODO complete method body here
		return "ArrayList";
	}

	/**
	 * Returns the name of the List type best suited for 
	 * filling a very large list by adding elements to the front.
	 * 
	 * @return either "ArrayList" or "LinkedList"
	 */
	private static String getBestForAddingToFront() {
		//TODO complete method body here
		return "ArrayList";
	}

	/**
	 * Returns the name of the List type best suited for 
	 * traversing a very large list by index.
	 * 
	 * @return either "ArrayList" or "LinkedList"
	 */
	private static String getBestForTraversingByIndex() {
		//TODO complete method body here
		return "ArrayList";
	}

	/**
	 * Returns the name of the List type best suited for 
	 * traversing a very large list by using an iterator.
	 * 
	 * @return either "ArrayList" or "LinkedList"
	 */
	private static String getBestForTraversingWithIterator() {
		//TODO complete method body here
		return "LinkedList";
	}
}
