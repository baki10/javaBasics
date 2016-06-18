package com.bakigoal.tpConcurrency.chat;

/**
 * Created by ilmir on 31.05.16.
 */
public class Chat {
	private boolean flag;

	public synchronized void question(String msg) {
		if (flag) {
			waitForAwake();
		}
		sleep(1000);
		System.out.println(msg);
		flag = true;
		notify();
	}

	public synchronized void answer(String msg){
		if(!flag){
			waitForAwake();
		}
		sleep(1500);
		System.out.println(msg);
		flag = false;
		notify();
	}

	private void waitForAwake() {
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void sleep(int time) {
		try {
			System.out.println("-----------------------------");
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
