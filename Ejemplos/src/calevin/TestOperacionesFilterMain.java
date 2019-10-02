package calevin;

import java.util.List;
import java.util.function.Predicate;

import entidades.Empleado;

public class TestOperacionesFilterMain {

	public static void main(String[] args) {
		List<Empleado> empleados = Empleado.empleadosParaTest();
		
		System.out.println("HOMBRES:");
		empleados.stream()
			.filter(Empleado::isHombre)
			.forEach(System.out::println);

		System.out.println("MUJERES:");
		empleados.stream()
			.filter(Empleado::isMujer)
			.forEach(System.out::println);
		
		System.out.println("Mayores 25:");
		empleados.stream()
			.filter(e -> e.getEdad()>25)
			.forEach(System.out::println);
		
		System.out.println("Hombre, salario mas de 1600");
		empleados.stream()
		.filter(e -> e.isHombre() && e.getSalario()>1600)
		.forEach(System.out::println);
		
		System.out.println("Mujer, salario mas de 1600");
		Predicate<Empleado> empFemenino = e -> e.isMujer();
		Predicate<Empleado> empMayor25 = e -> e.getEdad()>25;
		Predicate<Empleado> empSalarioMayor1600 = e -> e.getSalario()>1600;
		
		empleados.stream()
			.filter(empFemenino.and(empMayor25).and(empSalarioMayor1600))
			.sorted((e1, e2) -> e1.getNombre().compareTo(e2.getNombre()))
			.forEach(System.out::println);
		
	}

}
