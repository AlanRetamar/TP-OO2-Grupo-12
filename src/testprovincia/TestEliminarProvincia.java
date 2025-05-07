package testprovincia;

import negocio.ProvinciaAbm;

public class TestEliminarProvincia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int idProvincia = 2;
        ProvinciaAbm.getInstance().eliminar(idProvincia);
        System.out.println("Provincia con ID " + idProvincia + " eliminada.");
	}

}
