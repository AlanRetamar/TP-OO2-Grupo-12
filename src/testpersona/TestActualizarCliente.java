package testpersona;

import datos.Cliente;
import negocio.PersonaAbm;

public class TestActualizarCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int idPersona = 4;
		Cliente c = (Cliente) PersonaAbm.getInstance().traerCliente(idPersona);
		if(!(c instanceof Cliente)) {
			throw new IllegalStateException("La persona con id " + c.getIdCliente() + " no es un cliente");
		}else {
			//c.setNombre("Gabriel");
			//c.setApellido("Garcia");
			c.setDni(64069081);
			c.setCodigo("3490");;
			PersonaAbm.getInstance().actualizarPersona(c);
			System.out.println("cliente actualizado con ID: " + c.getIdPersona());
		}
	}

}

