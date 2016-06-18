package com.bakigoal.ocjp.format;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by ilmir on 17.04.16.
 */
public class CustomDatePatterns {
	public static void main(String[] args) {
		// patterns from simple to complex ones
		String[] dateFormats = {
				"dd-MM-yyyy", /* d is day (in month), M is month, y is year */
				"d '('E')' MMM, YYYY", /*E is name of the day (in week), Y is year*/
				"w'-я неделя' YYYY' года'", /* w is the week of the year */
				"EEEE, dd'th' MMMM, YYYY" /*E is day name in the week */
		};
		Date today = new Date();
		Locale ru_RU = new Locale("ru", "RU");
		System.out.println("Default format for the date is " + DateFormat.getDateInstance(DateFormat.DEFAULT, ru_RU).format(today));
		for (String dateFormat : dateFormats) {
			System.out.printf("Date in pattern %-30s%s %n", "\"" + dateFormat + "\"",
					new SimpleDateFormat(dateFormat, ru_RU).format(today));
		}
	}
}
