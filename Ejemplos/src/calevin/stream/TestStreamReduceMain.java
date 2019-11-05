package calevin.stream;

import java.util.OptionalInt;

import entidades.Empleado;

public class TestStreamReduceMain {

	public static void main(String[] args) {
		int sumatoriaSalario = Empleado.empleadosParaTest()
		.stream()
		.mapToInt(e->e.getSalario())
		.reduce(0, 
				(salario1, salario2)->salario1+salario2);

		System.out.println(sumatoriaSalario);
		
		//si con un filter elimino todos los elementos, el reduce no va a poder devolver nada
		//ya que no tiene identity tiene que devolver un Optional para el caso de no devolver nada 
		OptionalInt sumatoriaSalarioOptional= Empleado.empleadosParaTest()
				.stream()
				.filter(e->e.getSalario()>1_000_000)
				.mapToInt(e->e.getSalario())
				.reduce((salario1, salario2)->salario1+salario2);
		
		sumatoriaSalarioOptional.ifPresent(System.out::println);
		System.out.println(sumatoriaSalarioOptional.orElse(0));
				
		sumatoriaSalarioOptional= Empleado.empleadosParaTest()
				.stream()
				.filter(e->e.getSalario()>=30_000)
				.mapToInt(e->e.getSalario())
				.reduce((salario1, salario2)->salario1+salario2);
		
		System.out.println(sumatoriaSalarioOptional.isPresent()? sumatoriaSalarioOptional.getAsInt():"NADA");
		System.out.println(sumatoriaSalarioOptional.orElse(0));

	}

}
