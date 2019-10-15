package calevin.fecha;

import java.time.LocalDate;
import java.time.Period;
import java.util.stream.IntStream;

public class TestLocalDate {

	public static void main(String[] args) {
		
		LocalDate hoy = LocalDate.now();
		System.out.println("Hoy: " + hoy);
		LocalDate cumpleanios = LocalDate.of(hoy.getYear(), 9, 10);
		System.out.println("Cumpleaños: " + cumpleanios);
		System.out.println("Mes actual (nombre): " + hoy.getMonth());
		System.out.println("Mes actual: (numero)" + hoy.getMonthValue());
		System.out.println("Dia actual: " + hoy.getDayOfMonth());
		
		System.out.println("Hoy es anterior a mi cumpleaños? " + hoy.isBefore(cumpleanios));
		LocalDate cumpleañosAnioNacimiento = cumpleanios.withYear(1987);
		System.out.println("Cumpleaños (año de nacimiento): " + cumpleañosAnioNacimiento);
		System.out.println("Cumpleaños + 10 años: " + cumpleañosAnioNacimiento.plusYears(10));
		System.out.println("Cumpleaños (año de nacimiento): " + cumpleañosAnioNacimiento);
		System.out.println("Hoy + 1 año, 2 mes, 3 dia: " 
				+ hoy.plusYears(1).plusMonths(2).plusDays(3));
		
		Period periodo = Period.between(cumpleañosAnioNacimiento, hoy);
		System.out.println("Años " + periodo.getYears());
		System.out.println("Meses " + periodo.getMonths());
		System.out.println("Dias " + periodo.getDays());
		
		//ejemploRango();
	}

	private static void ejemploRango() {
		//System.out::println
		//.anyMatch
		LocalDate cumpleañosAnioNacimiento = LocalDate.of(1987, 9, 10);
		System.out.println("forEach ----------------------------------------------------");
		IntStream.range(1, 32).forEach(n -> {
			System.out.println(n + ") Cumpleaños " + cumpleañosAnioNacimiento.plusYears(n));
		});
		System.out.println("anyMatch ----------------------------------------------------");
		IntStream.range(1, 32).anyMatch(n -> {
			System.out.println(n + ") Cumpleaños " + cumpleañosAnioNacimiento.plusYears(n));
			return cumpleañosAnioNacimiento.plusYears(n).getYear() == 2001;
		});
		System.out.println("filter ----------------------------------------------------");
		IntStream.range(1, 32).filter(n -> {
			System.out.println(n + ") Cumpleaños " + cumpleañosAnioNacimiento.plusYears(n));
			return cumpleañosAnioNacimiento.plusYears(n).getYear() == 2001;
		})
		.forEach(n -> {
			System.out.println(n + ")(Otro Stream) Cumpleaños " + cumpleañosAnioNacimiento.plusYears(n));
		});
		System.out.println("----------------------------------------------------");
				
		
	}
}
