package com.bakigoal.designPatterns.behavioral.strategy1;

import com.bakigoal.designPatterns.behavioral.strategy1.impl.AddStrategy;
import com.bakigoal.designPatterns.behavioral.strategy1.impl.MultiplyStrategy;
import com.bakigoal.designPatterns.behavioral.strategy1.impl.SubtractStrategy;

/**
 * tutorialspoint example
 * <b>Strategy pattern</b> is one of the <i>behavioral design pattern</i>.
 * Strategy pattern is used when we have multiple algorithm for a specific task
 * and client decides the actual implementation to be used at runtime.
 *
 * Created by ilmir on 21.06.16.
 */
public class StrategyPatternDemo {

	public static void main(String[] args) {
		Context context = new Context();

		context.setStrategy(new AddStrategy());
		System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

		//we can dynamically change strategy
		context.setStrategy(new SubtractStrategy());
		System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

		context.setStrategy(new MultiplyStrategy());
		System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
	}
}
