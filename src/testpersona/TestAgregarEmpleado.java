package testpersona;

import java.time.LocalDate;

import datos.Empleado;
import negocio.PersonaAbm;

public class TestAgregarEmpleado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonaAbm abm = PersonaAbm.getInstance();
		// Agregar Persona Física
		Empleado e = new Empleado("Gerardo", "Juarez", 45567891, LocalDate.of(1990, 07, 13), "gerardo@gmail.com", "1124784590", "gerardo90", LocalDate.of(2024, 05, 20), "Odontologo", "20455678913");
		int idE = abm.agregarPersona(e);
		System.out.println("Empleado agregado con ID: " + idE);
	}
	
	// String nombre, int dni, LocalDate fechaDeNacimiento, String email, String telefono,
	// String contraseña, LocalDate fechaDeIngreso, String funcion, String cuit

}
