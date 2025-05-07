package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Direccion;

public class DireccionDao {
	private static Session session;
	private Transaction tx;
	private static DireccionDao instancia = null; // Patrón Singleton

	protected DireccionDao() {
	}

	public static DireccionDao getInstance() {
		if (instancia == null)
			instancia = new DireccionDao();
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

	public int agregarDireccion(Direccion objeto) {
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

	public void actualizarDireccion(Direccion objeto) {
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

	public void eliminarDireccion(Direccion objeto) {
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

	public Direccion traer(int idDireccion) {
		Direccion objeto = null;
		try {
			iniciaOperacion();
			objeto = (Direccion) session.get(Direccion.class, idDireccion);
		} finally {
			session.close();
		}
		return objeto;
	}

	public List<Direccion> traer() throws HibernateException {
		List<Direccion> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Direccion d order by d.idDireccion asc",
					Direccion.class).getResultList();

		} finally {
			session.close();
		}

		return lista;
	}

	public Direccion traerDireccionYLocalidad(int idDireccion) throws HibernateException {
		Direccion objeto = null;
		try {
			iniciaOperacion();
			String hql = "from Direccion d left join fetch d.localidad where d.idDireccion = :idDireccion";
			objeto = (Direccion) session.createQuery(hql).setParameter("idDireccion", idDireccion).uniqueResult();

		} finally {
			session.close();
		}
		return objeto;
	}
}
