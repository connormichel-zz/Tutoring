package DataRecovery;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class DataRecovery {

	private ArrayList<String> data = new ArrayList<String>();
	private HashMap<String,Customer> customers = new HashMap<String,Customer>();

	public DataRecovery(String path) throws FileNotFoundException{
		Scanner scan = new Scanner(new FileInputStream(path));

		while(scan.hasNextLine()){
			String line = scan.nextLine().trim();
			if(line.length()>0){
				data.add(line);
			}
		}
		scan.close();
		readCustomers();
		printCustomers();
	}

	public void readCustomers(){
		for(int i=0; i<data.size();i++){
			Scanner scan = new Scanner(data.get(i));
			String name = scan.next();
			name += " " + scan.next();
			Customer temp = new Customer(name);

			if(customers.get(name)==null){
				changeAccount(i, temp);
				customers.put(name,temp);
			}
			else{
				changeAccount(i,customers.get(name));
			}
		}
	}

	public void changeAccount(int index, Customer customer){
		Scanner line = new Scanner(data.get(index));

		line.next();
		line.next();
		line.next();
		line.next();

		String account = line.next();

		if(account.equals("Checking")){
			customer.setChecking(line.nextInt());
		}
		else if(account.equals("Savings")){
			customer.setSavings(line.nextInt());
		}
		else if(account.equals("Loan")){
			customer.setLoan(line.nextInt());
		}
	}

	public void printCustomers(){
		for(Customer i:customers.values())
			System.out.println(i);
	}

	public static void main(String[] args){
		try{
			DataRecovery recover = new DataRecovery("data.txt");
		}
		catch (FileNotFoundException ex){
			System.out.println("File not found");
		}

	}

}
