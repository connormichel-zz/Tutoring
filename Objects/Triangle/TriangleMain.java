package Triangle;

import java.util.Scanner;

public class TriangleMain {
	/**
	 * Driver program for the programming exercise.  <BR>
	 * This method should not be modified in any way.
	 * 
	 * @param args This program does not expect any arguments.
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter three sides: ");
		double side1 = input.nextDouble();
		double side2 = input.nextDouble();
		double side3 = input.nextDouble();
		input.nextLine(); // consumes the <enter> after the last number

		Triangle triangle = new Triangle(side1, side2, side3);

		System.out.print("Enter the color: ");
		String color = input.nextLine();
		triangle.setColor(color);

		System.out.print("Enter a boolean value for filled: ");
		boolean filled = input.nextBoolean();
		triangle.setFilled(filled);

		System.out.println("The area is " + triangle.getArea());
		System.out.println("The perimeter is "
				+ triangle.getPerimeter());
		System.out.println("The color is " + triangle.getColor());
		System.out.println("It is filled: " + triangle.isFilled());
		System.out.println(triangle);

		input.close();
	}

}

