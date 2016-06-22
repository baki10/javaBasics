package com.bakigoal.designPatterns.creational.abstractFactory.colors;

import com.bakigoal.designPatterns.creational.abstractFactory.Color;

/**
 * Created by ilmir on 22.06.16.
 */
public class Red implements Color {
	@Override
	public void fill() {
		System.out.println("Inside Red::fill() method.");
	}
}
