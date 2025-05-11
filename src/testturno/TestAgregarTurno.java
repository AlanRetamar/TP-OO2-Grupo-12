package testturno;

import java.time.LocalDate;
import java.time.LocalTime;

import datos.Cliente;
import datos.Empleado;
import datos.Turno;
import negocio.PersonaAbm;
import negocio.TurnoAbm;

public class TestAgregarTurno {

	public static void main(String[] args) {
		TurnoAbm turnoAbm = TurnoAbm.getInstance();
		PersonaAbm personaAbm = PersonaAbm.getInstance();

		// Trae el cliente y el empleado ya existentes 
		Empleado empleado = personaAbm.traerEmpleado(2);

		// Crear el turno
		Turno turno = new Turno(LocalDate.now().plusDays(1), LocalTime.of(9, 30),"pendiente", "Consulta general", LocalDate.now(), empleado);

		// Agregar el turno
		int idTurno = turnoAbm.agregarTurno(turno);
		System.out.println("Turno agregado con ID: " + idTurno);
	}
}