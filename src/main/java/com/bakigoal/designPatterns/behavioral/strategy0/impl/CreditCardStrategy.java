package com.bakigoal.designPatterns.behavioral.strategy0.impl;

import com.bakigoal.designPatterns.behavioral.strategy0.PaymentStrategy;

/**
 * Created by ilmir on 21.06.16.
 */
public class CreditCardStrategy implements PaymentStrategy {

	private String name;
	private String cardNumber;
	private String cvv;
	private String dateOfExpire;

	public CreditCardStrategy(String name, String cardNumber, String cvv, String dateOfExpire) {
		this.name = name;
		this.cardNumber = cardNumber;
		this.cvv = cvv;
		this.dateOfExpire = dateOfExpire;
	}

	@Override
	public void pay(int amount) {
		System.out.println(amount + " paid with credit card");
	}
}
