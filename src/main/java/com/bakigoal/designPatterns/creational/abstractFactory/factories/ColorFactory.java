package com.bakigoal.designPatterns.creational.abstractFactory.factories;

import com.bakigoal.designPatterns.creational.abstractFactory.AbstractFactory;
import com.bakigoal.designPatterns.creational.abstractFactory.Color;
import com.bakigoal.designPatterns.creational.abstractFactory.Shape;
import com.bakigoal.designPatterns.creational.abstractFactory.colors.Blue;
import com.bakigoal.designPatterns.creational.abstractFactory.colors.Green;
import com.bakigoal.designPatterns.creational.abstractFactory.colors.Red;

/**
 * Created by ilmir on 22.06.16.
 */
public class ColorFactory extends AbstractFactory {

	@Override
	public Color getColor(String color) {

		if (color == null) {
			return null;
		}

		if (color.equalsIgnoreCase("RED")) {
			return new Red();

		} else if (color.equalsIgnoreCase("GREEN")) {
			return new Green();

		} else if (color.equalsIgnoreCase("BLUE")) {
			return new Blue();
		}

		return null;
	}

	@Override
	public Shape getShape(String shape) {
		return null;
	}
}
