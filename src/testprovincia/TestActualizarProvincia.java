package testprovincia;

import datos.Provincia;
import negocio.ProvinciaAbm;

public class TestActualizarProvincia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ProvinciaAbm abmProvincia = new ProvinciaAbm();
		 int idProvincia=2;
		 Provincia p=abmProvincia.traerProvincia(idProvincia);
		 System.out.printf("Actualizando provincia con id %d\n", idProvincia);
		 p.setNombre("Mendoza");
		 abmProvincia.modificar(p);
	}

}
