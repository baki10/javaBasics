package com.bakigoal.tpConcurrency.guess;

/**
 * Created by ilmir on 29.05.16.
 */
public class DisplayMessage implements Runnable {

	private String message;

	public DisplayMessage(String message) {
		this.message = message;
	}

	@Override
	public void run() {
		while (true){
			System.out.println(message);
		}
	}
}
