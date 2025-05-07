package testpersona;

import negocio.PersonaAbm;

public class TestVincularPersonaYDireccion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  int idPersona=2;  
		  int idDireccion=2;
		 
		  PersonaAbm.getInstance().asignarPersonaADireccion(idPersona, idDireccion);
		  System.out.println("Persona con ID " + idPersona + " vinculado con Direccion con ID " + idDireccion);
	}

}
