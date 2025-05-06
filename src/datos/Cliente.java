package datos;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class Cliente extends Persona{
	private String codigo; 
	private Set<Turno> historialDeTurnos;
	
	public Cliente(){}
	
	public Cliente(String nombre, String apellido, int dni, LocalDate fechaDeNacimiento, String email, String telefono,
			String contraseña, String codigo) {
		super(nombre, apellido, dni, fechaDeNacimiento, email, telefono, contraseña);
		this.codigo = codigo;

	}
	
	public int getIdCliente() {
		return getIdPersona();
	}
	
	protected void setIdCliente(int idCliente) {
		setIdPersona(idCliente);;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public Set<Turno> getHistorialDeTurnos() {
		return historialDeTurnos;
	}

	public void setHistorialDeTurnos(Set<Turno> historialDeTurnos) {
		this.historialDeTurnos = historialDeTurnos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(getIdPersona());
	}

	@Override
	public boolean equals(Object obj) {
		Cliente other = (Cliente) obj;
		return getIdPersona() == other.getIdPersona();
	}

	public boolean agregar(Turno turno){	
		boolean agregar=false;
		if (! (historialDeTurnos.contains(turno))) {
			agregar=historialDeTurnos.add(turno);
		}
		return agregar;
	}

    public boolean eliminar(Turno turno){    	
    	Turno borrar = null;  
    	boolean eliminar = false;
    	Iterator<Turno> it = historialDeTurnos.iterator();
        while ((it.hasNext()) && (borrar==null)){
        	 Turno t = it.next();
             if (t.equals(turno)) borrar = t;
        }		
		eliminar=historialDeTurnos.remove(borrar);
		return eliminar;
	}
	@Override
	public String toString() {
		return "Cliente [idCliente=" + getIdPersona() + ", codigo=" + codigo + "]";
	}

	
	
	


}
