package datos;

import java.util.Set;

public class Localidad {
    private int idLocalidad;
    private String nombre;
    private Provincia provincia;
    private Set<Direccion> direcciones;
	
	public Localidad(){}

	public Localidad(String nombre, Provincia provincia) {
		super();
		this.nombre = nombre;
		this.provincia = provincia;
	}

	public int getIdLocalidad() {
		return idLocalidad;
	}

	protected void setIdLocalidad(int idLocalidad) {
		this.idLocalidad = idLocalidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public Set<Direccion> getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(Set<Direccion> direcciones) {
		this.direcciones = direcciones;
	}

	@Override
	public String toString() {
		return "Localidad [idLocalidad=" + idLocalidad + ", nombre=" + nombre + ", direcciones=" + direcciones + "]";
	}

	
}

