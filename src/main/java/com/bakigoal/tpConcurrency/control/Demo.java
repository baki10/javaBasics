package com.bakigoal.tpConcurrency.control;

/**
 * Created by ilmir on 01.06.16.
 */
public class Demo {
	public static void main(String args[]) {

		MyRunnable R1 = new MyRunnable("Thread-1");
		R1.start();

		MyRunnable R2 = new MyRunnable("Thread-2");
		R2.start();

		try {
			Thread.sleep(1000);
			R1.suspend();
			System.out.println("Suspending First Thread");
			Thread.sleep(1000);
			R1.resume();
			System.out.println("Resuming First Thread");
			R2.suspend();
			System.out.println("Suspending thread Two");
			Thread.sleep(1000);
			R2.resume();
			System.out.println("Resuming thread Two");
		} catch (InterruptedException e) {
			System.out.println("ShoppingCartTest thread Interrupted");
		}
		try {
			System.out.println("Waiting for threads to finish.");
			R1.thread.join();
			R2.thread.join();
		} catch (InterruptedException e) {
			System.out.println("ShoppingCartTest thread Interrupted");
		}
		System.out.println("ShoppingCartTest thread exiting.");
	}
}
