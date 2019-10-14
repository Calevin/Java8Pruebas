package calevin.fecha;

import java.time.LocalDate;

public class TestLocalDate {

	public static void main(String[] args) {
		
		LocalDate hoy = LocalDate.now();
		System.out.println("Hoy: " + hoy);
		LocalDate cumpleaños = LocalDate.of(hoy.getYear(), 9, 10);
		System.out.println("Cumpleaños: " + cumpleaños);
		System.out.println("Mes actual (nombre): " + hoy.getMonth());
		System.out.println("Mes actual: (numero)" + hoy.getMonthValue());
		System.out.println("Dia actual: " + hoy.getDayOfMonth());
		
		System.out.println("Hoy es anterior a mi cumpleaños? " + hoy.isBefore(cumpleaños));
		LocalDate cumpleañosAñoNacimiento = cumpleaños.withYear(1987);
		System.out.println("Cumpleaños (año de nacimiento): " + cumpleañosAñoNacimiento);
	}
}
