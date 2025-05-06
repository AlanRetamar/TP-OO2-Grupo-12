package negocio;

import java.util.List;

import dao.PersonaDao;
import datos.Cliente;
import datos.Empleado;
import datos.Persona;
import datos.Turno;





public class PersonaAbm {
	private static PersonaAbm instancia = null; // Patrón Singleton

	protected PersonaAbm() {
	}

	public static PersonaAbm getInstance() {
		if (instancia == null)
			instancia = new PersonaAbm();
		return instancia;
	}
	
	public int agregarPersona(Persona p) {
		//Si la persona tiene un dni que ya esta en el sistema se lanza la excepcion
		if(PersonaDao.getInstance().traerPersonaPorDni(p.getDni()) != null) {
			throw new IllegalStateException("La persona con dni " + p.getDni() + " ya existe en el sistema");
		}
		return	PersonaDao.getInstance().agregarPersona(p);	
	}
	
	public void actualizarPersona(Persona p) {
		//Trae a la persona por dni
		Persona Personaexistente = PersonaDao.getInstance().traerPersonaPorDni(p.getDni());
		//En caso de editar el dni, antes de actualizar, validar que no exista una persona con el mismo dni
		//y si eso pasa lanzar la Exception
			 if (Personaexistente != null && Personaexistente.getIdPersona() != p.getIdPersona()) {
			        throw new IllegalStateException("La persona con dni " + p.getDni() + " ya existe");
			 }
		PersonaDao.getInstance().actualizarPersona(p);
	}
	
	public void eliminarPersona(int idPersona) {
		//Trae a la persona por id
		Persona p = PersonaDao.getInstance().traer(idPersona);
		//Si la persona es null lanzara la excepcion
		if (p == null) throw new NullPointerException("La persona con ID " + idPersona + " no existe.");
		PersonaDao.getInstance().eliminarPersona(p);
	}
	
	public Empleado traerEmpleado(int idPersona) {
		//Trae a la persona por id
	    Persona e = PersonaDao.getInstance().traer(idPersona);
	   //Si el empleado es null lanzara la excepcion
	    if (e == null) {
	        throw new NullPointerException("No existe la persona con ID " + idPersona);
	    }

	    //Si la persona no es un empleado lanzara la excepcion
	    if (!(e instanceof Empleado)) {
	        throw new IllegalArgumentException("La persona con ID " + idPersona + " no es una un empleado");
	    }

	    return (Empleado) e;
	}
	
	public Cliente traerCliente(int idCliente) {
		//Trae a la persona por id
	    Persona c = PersonaDao.getInstance().traer(idCliente);
	    //Si el cliente es null lanzara la excepcion
	    if (c == null) {
	        throw new NullPointerException("No existe el cliente con ID " + idCliente);
	    }

	    //Si la persona no es un cliente lanzara la excepcion
	    if (!(c instanceof Cliente)) {
	        throw new IllegalArgumentException("La persona con ID " + idCliente + " no es un cliente");
	    }

	    return (Cliente) c;
	}
	
	public Persona traerPersonaYTurnos(int idPersona) {
		//Trae a la persona por id
		Persona p = PersonaAbm.getInstance().traerPersona(idPersona);
		//Si la persona es null lanzara la excepcion
		if(p == null) {
			   throw new NullPointerException("La persona con id " + idPersona + " no existe");
		}
		//Si la persona es un empleado, va a traelo con todos sus turnos 
		if(p instanceof Empleado) {
		    p = PersonaDao.getInstance().traerEmpleadoYTurnos(idPersona);
		}
		//Si la persona es un cliente, va a traelo con su historial de turnos 
		else if(p instanceof Cliente) {
			p = PersonaDao.getInstance().traerClienteEHistorialTurnos(idPersona);

		}
		return p;

	}

	public Persona traerPersona(int idPersona) {
		//Trae a la persona por id
		Persona p = PersonaDao.getInstance().traer(idPersona);
		//Si la persona es null lanzara la excepcion
		if(p == null) {
			throw new NullPointerException("La persona con id " + idPersona + " no existe");
		}
		return p;
	}

	public List<Persona> traer() {
		//Trae la lista de todas las personas agregadas
		return PersonaDao.getInstance().traer();
	}
	
	public void asignarClienteATurno(int idCliente, int idTurno) {
		//Trae el cliente con todos sus turnos
	    Cliente cliente =  PersonaDao.getInstance().traerClienteEHistorialTurnos(idCliente);

	    //Si el cliente es null lanzara la excepcion
	    if (cliente == null) {
	        throw new NullPointerException("Cliente con id " + idCliente + " no existe.");
	    }

	    //Trae el turno
	    Turno turno = TurnoAbm.getInstance().traerTurno(idTurno); 

	    //Si el turno es null lanzara la excepcion
	    if (turno == null) {
	        throw new NullPointerException("Turno con id " + idTurno + " no existe.");
	    }

	    //si el cliente en su historial de turnos ya contiene ese turno se lanzara la excepcion
	    if (cliente.getHistorialDeTurnos().contains(turno)) {
	        throw new IllegalStateException("El cliente con id " + idCliente + " ya está asignado al turno con id " + idTurno + ".");
	    }

	    //Agrega el turno al historial de turnos del cliente
	    cliente.getHistorialDeTurnos().add(turno);
	    //Delega al DAO la persistencia
	    PersonaDao.getInstance().actualizarClienteConTurnos(cliente); 
	}

}
