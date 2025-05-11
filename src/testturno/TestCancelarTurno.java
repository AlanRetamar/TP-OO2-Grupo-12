package testturno;

import datos.Turno;
import negocio.TurnoAbm;

public class TestCancelarTurno {

	public static void main(String[] args) {
		TurnoAbm abm = TurnoAbm.getInstance();

		int idTurno = 1; // ID del turno a cancelar 
		try {
			Turno turno = abm.traerTurno(idTurno);

			if (turno == null) {
				System.out.println("El turno con ID " + idTurno + " no existe.");
				return;
			}

			if ("cancelado".equalsIgnoreCase(turno.getEstado())) {
				System.out.println("El turno ya está cancelado.");
				return;
			}

			turno.setEstado("cancelado");
			abm.actualizarTurno(turno);

			System.out.println("El turno fue cancelado correctamente.");
		} catch (Exception e) {
			System.err.println("Error al cancelar el turno: " + e.getMessage());
			e.printStackTrace();
		}
	}
}