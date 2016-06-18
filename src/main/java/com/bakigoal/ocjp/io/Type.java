package com.bakigoal.ocjp.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by ilmir on 16.04.16.
 * a text file name(s) as argument, it prints the content of the text file(s) on console
 */
public class Type {
	public static void main(String[] files) {
		if (files.length == 0) {
			System.err.println("pass the name of the file(s) as argument");
			System.exit(-1);
		}
		for (String file : files) {
			// try opening the file with FileReader
			try (FileReader inputFile = new FileReader(file)) {
				int ch = 0;
				while ((ch = inputFile.read()) != -1) {
					System.out.print((char) ch);
				}
			} catch (FileNotFoundException e) {
				System.err.printf("Cannot open the given file %s ", file);
			} catch (IOException e) {
				System.err.printf("Error when processing file %s... skipping it", file);
			}
		}
	}
}
