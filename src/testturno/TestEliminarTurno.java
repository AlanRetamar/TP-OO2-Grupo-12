package testturno;

import datos.Turno;
import negocio.TurnoAbm;

public class TestEliminarTurno {

	public static void main(String[] args) {
		TurnoAbm abm = TurnoAbm.getInstance();
		int idTurno = 3; // Cambiá este ID según tu base

		try {
			Turno turno = abm.traerTurno(idTurno);

			if (turno == null) {
				System.out.println("Turno con ID " + idTurno + " no existe.");
				return;
			}

			abm.eliminarTurno(idTurno);
			System.out.println("Turno eliminado correctamente.");

		} catch (Exception e) {
			System.err.println("Error al eliminar el turno: " + e.getMessage());
			e.printStackTrace();
		}
	}
}