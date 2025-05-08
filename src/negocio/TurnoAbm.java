package negocio;

import java.util.List;
import dao.TurnoDao;
import datos.Turno;

public class TurnoAbm {
	private static TurnoAbm instancia = null; 

	protected TurnoAbm() {
	}

	public static TurnoAbm getInstance() {
		if (instancia == null)
			instancia = new TurnoAbm();
		return instancia;
	}
	
	
	public int agregarTurno(Turno t) {
		// Validación: evitar duplicados exactos (puede adaptarse)
		List<Turno> turnosEmpleado = TurnoDao.getInstance().traerTurnosPorEmpleado(t.getEmpleado().getIdPersona());
		for (Turno existente : turnosEmpleado) {
			if (existente.equals(t)) {
				throw new IllegalStateException("Ya existe un turno igual para este empleado.");
			}
		}
		return TurnoDao.getInstance().agregarTurno(t);
	}

	public void actualizarTurno(Turno t) {
		Turno existente = TurnoDao.getInstance().traerTurno(t.getIdTurno());
		if (existente == null) {
			throw new NullPointerException("El turno con ID " + t.getIdTurno() + " no existe.");
		}
		TurnoDao.getInstance().actualizarTurno(t);
	}

	public void eliminarTurno(int idTurno) {
		Turno turno = TurnoDao.getInstance().traerTurno(idTurno);
		if (turno == null) {
			throw new NullPointerException("El turno con ID " + idTurno + " no existe.");
		}

		TurnoDao.getInstance().eliminarTurno(turno);
	}

	public Turno traerTurno(int idTurno) {
		Turno t = TurnoDao.getInstance().traerTurno(idTurno);
		if (t == null) {
			throw new NullPointerException("El turno con ID " + idTurno + " no existe.");
		}
		return t;
	}
	public List<Turno> traer() {
		return TurnoDao.getInstance().traerTodos();
	}

	public List<Turno> traerTurnosPorEstado(String estado) {
		return TurnoDao.getInstance().traerTurnosPorEstado(estado);
	}

	public List<Turno> traerTurnosPorEmpleado(int idEmpleado) {
		if (idEmpleado <= 0) {
			throw new IllegalArgumentException("El ID del empleado debe ser mayor a cero.");
		}
		return TurnoDao.getInstance().traerTurnosPorEmpleado(idEmpleado);
	}

	public List<Turno> traerTurnosPorCliente(int idCliente) {
		if (idCliente <= 0) {
			throw new IllegalArgumentException("El ID del cliente debe ser mayor a cero.");
		}
		return TurnoDao.getInstance().traerTurnosPorCliente(idCliente);
	}

	public List<Turno> traerTurnosPorServicio(String servicio) {
		return TurnoDao.getInstance().traerTurnosPorServicio(servicio);
	}
	
}
