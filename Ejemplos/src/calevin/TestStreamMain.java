package calevin;

import java.util.Arrays;
import java.util.List;

public class TestStreamMain {

	public static void main(String[] args) {
		List<Integer> numeros = Arrays.asList(1, 2, 3, 4 , 5 );
		
		sumaDeCuadradosOld(numeros);
		System.out.println("Con stream");
		sumaDeCuadradosConStream(numeros);
	}

	public static void sumaDeCuadradosOld(List<Integer> numeros) {
		
		int suma = 0;
		for (Integer num : numeros) {
			if(num % 2 == 1) {
				int cuadrado = num * num;
				System.out.println("Cuadrado de " + num + " es " + cuadrado);
				suma = suma + cuadrado;
			}
		}
		
		System.out.println("Numeros: " + suma);
	}
	
	public static void sumaDeCuadradosConStream(List<Integer> numeros) {
		int suma = (int) numeros.stream()
				.filter(n -> n % 2 == 1)
				.map(n -> n * n)
				.reduce(0, Integer::sum);
		
		Integer.sum(1, 2);
		
		System.out.println("Numeros: " + suma);
	}
}
