package testpersona;

import negocio.PersonaAbm;

public class TestEliminarPersona {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int idPersona = 5;
		int idDireccion = 2;
		int idTurno = 1;
	    PersonaAbm.getInstance().eliminarPersona(idPersona, idDireccion, idTurno);
		System.out.println("Persona con ID " + idPersona + " eliminada.");
	}

}
