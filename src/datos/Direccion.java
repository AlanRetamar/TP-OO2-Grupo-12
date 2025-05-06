package datos;

public class Direccion {
    private int idDireccion;
    private String calle;
    private String numero;
    private Localidad localidad;
    private Persona persona;
	
	public Direccion(){}

	public Direccion(String calle, String numero, Localidad localidad, Persona persona) {
		super();
		this.calle = calle;
		this.numero = numero;
		this.localidad = localidad;
		this.persona = persona;
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
	
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Override
	public String toString() {
		return "Direccion [idDireccion=" + idDireccion + ", calle=" + calle + ", numero=" + numero + "]";
	}
	
	
}
