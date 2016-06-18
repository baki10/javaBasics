package com.bakigoal.ocjp.nio;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by ilmir on 16.04.16.
 */
public class FileTreeWalk {
	public static void main(String[] args) {
		Path pathSource = Paths.get("src");
		try {
			Files.walkFileTree(pathSource, new MyFileVisitor());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static class MyFileVisitor implements FileVisitor<Path> {
		@Override
		public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
			System.out.println("----------Directory name:" + dir + "----------");
			return FileVisitResult.CONTINUE;
		}

		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
			System.out.println("file name:" + file.getFileName());
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
