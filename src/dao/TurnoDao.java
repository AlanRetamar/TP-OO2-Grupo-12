package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import datos.Turno;

public class TurnoDao {
	private static Session session;
	private Transaction tx;
	private static TurnoDao instancia = null; // Patrón Singleton

	protected TurnoDao() {
	}

	public static TurnoDao getInstance() {
		if (instancia == null)
			instancia = new TurnoDao();
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
	
    public int agregarTurno(Turno objeto) {
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
    
	public Turno traerTurno(int idTurno) {
		Turno objeto = null;
		try {
			iniciaOperacion();
			objeto = (Turno) session.createQuery("from Turno t where t.idTurno=:idTurno")
						.setParameter("idTurno", idTurno).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
}
