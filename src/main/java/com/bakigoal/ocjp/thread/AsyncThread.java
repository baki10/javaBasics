package com.bakigoal.ocjp.thread;

/**
 * Created by ilmir on 17.04.16.
 */
public class AsyncThread extends Thread {
	@Override
	public void run() {
		System.out.println("Starting the thread " + getName());
		for (int i = 0; i < 3; i++) {
			System.out.println("In thread " + getName() + "; iteration " + i);
			try {
				// sleep for sometime before the next iteration
				Thread.sleep(20);
			} catch (InterruptedException ie) {
				// we're not interrupting any threads
				// – so safe to ignore this exeception
				ie.printStackTrace();
			}
		}
	}

	public static void main(String args[]) {
		AsyncThread asyncThread1 = new AsyncThread();
		AsyncThread asyncThread2 = new AsyncThread();
		// start both the threads around the same time
		asyncThread1.start();
		asyncThread2.start();
	}
}
