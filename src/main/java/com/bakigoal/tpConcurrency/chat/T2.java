package com.bakigoal.tpConcurrency.chat;

/**
 * Created by ilmir on 31.05.16.
 */
public class T2 implements Runnable {

	private Chat chat;
	private String[] s2 = { "Hi", "I am good, what about you?", "Great!" };

	public T2(Chat chat) {
		this.chat = chat;
		new Thread(this, "T2(answer)").start();
	}

	@Override
	public void run() {
		for (String msg : s2) {
			chat.answer(msg);
		}
	}
}
