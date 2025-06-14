package negocio;

import java.util.List;

import org.hibernate.HibernateException;

import dao.LocalidadDao;
import datos.Localidad;
import datos.Persona;
import datos.Provincia;

public class LocalidadAbm {
	private static LocalidadAbm instancia = null; // Patrón Singleton

	public LocalidadAbm() {
	}

	public static LocalidadAbm getInstance() {
		if (instancia == null)
			instancia = new LocalidadAbm();
		return instancia;
	}

	public Localidad traerLocalidad(int idLocalidad) {
		Localidad l = LocalidadDao.getInstance().traerLocalidad(idLocalidad);
		//Si es null que arroje la excepción de que la localidad no existe
		if(l == null) {
			throw new NullPointerException("La localidad con id " + idLocalidad + " no existe");
		}
		return l;
	}
	
	public Localidad traerLocalidad(String nombre) {
		Localidad l = LocalidadDao.getInstance().traerLocalidad(nombre);
		//Si es null que arroje la excepción de que la localidad no existe
		if(l == null) {
			throw new NullPointerException("La localidad " + nombre + " no existe");
		}
		return l;
	}

	public int agregar(Localidad l) {
		return LocalidadDao.getInstance().agregarLocalidad(l);
	}

	public void modificar(Localidad l) {
		LocalidadDao.getInstance().actualizarLocalidad(l);
	}

	public void eliminar(int idLocalidad) {
		Localidad l = LocalidadDao.getInstance().traerLocalidad(idLocalidad);
		//Si es null que arroje la excepción de que la provincia no existe
		if(l == null) {
			throw new NullPointerException("La localidad con id " + idLocalidad + " no existe");
		}
		Localidad l2 = traerLocalidadYDirecciones(idLocalidad);
		//Si no tiene localidades la provincia se va a eliminar
		if(l2.getDirecciones() != null && !l2.getDirecciones().isEmpty()) {
			throw new IllegalStateException("La localidad no se puede eliminar porque tiene tiene direcciones");
	    }
		LocalidadDao.getInstance().eliminarLocalidad(l2);
	}

	public void eliminar(String nombre) {
		Localidad l = LocalidadDao.getInstance().traerLocalidad(nombre);
		//Si es null que arroje la excepción de que la provincia no existe
		if(l == null) {
			throw new NullPointerException("La localidad " + nombre + " no existe");
		}
		Localidad l2 = traerLocalidadYDirecciones(nombre);
		//Si no tiene localidades la provincia se va a eliminar
		if(l2.getDirecciones() != null && !l2.getDirecciones().isEmpty()) {
			throw new IllegalStateException("La localidad no se puede eliminar porque tiene tiene direcciones");
	    }
		LocalidadDao.getInstance().eliminarLocalidad(l2);
	}
	
	public List<Localidad> traer() {
		return LocalidadDao.getInstance().traer();
	}
	
	public Localidad traerLocalidadYDirecciones(int idLocalidad) {
		Localidad l = LocalidadDao.getInstance().traerLocalidadYDirecciones(idLocalidad);
		//Si es null que arroje la excepción de que la localidad no existe
		if(l == null) {
			throw new NullPointerException("La localidad con id " + idLocalidad + " no existe");
		}
		return l;
	}
	
	
	public Localidad traerLocalidadYDirecciones(String nombre) {
		Localidad l = LocalidadDao.getInstance().traerLocalidadYDirecciones(nombre);
		//Si es null que arroje la excepción de que la localidad no existe
		if(l == null) {
			throw new NullPointerException("La localidad  " +nombre + " no existe");
		}
		return l;
	}
	public void asignarProvinciaALocalidad(String nombreProvincia, String nombreLocalidad) {
	    Provincia provincia = ProvinciaAbm.getInstance().traerProvincia(nombreProvincia);
	    if (provincia == null) {
	        throw new NullPointerException("Provincia " + nombreProvincia + " no existe.");
	    }

	    Localidad localidad = LocalidadAbm.getInstance().traerLocalidad(nombreLocalidad);
	    if (localidad == null) {
	        throw new NullPointerException("Localidad " + nombreProvincia + " no existe.");
	    }

	    // Si ya está asignada, no repetir
	    if (localidad.getProvincia() != null && localidad.getProvincia().equals(provincia)) {
	        throw new IllegalStateException("La localidad " + nombreLocalidad + " ya está asignada a la provincia " + nombreProvincia);
	    }

	    // Vincula la localidad con la provincia
	    localidad.setProvincia(provincia);

	    // Guarda los cambios
	    LocalidadDao.getInstance().actualizarLocalidad(localidad);
	}

}
