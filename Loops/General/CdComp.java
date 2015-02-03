package General;

import java.util.Scanner;

public class CdComp {

	public static void main (String [] args){

		Scanner input = new Scanner(System.in);

		System.out.print("Enter intial deposit: ");
		double n1 = input.nextDouble();
		System.out.print("Enter annual percentage yield: ");
		double n2 = input.nextDouble();
		System.out.print("Enter maturity period: ");
		int n3 = input.nextInt();

		System.out.println("Month	Deposit");
		for(int i = 1; i <= n3; i++){
			n1 = n1 +( n1 * n2)  / 1200;
			System.out.println("  " + i + "	" + n1);
		}
	}
}
