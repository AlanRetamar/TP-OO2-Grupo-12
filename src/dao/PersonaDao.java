package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import datos.Cliente;
import datos.Empleado;
import datos.Persona;

public class PersonaDao {
	//Se declara una Session y Transaction de Hibernate para manejar la base de datos.
	private static Session session;
	private Transaction tx;
	//instancia es parte del patrón Singleton, que asegura que haya una única instancia de PersonaDao.
	private static PersonaDao instancia = null; // Patrón Singleton

	//Constructor protegido para evitar que otras clases instancien la clase directamente (por el Singleton)
	protected PersonaDao() {
	}

	//Devuelve la única instancia de PersonaDao. Si no existe, la crea.
	public static PersonaDao getInstance() {
		if (instancia == null)
			instancia = new PersonaDao();
		return instancia;
	}

	//Inicia una sesión y transacción en Hibernate antes de ejecutar operaciones sobre la base de datos.
	protected void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	//Método auxiliar para manejar errores y deshacer cambios si ocurre una excepción de Hibernate.
	protected void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	
	//Agrega una nueva persona a la base de datos, hace commit si todo sale bien y cierra la sesión. 
	//Lanza excepción si falla.
    public int agregarPersona(Persona objeto) {
        int id = 0;
        try {
            iniciaOperacion();
            id = Integer.parseInt(session.save(objeto).toString()); // Devuelve el ID generado
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            session.close();
           
        }
        return id;
    }
    
    //Actualiza una persona en la base de datos sin relaciones asociadas.
    public void actualizarPersona(Persona objeto) {
        try {
            iniciaOperacion();
            session.update(objeto);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            session.close();
        }
    }
    
    //Actualiza una persona y también las direcciones relacionadas (tabla intermedia).
    public void actualizarPersonaConDirecciones(Persona persona) {
        try {
            iniciaOperacion();
            session.update(persona); // actualiza persona y la tabla intermedia
            tx.commit();
        } catch (ConstraintViolationException e) {
            tx.rollback();
            throw new IllegalStateException("❌ Ya existe una relación entre ese persona y esa direccion.");
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            session.close();
        }
    }
    
    //Actualiza un Cliente y su historial de turnos.
    public void actualizarClienteConTurnos(Cliente cliente) {
        try {
            iniciaOperacion();
            session.update(cliente); // actualiza cliente y la tabla intermedia
            tx.commit();
        } catch (ConstraintViolationException e) {
            tx.rollback();
            throw new IllegalStateException("❌ Ya existe una relación entre ese cliente y ese turno.");
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            session.close();
        }
    }
    
    //Elimina una persona de la base de datos.
    public void eliminarPersona(Persona objeto) {
        try {
            iniciaOperacion();
            session.delete(objeto);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            session.close();
        }
    }

    //Trae una persona por ID.
	public Persona traer(int idPersona) {
		Persona objeto = null;
		try {
			iniciaOperacion();
			objeto = (Persona) session.createQuery("from Persona p where p.idPersona=:idPersona")
						.setParameter("idPersona", idPersona).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	//Trae una persona por su DNI.
	public Persona traerPersonaPorDni(int dni) {
		Persona objeto = null;
		try {
			iniciaOperacion();
			objeto = (Persona) session.createQuery("from Persona p where p.dni=:dni")
						.setParameter("dni", dni).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	//Trae una persona junto con sus direcciones, si no tiene direcciones trae una lista vacia
	public Persona traerPersonaYDirecciones(int idPersona) {
		Persona objeto = null;
        try {
            iniciaOperacion();            
            String hql = "from datos.Persona p left join fetch p.direcciones where p.idPersona=:idPersona";            
            objeto=(Persona) session.createQuery(hql).setParameter("idPersona", idPersona).uniqueResult();
         
        }
 		finally {
 			session.close();
        }
        return objeto;
    }
	
    //Trae un cliente y sus turnos, si no tiene turnos trae una lista vacia
	public Cliente traerClienteEHistorialTurnos(int idCliente) {
        Cliente objeto = null;
        try {
            iniciaOperacion();            
            String hql = "from datos.Cliente c left join fetch c.historialDeTurnos where c.idPersona=:idCliente";            
            objeto=(Cliente) session.createQuery(hql).setParameter("idCliente", idCliente).uniqueResult();
         
        }
 		finally {
 			session.close();
        }
        return objeto;
    }
	
	//Trae un empleado y sus turnos, si no tiene turnos trae una lista vacia 
	public Empleado traerEmpleadoYTurnos(int idEmpleado) {
		Empleado objeto = null;
        try {
            iniciaOperacion();            
            String hql = "from datos.Empleado e left join fetch e.turnos where e.idPersona=:idEmpleado";            
            objeto=(Empleado) session.createQuery(hql).setParameter("idEmpleado", idEmpleado).uniqueResult();
         
        }
 		finally {
 			session.close();
        }
        return objeto;
    }
	
	//Trae una lista con todos los empleados y clientes con sus turnos.
	public List<Persona> traer() throws HibernateException {
		List<Persona> personas = new ArrayList<>();
		try {
			iniciaOperacion();
			// solo si p es Empleado
			String hqlEmpleados = "select distinct e from Empleado e left join fetch e.turnos";
			List<Empleado> empleados = session.createQuery(hqlEmpleados, Empleado.class).list();
			
			// solo si p es Cliente
			String hqlClientes = "select distinct c from Cliente c left join fetch c.historialDeTurnos";
			List<Cliente> clientes = session.createQuery(hqlClientes, Cliente.class).list();

			personas.addAll(empleados);
			personas.addAll(clientes);
		
		} finally {
			session.close();
		}
		return personas;
	}
}