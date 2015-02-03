package DoubleArrayLists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DoubleArrayList {

	public static void main (String [] args){

		Scanner input = new Scanner(System.in);
		System.out.print("Enter the array size n: ");
		int n = input.nextInt();
		List<Integer> rows = new ArrayList<Integer>();
		List<Integer> columns = new ArrayList<Integer>();
		int[][] matrix = new int[n][n];
		int bigrindex = 0;
		int bigrsum = 0;
		int bigr = 0;
		int bigcindex = 0;
		int bigcsum = 0;
		int bigc = 0;

		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				int rand = (int)(Math.random()*2);
				matrix[i][j] = rand;
				rows.add(matrix[i][j]);
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}

		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				columns.add(matrix[j][i]);
			}
		}

		for(int i=0; i<rows.size(); i++){
			bigrsum += rows.get(i);
			bigcsum += columns.get(i);
			if(((i+1)%n)==0){
				if(bigrsum > bigr){
					bigr = bigrsum;
					bigrindex = (i+1)/n;
				}
				if(bigcsum > bigc){
					bigc = bigcsum;
					bigcindex = (i+1)/n;
				}
				bigrsum = 0;
				bigcsum = 0;
			}
		}

		System.out.println("The largest row is row " + bigrindex + " with " + bigr + " ones");
		System.out.println("The largest column is column " + bigcindex + " with " + bigc + " ones");	
	}
}
