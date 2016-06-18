package com.bakigoal.ocjp.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by ilmir on 16.04.16.
 */
public class FileAttributes {
	public static void main(String[] args) {
		Path path = Paths.get("src/main/java/com/bakigoal/nio/FileAttributes.java");
		try {
			printPathAttribute("creationTime", path);
			printPathAttribute("lastModifiedTime", path);
			printPathAttribute("basic:size", path);         //view:attribute format
			printPathAttribute("size", path);               //If no view is specified, the view is assumed as basic
			printPathAttribute("dos:hidden", path);
			printPathAttribute("isDirectory", path);

		} catch (IOException e) {
			System.err.println("Error: " + e.getLocalizedMessage());
		}

		System.out.println("--------------Read attributes--------------");
		try {
			BasicFileAttributes fileAttributes = Files.readAttributes(path, BasicFileAttributes.class);

			printLine("File size: ", fileAttributes.size());
			printLine("isDirectory: ", fileAttributes.isDirectory());
			printLine("isRegularFile: ", fileAttributes.isRegularFile());
			printLine("isSymbolicLink: ", fileAttributes.isSymbolicLink());
			printLine("File last accessed time: ",fileAttributes.lastAccessTime());
			printLine("File last modified time: ", fileAttributes.lastModifiedTime());
			printLine("File creation time: ", fileAttributes.creationTime());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void printPathAttribute(String attributeName, Path path) throws IOException {
		Object context = Files.getAttribute(path, attributeName, LinkOption.NOFOLLOW_LINKS);
		printLine(attributeName, context);
	}

	private static void printLine(String title, Object context) {
		System.out.printf("%-25s \t %s \n", title, context);
	}
}
