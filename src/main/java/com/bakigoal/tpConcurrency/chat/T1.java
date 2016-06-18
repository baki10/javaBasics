package com.bakigoal.tpConcurrency.chat;

/**
 * Created by ilmir on 31.05.16.
 */
public class T1 implements Runnable {

	private Chat chat;
	private String[] s1 = {"Hello", "How are you?", "I am also doing fine!"};

	public T1(Chat chat) {
		this.chat = chat;
		new Thread(this, "Question").start();
	}

	@Override
	public void run() {
		for (String msg : s1) {
			chat.question(msg);
		}
	}
}
