package com.bakigoal.ocjp.thread;

/**
 * This class instantiates two threads - CoffeeMachine and Waiter threads
 * and these two threads interact with each other through wait/notify
 * till you terminate the application explicitly by pressing Ctrl-C
 * Created by ilmir on 17.04.16.
 */
public class CoffeeShop {
	public static void main(String[] s) {
		CoffeeMachine coffeeMachine = new CoffeeMachine();
		Waiter waiter = new Waiter();
		coffeeMachine.start();
		waiter.start();
	}
}
