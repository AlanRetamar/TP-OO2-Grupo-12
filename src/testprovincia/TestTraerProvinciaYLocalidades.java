package testprovincia;

import datos.Provincia;
import negocio.ProvinciaAbm;


public class TestTraerProvinciaYLocalidades {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  int idProvincia=1;
		  ProvinciaAbm proAbm = new ProvinciaAbm();
		
		  Provincia provincia = proAbm.traerProvinciaYLocalidades(idProvincia);
		  System.out.printf("Traer Provincia y Localidades idProvincia=%d\n", idProvincia);
		  System.out.printf("\n%s\n", provincia);
		  System.out.printf("\n%s\n", provincia.getLocalidades());
	
			  
	  
	}

}
