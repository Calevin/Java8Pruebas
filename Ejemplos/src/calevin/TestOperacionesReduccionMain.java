package calevin;

import java.util.List;

import entidades.Empleado;

public class TestOperacionesReduccionMain {

	public static void main(String[] args) {
		List<Empleado> empleados = Empleado.empleadosParaTest();
		
		Empleado empMaxSalario = empleados
				.stream()
				.max(
						(e1, e2)->(int)e1.getSalario()-e2.getSalario()
					)
				.get();
		
		System.out.println(empMaxSalario);
		
	}

}
