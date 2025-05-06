package datos;

import java.util.Set;

public class Provincia {
	private int idProvincia;
	private String nombre;
	private Set<Localidad> localidades;
	
	public Provincia(){}

	public Provincia(String nombre) {
		super();
		this.nombre = nombre;
	}

	public int getIdProvincia() {
		return idProvincia;
	}

	protected void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Localidad> getLocalidades() {
		return localidades;
	}

	public void setLocalidades(Set<Localidad> localidades) {
		this.localidades = localidades;
	}

	@Override
	public String toString() {
		return "Provincia [idProvincia=" + idProvincia + ", nombre=" + nombre + ", localidades=" + localidades + "]";
	}


	

}
