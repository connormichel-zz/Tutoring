package General;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class OrderToFile {

	private final Scanner input;
	private final PrintStream sameOrder;
	private final PrintStream reverseOrder;
	private int count;

	public OrderToFile(String file) throws FileNotFoundException {
		sameOrder = new PrintStream("same-order.txt");
		reverseOrder = new PrintStream("reverse-order.txt");
		FileInputStream fin = new FileInputStream(file);
		input = new Scanner(fin);
		count = -1;
	}//constructor

	public int readWriteFile() {
		if (!input.hasNext())
			return 0;
		String token = input.next();
		sameOrder.println(token);
		count = readWriteFile();
		reverseOrder.println(token);
		return count + 1;
	}//readWriteFile()

	public void run() {
		count = readWriteFile();
		sameOrder.close();
		reverseOrder.close();
		input.close();
	}//run()

	@Override 
	public String toString() {
		if (count == -1)
			return "run() is NEVER initialized";
		return "number of tokens is " + count;
	}

	public static void main(String[] args) {
		try {
			OrderToFile orderToFile = new OrderToFile("in.txt");
			orderToFile.run();
			System.out.println(orderToFile);
		}
		catch (FileNotFoundException e){
			System.out.println("File not found");
		}
	}
}

