package testpersona;

import negocio.PersonaAbm;

public class TestEliminarPersona {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int idPersona = 2;
	    PersonaAbm.getInstance().eliminarPersona(idPersona);
		System.out.println("Persona con ID " + idPersona + " eliminada.");
	}

}
