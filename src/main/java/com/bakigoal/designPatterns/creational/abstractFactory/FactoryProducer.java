package com.bakigoal.designPatterns.creational.abstractFactory;

import com.bakigoal.designPatterns.creational.abstractFactory.factories.ColorFactory;
import com.bakigoal.designPatterns.creational.abstractFactory.factories.ShapeFactory;

/**
 * Created by ilmir on 22.06.16.
 */
public class FactoryProducer {
	public static AbstractFactory getFactory(String factory){
		if(factory.equalsIgnoreCase("SHAPE")){
			return new ShapeFactory();
		}else if(factory.equalsIgnoreCase("COLOR")){
			return new ColorFactory();
		}

		return null;
	}
}
