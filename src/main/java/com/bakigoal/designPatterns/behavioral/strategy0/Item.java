package com.bakigoal.designPatterns.behavioral.strategy0;

/**
 * Created by ilmir on 21.06.16.
 */
public class Item {
	private String upcCode;
	private int price;

	public Item(String upc, int cost) {
		this.upcCode = upc;
		this.price = cost;
	}

	public String getUpcCode() {
		return upcCode;
	}

	public int getPrice() {
		return price;
	}
}
