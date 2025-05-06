package testlocalidad;

import datos.Localidad;
import datos.Provincia;
import negocio.LocalidadAbm;
import negocio.ProvinciaAbm;

public class TestAgregarLocalidad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalidadAbm locabm = new LocalidadAbm();
		ProvinciaAbm proabm = new ProvinciaAbm();
		
		int idProvincia = 1;
		Provincia p = proabm.traerProvincia(idProvincia);
		Localidad l = new Localidad("Presidente Peron", p);
		
		int idProvinciaAgregada = locabm.agregar(l);
        System.out.printf("Id provincia %d: ", idProvinciaAgregada);
	}

}
