package calevin.collections;

import java.util.ArrayList;
import java.util.List;

public class TestList {

	public static void main(String[] args) {
		//Permite operaciones por posicion
		List<String> nombres = new ArrayList<String>();
		nombres.add("Sebastian");
		nombres.add("Ezequiel");
		nombres.add("Alberto");
		nombres.add("Bruno");
		nombres.add("Carlos");
		
		System.out.println(nombres.get(0));
		
		System.out.println(nombres.indexOf("Ezequiel"));

	}

}
