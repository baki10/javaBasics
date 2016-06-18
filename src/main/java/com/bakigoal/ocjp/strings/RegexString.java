package com.bakigoal.ocjp.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.bakigoal.ocjp.strings.SearchString.lineBreak;

/**
 * ^expr      Matches expr at beginning of line
 * expr$      Matches expr at end of line
 * .          Matches any single character(except new line character)
 * [xyz]      Matches either x, y, or z
 * [p-z1-9]   Matches either any character from p to z or any digit from 1 to 9
 * [^p-z]     Matches any character except characters p to z
 * x|y        Matches either x or y
 * <p>
 * \d         Matches digits (equivalent to [0–9])
 * \D         Matches non-digits
 * \w         Matches word characters
 * \W         Matches non-word characters
 * \s         Matches whitespaces (equivalent to [\thread\r\f\n])
 * \S         Matches non-whitespaces
 * \b         Matches word boundary when outside bracket. Matches backslash when inside bracket.
 * \B         Matches non-word boundary.
 * \A         Matches beginning of string
 * \Z         Matches end of string
 * <p>
 * expr?      Matches 0 or 1 occurrence of expr (equivalent to expr{0,1})
 * expr*      Matches 0 or more occurrences of expr (equivalent to expr{0,}).
 * expr+      Matches 1 or more occurrences of expr (equivalent to expr{1,}).
 * expr{x}    Matches x occurrences of expr.
 * expr{x,y}  Matches between x and y occurrences of expr.
 * expr{x,}   Matches x or more occurrences of expr.
 */
public class RegexString {

	public static void main(String[] args) {
		new RegexString().test();
	}

	private void test() {
		String str = "Danny Doo, Flat no 502, Big Apartment, Wide Road, Near Huge Milestone, Hugo-city " +
				"56010, Ph: 9876543210, Email: danny@myworld.com. Maggi Myer, Post bag no 52, Big bank post office, " +
				"Big bank city 56000, ph: 9876501234, Email: maggi07@myuniverse.com.";
		printMatches(str, "\\w+");
		lineBreak();
		printMatches(str, "\\d+");
		lineBreak();
		printMatches(str, "\\d{5}");
		lineBreak();
		printMatches(str, "\\D\\d{5}\\D");
		lineBreak();
		printMatches(str, "\\b\\d{5}\\b");  //zip codes
		lineBreak();
		printMatches(str, "\\b\\d{10}\\b"); //phone numbers
		lineBreak();
		printMatches(str, "\\w+@\\w+\\.\\w{3}"); //email
		lineBreak();
		modifyPhoneNumbers(str);
		lineBreak();
		validateIpAddress("255.245.188.123");
		validateIpAddress("255.245.188.273");
	}

	private void printMatches(String str, String regex) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {
			System.out.println(matcher.group());
		}
	}

	private void modifyPhoneNumbers(String str) {
		Pattern pattern = Pattern.compile("(\\D)(\\d{3})(\\d{7})(\\D)");
		Matcher matcher = pattern.matcher(str);
		String newStr = matcher.replaceAll("$1$2-$3$4");
		System.out.println(newStr);
	}

	private void validateIpAddress(String ip) {
		String regex = "\\b((25[0–5]|2[0–4]\\d|[01]?\\d\\d?)(\\.)){3}(25[0–5]|2[0–4]\\d|[01]?\\d\\d?)\\b";
		boolean matches = Pattern.matches(regex, ip);
		System.out.println(ip + " is " + (matches ? "" : "NOT ") + "valid");
	}
}
