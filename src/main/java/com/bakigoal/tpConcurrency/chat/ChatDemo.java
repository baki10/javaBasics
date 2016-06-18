package com.bakigoal.tpConcurrency.chat;

/**
 * Created by ilmir on 31.05.16.
 */
public class ChatDemo {
	public static void main(String[] args) {
		Chat chat = new Chat();
		new T1(chat);
		new T2(chat);
	}
}
