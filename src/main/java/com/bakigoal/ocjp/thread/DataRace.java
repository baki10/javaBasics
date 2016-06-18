package com.bakigoal.ocjp.thread;

/**
 * Created by ilmir on 17.04.16.
 */
// This class exposes a publicly accessible counter
// to help demonstrate data race problem
class Counter {
	static long count = 0;
}

// This class implements Runnable interface
// Its run method increments the counter three times
class UseCounter implements Runnable {
	private void increment() {
		// increments the counter and prints the value
		// of the counter shared between threads
		synchronized (this) {
			Counter.count++;
			System.out.print(Counter.count + " ");
		}
	}

	public void run() {
		increment();
		increment();
		increment();
	}
}

// This class creates three threads
public class DataRace {
	public static void main(String args[]) {
		UseCounter c = new UseCounter();
		Thread t1 = new Thread(c);
		Thread t2 = new Thread(c);
		Thread t3 = new Thread(c);
		t1.start();
		t2.start();
		t3.start();
	}
}
