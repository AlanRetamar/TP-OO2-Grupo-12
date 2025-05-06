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
	private static Session session;
	private Transaction tx;
	private static PersonaDao instancia = null; // Patrón Singleton

	protected PersonaDao() {
	}

	public static PersonaDao getInstance() {
		if (instancia == null)
			instancia = new PersonaDao();
		return instancia;
	}

	protected void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	protected void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	
    public int agregarPersona(Persona objeto) {
        int id = 0;
        try {
            iniciaOperacion();
            id = Integer.parseInt(session.save(objeto).toString());  // Esto lanzará ConstraintViolationException si se duplica el DNI
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            session.close();
           
        }
        return id;
    }
    
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