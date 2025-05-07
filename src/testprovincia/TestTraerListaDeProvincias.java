package testprovincia;

import java.util.List;

import datos.Localidad;
import datos.Provincia;
import negocio.ProvinciaAbm;

public class TestTraerListaDeProvincias {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Provincia> provincias = ProvinciaAbm.getInstance().traer();
		
		for (Provincia elemento : provincias) {
		    System.out.println(elemento);
		    
	        for (Localidad localidad : elemento.getLocalidades()) {
	            System.out.println("Localidad: " + localidad);
	        }
		    
		}
	}

}
