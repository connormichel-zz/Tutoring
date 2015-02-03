package Triangle;

public class Triangle extends GeometricObject {

	double s1;
	double s2;
	double s3;

	public Triangle(double side1, double side2, double side3){
		s1 = side1;
		s2 = side2;
		s3 = side3;
	}

	public double getArea() {
		double s = .5 * (s1 + s2 + s3);
		double area = s*(s-s1)*(s-s2)*(s-s3);
		return area;
	}

	public double getPerimeter() {
		return s1+s2+s3;
	}

	public double gets1(){
		return s1;
	}

	public String toString(){
		return "Triangle: side1 = " + s1 + " side2 = " + s2 + " side3 = " + s3;
	}
}
