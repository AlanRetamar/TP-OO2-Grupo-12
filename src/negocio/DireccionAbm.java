package negocio;

import java.util.List;


import dao.DireccionDao;
import datos.Direccion;
import datos.Localidad;


public class DireccionAbm {
	private static DireccionAbm instancia = null; // Patrón Singleton

	public DireccionAbm() {
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

	public Direccion traerDireccion(String calle, String numero) {
		Direccion d = DireccionDao.getInstance().traer(calle, numero);
		if(d == null) {
			throw new NullPointerException("La direccion " + calle + " " + "numero" + " no existe");
		}
		return d;
	}
	
	public Direccion traerDireccion_LocalidadYProvincia(String calle, String numero) {
	    Direccion d = DireccionDao.getInstance().traerDireccionConLocalidadYProvincia(calle, numero);

	    if (d == null) {
	        throw new NullPointerException("La dirección con calle " + calle + " " + numero + " no existe.");
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
	
	public void eliminar(String calle, String numero) {
		Direccion d = traerDireccion(calle, numero);
		if(d == null) {
			throw new NullPointerException("La direccion " + calle+ " "+ numero + " no existe");
		}
		
		d.setLocalidad(null);
		DireccionDao.getInstance().eliminarDireccion(d);
	}
	
	public void asignarLocalidadADireccion(String nombreLocalidad, String calle, String numero) {
	    Localidad localidad = LocalidadAbm.getInstance().traerLocalidad(nombreLocalidad);
	    if (localidad == null) {
	        throw new NullPointerException("La localidad " + nombreLocalidad + " no existe.");
	    }

	    Direccion direccion = DireccionAbm.getInstance().traerDireccion(calle,numero);
	    if (direccion == null) {
	        throw new NullPointerException("La direccion " + calle + " " + numero + " no existe.");
	    }

	    if (direccion.getLocalidad() != null && direccion.getLocalidad().equals(localidad)) {
	        throw new IllegalStateException("La direccion con id " + calle + " " + numero +  " ya está asignada a la localidad con id " + nombreLocalidad + ".");
	    }

	    direccion.setLocalidad(localidad);

	    DireccionDao.getInstance().actualizarDireccion(direccion);
	}


	public List<Direccion> traer() {
		return DireccionDao.getInstance().traer();
	}

}
