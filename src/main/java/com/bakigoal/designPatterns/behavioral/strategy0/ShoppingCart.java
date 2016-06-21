package com.bakigoal.designPatterns.behavioral.strategy0;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ilmir on 21.06.16.
 */
public class ShoppingCart {

	private List<Item> items;

	public ShoppingCart() {
		this.items = new ArrayList<>();
	}

	public void addItem(Item item) {
		this.items.add(item);
	}

	public void removeItem(Item item) {
		this.items.remove(item);
	}

	public int calculateTotal() {
		int sum = 0;
		for (Item item : items) {
			sum += item.getPrice();
		}
		return sum;
	}

	public void pay(PaymentStrategy paymentStrategy){
		int total = calculateTotal();
		paymentStrategy.pay(total);
	}
}
