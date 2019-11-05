package calevin;

import java.util.function.Function;

public class FuncionesEjemplosMain {

	public static void main(String[] args) {
		System.out.println("INICIO");

		Function<Integer, String> intToString = (i)-> { 
			return Integer.toString(i);
		};
		
		FunctionEjemploSinImplementar fSinImplementar = parametro -> System.out
				.println("fSinImplementar entero: " + parametro);

		// this.metodoQueUsaFuctionSinImplementar(fSinImplementar, 1);
		FuncionesEjemplosMain.EjectuadorPruebas e = new FuncionesEjemplosMain().new EjectuadorPruebas();

		e.metodoQueUsaFuctionSinImplementar(fSinImplementar, 1);

		e.metodoQueUsaFuctionImplementad(new FuncionesEjemplosMain().new UsoFunctionEjemploImplementado(), 2);
		
	}

	public class EjectuadorPruebas {

		public EjectuadorPruebas() {
			super();
		}

		public void metodoQueUsaFuctionSinImplementar(FunctionEjemploSinImplementar f, int entero) {
			f.accept(entero);
		}

		public void metodoQueUsaFuctionImplementad(FunctionEjemploImplementado f, int entero) {
			f.accept(entero);
		}
	}

	@FunctionalInterface
	public interface FunctionEjemploSinImplementar {
		// No requeriere cuertpo
		public void accept(int entero);

		// REQUIERE cuerpo
		// Error al compilar
		// public default void accept(int entero);
	}

	public interface FunctionEjemploImplementado {
		// REQUIERE default
		// Error al compilar
		// public void accept(int entero) {

		// default requiere cuerpo
		public default void accept(int entero) {
			System.out.println("Entero es: " + entero);
		}
	}

	public class UsoFunctionEjemploImplementado implements FunctionEjemploImplementado {
		public UsoFunctionEjemploImplementado() {
			System.out.println("CREO UNA INSTANCIA DE UsoFunctionEjemploImplementado");
		}
	}
}
