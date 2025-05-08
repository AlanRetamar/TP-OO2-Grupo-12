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

		// Trae el cliente y el empleado ya existentes (asegúrate de tenerlos en la BD)
		Cliente cliente = personaAbm.traerCliente(1);
		Empleado empleado = personaAbm.traerEmpleado(2);

		// Crear el turno
		Turno turno = new Turno(LocalDate.now().plusDays(1), LocalTime.of(9, 30),"pendiente", "Consulta general", LocalDate.now(), empleado, cliente);

		// Agregar el turno
		int idTurno = turnoAbm.agregarTurno(turno);
		System.out.println("Turno agregado con ID: " + idTurno);
	}
}