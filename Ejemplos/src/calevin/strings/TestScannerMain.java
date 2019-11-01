package calevin.strings;

import java.util.Scanner;
import java.util.stream.IntStream;

public class TestScannerMain {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in);) {
			String entradaTeclado = sc.nextLine();
			
			IntStream streamChars = entradaTeclado.chars();
			
			streamChars
				.map(n -> (char)n)
				.filter(c -> !Character.isDigit((char) c))
			    .filter(c -> !Character.isWhitespace((char) c))
				.forEach(c -> System.out.print((char) c));
		} catch (Exception e) {
		}
	}
}
