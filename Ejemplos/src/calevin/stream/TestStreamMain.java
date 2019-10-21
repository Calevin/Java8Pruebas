package calevin.stream;

import java.util.List;
import java.util.stream.Stream;

import entidades.Empleado;

public class TestStreamMain {

	public static void main(String[] args) {
		List<Empleado> listaEmpleadosParaTest = Empleado.empleadosParaTest();

		Stream<Empleado> streamEmpleados = listaEmpleadosParaTest.stream();
		
		streamEmpleados.forEach((Empleado e) -> {
			System.out.println(e.getNombre());
			System.out.println(e.getSector());
		});
		
		//listaEmpleadosParaTest.stream().forEach(e->metodoStatic(e));
	}

	public static void metodoStatic(Empleado e) {
		System.out.println("public static void " + e);
	}
}
