package com.bakigoal.designPatterns.creational.factory.shapes;

import com.bakigoal.designPatterns.creational.factory.Shape;

/**
 * Created by ilmir on 21.06.16.
 */
public class Circle implements Shape {
	@Override
	public void draw() {
		System.out.println("Inside Circle::draw() method.");
	}
}
