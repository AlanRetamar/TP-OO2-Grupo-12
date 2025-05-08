package testturno;

import java.util.List;

import datos.Persona;
import datos.Cliente;
import datos.Empleado;
import datos.Turno;
import negocio.PersonaAbm;

public class TestListaDeTurnos {

	public static void main(String[] args) {

		List<Persona> personas = PersonaAbm.getInstance().traer(); 

		for (Persona persona : personas) {
			System.out.println(persona); 

			if (persona instanceof Empleado) {
				Empleado empleado = (Empleado) persona;
				for (Turno turno : empleado.getTurnos()) {
					System.out.println("\tTurno como empleado: " + turno);
				}
			}

			if (persona instanceof Cliente) {
				Cliente cliente = (Cliente) persona;
				for (Turno turno : cliente.getHistorialDeTurnos()) {
					System.out.println("\tTurno como cliente: " + turno);
				}
			}
		}
	}
}
