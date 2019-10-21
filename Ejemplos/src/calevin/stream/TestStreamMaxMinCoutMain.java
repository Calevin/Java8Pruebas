package calevin.stream;

import java.util.OptionalInt;
import java.util.OptionalLong;

import entidades.Empleado;

public class TestStreamMaxMinCoutMain {

	public static void main(String[] args) {

		salarioMax();
		salarioMin();
		salarioCount();
	}

	public static void salarioMax() {
		OptionalInt salarioMax = Empleado.empleadosParaTest()
		.stream()
		.mapToInt(e->e.getSalario())
		.max();

		System.out.println(salarioMax.isPresent()?salarioMax.getAsInt():"NADA");		
	}
	
	public static void salarioMin() {
		OptionalInt salarioMax = Empleado.empleadosParaTest()
		.stream()
		.mapToInt(e->e.getSalario())
		.min();

		System.out.println(salarioMax.isPresent()?salarioMax.getAsInt():"NADA");		
	}
	
	public static void salarioCount() {
		OptionalLong salarioCount = OptionalLong.of(Empleado.empleadosParaTest()
		.stream()
		//.mapToInt(e->e.getSalario())
		.count());

		System.out.println(salarioCount.isPresent()?salarioCount.getAsLong():"NADA");		
	}	
}
