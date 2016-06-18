package com.bakigoal.ocjp.nio;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Essentially, what you are doing is quite simple: in the preVisitDirectory() method, you are copying the
 * directory (which is being visited). To retrieve the new destination path, you are using the relativize() method from
 * the Path class. Similarly, you get a new destination path each time you visit a file, which is used to copy the file to the
 * destination directory. That’s it. You’re done!
 * Created by ilmir on 16.04.16.
 */
public class FileTreeWalkCopy {
	public static void main(String[] args) {
		Path pathSource = Paths.get("src");
		Path pathDestination = Paths.get("src2");
		try {
			Files.walkFileTree(pathSource, new MyFileCopyVisitor(pathSource, pathDestination));
			System.out.println("Files copied successfully!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static class MyFileCopyVisitor implements FileVisitor<Path> {
		private Path source;
		private Path destination;

		MyFileCopyVisitor(Path pathSource, Path pathDestination) {
			source = pathSource;
			destination = pathDestination;
		}

		private void copy(Path path) {
			Path newd = destination.resolve(source.relativize(path));
			try {
				Files.copy(path, newd, StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
			copy(dir);
			return FileVisitResult.CONTINUE;
		}

		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
			copy(file);
			return FileVisitResult.CONTINUE;
		}

		@Override
		public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
			return FileVisitResult.TERMINATE;
		}

		@Override
		public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
			return FileVisitResult.CONTINUE;
		}
	}
}
