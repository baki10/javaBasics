package com.bakigoal.ocjp.locale;

import java.util.ListResourceBundle;

/**
 * Created by ilmir on 17.04.16.
 */
public class Messages extends ListResourceBundle {
	@Override
	protected Object[][] getContents() {
		return contents;
	}

	static final Object[][] contents = {
			{"MovieName", "Avatar"},
			{"GrossRevenue", (Long) 2782275172L}, // in US dollars
			{"Year", (Integer) 2009}
	};
}
