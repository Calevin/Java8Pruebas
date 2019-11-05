package calevin.optional;

import java.util.Optional;

import entidades.Empleado;

public class TestOpcionalMain {

	public static void main(String[] args) {

		Optional<Empleado> empleadoEncontrado = buscarEmpleadoPorNombre("nadie");
		
		System.out.println(empleadoEncontrado.isPresent()?empleadoEncontrado.get():"No encontrado");
		
		System.out.println(empleadoEncontrado.orElse(Empleado.EMPTY_EMPLEADO));

		
		empleadoEncontrado = buscarEmpleadoPorNombre("Seba");
		
		System.out.println(empleadoEncontrado.isPresent()?empleadoEncontrado.get():"No encontrado");
		
		System.out.println(empleadoEncontrado.orElseGet(() -> {
			System.out.println("No encontrado");
			return Empleado.EMPTY_EMPLEADO;
		}));

	}

	public static Optional<Empleado> buscarEmpleadoPorNombreSinStream(String nombre){
		Optional<Empleado> empleadoEncontrado = Optional.empty();
		
		for (Empleado e : Empleado.empleadosParaTest()) {
			if(e.getNombre().equalsIgnoreCase(nombre)) {
				empleadoEncontrado = Optional.of(e);
			}
			
		}
		
		return empleadoEncontrado;
	}
	
	public static Optional<Empleado> buscarEmpleadoPorNombre(String nombre){
		return Empleado.empleadosParaTest()
				.stream()
				.filter(p -> p.getNombre().equalsIgnoreCase(nombre))
				.findFirst();
	}
}
