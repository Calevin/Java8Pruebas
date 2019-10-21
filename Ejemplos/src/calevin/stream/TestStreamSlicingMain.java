package calevin.stream;

import entidades.Empleado;

public class TestStreamSlicingMain {

	public static void main(String[] args) {
		Empleado.empleadosParaTest()
		.stream()
		.forEach(System.out::println);

		System.out.println("----------------------------------------");
		//Sirve para paginar
		Empleado.empleadosParaTest()
		.stream()
		.skip(3)
		.limit(4)
		.forEach(System.out::println);
	}

}
