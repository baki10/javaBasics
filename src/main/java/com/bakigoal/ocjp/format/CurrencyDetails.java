package com.bakigoal.ocjp.format;

import java.util.Currency;
import java.util.Locale;

/**
 * Created by ilmir on 17.04.16.
 */
public class CurrencyDetails {
	public static void main(String[] args) {
		Locale locale = new Locale("ru","RU");
		Currency currencyInstance = Currency.getInstance(locale);
		System.out.println(" The currency code for locale " + locale + " is: " + currencyInstance.getCurrencyCode()
				+ " \n The currency symbol is " + currencyInstance.getSymbol()
				+ " \n The currency name is " + currencyInstance.getDisplayName());
	}
}
