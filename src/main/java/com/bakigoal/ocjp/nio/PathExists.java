package com.bakigoal.ocjp.nio;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by ilmir on 16.04.16.
 */
public class PathExists {
	public static void main(String[] args) {
		Path path = Paths.get("build.gradle");

		if (Files.exists(path, LinkOption.NOFOLLOW_LINKS)) {
			System.out.println("The file/directory " + path.getFileName() + " exists");
			// check whether it is a file or a directory
			if (Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS)) {
				System.out.println(path.getFileName() + " is a directory");
			} else {
				System.out.println(path.getFileName() + " is a file");
			}
		} else {
			System.out.println("The file/directory " + path.getFileName() + " does not exist");
		}
	}
}
