package com.bakigoal.ocjp.locale;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by ilmir on 17.04.16.
 */
public class LocalizedHello {
	public static void main(String args[]) throws UnsupportedEncodingException {
		Locale ruLocale = new Locale("ru", "RU");
		Locale locale = Locale.getDefault();

		System.out.println("-------resources from Messages class--------");
		movieInfo(locale);
		movieInfo(ruLocale);

		System.out.println("-------resources from message.properties--------");
		hello(locale);
		hello(ruLocale);
		hello(new Locale("ar"));

	}

	private static void movieInfo(Locale locale) {
		printMovieDetails(ResourceBundle.getBundle("Messages", locale));
	}

	private static void hello(Locale locale) throws UnsupportedEncodingException {
		Locale.setDefault(locale);
		ResourceBundle resourceBundle = ResourceBundle.getBundle("message", Locale.getDefault());
		String bundleGreeting = resourceBundle.getString("Greeting");
		String greeting = new String(bundleGreeting.getBytes("ISO-8859-1"), "UTF-8");
		System.out.printf(greeting);
		System.out.println();
	}

	public static void printMovieDetails(ResourceBundle resBundle) {
		String movieName = resBundle.getString("MovieName");
		Long revenue = (Long) (resBundle.getObject("GrossRevenue"));
		Integer year = (Integer) resBundle.getObject("Year");
		System.out.println("Movie " + movieName + "(" + year + ")" + " grossed " + revenue);
	}
}
