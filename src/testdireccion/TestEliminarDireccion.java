package testdireccion;

import negocio.DireccionAbm;


public class TestEliminarDireccion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        DireccionAbm abmDireccion = new DireccionAbm();
        int idDireccion = 3;
        abmDireccion.eliminar(idDireccion);
        System.out.println("Direccion con ID " + idDireccion + " eliminada.");
	}

}
