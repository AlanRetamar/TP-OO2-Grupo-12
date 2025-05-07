package testlocalidad;

import negocio.LocalidadAbm;

public class TestEliminarLocalidad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int idLocalidad = 2;
        LocalidadAbm.getInstance().eliminar(idLocalidad);
        System.out.println("Localidad con ID " + idLocalidad + " eliminada.");
	}

}
