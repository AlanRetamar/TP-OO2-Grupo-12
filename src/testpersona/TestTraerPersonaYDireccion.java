package testpersona;

import java.time.LocalDate;

import datos.Cliente;
import datos.Direccion;
import datos.Localidad;
import datos.Provincia;
import negocio.DireccionAbm;
import negocio.LocalidadAbm;
import negocio.PersonaAbm;
import negocio.ProvinciaAbm;

public class TestTraerPersonaYDireccion {
	public static void main(String[] args) {
		//Vinculo provincia con localidad, localidad con direccion y direccion con Persona/empleado/cliente
		PersonaAbm personaAbm= new PersonaAbm();
		DireccionAbm direccionAbm= new DireccionAbm();
		LocalidadAbm localidadAbm= new LocalidadAbm();
		ProvinciaAbm provinciaAbm= new ProvinciaAbm();
		Cliente c= new Cliente("Daniel", "Alves", 12345, LocalDate.of(1980, 12, 12),  "danielalves@gmail.com", "11233345", "contraseña12", "AC513");
	Provincia p= new Provincia("Buenos Aires");
    Localidad l= new Localidad("Longchamps", p);
    Direccion d= new Direccion("calle 1", "1234", l );
	
    personaAbm.agregarPersona(c);
    provinciaAbm.agregar(p);
    localidadAbm.agregar(l);
    direccionAbm.agregar(d);
    
    localidadAbm.asignarProvinciaALocalidad(p.getNombre(), l.getNombre());
    direccionAbm.asignarLocalidadADireccion(l.getNombre(), d.getCalle(), d.getNumero());
    
	System.out.println(personaAbm.traerClientePorDni(12345));
	System.out.println(direccionAbm.traerDireccion_LocalidadYProvincia(d.getCalle(),d.getNumero()));
	personaAbm.eliminarPersonaDni(12345);
	direccionAbm.eliminar(d.getCalle(), d.getNumero());
	localidadAbm.eliminar(l.getNombre());
	provinciaAbm.eliminar(p.getNombre());

	}
}
