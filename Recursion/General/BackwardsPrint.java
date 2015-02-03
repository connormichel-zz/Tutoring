package General;

import java.util.Scanner;

public class BackwardsPrint{

	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a String: ");
		String str = input.nextLine();
		reverseDisplay(str);

	}

	private static void reverseDisplay(String str) {
		if(str.length()==1){
			System.out.println(str);
			return;
		}
		System.out.print(str.substring(str.length()-1));
		reverseDisplay(str.substring(0,str.length()-1));
	}
}
