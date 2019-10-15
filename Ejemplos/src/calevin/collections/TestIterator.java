package calevin.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestIterator {

	public static void main(String[] args) {
		
		List<String> nombres = new ArrayList<String>();
		nombres.add("Sebastian");
		nombres.add("Ezequiel");
		nombres.add("Alberto");
		nombres.add("Bruno");
		nombres.add("Carlos");
		
		//Permite recorrer y remover
		Iterator<String> iNombres = nombres.iterator();
		
		while (iNombres.hasNext()) {
			String nombre = iNombres.next();
			System.out.println(nombre);
			if (nombre.equals("Sebastian"))
				iNombres.remove();
			
		}
		System.out.println("LISTA");
		for (String string : nombres) {
			System.out.println(string);
		}

	}

}
