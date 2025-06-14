package negocio;


import java.util.List;
import dao.ProvinciaDao;
import datos.Provincia;

public class ProvinciaAbm {
	private static ProvinciaAbm instancia = null; // Patrón Singleton

	public ProvinciaAbm() {
	}

	public static ProvinciaAbm getInstance() {
		if (instancia == null)
			instancia = new ProvinciaAbm();
		return instancia;
	}

	public Provincia traerProvincia(int idProvincia) {
		Provincia p = ProvinciaDao.getInstance().traerProvincia(idProvincia);
		if(p == null) {
			throw new NullPointerException("La provincia con id " + idProvincia + " no existe");
		}
		return p;
	}
	
	public Provincia traerProvincia(String nombre) {
		Provincia p = ProvinciaDao.getInstance().traerProvincia(nombre);
		
		
		if(p == null) {
			throw new NullPointerException("La provincia" + nombre + " no existe");
		}
		return p;
	}

	public int agregar(Provincia p) {
		return ProvinciaDao.getInstance().agregarProvincia(p);
	}

	public void modificar(Provincia p) {
		ProvinciaDao.getInstance().actualizarProvincia(p);
	}

	public void eliminar(int idProvincia) {
		Provincia p = ProvinciaDao.getInstance().traerProvincia(idProvincia);
		//Si es null que arroje la excepción de que la provincia no existe
		if(p == null) {
			throw new NullPointerException("La provincia con id " + idProvincia + " no existe");
		}
		Provincia p2 = traerProvinciaYLocalidades(idProvincia);
		//Si no tiene localidades la provincia se va a eliminar
		if(p2.getLocalidades() != null && !p2.getLocalidades().isEmpty()) {
			throw new IllegalStateException("La provincia no se puede eliminar porque tiene tiene localidades");
	    }
		ProvinciaDao.getInstance().eliminarProvincia(p2);
	}
	
	public void eliminar(String nombre) {
		Provincia p = ProvinciaDao.getInstance().traerProvincia(nombre);
		//Si es null que arroje la excepción de que la provincia no existe
		if(p == null) {
			throw new NullPointerException("La provincia " + nombre + " no existe");
		}
		Provincia p2 = traerProvinciaYLocalidades(nombre);
		//Si no tiene localidades la provincia se va a eliminar
		if(p2.getLocalidades() != null && !p2.getLocalidades().isEmpty()) {
			throw new IllegalStateException("La provincia no se puede eliminar porque tiene tiene localidades");
	    }
		ProvinciaDao.getInstance().eliminarProvincia(p2);
	}

	public List<Provincia> traer() {
		return ProvinciaDao.getInstance().traer();
	}
	
	public Provincia traerProvinciaYLocalidades(int idProvincia) {
		Provincia p = ProvinciaDao.getInstance().traerProvinciaYLocalidades(idProvincia);
		//Si es null que arroje la excepción de que la provincia no existe
		if(p == null) {
			throw new NullPointerException("La provincia con id " + idProvincia + " no existe");
		}
		return p;
	}
	
	public Provincia traerProvinciaYLocalidades(String nombre) {
		Provincia p = ProvinciaDao.getInstance().traerProvinciaYLocalidades(nombre);
		//Si es null que arroje la excepción de que la provincia no existe
		if(p == null) {
			throw new NullPointerException("La provincia " + nombre + " no existe");
		}
		return p;
	}
}
