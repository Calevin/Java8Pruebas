package calevin.fecha;

import java.time.LocalDate;
import java.time.Period;
import java.util.stream.IntStream;

public class TestLocalDate {

	public static void main(String[] args) {
		
		LocalDate hoy = LocalDate.now();
		System.out.println("Hoy: " + hoy);
		LocalDate cumpleanios = LocalDate.of(hoy.getYear(), 9, 10);
		System.out.println("Cumplea�os: " + cumpleanios);
		System.out.println("Mes actual (nombre): " + hoy.getMonth());
		System.out.println("Mes actual: (numero)" + hoy.getMonthValue());
		System.out.println("Dia actual: " + hoy.getDayOfMonth());
		
		System.out.println("Hoy es anterior a mi cumplea�os? " + hoy.isBefore(cumpleanios));
		LocalDate cumplea�osAnioNacimiento = cumpleanios.withYear(1987);
		System.out.println("Cumplea�os (a�o de nacimiento): " + cumplea�osAnioNacimiento);
		System.out.println("Cumplea�os + 10 a�os: " + cumplea�osAnioNacimiento.plusYears(10));
		System.out.println("Cumplea�os (a�o de nacimiento): " + cumplea�osAnioNacimiento);
		System.out.println("Hoy + 1 a�o, 2 mes, 3 dia: " 
				+ hoy.plusYears(1).plusMonths(2).plusDays(3));
		
		Period periodo = Period.between(cumplea�osAnioNacimiento, hoy);
		System.out.println("A�os " + periodo.getYears());
		System.out.println("Meses " + periodo.getMonths());
		System.out.println("Dias " + periodo.getDays());
		
		//ejemploRango();
	}

	private static void ejemploRango() {
		//System.out::println
		//.anyMatch
		LocalDate cumplea�osAnioNacimiento = LocalDate.of(1987, 9, 10);
		System.out.println("forEach ----------------------------------------------------");
		IntStream.range(1, 32).forEach(n -> {
			System.out.println(n + ") Cumplea�os " + cumplea�osAnioNacimiento.plusYears(n));
		});
		System.out.println("anyMatch ----------------------------------------------------");
		IntStream.range(1, 32).anyMatch(n -> {
			System.out.println(n + ") Cumplea�os " + cumplea�osAnioNacimiento.plusYears(n));
			return cumplea�osAnioNacimiento.plusYears(n).getYear() == 2001;
		});
		System.out.println("filter ----------------------------------------------------");
		IntStream.range(1, 32).filter(n -> {
			System.out.println(n + ") Cumplea�os " + cumplea�osAnioNacimiento.plusYears(n));
			return cumplea�osAnioNacimiento.plusYears(n).getYear() == 2001;
		})
		.forEach(n -> {
			System.out.println(n + ")(Otro Stream) Cumplea�os " + cumplea�osAnioNacimiento.plusYears(n));
		});
		System.out.println("----------------------------------------------------");
				
		
	}
}
