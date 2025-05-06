package testpersona;

import negocio.PersonaAbm;

public class TestTraerPersonaYTurnos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int idPersona=2;
		 System.out.printf("+ traer(%d)\n", idPersona);
		 System.out.println(PersonaAbm.getInstance().traerPersonaYTurnos(idPersona));
	}

}
