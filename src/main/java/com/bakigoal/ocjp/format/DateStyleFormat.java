package com.bakigoal.ocjp.format;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by ilmir on 17.04.16.
 */
public class DateStyleFormat {
	public static void main(String[] args) {
		Date now = new Date();
		int[] dateStyleFormats = {DateFormat.SHORT, DateFormat.MEDIUM, DateFormat.LONG, DateFormat.FULL, DateFormat.DEFAULT};
		String[] types = {"DateFormat.SHORT", "DateFormat.MEDIUM", "DateFormat.LONG", "DateFormat.FULL", "DateFormat.DEFAULT"};
		System.out.println("Today's date in different styles are: ");

		Locale locale = new Locale("ru", "RU");
		for (int i = 0; i < dateStyleFormats.length; i++) {
			int dateStyleFormat = dateStyleFormats[i];
			DateFormat dateFormat = DateFormat.getDateInstance(dateStyleFormat, locale);
			System.out.printf("%-20s%s%n", types[i], dateFormat.format(now));
		}
	}
}
