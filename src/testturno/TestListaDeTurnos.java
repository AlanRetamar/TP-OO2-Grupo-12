package testturno;

import java.util.List;

import datos.Turno;
import negocio.TurnoAbm;

public class TestListaDeTurnos {

	public static void main(String[] args) {

		List<Turno> turnos = TurnoAbm.getInstance().traer();

		if (turnos.isEmpty()) {
			System.out.println("No hay turnos registrados");
			return;
		}

		System.out.println("LISTADO DE TURNOS");

		for (Turno turno : turnos) {
			System.out.println(turno);
		}
	}
}