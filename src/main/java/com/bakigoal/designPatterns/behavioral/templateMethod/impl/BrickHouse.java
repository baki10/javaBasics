package com.bakigoal.designPatterns.behavioral.templateMethod.impl;

import com.bakigoal.designPatterns.behavioral.templateMethod.HouseTemplate;

/**
 * Created by ilmir on 21.06.16.
 */
public class BrickHouse extends HouseTemplate {
	@Override
	protected void buildWalls() {
		System.out.println("Building Brick Walls");
	}
}
