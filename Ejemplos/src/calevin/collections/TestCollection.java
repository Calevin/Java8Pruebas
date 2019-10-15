package calevin.collections;

import java.util.ArrayList;
import java.util.Collection;

public class TestCollection {
	
	public static void main(String[] args) {
		//Permite operaciones Añadir/Eliminar
		Collection<String> nombres = new ArrayList<String>();
		nombres.add("Sebastian");
		nombres.add("Ezequiel");
		nombres.add("Alberto");
		nombres.add("Bruno");
		nombres.add("Carlos");
		
		Collection<String> otrosNombres = new ArrayList<String>();
		otrosNombres.add("Mauro");
		otrosNombres.add("Jose");
		otrosNombres.add("Ana");
		
		System.out.println(nombres.contains("Bruno"));
		System.out.println(nombres.size());
		
		nombres.addAll(otrosNombres);
		
		System.out.println(nombres.size());
	}
}
