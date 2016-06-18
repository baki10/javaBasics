package com.bakigoal.ocjp.nio;

import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Class to illustrate how to use Path interface and its methods
 * <p>
 * Created by ilmir on 16.04.16.
 */
public class PathInfo {

	private static void line(){
		System.out.println("--------------------------------------------------");
	}

	public static void main(String[] args) throws IOException {
		// create a Path object by calling static method get() in Paths class
		Path testFilePath = Paths.get("/home/ilmir/Dropbox/Aliya_Ilmir/2дебила");
		System.out.println("Path: "+testFilePath);
		line();

		// retrieve basic information about path
		System.out.println("Printing file information: ");
		System.out.println("\t getFileName(): \t" + testFilePath.getFileName());
		System.out.println("\t getRoot(): \t\t" + testFilePath.getRoot());
		System.out.println("\t getParent(): \t\t" + testFilePath.getParent());
		line();

		// print path elements
		System.out.println("Printing elements of the path: ");
		for(Path element : testFilePath) {
			System.out.println("\t path element: " + element);
		}
		line();

		//get a path object with relative path
		Path path = Paths.get("./src");
		System.out.println("Path: "+path);
		System.out.println("1) getFileName(): " + path.getFileName());
		System.out.println("2) toUri(): " + path.toUri());
		System.out.println("3) toAbsolutePath(): " + path.toAbsolutePath());
		System.out.println("4) normalize(): " + path.normalize());

		// get another path object with normalized relative path
		Path testPathNormalized = Paths.get(path.normalize().toString());
		System.out.println("Path normalized: "+testPathNormalized);
		System.out.println("5) normalized absolute path is: " +
				testPathNormalized.toAbsolutePath());
		System.out.println("6) normalized real path is: " +
				path.toRealPath (LinkOption.NOFOLLOW_LINKS));

		line();

		Path dir = Paths.get("/home/ilmir/Dropbox/Aliya_Ilmir");
		Path resolvedPath = dir.resolve("2дебила");
		System.out.println("Resolved path: "+resolvedPath);
	}
}
