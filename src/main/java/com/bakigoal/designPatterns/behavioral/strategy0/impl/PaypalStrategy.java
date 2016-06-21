package com.bakigoal.designPatterns.behavioral.strategy0.impl;

import com.bakigoal.designPatterns.behavioral.strategy0.PaymentStrategy;

/**
 * Created by ilmir on 21.06.16.
 */
public class PaypalStrategy implements PaymentStrategy {

	private String emailId;
	private String password;

	public PaypalStrategy(String email, String pwd) {
		this.emailId = email;
		this.password = pwd;
	}

	@Override
	public void pay(int amount) {
		System.out.println(amount + " paid using Paypal.");
	}
}
