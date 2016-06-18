package com.bakigoal.ocjp.format;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by ilmir on 17.04.16.
 */
public class DateTimePrint {
	public static void main(String[] args) {
		Date today = new Date();
		Locale[] locales = {Locale.UK, Locale.US, Locale.FRANCE, Locale.GERMANY, Locale.CHINA, new Locale("ru", "RU")};
		// print the header first
		System.out.printf("%5s \t %10s \t %10s \t %10s %n", "Locale", "Date", "Time", "Date with Time");
		// print the date, time, and date & time for each locale
		for (Locale locale : locales) {
			DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, locale);
			DateFormat timeFormat = DateFormat.getTimeInstance(DateFormat.SHORT, locale);
			DateFormat dateTimeFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.FULL, locale);
			System.out.printf("%5s \t %10s \t %10s \t %20s %n",
					locale, dateFormat.format(today), timeFormat.format(today), dateTimeFormat.format(today));
		}
	}
}
