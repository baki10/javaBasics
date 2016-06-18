package com.bakigoal.ocjp.format;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by ilmir on 17.04.16.
 */
public class CustomTimePattern {
	public static void main(String[] args) {
		// patterns from simple to complex ones
		String[] timeFormats = {
				"h:mm", /* h is hour in am/pm (1-12), m is minute */
				"H 'часов' mm 'минут'", /* '' is the escape sequence to print a single quote */
				"H:mm a", /* H is hour in day (0-23), a is am/pm*/
				"hh:mm:ss:SS", /* s is seconds, S is milliseconds */
				"K:mm:ss a, zzzz" /*K is hour in am/pm(0-11), z is time zone */
		};
		Date today = new Date();
		Locale ru_RU = new Locale("ru", "RU");
		System.out.println("Default format for the time is " + DateFormat.getTimeInstance(DateFormat.DEFAULT, ru_RU).format(today));
		for (String timeFormat : timeFormats) {
			System.out.printf("Time in pattern %-30s%s %n", "\"" + timeFormat + "\"",
					new SimpleDateFormat(timeFormat, ru_RU).format(today));
		}
	}
}
