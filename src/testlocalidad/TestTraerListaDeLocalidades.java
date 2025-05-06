package testlocalidad;

import java.util.List;

import datos.Direccion;
import datos.Localidad;
import negocio.LocalidadAbm;

public class TestTraerListaDeLocalidades {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalidadAbm localidadAbm = new LocalidadAbm();
		List<Localidad> localidades = localidadAbm.traer();
		
		for (Localidad elemento : localidades) {
		    System.out.println(elemento);
		    
	        for (Direccion direccion : elemento.getDirecciones()) {
	            System.out.println("Direccion: " + direccion);
	        }
		    
		}
	}

}
