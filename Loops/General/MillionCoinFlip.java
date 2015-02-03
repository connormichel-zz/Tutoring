package General;

import java.util.Random;

public class MillionCoinFlip {

	public static void main (String [] args){

		int hCount = 0;
		int tCount = 0;
		Random rand = new Random();
		for(int i = 1; i <= 1000000; i++){

			int random = (int) rand.nextInt(2);
			if(random == 1){
				hCount++;
			}
			else{
				tCount++;
			}
		}
		System.out.println(hCount);
		System.out.println(tCount);		   
	}
}
