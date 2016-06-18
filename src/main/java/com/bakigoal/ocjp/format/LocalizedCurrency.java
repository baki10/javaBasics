package com.bakigoal.ocjp.format;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by ilmir on 17.04.16.
 */
public class LocalizedCurrency {
	public static void main(String []args) {
		long tenMillion = 10000000L; // this is ten million
		Locale [] locales = {Locale.UK, Locale.US, Locale.FRANCE, Locale.GERMANY, Locale.CHINA, new Locale("ru","RU") };

		for(Locale locale : locales) {
			System.out.printf("Ten million in %-30s %s%n", locale.getDisplayName() + " is ",
					NumberFormat.getCurrencyInstance(locale).format(tenMillion));
		}
	}
}
