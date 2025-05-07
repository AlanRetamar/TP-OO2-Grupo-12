package testdireccion;

import negocio.DireccionAbm;


public class TestEliminarDireccion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int idDireccion = 3;
        DireccionAbm.getInstance().eliminar(idDireccion);
        System.out.println("Direccion con ID " + idDireccion + " eliminada.");
	}

}
