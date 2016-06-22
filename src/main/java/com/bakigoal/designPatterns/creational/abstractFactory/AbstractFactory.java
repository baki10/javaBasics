package com.bakigoal.designPatterns.creational.abstractFactory;

/**
 * Created by ilmir on 22.06.16.
 */
public abstract class AbstractFactory {
	public abstract Color getColor(String color);
	public abstract Shape getShape(String shape);
}
