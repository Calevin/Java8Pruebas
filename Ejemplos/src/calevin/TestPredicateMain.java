package calevin;

import java.util.List;
import java.util.function.Predicate;

import entidades.Empleado;
import funciones.Evaluador;

public class TestPredicateMain {

	public static void main(String[] args) {
		List <Empleado> listaEmpleados = Empleado.empleadosParaTest();

		Evaluador evaluador = new Evaluador();
		
		System.out.println("Empleados con salarios > 5000");
		
		List<Empleado> empSalariosAltos = evaluador.evaluar(listaEmpleados
				, empleado -> empleado.getSalario()>1600);
		
		for (Empleado empleado2 : empSalariosAltos) {
			System.out.println(empleado2.getNombre());
			
		}
		
		System.out.println("Empleados que su nombre empieza con J");
		List<Empleado> empInicianConJ = evaluador.evaluar(listaEmpleados
				, empleado -> empleado.getNombre().startsWith("J"));
		
		for (Empleado empleado2 : empInicianConJ) {
			System.out.println(empleado2.getNombre());
			
		}
		
		System.out.println("Empleados menores de 30");
		//EJEMPLO con clase anonima
		List<Empleado> empMenores30 = evaluador.evaluar(listaEmpleados
				, new Predicate<Empleado>() {
					
					@Override
					public boolean test(Empleado t) {
						
						return t.getEdad()<30;
					}
				});
		
		for (Empleado empleado2 : empMenores30) {
			System.out.println(empleado2.getNombre());
			
		}
		
		Predicate<Empleado> salarioMayor1600 = empleado -> empleado.getSalario()>1600;
		Predicate<Empleado> nombreIniciaConJ = empleado -> empleado.getNombre().startsWith("J");
		
		List<Empleado> empSalarioMayor5000yNombreIniciaConJ = evaluador.evaluar(listaEmpleados,
				salarioMayor1600.or(nombreIniciaConJ));
		

		System.out.println("empSalarioMayor5000yNombreIniciaConJ: ");
		for (Empleado empleado2 : empSalarioMayor5000yNombreIniciaConJ) {
			System.out.println(empleado2.getNombre());
		}
	}
}
