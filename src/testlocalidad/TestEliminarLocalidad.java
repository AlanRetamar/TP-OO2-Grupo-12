package testlocalidad;

import negocio.LocalidadAbm;

public class TestEliminarLocalidad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        LocalidadAbm abmLocalidad = new LocalidadAbm();
        int idLocalidad = 2;
        abmLocalidad.eliminar(idLocalidad);
        System.out.println("Localidad con ID " + idLocalidad + " eliminada.");
	}

}
