package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Localidad;
import datos.Persona;

public class LocalidadDao {
	private static Session session;
	private Transaction tx;
	private static LocalidadDao instancia = null; // Patrón Singleton

	protected LocalidadDao() {
	}

	public static LocalidadDao getInstance() {
		if (instancia == null)
			instancia = new LocalidadDao();
		return instancia;
	}

	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	
	public int agregarLocalidad(Localidad objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return id;
	}

	public void actualizarLocalidad(Localidad objeto) {
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

	public void eliminarLocalidad(Localidad objeto) {
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

	public Localidad traerLocalidad(int idLocalidad) {
		Localidad objeto = null;
		try {
			iniciaOperacion();
			objeto = (Localidad) session.get(Localidad.class, idLocalidad);
		} finally {
			session.close();
		}
		return objeto;
	}

	public Localidad traerLocalidad(String nombre) {
		Localidad objeto = null;
		try {
			iniciaOperacion();
			objeto = (Localidad) session.createQuery("from Localidad l where l.nombre=:nombre")
					.setParameter("nombre", nombre).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public List<Localidad> traer() throws HibernateException {
		List<Localidad> lista = null;
		try {
			iniciaOperacion();
			String hql = "select distinct l from Localidad l left join fetch l.direcciones";
			lista = session.createQuery(hql, Localidad.class).getResultList();
		} finally {
			session.close();
		}
		return lista;
	}

	public Localidad traerLocalidadYDirecciones(int idLocalidad) throws HibernateException {
		Localidad objeto = null;
        try {
            iniciaOperacion();            
            String hql = "from Localidad l left join fetch l.direcciones where l.idLocalidad=:idLocalidad";            
            objeto=(Localidad) session.createQuery(hql).setParameter("idLocalidad", idLocalidad).uniqueResult();
         
        }
 		finally {
 			session.close();
        }
        return objeto;
    }
	
	public Localidad traerLocalidadYDirecciones(String nombre) throws HibernateException {
		Localidad objeto = null;
        try {
            iniciaOperacion();            
            String hql = "from Localidad l left join fetch l.direcciones where l.nombre=:nombre";            
            objeto=(Localidad) session.createQuery(hql).setParameter("nombre", nombre).uniqueResult();
         
        }
 		finally {
 			session.close();
        }
        return objeto;
    }
}
