package testpersona;

import java.time.LocalDate;

import datos.Cliente;
import negocio.PersonaAbm;

public class TestAgregarCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonaAbm abm = PersonaAbm.getInstance();
		// Agregar Persona Física
		Cliente c = new Cliente("Ramon", "Sosa", 45567881, LocalDate.of(1994, 10, 19), "ramonsosa@gmail.com", "1124754590", "ramon94", "2334");
		int idC = abm.agregarPersona(c);
		System.out.println("Cliente agregado con ID: " + idC);
	}
	

	//String nombre, String apellido, int dni, LocalDate fechaDeNacimiento, String email, String telefono,
	//String contraseña, String codigo

}
