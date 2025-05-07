package negocio;

import java.util.List;


import dao.DireccionDao;
import datos.Direccion;


public class DireccionAbm {
	DireccionDao dao = new DireccionDao();

	public Direccion traerDireccion(int idDireccion) {
		Direccion d = dao.traer(idDireccion);
		if(d == null) {
			throw new NullPointerException("La direccion con id " + idDireccion + " no existe");
		}
		return d;
	}

	public int agregar(Direccion d) {
		return dao.agregarDireccion(d);
	}

	public void modificar(Direccion d) {
		dao.actualizarDireccion(d);
	}

	public void eliminar(int idDireccion) {
		Direccion d = traerDireccion(idDireccion);
		if(d == null) {
			throw new NullPointerException("La direccion con id " + idDireccion + " no existe");
		}
		
		d.setLocalidad(null);
		dao.eliminarDireccion(d);
	}

	public List<Direccion> traer() {
		return dao.traer();
	}

	/*public Direccion traerDireccionYLocalidad(int idDireccion) {
		Direccion d = traer(idDireccion);
		if(d == null) {
			throw new NullPointerException("La direccion con id " + idDireccion + " no existe");
		}
		return dao.traerDireccionYLocalidad(idDireccion);
	}*/
}
