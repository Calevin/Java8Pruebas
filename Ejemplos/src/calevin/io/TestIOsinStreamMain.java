package calevin.io;

import java.io.File;

public class TestIOsinStreamMain {

	public static void main(String[] args) {
		System.out.println("-----------------------");
		casoSinRecursividad();
		System.out.println("-----------------------");
		casoRecursividad(); 
		System.out.println("-----------------------");

	}

	public static void casoSinRecursividad() {
		File archivo = new File("./src");
		
		File[] archivos = archivo.listFiles();
		
		for (File file : archivos) {
			System.out.println(file.getName());
		}
	}
	
	public static void casoRecursividad() {
		File archivo = new File("./src");
		imprimirRecursivo(archivo);
	}
	
	public static void imprimirRecursivo(File archivo) {
		if(archivo.isDirectory()) {
			for (File file : archivo.listFiles()) {
				imprimirRecursivo(file);
			}
		} else {
			System.out.println(archivo.getName());
		}
	}
}

