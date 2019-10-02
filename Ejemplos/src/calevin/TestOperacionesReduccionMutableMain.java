package calevin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import entidades.Empleado;

public class TestOperacionesReduccionMutableMain {

	public static void main(String[] args) {
		List<Empleado> empleados = Empleado.empleadosParaTest();
		
		collectFirmaCompleta(empleados);
		System.out.println("\n");
		collectFirmaNoCompleta(empleados);
		System.out.println("\n");
		collectStreamAmapa(empleados);
	}

	public static void collectFirmaCompleta(List<Empleado> empleados) {
		//COLLECT
		//Supplier<ArrayList<String>> proveedor = () -> new ArrayList<>;
		Supplier<ArrayList<String>> proveedor = ArrayList::new;

		//BiConsumer<ArrayList<String>, String> acumulador = (lista, str) -> lista.add(str);
		BiConsumer<ArrayList<String>, String> acumulador = ArrayList::add;
		
		//BiConsumer<ArrayList<Empleado>, ArrayList<Empleado>> combinador = (lista1, lista2) -> lista1.addAll(lista2);
		BiConsumer<ArrayList<String>, ArrayList<String>> combinador = ArrayList::addAll;
		
		//collect(proveedor, acumulador, combinador)
		
		List<String> nombres = empleados
				.stream()
				.map(Empleado::getNombre)
				.collect(proveedor, acumulador, combinador);
		
		System.out.println(nombres);
	}
	
	public static void collectFirmaNoCompleta(List<Empleado> empleados) {
		Set<String> nombres = empleados
				.stream()
				.map(Empleado::getNombre)
				.collect(Collectors.toSet());
		
		System.out.println(nombres);
	}
	
	public static void collectStreamAmapa(List<Empleado> empleados) {
		Map<Integer, String> idNombreMap = empleados
				.stream()
				.collect(Collectors
							.toMap(Empleado::getId, Empleado::getNombre)
						);
		
		System.out.println(idNombreMap);
	}
}
