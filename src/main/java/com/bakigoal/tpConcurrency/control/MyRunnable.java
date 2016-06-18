package com.bakigoal.tpConcurrency.control;

/**
 * Created by ilmir on 01.06.16.
 */
public class MyRunnable implements Runnable {
	public Thread thread;
	private String threadName;
	private boolean suspended;

	public MyRunnable(String name) {
		threadName = name;
		System.out.println("Creating " + threadName);
	}

	public void run() {
		System.out.println("Running " + threadName);
		try {
			for (int i = 10; i > 0; i--) {
				System.out.println("Thread: " + threadName + ", " + i);
				// Let the thread sleep for a while.
				Thread.sleep(300);
				synchronized (this) {
					while (suspended) {
						wait();
					}
				}
			}
		} catch (InterruptedException e) {
			System.out.println("Thread " + threadName + " interrupted.");
		}
		System.out.println("Thread " + threadName + " exiting.");
	}

	public void start() {
		System.out.println("Starting " + threadName);
		if (thread == null) {
			thread = new Thread(this, threadName);
			thread.start();
		}
	}

	public void suspend() {
		suspended = true;
	}

	synchronized void resume() {
		suspended = false;
		notify();
	}
}
