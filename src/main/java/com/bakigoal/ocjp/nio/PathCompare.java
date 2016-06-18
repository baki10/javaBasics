package com.bakigoal.ocjp.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * even if two Path objects point to the same file/directory, it is not guaranteed that you will get true from
 * the equals() method. You need to make sure that both are absolute and normalized paths for an equality
 * comparison to succeed for paths.
 * Created by ilmir on 16.04.16.
 */
public class PathCompare {
	public static void main(String[] args) throws IOException {

		Path path1 = Paths.get("src");
		Path path2 = Paths.get("/home/ilmir/IdeaProjects/javaTutorials/src");
		// comparing two paths using compareTo() method
		System.out.println("(path1.compareTo(path2) == 0) is: " + (path1.compareTo(path2) == 0));

		//comparing two paths using equals() method
		System.out.println("path1.equals(path2) is: " + path1.equals(path2));

		// comparing two paths using equals() method with absolute path
		System.out.println("path2.equals(path1.toAbsolutePath()) is "
				+ path2.equals(path1.toAbsolutePath()));

		// illustrates how to use Files class to compare two paths
		System.out.println("Files.isSameFile(path1, path2) is: "
				+ Files.isSameFile(path1, path2));
	}
}
