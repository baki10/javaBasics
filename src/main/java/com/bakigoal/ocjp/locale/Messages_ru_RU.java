package com.bakigoal.ocjp.locale;

import java.util.ListResourceBundle;

/**
 * Created by ilmir on 17.04.16.
 */
public class Messages_ru_RU extends ListResourceBundle {
	@Override
	protected Object[][] getContents() {
		return contents;
	}

	static final Object[][] contents = {
			{"MovieName", "Операция Ы"},
			{"GrossRevenue", (Long) 250007774560L}, // in rubles
			{"Year", (Integer) 1981}
	};
}
