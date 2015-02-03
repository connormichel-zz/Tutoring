package General;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class NearestPairFinder {

	private Point[] points;

	private String fileName;

	// This constructor allows us to change the names of the files easily.
	public NearestPairFinder(String fileName) {
		this.fileName = fileName;
	} // constructor

	private int countPoints() throws IOException {
		int count = 0;

		FileInputStream reader = new FileInputStream(fileName);
		Scanner in = new Scanner(reader);

		while (in.hasNextDouble()) {      // read the file
			in.nextDouble();
			count++;
		}
		if(count % 2 != 0){
		System.exit(1);
		}
		in.close();                     // done with it--put it away
		return count/2;
	} // readNumbers()

	private void readPoints(int count) throws IOException {
		points = new Point[count];
		FileInputStream reader = new FileInputStream(fileName);
		Scanner in = new Scanner(reader);
		for(int n =0; n<count; n++) {
			double x = in.nextDouble();
			double y = in.nextDouble();
			points[n] = new Point(x,y);
		}
		in.close(); 
	}

	private Point[] closestPair() throws IOException { 
		// p1 and p2 are the indices in the points array
		int p1 = 0, p2 = 1; // Initial two points
		double shortestDistance = distance(points[p1], points[p2]); // Initialize shortestDistance

		// Compute distance for every two points
		for (int i = 0; i < points.length; i++) {
			for (int j = i + 1; j < points.length; j++) {
				double distance = distance(points[i], points[j]); // Find distance

				if (shortestDistance > distance) {
					p1 = i; // Update p1
					p2 = j; // Update p2
					shortestDistance = distance; // Update shortestDistance 
				}
			}
		}
		Point[] closest = new Point[2];
		closest[0] = points[p1];
		closest[1] = points[p2];
		return closest; 
	}

	private double distance(Point p1 , Point p2) {
		return Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y));
	}

	public void run() throws IOException {
		int n = countPoints();
		readPoints(n);
		Point[] nearest = closestPair();
		System.out.println("The closest points are " + nearest[0] + " and " + nearest[1] + " at a distance of " + distance(nearest[0], nearest[1]) + " units.");
	} // run()

	public static void main(String[] args) {
		NearestPairFinder finder = new NearestPairFinder("input.txt");
		try{
			finder.run();
		}
		catch( IOException e ) {
			System.out.print("IOException Found"); 
		}
	}

}

