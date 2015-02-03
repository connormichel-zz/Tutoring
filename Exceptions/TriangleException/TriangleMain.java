package TriangleException;

public class TriangleMain {

	public static void main(String[] args) {
		try {
			TriangleWithException t1 = new TriangleWithException(1.5, 2, 3);
			System.out.println("Perimeter for t1: " + t1.getPerimeter());
			System.out.println("Area for t1: " + t1.getArea());

			TriangleWithException t2 = new TriangleWithException(1, 2, 3);
			System.out.println("Perimeter for t2: " + t2.getPerimeter());
			System.out.println("Area for t2: " + t2.getArea());
		}
		catch (IllegalTriangleException ex) {
			System.out.println("Illegal triangle");
			System.out.println("Side1: " + ex.getSide1());
			System.out.println("Side2: " + ex.getSide2());
			System.out.println("Side3: " + ex.getSide3());
		}
	}
}
