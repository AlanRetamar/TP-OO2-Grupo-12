package dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Turno;


public class TurnoDao {
    private static Session session;
    private Transaction tx;
    private static TurnoDao instancia = null;

    protected TurnoDao() {}

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
	//Agrega un nuevo turno a la base de datos, hace commit si todo sale bien y cierra la sesión. 
	//Lanza excepción si falla.
    public int agregarTurno(Turno turno) {
        int id = 0;
        try {
            iniciaOperacion();
            id = Integer.parseInt(session.save(turno).toString());
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            session.close();
        }
        return id;
    }
  //Actualiza un turno en la base de datos.
    public void actualizarTurno(Turno turno) {
        try {
            iniciaOperacion();
            session.update(turno);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            session.close();
        }
    }
  //Elimina un turno de la base de datos.
    public void eliminarTurno(Turno turno) {
        try {
            iniciaOperacion();
            session.delete(turno);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            session.close();
        }
    }
  //Trae un turno por ID.
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

  //Trae todos los turnos
    public List<Turno> traerTodos() {
        List<Turno> lista = null;
        try {
            iniciaOperacion();
            String hql = "from Turno t left join fetch t.empleado";
            lista = session.createQuery(hql, Turno.class).list();
        } finally {
            session.close();
        }
        return lista;
    }
    //Turnos por fecha
    public List<Turno> traerTurnosPorFecha(LocalDate fecha) {
        List<Turno> lista = null;
        try {
            iniciaOperacion();
            lista = session.createQuery("from Turno t where t.fecha = :fecha", Turno.class)
                    .setParameter("fecha", fecha)
                    .list();
        } finally {
            session.close();
        }
        return lista;
    }
    //Turnos por estado
    public List<Turno> traerTurnosPorEstado(String estado) {
        List<Turno> lista = null;
        try {
            iniciaOperacion();
            lista = session.createQuery("from Turno t where t.estado = :estado", Turno.class)
                    .setParameter("estado", estado)
                    .list();
        } finally {
            session.close();
        }
        return lista;
    }
    //Turnos por servicio
    public List<Turno> traerTurnosPorServicio(String servicio) {
        List<Turno> lista = null;
        try {
            iniciaOperacion();
            lista = session.createQuery("from Turno t where t.servicio = :servicio", Turno.class)
                    .setParameter("servicio", servicio)
                    .list();
        } finally {
            session.close();
        }
        return lista;
    }

    //Turnos por empleado
    public List<Turno> traerTurnosPorEmpleado(int idEmpleado) {
        List<Turno> lista = null;
        try {
            iniciaOperacion();
            String hql = "from Turno t where t.empleado.idPersona = :idEmpleado";
            lista = session.createQuery(hql, Turno.class)
                    .setParameter("idEmpleado", idEmpleado)
                    .list();
        } finally {
            session.close();
        }
        return lista;
    }

}
