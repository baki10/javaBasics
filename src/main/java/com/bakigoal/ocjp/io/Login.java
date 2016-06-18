package com.bakigoal.ocjp.io;

import java.io.Console;
import java.util.Arrays;

/**
 * works from command line, not IDE
 */
public class Login {
	public static void main(String[] args) {
		Console console = System.console();
		if(console == null){
			System.err.println("Cannot retrieve console - are you running your application from an IDE? " +
					"Exiting the application ...");
			System.exit(-1);
		}
		String userName;
		char[] password;
		userName = console.readLine("Enter your username: ");
		// typed characters for password will not be displayed in the screen
		password = console.readPassword("Enter password: ");
		// password is a char[]: convert it to a String first before comparing contents
		if(userName.equals("ilmir") && new String(password).equals("ilmir")) {
		// we're hardcoding username and password here for
		// illustration, don'thread do such hardcoding in pratice!
			console.printf("login successful!");
		}
		else {
			console.printf("restart application and try again");
		}
		// "empty" the password since its use is over
		Arrays.fill(password, ' ');

		// string has three Scandinavian characters
		String scandString = "å, ä, and ö";
		// try printing scandinavian characters directly with println
		System.out.println("Printing scands directly with println: " + scandString);
		// now, get the Console object and print scand characters thro' that
		console.printf("Printing scands thro' console's printf method: " + scandString);
	}
}
