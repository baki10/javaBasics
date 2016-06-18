package com.bakigoal.thinkingInJava.generics;

import java.util.HashSet;
import java.util.Set;

/**
 * Do your best to eliminate unchecked warnings. If you can’thread eliminate an
 * unchecked warning and you can prove that the code that provoked it is typesafe,
 * suppress the warning with an @SuppressWarnings("unchecked") annotation in
 * the narrowest possible scope.
 * Every time you use an @SuppressWarnings("unchecked") annotation,
 * add a comment saying why it’s safe to do so.
 * <p>
 * Created by ilmir on 22.05.16.
 */
public class Warnings {
	public static void main(String[] args) {
		Warnings warnings = new Warnings();
		warnings.test();
	}

	private void test() {
		Set<Long> longs = new HashSet();
		// This cast is correct because the ...
		@SuppressWarnings("unchecked")
		Set<Long> longs1 = new HashSet();

		Set<Long> longs2 = new HashSet<>();
	}
}
