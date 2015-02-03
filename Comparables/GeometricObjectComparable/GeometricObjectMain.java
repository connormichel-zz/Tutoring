package GeometricObjectComparable;

public class GeometricObjectMain {

	public static void main(String[] args) {
		//TODO implement program here
		Circle cBig;
		Rectangle rBig;

		Circle c1 = new Circle(5.0);
		Circle c2 = new Circle(4.0);
		Rectangle rect1 = new Rectangle(3.0,2.0);
		Rectangle rect2 = new Rectangle(1.0,7.0);

		System.out.println("Comparing "+ c1 + " and " + c2);
		if(c1.max(c2)){
			System.out.println("The max circle's radius is " + c1);
			cBig = c1;
		}
		else{
			System.out.println("The max circle's radius is " + c2);
			cBig = c2;
		}

		System.out.println("Comparing " + rect1 + " and " + rect2);
		if(rect1.max(rect2)){
			System.out.println("The max rectangle is " + rect1);
			rBig = rect1;
		}
		else{
			System.out.println("The max rectangle is " + rect2);
			rBig = rect2;
		}

		if(cBig.max(rBig)){
			System.out.println("The biggest shape is " + cBig);
		}
		else{
			System.out.println("The biggest rectangle is " + rBig);
		}

	}

}
