package com.bakigoal.ocjp.nio;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by ilmir on 16.04.16.
 */
public class FilePermissions {
	public static void main(String[] args) {
		Path path = Paths.get("src/main/java/com/bakigoal/nio/FilePermissions.java");
		System.out.printf("Readable: %b, Writable: %b, Executable: %b ",
				Files.isReadable(path), Files.isWritable(path), Files.isExecutable(path));
	}
}
