package testdireccion;

import java.util.List;

import datos.Direccion;
import negocio.DireccionAbm;

public class TraerListaDeDirecciones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Direccion> direcciones = DireccionAbm.getInstance().traer();
		
		for (Direccion elemento : direcciones) {
		    System.out.println(elemento);
		}
	}

}
