package testpersona;


import negocio.PersonaAbm;

import java.time.LocalDate;

import datos.Cliente;

public class TestTreaerPersonaPorDni {
	public static void main(String[] args) {

	  
		PersonaAbm personaAbm = new PersonaAbm();
	    Cliente c= new Cliente("Juan", "Pérez", 1234, LocalDate.now() , "juanperez@gmail.com", "111234", "password", "AB123");
	    personaAbm.agregarPersona(c);

	   
	    Cliente cli=(Cliente) personaAbm.traerClientePorDni(1234);
	  
	    System.out.println("Se creo con exito y se trajo al cliente " + cli.getNombre() + " " + cli.getDni());
	
	    personaAbm.eliminarPersonaDni(1234);
}
}
