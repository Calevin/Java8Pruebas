package calevin.fecha;

import java.time.LocalDate;

public class TestLocalDate {

	public static void main(String[] args) {
		
		LocalDate hoy = LocalDate.now();
		System.out.println("Hoy: " + hoy);
		LocalDate cumplea�os = LocalDate.of(hoy.getYear(), 9, 10);
		System.out.println("Cumplea�os: " + cumplea�os);
		System.out.println("Mes actual (nombre): " + hoy.getMonth());
		System.out.println("Mes actual: (numero)" + hoy.getMonthValue());
		System.out.println("Dia actual: " + hoy.getDayOfMonth());
		
		System.out.println("Hoy es anterior a mi cumplea�os? " + hoy.isBefore(cumplea�os));
		LocalDate cumplea�osA�oNacimiento = cumplea�os.withYear(1987);
		System.out.println("Cumplea�os (a�o de nacimiento): " + cumplea�osA�oNacimiento);
	}
}
