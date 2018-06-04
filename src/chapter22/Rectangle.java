package chapter22;

public class Rectangle implements GeometricObject {
	int length;
	int width;
	
	public Rectangle(int a, int b) {
		// TODO Auto-generated constructor stub
		length = a;
		width = b;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return length * width;
	}

}
