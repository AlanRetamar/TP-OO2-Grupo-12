package testprovincia;

import negocio.ProvinciaAbm;

public class TestEliminarProvincia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ProvinciaAbm abmProvincia = new ProvinciaAbm();
        int idProvincia = 2;
        abmProvincia.eliminar(idProvincia);
        System.out.println("Provincia con ID " + idProvincia + " eliminada.");
	}

}
