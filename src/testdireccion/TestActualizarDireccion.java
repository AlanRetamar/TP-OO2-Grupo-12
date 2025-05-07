package testdireccion;

import datos.Direccion;
import negocio.DireccionAbm;
import negocio.LocalidadAbm;

public class TestActualizarDireccion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 DireccionAbm direccionAbm = new DireccionAbm();
		 int idDireccion=1;
		 Direccion d = direccionAbm.traerDireccion(idDireccion);
		 System.out.printf("Actualizando direccion con id %d\n", idDireccion);
		 d.setCalle("circunvalacion");
		 d.setNumero("4589");
		 
		 LocalidadAbm localidadAbm = new LocalidadAbm();
		 int idLocalidad = 3;
		 d.setLocalidad(localidadAbm.traerLocalidad(idLocalidad));
		 direccionAbm.modificar(d);
	}

}
