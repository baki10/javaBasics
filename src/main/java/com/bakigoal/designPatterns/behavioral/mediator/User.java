package com.bakigoal.designPatterns.behavioral.mediator;

/**
 * Created by ilmir on 24.06.16.
 */
public class User {

	private ChatMediator mediator;
	private String name;

	public User(ChatMediator chatMediator, String name) {
		this.mediator = chatMediator;
		this.name = name;
		mediator.addUser(this);
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return this.name;
	}

	public void sendMessage(String message) {
		System.out.println(this.name + ": Sending Message=" + message);
		mediator.sendMessage(this, message);
	}

	public void receiveMessage(String msg) {
		System.out.println(this.name + ": Received Message:" + msg);
	}
}
