package calevin.collections;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import entidades.Empleado;
import entidades.Empleado.Genero;

public class TestSet {

	public static void main(String[] args) {
		// Interface de marca
		// No añade funcionalidad pero define particularidades
		// En este caso no permite repetidos

		List<Empleado> listaEmpleados = Empleado.empleadosParaTest();
		sinOrden(listaEmpleados);
		conOrden(listaEmpleados);
	}

	private static void sinOrden(List<Empleado> listaEmpleados) {
		Set<Empleado> conjuntoHash = new HashSet<Empleado>();

		for (Empleado empleado : listaEmpleados) {
			conjuntoHash.add(empleado);
		}
		conjuntoHash.add(new Empleado(4, "Seba", 1600, 28, "SemiS", Genero.HOMBRE));
		// Sin orden
		System.out.println("SIN ORDEN-------------------------------------->");
		for (Empleado empleado : conjuntoHash) {
			System.out.println(empleado);
		}
		System.out.println("SIN ORDEN<--------------------------------------");
	}

	private static void conOrden(List<Empleado> listaEmpleados) {
		Set<Empleado> conjuntoTree = new TreeSet<Empleado>();

		for (Empleado empleado : listaEmpleados) {
			conjuntoTree.add(empleado);
		}
		conjuntoTree.add(new Empleado(4, "Seba", 1600, 28, "SemiS", Genero.HOMBRE));
		// Con orden
		System.out.println("CON ORDEN-------------------------------------->");
		for (Empleado empleado : conjuntoTree) {
			System.out.println(empleado);
		}
		System.out.println("CON ORDEN<--------------------------------------");
	}
}
