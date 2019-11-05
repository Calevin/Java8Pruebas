package calevin.bifunction;

import java.util.Optional;

import entidades.Documento;
import entidades.Versionable;

public class TestBiFuctionMain {

	public static void main(String[] args) {
		//Reduce
		//Sobre un acumulador y un BiOperator que es una especialización de BiFunction
		//En vez de acumular lo que se hace es ir almacenando el mayor
		Optional<Documento> mayorVersion = Documento.documentosParaTest()
				.stream()
				.reduce(Versionable::esVersionMayor);
		
		System.out.println(mayorVersion.isPresent()?"Mayor: " + mayorVersion.get():"NADA");

		System.out.println(mayorVersion.orElse(new Documento("NADA", -1)));

		
		//Usar metodo de instancia
		//Metodo por defecto
		Optional<Documento> menorVersion = Documento.documentosParaTest()
				.stream()
				.reduce(Versionable::esVersionMenor);
		
		System.out.println(menorVersion.isPresent()?"Menor: " + menorVersion.get():"NADA");
		//Usa Supplier
		System.out.println(mayorVersion.orElseGet(() -> new Documento("NADA", -1)));

		
	}

}
