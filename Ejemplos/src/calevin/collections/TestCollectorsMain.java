package calevin.collections;


import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import entidades.Empleado;

public class TestCollectorsMain {

	public static void main(String[] args) {
		Optional<Empleado> conMaxSalario = 
				Empleado.empleadosParaTest()
				.stream()
				.collect(Collectors.maxBy(Comparator.comparing(Empleado::getSalario)));

		conMaxSalario.ifPresent(System.out::println);
		
		
		Optional<Empleado> conMinSalario = 
				Empleado.empleadosParaTest()
				.stream()
				.collect(Collectors.minBy(Comparator.comparing(Empleado::getSalario)));

		conMinSalario.ifPresent(System.out::println);
		
		System.out.println("------------- Mayores/Menores de 30:");		
		Map<Boolean, List<Empleado>> mayoresEmpleados =  Empleado.empleadosParaTest()
				.stream()
				.collect(Collectors.partitioningBy(e -> e.getEdad() >= 30));
		
		mayoresEmpleados.forEach((k, v) -> System.out.println(k + " - " + v));
		
		System.out.println("------------- Por Genero:");
		Map<Empleado.Genero, List<Empleado>> empleadosPorGenero =  Empleado.empleadosParaTest()
				.stream()
				.collect(Collectors.groupingBy(Empleado::getGenero));
		
		empleadosPorGenero.forEach((k, v) -> System.out.println(k + " - " + v));
		
		System.out.println("------------- Por Genero COUNTING:");
		Map<Empleado.Genero, Long> empleadosPorGeneroCounting =  Empleado.empleadosParaTest()
				.stream()
				.collect(Collectors.groupingBy( e -> e.getGenero(), Collectors.counting()));
		
		empleadosPorGeneroCounting.forEach((k, v) -> System.out.println(k + " - " + v));
		
		System.out.println("------------- Salario Promedio Mujer:");
		Double salarioPromedio =  Empleado.empleadosParaTest()
				.stream()
				.filter(Empleado::isMujer)
				.collect(Collectors.averagingInt(Empleado::getSalario));
		
		System.out.println("Salario Promedio Mujer:" + salarioPromedio);

		System.out.println("------------- Salarios promedio por genero:");
		Map<Empleado.Genero, Double> empleadosPorGeneroPromedioSalario =  Empleado.empleadosParaTest()
				.stream()
				.collect(Collectors.groupingBy( e -> e.getGenero(), Collectors.averagingInt(Empleado::getSalario)));
		
		empleadosPorGeneroPromedioSalario.forEach((k, v) -> System.out.println(k + " - " + v));
		
		System.out.println("------------- Estadisticas Salarios por genero:");
		Map<Empleado.Genero, IntSummaryStatistics> salarioPorGeneroEstadisticas =  Empleado.empleadosParaTest()
				.stream()
				.collect(Collectors.groupingBy( e -> e.getGenero(), Collectors.summarizingInt(Empleado::getSalario)));
		
		salarioPorGeneroEstadisticas.forEach((k, v) -> System.out.println(k + " - " + v));
		
		System.out.println("------------- Sumarizacion Salarios por genero:");
		Map<Empleado.Genero, Integer> salarioPorGeneroSumarizado =  Empleado.empleadosParaTest()
				.stream()
				.collect(Collectors.groupingBy( e -> e.getGenero(), Collectors.summingInt(Empleado::getSalario)));
		
		salarioPorGeneroSumarizado.forEach((k, v) -> System.out.println(k + " - " + v));
		
		Integer salarioSumarizado =  Empleado.empleadosParaTest()
				.stream()
				.collect(Collectors.summingInt(Empleado::getSalario));
		
		System.out.println(" Salario sumarizado: " + salarioSumarizado);
		
		System.out.println("------------- empleadosHombres:");
		String empleadosHombres =  Empleado.empleadosParaTest()
				.stream()
				.filter(Empleado::isHombre)
				.map(Empleado::getNombre)
				.collect(Collectors.joining(", "));
		
		System.out.println(empleadosHombres);
	}

}
