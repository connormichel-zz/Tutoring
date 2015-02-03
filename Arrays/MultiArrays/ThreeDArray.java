package MultiArrays;

import java.util.Scanner; 

public class ThreeDArray {


	public static void main(String[] args) {

		double[][][] scores = {
				{{7.5, 20.5}, {9.0, 22.5}, {15, 33.5}, {13, 21.5}, {15, 2.5}},
				{{4.5, 21.5}, {9.0, 22.5}, {15, 34.5}, {12, 20.5}, {14, 9.5}},
				{{6.5, 30.5}, {9.4, 10.5}, {11, 33.5}, {11, 23.5}, {10, 2.5}},
				{{6.5, 23.5}, {9.4, 32.5}, {13, 34.5}, {11, 20.5}, {16, 7.5}},
				{{8.5, 26.5}, {9.4, 52.5}, {13, 36.5}, {13, 24.5}, {16, 2.5}},
				{{9.5, 20.5}, {9.4, 42.5}, {13, 31.5}, {12, 20.5}, {16, 6.5}}};			

		String[] roster = {"Brandon", "John", "Jane", "Mike", "Sally", "Steve"};

		Scanner input = new Scanner(System.in);
		System.out.print("Enter a students name: ");
		String Student= input.next();

		printAvgScores(scores,roster,Student);
	}

	public static void printAvgScores(double[][][] scores, String[] roster, String studentName)
	{

		int studentIndex=0;
		for (int i = 0; i < roster.length; i++) {
			if (roster[i].equals(studentName)){
				studentIndex = i;
			}
		}
		double mchoice=0; 
		double essay=0;
		for (int i =0; i < scores [studentIndex].length; i++){
			mchoice +=scores[studentIndex][i][0];
			essay +=scores [studentIndex][i][1];

		}
		System.out.println(studentName+ " has an average of " + mchoice / (roster.length -1) + " on the multiple choice sections and " + essay / (roster.length -1) + " on the essay sections");

	}
}
