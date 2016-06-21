package com.bakigoal.designPatterns.behavioral.templateMethod.impl;

import com.bakigoal.designPatterns.behavioral.templateMethod.HouseTemplate;

/**
 * Created by ilmir on 21.06.16.
 */
public class WoodenHouse extends HouseTemplate {
	@Override
	protected void buildWalls() {
		System.out.println("Building Wooden Walls");
	}
}
