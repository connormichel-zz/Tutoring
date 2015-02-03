package Rectangle;

public class RectangleMain {

	public static void main(String[] args) {

		Rectangle rec1 = new Rectangle(4,40);

		Rectangle rec2 = new Rectangle(3.5,35.9);


		System.out.println(rec1);

		System.out.println(rec2);


		rec1.setHeight(3);

		rec1.setWidth(3);


		System.out.println("rec1.height: " + rec1.getHeight());
		System.out.println("rec1.width: " + rec1.getWidth());

		System.out.println(rec1);

		System.out.println(rec2);


	}


}

