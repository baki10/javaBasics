package com.bakigoal.designPatterns.behavioral.mediator;

/**
 * Mediator pattern is used to reduce communication complexity between multiple objects or classes.
 * This pattern provides a mediator class which normally handles all the communications between different classes
 * and supports easy maintenance of the code by loose coupling.
 * <p>
 * Created by ilmir on 24.06.16.
 */
public class Demo {

	public static void main(String[] args) throws InterruptedException {
		new Demo().test();
	}

	private void test() throws InterruptedException {
		ChatMediator mediator = new ChatMediator();

		User baki = new User(mediator, "Baki");
		User aliya = new User(mediator, "Aliya");
		User ildar = new User(mediator, "Ildar");
		User zarina = new User(mediator, "Zarina");

		baki.sendMessage("Hi!");
		Thread.sleep(1000);
		mediator.removeUser(ildar);
		aliya.sendMessage("Hello!");
		Thread.sleep(500);
		aliya.sendMessage("How r u?");
		mediator.removeUser(zarina);
		Thread.sleep(2000);
		baki.sendMessage("Fine! How about u?");
		Thread.sleep(1000);
		aliya.sendMessage("I am also fine! Thanks ;*");
	}
}
