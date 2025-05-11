package testpersona;

import datos.Empleado;
import negocio.PersonaAbm;

public class TestActualizarEmpleado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int idPersona = 2;
		Empleado e = (Empleado) PersonaAbm.getInstance().traerEmpleado(idPersona);
		if(!(e instanceof Empleado)) {
			throw new IllegalStateException("La persona con id " + e.getIdEmpleado() + " no es un empleado");
		}else {
			e.setNombre("Fabian");
			e.setApellido("Romero");
			e.setContraseña("1234");
			//e.setDni(45819081);
			//e.setFuncion("Ginecologo");
			PersonaAbm.getInstance().actualizarPersona(e);
			System.out.println("empleado actualizado con ID: " + e.getIdPersona());
		}
	}

}
