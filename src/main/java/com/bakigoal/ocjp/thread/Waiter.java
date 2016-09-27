package com.bakigoal.ocjp.thread;

/**
 * Created by ilmir on 17.04.16.
 */
public class Waiter extends Thread {
	public void getCoffee() {
		synchronized (CoffeeMachine.lock) {
			if (CoffeeMachine.coffeeMade == null) {
				try {
					System.out.println("Waiter: Will get orders till coffee machine notifies me ");
					CoffeeMachine.lock.wait();
				} catch (InterruptedException ie) {
					ie.printStackTrace();
				}
			}
			System.out.println("Waiter: Delivering " + CoffeeMachine.coffeeMade);
			CoffeeMachine.coffeeMade = null;
			// ask (notify) the coffee machine to prepare the next coffee
			CoffeeMachine.lock.notifyAll();
			System.out.println("Waiter: Notifying coffee machine to make another one");
		}
	}

	@Override
	public void run() {
		// keep going till the user presses ctrl-C and terminates the program
		while (true) {
			getCoffee();
		}
	}
}
