package com.bakigoal.ocjp.thread;

/**
 * Created by ilmir on 17.04.16.
 */
public class TimeBomb extends Thread {

	@Override
	public void run() {
		for (int i = 9; i >= 0; i--) {
			try {
				System.out.println(i);
				Thread.sleep(1000);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}

	public static void main(String[] s) {
		TimeBomb timer = new TimeBomb();
		System.out.println("Starting 10 second count down. . . ");
		timer.start();
		try {
			timer.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(">>>--- !!! Boom !!! ---<<<");
	}
}
