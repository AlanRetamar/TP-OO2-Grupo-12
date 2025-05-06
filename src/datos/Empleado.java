package datos;

import java.time.LocalDate;
import java.util.Set;

public class Empleado extends Persona{
	private LocalDate fechaDeIngreso;
	private String funcion;
	private String cuit;
	private Set<Turno> turnos;
	
	public Empleado(){}
	
	public Empleado(String nombre, String apellido, int dni, LocalDate fechaDeNacimiento, String email, String telefono,
			String contraseña, LocalDate fechaDeIngreso, String funcion, String cuit) {
		super(nombre, apellido, dni, fechaDeNacimiento, email, telefono, contraseña);
		this.fechaDeIngreso = fechaDeIngreso;
		this.funcion = funcion;
		this.cuit = cuit;
	}

	public int getIdEmpleado() {
		return getIdPersona();
	}
	
	protected void setIdEmpleado(int idEmpleado) {
		setIdPersona(idEmpleado);
	}

	public LocalDate getFechaDeIngreso() {
		return fechaDeIngreso;
	}
	
	public void setFechaDeIngreso(LocalDate fechaDeIngreso) {
		this.fechaDeIngreso = fechaDeIngreso;
	}

	public String getFuncion() {
		return funcion;
	}

	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}
	
	public String getCuit() {
		return cuit;
	}
	
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	
	public Set<Turno> getTurnos() {
		return turnos;
	}

	public void setTurnos(Set<Turno> turnos) {
		this.turnos = turnos;
	}

	@Override
	public String toString() {
		return "Empleado [idEmpleado=" + getIdEmpleado() + ", fechaDeIngreso=" + fechaDeIngreso + ", funcion=" + funcion
				+ ", cuit=" + cuit + ", turnos=" + turnos + "]";
	}





	
		
}
