package com.bakigoal.thinkingInJava.classesAndInterfaces;

/**
 * Created by ilmir on 22.05.16.
 */
class Rectangle extends Figure {

	private final double length;
	private final double width;

	Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}

	@Override
	double area() {
		return length * width;
	}
}
