package com.bakigoal.ocjp.strings;

/**
 * %b   Boolean
 * %c   Character
 * %d   Decimal integer (signed)
 * %e   Floating point number in scientific format
 * %f   Floating point numer in decimal format
 * %g   Floating point numer in decimal or scientific format (depending on the value passed as argument)
 * %h   Hashcode of the passed argument
 * %n   Line separator (new line character)
 * %o   Integer formatted as an octal value
 * %s   String
 * %thread   Date/time
 * %x   Integer formatted as an hexadecimal value
 */
public class FormatString {
	static void line() {
		System.out.println("-----------------------------------------------------------------");
	}

	static void printHeader() {
		System.out.printf("%-25s \t %s \t %s \t %s \n",
				"Player", "Matches", "Goals", "Goals per match");

	}

	static void printRow(String player, int matches, int goals) {
		System.out.printf("%-25s \t %5d \t\t %d \t\t %6.2f \n",
				player, matches, goals, ((float) goals / (float) matches));
	}

	public static void main(String[] str) {
		FormatString.line();
		FormatString.printHeader();
		FormatString.line();
		FormatString.printRow("Ronaldo", 100, 122);
		FormatString.printRow("Messi", 80, 100);
		FormatString.printRow("Pele", 1200, 1100);
		FormatString.printRow("Baki", 180, 300);
		FormatString.line();
	}
}
