package testlocalidad;

import datos.Localidad;
import datos.Provincia;
import negocio.LocalidadAbm;
import negocio.ProvinciaAbm;

public class TestAgregarLocalidad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int idProvincia = 1;
		Provincia p = ProvinciaAbm.getInstance().traerProvincia(idProvincia);
		Localidad l = new Localidad("Presidente Peron", p);
		
		int idProvinciaAgregada = LocalidadAbm.getInstance().agregar(l);
        System.out.printf("Id provincia %d: ", idProvinciaAgregada);
	}

}
