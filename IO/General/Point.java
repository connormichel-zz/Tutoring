package General;

public class Point {
	// This is a P.O.D. class, plain-old data. It is customary to leave
	// the data in such a class public, but to make it final, so no one
	// can change it.
	public final double x;
	public final double y;

	public Point(double xIn, double yIn) {
		x = xIn;
		y = yIn;
	} // constructor

	public String toString() {
		return "(" + x + ", " + y + ")";
	} // toString()

} // class Point 
