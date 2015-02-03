package TriangleException;

public class TriangleWithException {

	double side1,side2,side3;

	public TriangleWithException(double side1,double side2,double side3) throws IllegalTriangleException{
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;

		if((side1+side2) <= side3 || (side2+side3) <= side1 || (side3+side1) <= side2){
			throw new IllegalTriangleException(side1,side2,side3);
		}
	}

	public double getSide1(){
		return side1;
	}

	public double getSide2(){
		return side2;
	}

	public double getSide3(){
		return side3;
	}

	public void setSide1(int side1){
		this.side1=side1;
	}

	public void setSide2(int side2){
		this.side2=side2;
	}

	public void setSide3(int side3){
		this.side3=side3;
	}

	public double getArea(){ 
		return 0.25 * Math.sqrt((side1 + side2 + side3) * (-side1 + side2 + side3) * (side1 - side2 + side3) * (side1 +side2 - side3));
	}

	public double getPerimeter(){ 
		return side1+side2+side3;
	}

}
