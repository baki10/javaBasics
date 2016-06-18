package com.bakigoal.ocjp.format;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by ilmir on 17.04.16.
 */
public class DatePrint {
	public static void main(String[] args) {
		// the default constructor for the Date
		// sets the date/time for current date/time
		Date today = new Date();
		Locale [] locales = {Locale.UK, Locale.US, Locale.FRANCE, Locale.GERMANY, Locale.CHINA, new Locale("ru","RU") };
		for (Locale locale : locales) {
			// DateFormat.FULL refers to the full details of the date
			DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, locale);
			System.out.printf("Date in locale %-20s %s%n", locale + " is: ", dateFormat.format(today));
		}
	}
}
