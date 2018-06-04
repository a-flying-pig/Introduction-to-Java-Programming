package chapter22;

public class Circle implements GeometricObject{
	int radius;
	public Circle(int a) {
		radius = a;
	}
	
	public double getArea() {
		return Math.PI * radius * radius;
	}
}
