package com.bakigoal.designPatterns.creational.abstractFactory.factories;

import com.bakigoal.designPatterns.creational.abstractFactory.AbstractFactory;
import com.bakigoal.designPatterns.creational.abstractFactory.Color;
import com.bakigoal.designPatterns.creational.abstractFactory.Shape;
import com.bakigoal.designPatterns.creational.abstractFactory.shapes.Circle;
import com.bakigoal.designPatterns.creational.abstractFactory.shapes.Rectangle;
import com.bakigoal.designPatterns.creational.abstractFactory.shapes.Square;

/**
 * Created by ilmir on 22.06.16.
 */
public class ShapeFactory extends AbstractFactory {

	@Override
	public Color getColor(String color) {
		return null;
	}

	@Override
	public Shape getShape(String shapeType){

		if(shapeType == null){
			return null;
		}

		if(shapeType.equalsIgnoreCase("CIRCLE")){
			return new Circle();

		}else if(shapeType.equalsIgnoreCase("RECTANGLE")){
			return new Rectangle();

		}else if(shapeType.equalsIgnoreCase("SQUARE")){
			return new Square();
		}

		return null;
	}
}
