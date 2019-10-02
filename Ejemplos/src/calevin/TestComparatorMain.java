package calevin;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import entidades.Empleado;

public class TestComparatorMain {

	public static void main(String[] args) {
		List<Empleado> listaEmpleados = Empleado.empleadosParaTest();
		
		System.out.println("Empleados sin ordenar:\n " + listaEmpleados);

		Collections.sort(listaEmpleados);
		
		System.out.println("Empleados ordenados:\n " + listaEmpleados);
		
		//int compare(T o1, T o2);
		//CLASE ANONIMA
		Collections.sort(listaEmpleados, new Comparator<Empleado>() {
			@Override
			public int compare(Empleado o1, Empleado o2) {
				return Integer.compare(o1.getSalario(), o2.getSalario());
			}
		});
		
		
		System.out.println("Empleados ordenados por salarios:\n " + listaEmpleados);
		
		Collections.sort(listaEmpleados
				, (o1,  o2) -> Integer.compare(o1.getEdad(), o2.getEdad()));
		
		System.out.println("Empleados ordenados por edad:\n " + listaEmpleados);
		
		//int compare(T o1, T o2);
		/*
		Collections.sort(listaEmpleados
				, (o1, o2) -> Empleado.compararPorSector(o1, o2)); 
		*/
		//METODO REFERENCIADO
		Collections.sort(listaEmpleados, Empleado::compararPorSector);
		
	}
}
