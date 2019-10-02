package calevin;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import entidades.Empleado;

public class TestConsumerMain {

	public static void main(String[] args) {
		/*
		 * Consumer<String> aMayusculas = x -> System.out.println(x.toUpperCase());
		 * 
		 * aMayusculas.accept("sebastian");
		 */
		List<Empleado> listaEmpleados =Empleado.empleadosParaTest();

		Consumer<Empleado> imprimir = e -> System.out.println(e);

		Consumer<Empleado> aumentarSalario = e -> e.setSalario((int) (e.getSalario() * 1.11));

		aceptarTodos(listaEmpleados, imprimir);
		System.out.println("AUMENTAR SALARIOS");
		aceptarTodos(listaEmpleados, aumentarSalario.andThen(imprimir));

		System.out.println("Ejemplo BiConsumer:");
		BiConsumer<Empleado, String> imprimirConMsj = (e, s) -> System.out.println(e + s);

		aceptarTodosBi(listaEmpleados, " aumentado", imprimirConMsj);

	}

	public static void aceptarTodos(List<Empleado> listaEmpleados, Consumer<Empleado> consumer) {
		listaEmpleados.forEach(consumer);
		/*
		 * for (Empleado empleado : listaEmpleados) { 
		 * 		consumer.accept(empleado); 
		 * }
		 */
	}

	public static void aceptarTodosBi(List<Empleado> listaEmpleados, String mensaje,
			BiConsumer<Empleado, String> consumer) {

		for (Empleado empleado : listaEmpleados) {
			consumer.accept(empleado, mensaje);
		}
	}
}
