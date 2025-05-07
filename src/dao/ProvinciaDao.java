package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Provincia;

public class ProvinciaDao {
	private static Session session;
	private Transaction tx;
	private static ProvinciaDao instancia = null; // Patrón Singleton

	protected ProvinciaDao() {
	}

	public static ProvinciaDao getInstance() {
		if (instancia == null)
			instancia = new ProvinciaDao();
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
	
	public int agregarProvincia(Provincia objeto) {
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

	public void actualizarProvincia(Provincia objeto) {
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

	public void eliminarProvincia(Provincia objeto) {
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

	public Provincia traerProvincia(int idProvincia) {
		Provincia objeto = null;
		try {
			iniciaOperacion();
			objeto = (Provincia) session.get(Provincia.class, idProvincia);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public List<Provincia> traer() throws HibernateException {
		List<Provincia> lista = null;
		try {
			iniciaOperacion();
			String hql = "select distinct p from Provincia p left join fetch p.localidades";
			lista = session.createQuery(hql, Provincia.class).getResultList();
		} finally {
			session.close();
		}
		return lista;
	}

	public Provincia traerProvinciaYLocalidades(int idProvincia) throws HibernateException {
		Provincia objeto = null;
        try {
            iniciaOperacion();            
            String hql = "from Provincia p left join fetch p.localidades where p.idProvincia=:idProvincia";            
            objeto=(Provincia) session.createQuery(hql).setParameter("idProvincia", idProvincia).uniqueResult();
         
        }
 		finally {
 			session.close();
        }
        return objeto;
    }
}
