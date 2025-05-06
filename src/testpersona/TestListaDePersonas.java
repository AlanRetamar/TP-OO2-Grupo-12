package testpersona;

import java.util.List;

import datos.Cliente;
import datos.Empleado;
import datos.Persona;
import datos.Turno;
import negocio.PersonaAbm;

public class TestListaDePersonas {
	
	 public static void main(String[] args) {
		 
		 List<Persona> personas = PersonaAbm.getInstance().traer();		 

		 for (Persona elemento : personas) {
			    System.out.println(elemento);

			    if (elemento instanceof Empleado) {
			        Empleado empleado = (Empleado) elemento;
			        for (Turno turno : empleado.getTurnos()) {
			            System.out.println("Turno como empleado: " + turno);
			        }
			    }

			    if (elemento instanceof Cliente) {
			        Cliente cliente = (Cliente) elemento;
			        for (Turno turno : cliente.getHistorialDeTurnos()) {
			            System.out.println("Turno como cliente: " + turno);
			        }
			    }
			}
	 }
}
