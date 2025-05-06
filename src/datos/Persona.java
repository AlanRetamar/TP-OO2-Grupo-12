package datos;

import java.time.LocalDate;
import java.util.Set;

public abstract class Persona {
	protected int idPersona; 
	protected String nombre;
	protected String apellido;
	protected int dni;
	protected LocalDate fechaDeNacimiento;
	protected String email;
	protected String telefono;
	protected String contraseña;
	protected Set<Direccion> direcciones;
	
	public Persona(){}

	public Persona(String nombre, String apellido, int dni, LocalDate fechaDeNacimiento, String email, String telefono,
			String contraseña) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.email = email;
		this.telefono = telefono;
		this.contraseña = contraseña;
	}

	public int getIdPersona() {
		return idPersona;
	}

	protected void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public Set<Direccion> getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(Set<Direccion> direcciones) {
		this.direcciones = direcciones;
	}

	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ ", fechaDeNacimiento=" + fechaDeNacimiento + ", email=" + email + ", telefono=" + telefono
				+ ", contraseña=" + contraseña + ", direcciones=" + direcciones + "]";
	}


	
	



	


}
