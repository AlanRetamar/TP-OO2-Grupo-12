package negocio;

import dao.TurnoDao;
import datos.Turno;

public class TurnoAbm {
	private static TurnoAbm instancia = null; // Patrón Singleton

	protected TurnoAbm() {
	}

	public static TurnoAbm getInstance() {
		if (instancia == null)
			instancia = new TurnoAbm();
		return instancia;
	}
	
	public int agregarTurno(Turno t) {
		return	TurnoDao.getInstance().agregarTurno(t);	
	}
	
	public Turno traerTurno(int idTurno) {
		Turno t = TurnoDao.getInstance().traerTurno(idTurno);
		if(t == null) {
			throw new NullPointerException("El turno con id " + idTurno + " no existe");
		}
		return t;
	}
}
