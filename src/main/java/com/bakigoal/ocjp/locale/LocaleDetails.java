package com.bakigoal.ocjp.locale;

import java.util.Locale;

/**
 * Created by ilmir on 17.04.16.
 */
public class LocaleDetails {
	public static void main(String args[]) {
//		Locale.setDefault(Locale.CHINA);
		Locale.setDefault(new Locale.Builder().setLanguage("ru").setRegion("RU").build());
//		Locale.setDefault(new Locale("ru","RU"));
		Locale defaultLocale = Locale.getDefault();
		System.out.printf("The default locale is %s %n", defaultLocale);
		System.out.printf("The default language code is %s and the name is %s %n",
				defaultLocale.getLanguage(), defaultLocale.getDisplayLanguage());
		System.out.printf("The default country code is %s and the name is %s %n",
				defaultLocale.getCountry(), defaultLocale.getDisplayCountry());
		System.out.printf("The default variant code is %s and the name is %s %n",
				defaultLocale.getVariant(), defaultLocale.getDisplayVariant());
	}
}
