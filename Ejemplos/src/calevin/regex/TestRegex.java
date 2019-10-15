package calevin.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {

	public static void main(String[] args) {
		String textoClientes="El cliente A tiene de clave clave12345"
				+ ", El cliente B tiene de clave Password12345";
		System.out.println(textoClientes);
		
		String ofuscado = textoClientes.replaceAll("[a-zA-Z]{3,10}\\d{4}", "XXXXXXXX");
		
		System.out.println(ofuscado);
		System.out.println("---------------------------------------------------------");
		
		String facturas = "las facturas son 123AB y 234CD";
		String factura = "345ZY";
		
		System.out.println(facturas);
		String expresionFactura = "\\d{3}[A-Z]{2}";
		
		Pattern patronFacturas = Pattern.compile(expresionFactura);
		Pattern patronFactura = Pattern.compile(expresionFactura);
		
		Matcher facturasEncontradas = patronFacturas.matcher(facturas);
		Matcher facturaEncontrada = patronFactura.matcher(factura);
		
		System.out.println("true if, and only if, a prefix of the inputsequence matches this matcher's pattern? " + facturasEncontradas.lookingAt());
		System.out.println("true if, and only if, a prefix of the inputsequence matches this matcher's pattern? " + facturaEncontrada.lookingAt());
		
		//System.out.println("se encontro algo? " + facturasEncontradas.find());
		//System.out.println("se encontro algo? " + facturaEncontrada.find());
		
		System.out.println("\nRecorriendo facturas " + facturas + "\n");
		while (facturasEncontradas.find()) {
			int inicio = facturasEncontradas.start();
			System.out.println("Inicio:" + inicio);
			int fin = facturasEncontradas.end();
			System.out.println("Fin: " + fin);
			
			System.out.println(facturas.substring(inicio, fin) + "\n");
			
		}
	}

}
