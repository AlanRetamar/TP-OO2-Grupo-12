package testprovincia;

import datos.Provincia;
import negocio.ProvinciaAbm;

public class TestAgregarProvincia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Provincia p = new Provincia("Cordoba");
		int idProvinciaAgregada = ProvinciaAbm.getInstance().agregar(p);
        System.out.printf("Id provincia %d: ", idProvinciaAgregada);
	}

}
