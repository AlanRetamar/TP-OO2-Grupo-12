package testlocalidad;

import datos.Localidad;
import negocio.LocalidadAbm;
import negocio.ProvinciaAbm;

public class TestActualizarLocalidad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 LocalidadAbm localidadAbm = new LocalidadAbm();
		 int idLocalidad=1;
		 Localidad l=localidadAbm.traerLocalidad(idLocalidad);
		 System.out.printf("Actualizando localidad con id %d\n", idLocalidad);
		 l.setNombre("San Francisco");
		 
		 ProvinciaAbm provinciaAbm = new ProvinciaAbm();
		 int idProvincia = 3;
		 l.setProvincia(provinciaAbm.traerProvincia(idProvincia));
		 localidadAbm.modificar(l);
	}

}
