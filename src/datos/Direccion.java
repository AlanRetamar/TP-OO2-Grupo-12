package datos;

import java.util.Objects;

public class Direccion {
    private int idDireccion;
    private String calle;
    private String numero;
    private Localidad localidad;
	
	public Direccion(){}

	public Direccion(String calle, String numero, Localidad localidad) {
		super();
		this.calle = calle;
		this.numero = numero;
		this.localidad = localidad;
	}

	public int getIdDireccion() {
		return idDireccion;
	}

	protected void setIdDireccion(int idDireccion) {
		this.idDireccion = idDireccion;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}
	
	
	//Se utiliza hashCode e equals para que funcione el metodo contains
	@Override
	public int hashCode() {
		return Objects.hash(idDireccion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Direccion other = (Direccion) obj;
		return idDireccion == other.idDireccion;
	}

	@Override
	public String toString() {
		return "Direccion [idDireccion=" + idDireccion + ", calle=" + calle + ", numero=" + numero + "]";
	}
	
	
}
