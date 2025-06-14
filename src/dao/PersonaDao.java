package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
            //guarda el objeto en la base de datos
            id = Integer.parseInt(session.save(objeto).toString()); // Devuelve el ID generado
            //si todo funciona correctamente se hace la transaccion, si no es asi se lanza la excepcion
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            session.close();
           
        }
        return id;
    }
    
    //Actualiza una persona en la base de datos.
    public void actualizarPersona(Persona objeto) {
        try {
            iniciaOperacion();
            //modifica el objeto en la base de datos
            session.update(objeto);
            //si todo funciona correctamente se hace la transaccion, si no es asi se lanza la excepcion
            tx.commit();
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
            //elimina el objeto de la base de datos
            //si todo funciona correctamente se hace la transaccion, si no es asi se lanza la excepcion
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
			//trae el objeto de la base de datos con el id indicado, el id tiene que ser clave primaria
			//:idPersona es el id que paso por parametro
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
			//trae el objeto de la base de datos con el dni indicado
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
	
	public Persona traerPersonaDniYDirecciones(int dni) {
		Persona objeto = null;
        try {
            iniciaOperacion();            
            String hql = "from datos.Persona p left join fetch p.direcciones where p.dni=:dni";            
            objeto=(Persona) session.createQuery(hql).setParameter("dni", dni).uniqueResult();
         
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
	
	public Cliente traerClienteDniEHistorialTurnos(int dni) {
        Cliente objeto = null;
        try {
            iniciaOperacion();            
            String hql = "from datos.Cliente c left join fetch c.historialDeTurnos where c.dni=:dni";            
            objeto=(Cliente) session.createQuery(hql).setParameter("dni", dni).uniqueResult();
         
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
	
	public Empleado traerEmpleadoDniYTurnos(int dni) {
		Empleado objeto = null;
        try {
            iniciaOperacion();            
            String hql = "from datos.Empleado e left join fetch e.turnos where e.dni=:dni";            
            objeto=(Empleado) session.createQuery(hql).setParameter("dni", dni).uniqueResult();
         
        }
 		finally {
 			session.close();
        }
        return objeto;
    }
	
	public Empleado traerEmpleadoDniYDireccion(int dni) {
		Empleado objeto= null;
        try {
            iniciaOperacion();            
            String hql = "select e from Empleado left join fetch e.direccion left join fetch d.localidad left join fetch l.provincia where e.dni = :dni";            
            objeto=(Empleado) session.createQuery(hql).setParameter("dni",dni ).uniqueResult();
         
        }
 		finally {
 			session.close();
        }
        return objeto;
	}
	
	public Cliente traerClienteDniYDireccion(int dni) {
		Cliente objeto= null;
        try {
            iniciaOperacion();            
            String hql = "select e from Empleado left join fetch e.direccion left join fetch d.localidad left join fetch l.provincia where e.dni = :dni";            
            objeto=(Cliente) session.createQuery(hql).setParameter("dni",dni ).uniqueResult();
         
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
	
			/*select distinct selecciona objetos de la entidad Empleado, 
			asegurando que no se repitan (por ejemplo, si un empleado tiene varios turnos).*/
			//Hace la consulta sobre la tabla (o clase) Empleado, con el alias e.
			//El uso de fetch indica que quiere traer los turnos junto con el empleado, en la misma consulta.
			//El left join permite que también se traigan empleados aunque no tengan turnos.
			String hqlEmpleados = "select distinct e from Empleado e left join fetch e.turnos";
			/*Se obtiene una lista con todas las instancias de la entidad Empleado que cumplan 
			con la consulta definida en hqlEmpleados*/
			List<Empleado> empleados = session.createQuery(hqlEmpleados, Empleado.class).list();
			
			String hqlClientes = "select distinct c from Cliente c left join fetch c.historialDeTurnos";
			List<Cliente> clientes = session.createQuery(hqlClientes, Cliente.class).list();

			//agrega todos los empleados y clientes a la lista de personas
			personas.addAll(empleados);
			personas.addAll(clientes);
		
		} finally {
			session.close();
		}
		return personas;
	}
	
	public List<Persona> traerPorLocalidad(String nombre) {
	    List<Persona> lista = new ArrayList<>();
	    try {
	        iniciaOperacion();
	        String hql = "select distinct p from Persona p " +
                    "left join fetch p.direcciones d " +
                    "left join fetch d.localidad l " +
                    "left join fetch l.provincia " +
                    "where l.nombre = :nombre";
	        lista = session.createQuery(hql, Persona.class)
	                       .setParameter("nombre", nombre)
	                       .getResultList();
	    } finally {
	            session.close();
	    }
	    return lista;
	}

}