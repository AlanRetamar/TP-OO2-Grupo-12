package testdireccion;

import datos.Direccion;
import negocio.DireccionAbm;

public class TestTraerDireccion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  int idDireccion=1;
		  Direccion direccion = DireccionAbm.getInstance().traerDireccion(idDireccion);
		  System.out.printf("Traer Direccion idDireccion=%d\n", idDireccion);
		  System.out.printf("\n%s\n", direccion);
	}

}
