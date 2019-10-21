package calevin.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import entidades.Empleado;
import entidades.Empleado.Genero;

public class TestStreamCollectorsMain {

	
	public static void main(String[] args) {
		//Collectors sirve para convertir en una collection
		
		toListEjemplo();
		
		toSetEjemplo();
		
		toMapEjemplo();
		
		toTreeSet();
		
		ejemploCollectorsJoin();
	}

	private static void toListEjemplo() {
		List<Empleado> empleadosTrainee = new ArrayList<Empleado>();
		empleadosTrainee.addAll(Empleado.empleadosParaTest());
		empleadosTrainee.add(new Empleado(6, "Diego2", 1222, 22, "Trainee", Genero.HOMBRE));
		
		empleadosTrainee = empleadosTrainee
				.stream()
				.filter(e->e.getSector().equals("Trainee"))
				.collect(Collectors.toList());
		
		System.out.println("Hay " + empleadosTrainee.size() + " trainees");
	}

	private static void toSetEjemplo() {
		List<Empleado> empleadosTrainee = new ArrayList<Empleado>();
		empleadosTrainee.addAll(Empleado.empleadosParaTest());
				
		empleadosTrainee.add(new Empleado(6, "Diego2", 1222, 22, "Trainee", Genero.HOMBRE));
				
		Set<Empleado> setEmpleadosTrainee = empleadosTrainee
				.stream()
				.filter(e->e.getSector().equals("Trainee"))
				.collect(Collectors.toSet());
		
		System.out.println("Hay " + setEmpleadosTrainee.size() + " trainees");
	}

	private static void toMapEjemplo() {
		Map<Integer, Empleado> mapEmpleados = Empleado.empleadosParaTest()
		.stream()
		.collect(Collectors.toMap(Empleado::getId, p->p));
		
		System.out.println("Hay en el map: " + mapEmpleados.size());
		
		System.out.println("El 66 es: " + mapEmpleados.get(66));
	}
	
	private static void toTreeSet() {
		TreeSet<Empleado> treeSetTrainees = Empleado.empleadosParaTest()
				.stream()
				.filter(e->e.getSector().equals("Trainee"))
				.collect(Collectors.toCollection(TreeSet::new));
		
		treeSetTrainees.forEach(System.out::println);
	}
	
	private static void ejemploCollectorsJoin() {
		 String distintosSectores = Empleado.empleadosParaTest()
			.stream()
			.map(e->e.getSector())
			.distinct()
			.collect(Collectors.joining(", "));
		 
		 System.out.println("Sectores: " + distintosSectores);
	}
}
