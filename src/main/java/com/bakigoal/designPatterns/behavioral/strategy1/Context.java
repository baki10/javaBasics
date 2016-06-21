package com.bakigoal.designPatterns.behavioral.strategy1;

/**
 * Created by ilmir on 21.06.16.
 */
public class Context {
	private Strategy strategy;

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	public int executeStrategy(int num1, int num2) {
		return strategy.doOperation(num1, num2);
	}
}
