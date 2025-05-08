package testturno;

import datos.Turno;
import negocio.TurnoAbm;

public class TestActualizarEstadoTurno {
	public static void main(String[] args) {
		TurnoAbm abm = TurnoAbm.getInstance();
		int idTurno = 3;
		String nuevoEstado = "atendido"; // puede ser "pendiente", "cancelado", etc.

		try {
			Turno turno = abm.traerTurno(idTurno);

			if (turno == null) {
				System.out.println("Turno no encontrado.");
				return;
			}

			turno.setEstado(nuevoEstado);
			abm.actualizarTurno(turno);

			System.out.println("Estado del turno actualizado a: " + nuevoEstado);
		} catch (Exception e) {
			System.err.println("Error al cambiar estado del turno: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
