package com.bakigoal.ocjp.nio;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by ilmir on 16.04.16.
 */
public class FileTreeWalkFind {
	public static void main(String[] args) {
		Path startPath = Paths.get("src");
		String pattern = "glob:File*.java";
		try {
			Files.walkFileTree(startPath, new MyFileFindVisitor(pattern));
			System.out.println("File search completed!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	private static class MyFileFindVisitor implements FileVisitor<Path> {
		private PathMatcher matcher;

		MyFileFindVisitor(String pattern) {
			try {
				matcher = FileSystems.getDefault().getPathMatcher(pattern);
			} catch (IllegalArgumentException iae) {
				System.err.println("Invalid pattern; did you forget to prefix \"glob:\"? (as in  glob:*.java)");
				System.exit(-1);
			}
		}

		private void find(Path path) {
			Path name = path.getFileName();
			if (matcher.matches(name))
				System.out.println("Matching file:" + path.getFileName());
		}

		@Override
		public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
			find(dir);

			return FileVisitResult.CONTINUE;
		}

		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
			find(file);
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
