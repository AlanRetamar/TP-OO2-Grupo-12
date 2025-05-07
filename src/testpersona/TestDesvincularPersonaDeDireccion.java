package testpersona;

import negocio.PersonaAbm;

public class TestDesvincularPersonaDeDireccion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int idPersona = 2;
		int idDireccion = 2;
		
		PersonaAbm.getInstance().desvincularPersonaDeDireccion(idPersona, idDireccion);
		System.out.println("Persona con ID " + idPersona + " desvinculado de Direccion con ID " + idDireccion);
	}

}
