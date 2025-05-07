package testdireccion;


import datos.Direccion;
import negocio.DireccionAbm;
import negocio.LocalidadAbm;

public class TestActualizarDireccion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 int idDireccion=1;
		 Direccion d = DireccionAbm.getInstance().traerDireccion(idDireccion);
		 System.out.printf("Actualizando direccion con id %d\n", idDireccion);
		 d.setCalle("circunvalacion");
		 d.setNumero("3099");
		 
		 int idLocalidad = 1;
		 d.setLocalidad(LocalidadAbm.getInstance().traerLocalidad(idLocalidad));
		 DireccionAbm.getInstance().modificar(d);
	}

}
