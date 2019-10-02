package funciones;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import entidades.Empleado;

public class Evaluador {
	/**
	 * Retorna una lista con los empleados que cumplen con eval
	 * @param lista
	 * @param eval
	 * @return
	 */
	public List<Empleado> evaluar (List<Empleado> lista, Predicate<Empleado> eval) {
		List<Empleado> listaRetorno = new ArrayList<Empleado>();
		
		for (Empleado empleado : lista) {
			if (eval.test(empleado)) {
				listaRetorno.add(empleado);
			}
		}
		
		return listaRetorno;
	}
}
