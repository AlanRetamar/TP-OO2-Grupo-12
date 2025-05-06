package testlocalidad;

import datos.Localidad;
import negocio.LocalidadAbm;

public class TestTraerLocalidadYDirecciones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  int idLocalidad=1;
		  LocalidadAbm locAbm = new LocalidadAbm();
		
		  Localidad localidad = locAbm.traerLocalidadYDirecciones(idLocalidad);
		  System.out.printf("Traer Localidad y Provincia idLocalidad=%d\n", idLocalidad);
		  System.out.printf("\n%s\n", localidad);
		  System.out.printf("\n%s\n", localidad.getDirecciones());
	}

}
