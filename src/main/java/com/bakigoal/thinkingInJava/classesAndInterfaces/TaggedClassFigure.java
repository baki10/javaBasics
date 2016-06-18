package com.bakigoal.thinkingInJava.classesAndInterfaces;

/**
 * Such tagged classes have numerous shortcomings. They are cluttered with
 * boilerplate, including enum declarations, tag fields, and switch statements.
 * Created by ilmir on 22.05.16.
 */
public class TaggedClassFigure {
	private enum Shape {
		RECTANGLE, CIRCLE
	}

	//Tag field
	private final Shape shape;

	//only for RECTANGLE
	private double length;
	private double width;

	//only for CIRCLE
	private double radius;

	public TaggedClassFigure(double length, double width) {
		shape = Shape.RECTANGLE;
		this.length = length;
		this.width = width;
	}

	public TaggedClassFigure(double radius) {
		shape = Shape.CIRCLE;
		this.radius = radius;
	}

	public double area() {
		switch (shape) {
			case RECTANGLE:
				return length * width;
			case CIRCLE:
				return Math.PI * (radius * radius);
			default:
				throw new AssertionError();
		}
	}
}
