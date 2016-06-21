package com.bakigoal.designPatterns.behavioral.templateMethod;

import com.bakigoal.designPatterns.behavioral.templateMethod.impl.BrickHouse;
import com.bakigoal.designPatterns.behavioral.templateMethod.impl.WoodenHouse;

/**
 * Created by ilmir on 21.06.16.
 */
public class HousingClient {
	public static void main(String[] args) {
		HouseTemplate houseType = new WoodenHouse();
		//using template method
		houseType.buildHouse();
		System.out.println("************");

		houseType = new BrickHouse();

		houseType.buildHouse();

	}
}
