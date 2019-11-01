package calevin.strings;

import java.util.regex.Pattern;

public class TestPatternMain {

	public static void main(String[] args) {
		String nombres = "Sebastian, Jose, Mauro";
		
		Pattern.compile(", ")
	    .splitAsStream(nombres)
	    .map(String::toUpperCase)
	    .forEach(System.out::println);
	}

}
