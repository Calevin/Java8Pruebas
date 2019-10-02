package calevin;

import funciones.Operacion;
import funciones.OperacionVoid;

public class TestOperacionesMain {

	public static void main(String[] args) {

		int intDos = 2;
		//-------------------------------------------------------
		//Lambda Multiples lineas:		
		Operacion suma = (var1, var2) -> {
			int resultado = var1 + var2;
			System.out.println("Suma " + resultado);
			return resultado;
		};
		
		metodoEjecutarOperacion(suma, 1, intDos);
		
		//-------------------------------------------------------		
		//Lambda inline
		
		Operacion resta = (var1, var2) -> (var1-var2);
		
		System.out.println("Resta");
		metodoEjecutarOperacion(resta, 1, intDos);
		
		//-------------------------------------------------------		
		//Lambda directamente como parametro:
		
		System.out.println("Multiplicar 2 * 3");
		metodoEjecutarOperacion((var1, var2) -> var1*var2, intDos, 3);
		
		//-------------------------------------------------------		
		//Lambda como retorno de un metodo		
		metodoEjecutarOperacion(metodoQueRetornaOperacion(), 4, intDos);
		//-------------------------------------------------------
		//Lo siguiente no es permitido
		//OperacionVoid restaVoid = (var1, var2) -> (var1-var2);
		//Necesita una implementacion VOID, por ejemplo:
		OperacionVoid restaVoid = (var1, var2) -> System.out.println("Resta usando operacion void: " + (var1-var2));
		restaVoid.operacion(1, 2);
	}

	public static void metodoEjecutarOperacion(Operacion o, int var1, int var2) {
		System.out.println("Resultado: " + o.operacion(var1, var2));
	}
	
	public static Operacion metodoQueRetornaOperacion() {
		System.out.println("metodoQueRetornaOperacion");
		return (x, y) -> x/y;
	}
}
