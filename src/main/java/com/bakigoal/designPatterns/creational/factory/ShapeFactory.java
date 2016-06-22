package com.bakigoal.designPatterns.creational.factory;

import com.bakigoal.designPatterns.creational.factory.shapes.Circle;
import com.bakigoal.designPatterns.creational.factory.shapes.Rectangle;
import com.bakigoal.designPatterns.creational.factory.shapes.Square;

/**
 * Created by ilmir on 21.06.16.
 */
public class ShapeFactory {

	public Shape getShape(String shapeType) {
		if (shapeType == null) {
			return null;
		}
		if (shapeType.equalsIgnoreCase("CIRCLE")) {
			return new Circle();

		} else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
			return new Rectangle();

		} else if (shapeType.equalsIgnoreCase("SQUARE")) {
			return new Square();
		}

		return null;
	}
}
