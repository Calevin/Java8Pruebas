package calevin.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TestIOStreamMain {

	public static void main(String[] args) {
		try (Stream<Path> streamPaths = Files.walk(Paths.get("./src"))) {
			
			streamPaths
			.peek(System.out::println)
			.map(Path::toFile)
			.filter(File::isFile)
			.map(File::getName)
			.forEach(System.out::println);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
