package negocio;

import java.util.List;


import dao.DireccionDao;
import datos.Direccion;


public class DireccionAbm {
	private static DireccionAbm instancia = null; // Patrón Singleton

	protected DireccionAbm() {
	}

	public static DireccionAbm getInstance() {
		if (instancia == null)
			instancia = new DireccionAbm();
		return instancia;
	}

	public Direccion traerDireccion(int idDireccion) {
		Direccion d = DireccionDao.getInstance().traer(idDireccion);
		if(d == null) {
			throw new NullPointerException("La direccion con id " + idDireccion + " no existe");
		}
		return d;
	}

	public int agregar(Direccion d) {
		return DireccionDao.getInstance().agregarDireccion(d);
	}

	public void modificar(Direccion d) {
		DireccionDao.getInstance().actualizarDireccion(d);
	}

	public void eliminar(int idDireccion) {
		Direccion d = traerDireccion(idDireccion);
		if(d == null) {
			throw new NullPointerException("La direccion con id " + idDireccion + " no existe");
		}
		
		d.setLocalidad(null);
		DireccionDao.getInstance().eliminarDireccion(d);
	}

	public List<Direccion> traer() {
		return DireccionDao.getInstance().traer();
	}

	/*public Direccion traerDireccionYLocalidad(int idDireccion) {
		Direccion d = traer(idDireccion);
		if(d == null) {
			throw new NullPointerException("La direccion con id " + idDireccion + " no existe");
		}
		return dao.traerDireccionYLocalidad(idDireccion);
	}*/
}
