package testlocalidad;

import datos.Localidad;
import negocio.LocalidadAbm;
import negocio.ProvinciaAbm;

public class TestActualizarLocalidad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int idLocalidad=1;
		 Localidad l = LocalidadAbm.getInstance().traerLocalidad(idLocalidad);
		 System.out.printf("Actualizando localidad con id %d\n", idLocalidad);
		 l.setNombre("San Francisco");
		 
		 int idProvincia = 3;
		 l.setProvincia(ProvinciaAbm.getInstance().traerProvincia(idProvincia));
		 LocalidadAbm.getInstance().modificar(l);
	}

}
