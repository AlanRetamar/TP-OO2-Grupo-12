package testpersona;

import negocio.PersonaAbm;

public class TestVincularClienteYTurno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  int idCliente=1;  
		  int idTurno=1;
		 
		  PersonaAbm.getInstance().asignarClienteATurno(idCliente, idTurno);
		  System.out.println("Cliente con ID " + idCliente + " viculado con Turno con ID " + idTurno);

	}

}