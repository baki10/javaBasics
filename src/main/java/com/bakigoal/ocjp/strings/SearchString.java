package com.bakigoal.ocjp.strings;

public class SearchString {
	public static void main(String[] args) {
		String str = "I am a student. And I am preparing for OCPJP";
		System.out.println("Character J at index: " + str.indexOf('J'));
		lineBreak();

		System.out.println("Substring \"for\" at index: " + str.indexOf("for"));
		lineBreak();

		System.out.println("If nothing found, the result is: " + str.indexOf("not found"));
		lineBreak();

		int fromIndex = 0;
		while (str.indexOf("am", fromIndex) != -1) {
			fromIndex = str.indexOf("am", fromIndex);
			System.out.println("\"am\" at index: " + fromIndex);
			fromIndex++;
		}
		lineBreak();

		String chat = "Tarzan: Hi Jane, wanna ride an Elephant? \nJane: No thanks! I'm preparing for OCPJP now!";
		String matchString = "Jane: No thanks!";
		int startIndex = chat.indexOf("\n");
		System.out.println("Jane's response starts at the index: " + startIndex);
		if (startIndex != -1) {
			boolean doesMatch = chat.regionMatches(startIndex + 1, matchString, 0, matchString.length());
			if (doesMatch) {
				System.out.println("Jane's response matches with the string: " + matchString);
			}
		}
	}

	static void lineBreak() {
		System.out.println("-----------------------------------------");
	}
}
