package com.bakigoal.ocjp.nio;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Created by ilmir on 16.04.16.
 */
public class FileCopy {
	public static void main(String[] args) {
		Path pathSource = Paths.get("src/main/java/com/bakigoal/nio/FileCopy.java");
		Path pathDestination = Paths.get("CopyOfFileCopy.java");
		try {
			copy(pathSource, pathDestination);
		} catch (FileAlreadyExistsException e) {
			System.err.println("File already exists, I gonna overwrite it!");
			copyOverwrite(pathSource, pathDestination);
		}

		Path newPath = Paths.get("/home/ilmir/FileCopy.java");
		moveFile(pathDestination, newPath);
	}

	private static void moveFile(Path pathSource, Path pathDestination) {
		try {
			Files.move(pathSource, pathDestination, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("Source file moved successfully");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void copyOverwrite(Path pathSource, Path pathDestination) {
		try {
			Files.copy(pathSource, pathDestination, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("Source file copied successfully");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void copy(Path pathSource, Path pathDestination) throws FileAlreadyExistsException {
		try {
			Files.copy(pathSource, pathDestination);
			System.out.println("Source file copied successfully");
		} catch (FileAlreadyExistsException e) {
			throw new FileAlreadyExistsException(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
