package com.bakigoal.designPatterns.creational.abstractFactory.shapes;

import com.bakigoal.designPatterns.creational.abstractFactory.Shape;

/**
 * Created by ilmir on 21.06.16.
 */
public class Rectangle implements Shape {
	@Override
	public void draw() {
		System.out.println("Inside Rectangle::draw() method.");
	}
}
