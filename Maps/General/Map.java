package General;

// Not Finished

import javax.swing.JOptionPane;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List; 

public class Map {
	public static void main(String[] args) {

		// create a new empty use counter
		UseCounter counter = new UseCounter();

		while (true) {
			// Enter an integer
			String numberString = JOptionPane.showInputDialog(null,
					"Enter an integer:", "Exercise23_06 Input",
					JOptionPane.QUESTION_MESSAGE);

			if(numberString == null) break;

			int number;
			try{
				// Convert string to int
				number = Integer.parseInt(numberString);
			}catch(NumberFormatException nfe){
				JOptionPane.showMessageDialog(null, 
						"\"" + numberString + "\" is not an integer.  Please try again (0 to quit)", 
						"Exercise23_06 Input", 
						JOptionPane.WARNING_MESSAGE);
				continue;
			}

			// If the user entered 0 then stop prompting for numbers.
			if (number == 0) break;

			// tell the use counter about the new number
			counter.recordOccurrence(number);
		}

		// make sure we got at least one number
		if(counter.getNumberOfUniqueUsed() == 0){
			// if not print an error
			System.out.println("You did not enter any numbers");

		}else{
			// if so print statistics
			System.out.println("You entered " + counter.getNumberOfUniqueUsed() + " unique numbers");
			System.out.println("The most used numbers were: " + counter.getMostUsed());
			System.out.println("Number of times each of them was used: " + counter.getCountOfMostUsed());
		}
	}
}

class UseCounter{

	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();
	int key = 0;

	public void recordOccurrence(int number) {
		map.put(key, number);
		key++;
	}

	public int getCountOfMostUsed() {

		return 0;
	}

	public List<Integer> getMostUsed() {
		List<Integer> values = (List<Integer>) map.values();

		for(int i = 0; i < values.size(); i++){
			int count = -1;
			for(int j = 1; j < values.size(); j++){
				if (values.get(i) == values.get(j)){
					count++;
				}
			}
			countMap.put(i, count);
		}
		List<Integer> countValues = (List<Integer>) countMap.values();
		List used = Arrays.asList();

		return null;
	}

	public int getNumberOfUniqueUsed() {

		return key;
	}
	//TODO define UseCounter here
}
