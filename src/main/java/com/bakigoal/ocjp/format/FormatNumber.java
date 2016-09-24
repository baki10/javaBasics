package com.bakigoal.ocjp.format;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * Created by ilmir on 17.04.16.
 */
public class FormatNumber {
	public static void main(String[] args) {
		long tenMillion = 10_000_000L;
		// first print ten million in German locale
		NumberFormat russianFormat = NumberFormat.getInstance(new Locale("ru", "RU", ""));
		String localizedTenMillion = russianFormat.format(tenMillion);
		System.out.println(tenMillion + " in Russian locale is " + localizedTenMillion);

		// now, scan the value ten million given in German locale
		try {
			Number parsedAmount = russianFormat.parse(localizedTenMillion);
			if (tenMillion == parsedAmount.longValue()) {
				System.out.println(localizedTenMillion + " parsed back to number: " + parsedAmount);
			}
		} catch (ParseException pe) {
			System.err.println("Error: Cannot parse the number for the locale");
		}
	}
}
