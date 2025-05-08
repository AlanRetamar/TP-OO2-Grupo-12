package testturno;

import java.time.LocalDate;
import java.time.LocalTime;

import datos.Turno;
import negocio.TurnoAbm;

public class TestModificarTurno {

	public static void main(String[] args) {
		TurnoAbm abm = TurnoAbm.getInstance();
		int idTurno = 3;

		try {
			Turno turno = abm.traerTurno(idTurno);

			if (turno == null) {
				System.out.println("❌ Turno no encontrado.");
				return;
			}

			// Nuevos datos
			turno.setFecha(LocalDate.now().plusDays(2));
			turno.setHora(LocalTime.of(14, 0));
			turno.setEstado("pendiente");

			abm.actualizarTurno(turno);

			System.out.println("✔ Turno modificado correctamente:");
			System.out.println("Nueva fecha: " + turno.getFecha());
			System.out.println("Nueva hora: " + turno.getHora());
			System.out.println("Nuevo estado: " + turno.getEstado());

		} catch (Exception e) {
			System.err.println("❌ Error al modificar turno: " + e.getMessage());
			e.printStackTrace();
		}
	}
}