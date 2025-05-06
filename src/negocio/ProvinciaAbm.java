package negocio;


import java.util.List;
import dao.ProvinciaDao;
import datos.Provincia;

public class ProvinciaAbm {
	ProvinciaDao dao = new ProvinciaDao();

	public Provincia traerProvincia(int idProvincia) {
		Provincia p = dao.traerProvincia(idProvincia);
		if(p == null) {
			throw new NullPointerException("La provincia con id " + idProvincia + " no existe");
		}
		return p;
	}

	public int agregar(Provincia p) {
		return dao.agregarProvincia(p);
	}

	public void modificar(Provincia p) {
		 dao.actualizarProvincia(p);
	}

	public void eliminar(int idProvincia) {
		Provincia p = dao.traerProvincia(idProvincia);
		//Si es null que arroje la excepción de que la provincia no existe
		if(p == null) {
			throw new NullPointerException("La provincia con id " + idProvincia + " no existe");
		}
		Provincia p2 = traerProvinciaYLocalidades(idProvincia);
		//Si no tiene localidades la provincia se va a eliminar
		if(p2.getLocalidades() != null && !p2.getLocalidades().isEmpty()) {
			throw new IllegalStateException("La provincia no se puede eliminar porque tiene tiene localidades");
	    }
		dao.eliminarProvincia(p2);
	}

	public List<Provincia> traer() {
		return dao.traer();
	}
	
	public Provincia traerProvinciaYLocalidades(int idProvincia) {
		Provincia p = dao.traerProvinciaYLocalidades(idProvincia);
		//Si es null que arroje la excepción de que la provincia no existe
		if(p == null) {
			throw new NullPointerException("La provincia con id " + idProvincia + " no existe");
		}
		return p;
	}
}
