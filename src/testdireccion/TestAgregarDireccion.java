package testdireccion;

import datos.Direccion;
import datos.Localidad;
import negocio.DireccionAbm;
import negocio.LocalidadAbm;


public class TestAgregarDireccion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int idLocalidad = 1;
		Localidad l = LocalidadAbm.getInstance().traerLocalidad(idLocalidad);
		Direccion d = new Direccion("centenario", "1346", l);
		
		int idDireccionAgregada = DireccionAbm.getInstance().agregar(d);
        System.out.printf("Id Direccion %d: ", idDireccionAgregada);
	}

}
