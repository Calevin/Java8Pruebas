package calevin.collections;

import java.util.HashMap;
import java.util.Set;

import entidades.Empleado;
import entidades.Empleado.Genero;

public class TestMap {

	public static void main(String[] args) {
		HashMap<String, Empleado> diccionario = new HashMap<String, Empleado>();
		//
		diccionario.put("Sebastian", new Empleado(4, "Seba", 1600, 28, "SemiS", Genero.HOMBRE));
		diccionario.put("Juli", new Empleado(7, "Juli", 1000, 22, "Trainee", Genero.HOMBRE));
		diccionario.put("Jose", new Empleado(3, "Jose", 2000, 30, "SemiS", Genero.HOMBRE));
		diccionario.put("Diego", new Empleado(6, "Diego", 1200, 24, "Trainee", Genero.HOMBRE));
		diccionario.put("Mauro", new Empleado(5, "Mauro", 1400, 26, "SemiS", Genero.HOMBRE));
		diccionario.put("Pepe", new Empleado(0, "Pepe", 30000, 72, "Boss", Genero.HOMBRE));
		System.out.println(diccionario.get("Sebastian"));
		
		System.out.println("Recorrer mapa");
		//Obtener conjunto de claves
		Set<String> clavesDelMap = diccionario.keySet();
		
		for (String clave : clavesDelMap) {
			System.out.println(diccionario.get(clave));
		}

	}

}
