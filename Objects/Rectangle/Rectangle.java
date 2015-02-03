package Rectangle;

import java.text.DecimalFormat;

public class Rectangle {

	double width = 1;

	double height = 1;

	public Rectangle(){

	}

	public Rectangle(double newWidth, double newHeight){

		width = newWidth;

		height = newHeight;
	}

	public double getArea(){

		return width * height;
	}

	public double getPerimeter(){

		return 2 * (width + height);

	}

	public String toString(){

		return "The width of rectangle is " + width +" and the height is " + height;

	}

	public double getWidth(){
		return width;
	}
	public double getHeight(){
		return height;
	}

	public void setWidth(double w){
		width = w;
	}
	public void setHeight(double h){
		height = h;
	}
}