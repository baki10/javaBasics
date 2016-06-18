package com.bakigoal.ocjp.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by ilmir on 16.04.16.
 */
public class FileDelete {
	public static void main(String[] args) {
		Path pathSource = Paths.get("/home/ilmir/FileCopy.java");
		try {
			Files.delete(pathSource);
//			Files.deleteIfExists(pathSource);
			System.out.println("File deleted successfully");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
