package calevin.stream;

import java.util.Comparator;

import entidades.Documento;
import entidades.Empleado;

public class TestStreamSortingMain {

	public static void main(String[] args) {
		ejemploSorted();
		ejemploComparator();
		ejemploComparatorThen();
		ejemploReversed();
	}

	public static void ejemploSorted() {
		System.out.println("ejemploSorted");
		Empleado.empleadosParaTest()
		.stream()
		.sorted()
		.forEach(System.out::println);
		System.out.println("----------------------");
	}
	
	public static void ejemploComparator() {
		System.out.println("ejemploComparator");

		Documento.documentosParaTest()
		.stream()
		.sorted(Comparator.comparing(Documento::getTitulo))
		.forEach(System.out::println);
		
		System.out.println("----------------------");
	}
	
	public static void ejemploComparatorThen() {
		System.out.println("ejemploComparatorThen");

		Documento.documentosParaTest()
		.stream()
		.sorted(
				Comparator.comparing(Documento::getTitulo)
				.thenComparing(Documento::getVersion)
				)
		.forEach(System.out::println);
		
		System.out.println("----------------------");
	}
	
	public static void ejemploReversed() {
		System.out.println("ejemploReversed");

		Documento.documentosParaTest()
		.stream()
		.sorted(
				Comparator.comparing(Documento::getTitulo)
				.thenComparing(Documento::getVersion)
				.reversed()
				)
		.forEach(System.out::println);
		
		System.out.println("----------------------");
	}
}
