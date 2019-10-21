package calevin.biconsumer;

import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

import entidades.Empleado;

public class TestBiConsumerMain {

	public static void main(String[] args) {
		ejemploBiConsumer();
		
		Map<Integer, Empleado> mapEmpleados = Empleado.empleadosParaTest()
				.stream()
				.collect(Collectors.toMap(Empleado::getId, empleado->empleado));
		
		/*forEach del map recibe un BiConsumer
		BiConsumer<Integer, Empleado> biConsumerForEach = 
				(Integer id, Empleado e) -> System.out.println(id + " )"+ e);
		mapEmpleados.forEach(biConsumerForEach);
		*/
		mapEmpleados.forEach((Integer id, Empleado e) -> System.out.println(id + " )"+ e));
		
	}

	public static void ejemploBiConsumer() {
		BiConsumer<Empleado, Empleado> biConsumerEmpleado = 
				(Empleado e1, Empleado e2) 
				-> System.out.println(e1.getNombre() + " " + e2.getNombre());
		
		Empleado jose = new Empleado();
		jose.setNombre("Jose");
		
		Empleado mauro = new Empleado();
		mauro.setNombre("Mauro");
		
		biConsumerEmpleado.accept(jose, mauro);
	}
}
