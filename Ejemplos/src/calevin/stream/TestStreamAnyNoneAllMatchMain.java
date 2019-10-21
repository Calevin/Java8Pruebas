package calevin.stream;

import entidades.Empleado;

public class TestStreamAnyNoneAllMatchMain {

	public static void main(String[] args) {

		allMatch();
		anyMatch();
		noneMatch();
	}

	public static void allMatch() {
		boolean todosMayores = Empleado.empleadosParaTest()
		.stream()
		.allMatch(e->e.getEdad()>21);
		
		System.out.println("Todos mayores: " + todosMayores);
	}
	
	public static void anyMatch() {
		boolean algunoSalario1666 = Empleado.empleadosParaTest()
		.stream()
		.peek(System.out::println)
		.anyMatch(e->e.getSalario()==1666);
		
		System.out.println("Alguno con salario 1666 " + algunoSalario1666);
	}
	
	public static void noneMatch() {
		boolean ningunoLlamadoRoberto = Empleado.empleadosParaTest()
				.stream()
				.noneMatch(e->e.getNombre().equalsIgnoreCase("Roberto"));
		
		System.out.println("No hay roberto " + ningunoLlamadoRoberto);
		
	}
}
