package com.bakigoal.designPatterns.behavioral.strategy1.impl;

import com.bakigoal.designPatterns.behavioral.strategy1.Strategy;

/**
 * Created by ilmir on 21.06.16.
 */
public class SubtractStrategy implements Strategy {
	@Override
	public int doOperation(int num1, int num2) {
		return num1 - num2;
	}
}
