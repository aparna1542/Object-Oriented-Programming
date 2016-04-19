package inheri_composition;

/**
 * @(#)InheritanceDemo2.java
 *
 *
 * @author
 * @version 1.00
 */

abstract class Shape {
	// Data Members
	private String shapeName = null;

	public Shape(String name) {
		shapeName = name;
	}

	public Shape() {
	}

	// An abstract method with no method implementation (method body)
	abstract public double area();

	public void print() {
		System.out.println("ShapeName: " + shapeName);
	}
}

class Circle extends Shape {
	private double radius;

	public Circle(String shapeName, double radius) {
		super(shapeName);
		this.radius = radius;
	}

	public Circle() {
	}

	@Override
	public double area() {
		return Math.PI * radius * radius;
	}

	@Override
	public void print() {
		super.print();
		System.out.println("Area = " + area());
	}
}

class Rectangle extends Shape {
	protected double width;
	protected double length;

	public Rectangle(String shapeName, double len, double wid) {
		super(shapeName);
		length = len;
		width = wid;
	}

	public Rectangle() {
	}

	@Override
	public double area() {
		return length * width;
	}

	@Override
	final public void print() {
		super.print();
		System.out.println("Area = " + area());
	}
}

final class Square extends Rectangle {
	public Square(String shapeName, double side) {
		super(shapeName, side, side);
	}

	public Square() {
	}
}

public class InheritanceDemo2 {
	public static void main(String[] args) {
		Shape shape;
		// Will not compile because Shape is an abstract class
		// and cannot be instantiated.
		// shape = new Shape ();
		Rectangle rectangle = new Rectangle("Rectangle", 2.0, 5.0);
		Circle circle = new Circle("Circle", 10);
		Square square = new Square("Square", 5);
		rectangle.print();
		// OK to assign an instance of a derived class to a base class type
		// This is called upward cast to the base and is always possible,
		// because an instance of a type Circle is also an instance of type
		// shape
		shape = rectangle;
		shape.print();
		shape = circle;
		// circle.print() is invoked since shape variable is actually referring
		// to a circle object
		shape.print();

		// Another way of assigning a derived class instance to a reference of
		// type
		// super class
		shape = new Rectangle("Rectangle", 5.0, 4.0);
		shape.print(); // What print() is invoked?
		// An array of different Shape objects
		Shape[] allShapes = new Shape[3];
		allShapes[0] = new Rectangle("Rectangle", 2.0, 5.0);
		allShapes[1] = new Circle("Circle", 10);
		allShapes[2] = new Square("Square", 5);
		for (int i = 0; i < allShapes.length; ++i) {
			allShapes[i].print();
		}
		// Casting
		Rectangle two = new Rectangle("Rectangle", 12, 13);
		Shape one = two; // upward cast to the base , always possible
		// two = one <- this assignment will not work, because an instance of
		// type Shape is not necessarily is an instance of type Circle.
		// A downward cast is required

		Rectangle three = (Rectangle) one;
		three.print();
	}
}
