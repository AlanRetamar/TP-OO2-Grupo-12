package testpersona;

import java.time.LocalDate;
import java.util.List;

import datos.Cliente;
import datos.Direccion;
import datos.Localidad;
import datos.Persona;
import datos.Provincia;
import negocio.DireccionAbm;
import negocio.LocalidadAbm;
import negocio.PersonaAbm;
import negocio.ProvinciaAbm;

public class TestTraerPorLocalidad {
    public static void main(String[] args) {
        PersonaAbm personaAbm = new PersonaAbm();
        DireccionAbm direccionAbm = new DireccionAbm();
        LocalidadAbm localidadAbm = new LocalidadAbm();
        ProvinciaAbm provinciaAbm = new ProvinciaAbm();
        
        Provincia pr= new Provincia("Buenos Aires");
        provinciaAbm.agregar(pr);
        Localidad longchamps = new Localidad("Longchamps", pr);
        localidadAbm.agregar(longchamps);

        Cliente c1 = new Cliente("Daniel", "Alves", 12345, LocalDate.of(1980, 12, 12),
                "danielalves@gmail.com", "11233345", "contraseña12", "AC513");
        Cliente c2 = new Cliente("Maria", "Lopez", 67890, LocalDate.of(1992, 3, 25),
                "maria@gmail.com", "11345678", "ascaavd", "BC345");
        Cliente c3 = new Cliente("Juan", "Gomez", 11111, LocalDate.of(1985, 8, 10),
                "juan@gmail.com", "11444555", "asdfcasd", "ZZ999");

        personaAbm.agregarPersona(c1);
        personaAbm.agregarPersona(c2);
        personaAbm.agregarPersona(c3);

        Direccion d1 = new Direccion("Calle 1", "100", longchamps);
        Direccion d2 = new Direccion("Calle 2", "200", longchamps);
        Direccion d3 = new Direccion("Calle 3", "300", longchamps);

        direccionAbm.agregar(d1);
        direccionAbm.agregar(d2);
        direccionAbm.agregar(d3);

        personaAbm.asignarPersonaADireccion(c1.getDni(), d1.getCalle(),d1.getNumero());
        personaAbm.asignarPersonaADireccion(c2.getDni(), d2.getCalle(),d2.getNumero());
        personaAbm.asignarPersonaADireccion(c3.getDni(), d3.getCalle(),d3.getNumero());

        List<Persona> personasEnLongchamps = personaAbm.traerPorLocalidad("Longchamps");

        System.out.println("Personas con dirección en Longchamps:");
        for (Persona p : personasEnLongchamps) {
            System.out.println(p);
        }
    }
}
