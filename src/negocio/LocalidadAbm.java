package negocio;

import java.util.List;

import dao.LocalidadDao;
import datos.Localidad;

public class LocalidadAbm {
	LocalidadDao dao = new LocalidadDao();

	public Localidad traerLocalidad(int idLocalidad) {
		Localidad l = dao.traerLocalidad(idLocalidad);
		//Si es null que arroje la excepción de que la localidad no existe
		if(l == null) {
			throw new NullPointerException("La localidad con id " + idLocalidad + " no existe");
		}
		return l;
	}

	public int agregar(Localidad l) {
		return dao.agregarLocalidad(l);
	}

	public void modificar(Localidad l) {
		 dao.actualizarLocalidad(l);
	}

	public void eliminar(int idLocalidad) {
		Localidad l = dao.traerLocalidad(idLocalidad);
		//Si es null que arroje la excepción de que la provincia no existe
		if(l == null) {
			throw new NullPointerException("La localidad con id " + idLocalidad + " no existe");
		}
		Localidad l2 = traerLocalidadYDirecciones(idLocalidad);
		//Si no tiene localidades la provincia se va a eliminar
		if(l2.getDirecciones() != null && !l2.getDirecciones().isEmpty()) {
			throw new IllegalStateException("La localidad no se puede eliminar porque tiene tiene direcciones");
	    }
		dao.eliminarLocalidad(l2);
	}

	public List<Localidad> traer() {
		return dao.traer();
	}
	
	public Localidad traerLocalidadYDirecciones(int idLocalidad) {
		Localidad l = dao.traerLocalidadYDirecciones(idLocalidad);
		//Si es null que arroje la excepción de que la localidad no existe
		if(l == null) {
			throw new NullPointerException("La localidad con id " + idLocalidad + " no existe");
		}
		return l;
	}
}
