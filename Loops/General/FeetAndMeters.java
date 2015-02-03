package General;

import java.text.DecimalFormat;

public class FeetAndMeters{

	public static void main(String[] args){

		DecimalFormat length = new DecimalFormat ("0.000"); 

		double meters,feet;

		System.out.println("Feet               Meters  |  Meters               Feet");
		System.out.println("----------------------------------------------------------");

		int k = 15; 
		for(int i = 1;  i<=10; i++){

			feet = 0;
			k += 5;
			feet = metersToFeet(k);
			meters = feetToMeters(i);
			System.out.print((i >= 10) ? i + "                 " + length.format(meters) : i + "                  " + length.format(meters));
			System.out.print("   |   " + k + "                 " + length.format(feet) + "\n");
		}
	}

	public static double feetToMeters(double feet){

		return 0.305 * feet; 
	}

	public static double metersToFeet(double meters){

		return 3.279 * meters;

	}
}