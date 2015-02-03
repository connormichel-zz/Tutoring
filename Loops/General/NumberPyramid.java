package General;

import java.util.Scanner;

public class NumberPyramid {

	public static void main( String[] args ){

		Scanner input = new Scanner(System.in);
		System.out.print("Input number of lines: ");
		int numLine = input.nextInt();

		for (int row = 1; row <= numLine; row++) 
		{  
			for (int column = 1; column <= numLine - row; column++)  
				System.out.print("   ");  
			for (int j = row; j >= 1; j--)  
				System.out.print((j >= 10) ? " " + j : "  " + j);  
			for (int k = 2; k <=row; k++)  
				System.out.print((k >= 10) ? " " + k : "  " + k);  
			System.out.println();  
		}
	}
}
