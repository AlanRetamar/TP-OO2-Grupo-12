package testpersona;

import negocio.PersonaAbm;

public class TestDesvincularClienteDeTurno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  int idCliente=5;  
		  int idTurno=1;
		 
		  PersonaAbm.getInstance().desvincularClienteDeTurno(idCliente, idTurno);
		  System.out.println("Cliente con ID " + idCliente + " desvinculado de Turno con ID " + idTurno);
	}

}
