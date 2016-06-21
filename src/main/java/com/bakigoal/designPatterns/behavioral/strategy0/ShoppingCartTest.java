package com.bakigoal.designPatterns.behavioral.strategy0;

import com.bakigoal.designPatterns.behavioral.strategy0.impl.CreditCardStrategy;
import com.bakigoal.designPatterns.behavioral.strategy0.impl.PaypalStrategy;

/**
 * <b>Strategy pattern</b> is one of the <i>behavioral design pattern</i>.
 * Strategy pattern is used when we have multiple algorithm for a specific task
 * and client decides the actual implementation to be used at runtime.
 * <p>
 * One of the best example of this pattern is <b>Arrays.sort()</b> method that takes Comparator parameter.
 * Based on the different implementations of Comparator interfaces, the Objects are getting sorted in different ways
 * <p>
 * Created by ilmir on 21.06.16.
 */
public class ShoppingCartTest {

	public static void main(String[] args) {
		ShoppingCart cart = new ShoppingCart();

		Item item1 = new Item("1234", 10);
		Item item2 = new Item("5678", 40);

		cart.addItem(item1);
		cart.addItem(item2);

		//pay by paypal
		cart.pay(new PaypalStrategy("bakigoal@gmail.com", "pswd"));

		//pay by credit card
		cart.pay(new CreditCardStrategy("Baki Goal", "1234567890123456", "786", "12/17"));

	}
}
