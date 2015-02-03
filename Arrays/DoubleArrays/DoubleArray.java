package DoubleArrays;

import java.util.*;

public class DoubleArray {

	public static void main(String[] args) 
	{
		Scanner input = new Scanner (System.in); 
		String again;

		do 
		{ 
			Random rand = new Random();
			int size = rand.nextInt(11);
			int[][] array = new int[size][size];

			for (int i=0; i<array.length;i++) 
			{
				for (int j = 0; j<array[i].length;j++){
					array[i][j] = rand.nextInt(11) + 1;
				}
			}

			for (int i=0; i<array.length;i++) 
			{
				for (int j = 0; j<array.length;j++){
					System.out.print((array[i][j]>=10) ? array[i][j] + " " : array[i][j] + "  ");
				}
				System.out.println();
			}

			System.out.print("Do you want to do another? Enter yes or no: "); 
			again = input.next();
		} while( again.equals ("yes"));

		System.out.println("Program has ended"); 
	}
}
