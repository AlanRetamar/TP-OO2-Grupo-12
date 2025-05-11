package testpersona;

import java.time.LocalDate;

import datos.Cliente;
import negocio.PersonaAbm;

public class TestAgregarCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonaAbm abm = PersonaAbm.getInstance();
		// Agregar Cliente
		Cliente c = new Cliente("Luis", "Martinez", 90552881, LocalDate.of(1989, 03, 23), "martinez@gmail.com", "1124754590", "ramon94", "9314");
		int idC = abm.agregarPersona(c);
		System.out.println("Cliente agregado con ID: " + idC);
	}
	

	//String nombre, String apellido, int dni, LocalDate fechaDeNacimiento, String email, String telefono,
	//String contraseña, String codigo

}
