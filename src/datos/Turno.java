package datos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class Turno {
   private int idTurno;
   private LocalDate fecha;
   private LocalTime hora;
   private String estado;
   private String servicio;
   private LocalDate fechaCreacion;
   //private Set<Cliente> clientes;
   private Empleado empleado;
   
   public Turno(){}

   public Turno(LocalDate fecha, LocalTime hora, String estado, String servicio, LocalDate fechaCreacion,
			Empleado empleado) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.estado = estado;
		this.servicio = servicio;
		this.fechaCreacion = fechaCreacion;
		this.empleado = empleado;
   }

	public int getIdTurno() {
		return idTurno;
	}
	
	protected void setIdTurno(int idTurno) {
		this.idTurno = idTurno;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	public LocalTime getHora() {
		return hora;
	}
	
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getServicio() {
		return servicio;
	}
	
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}
	
	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}
	
	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	public Empleado getEmpleado() {
		return empleado;
	}
	
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
	/*public Set<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}*/
	
	@Override
	public int hashCode() {
		return Objects.hash(idTurno);
	}

	@Override
	public boolean equals(Object obj) {
		Turno other = (Turno) obj;
		return idTurno == other.idTurno;
	}

	/*public boolean agregar(Cliente cliente){	
		boolean agregar=false;
		if (! (clientes.contains(cliente))) {
			agregar=clientes.add(cliente);
		}
		return agregar;
	}

    public boolean eliminar(Cliente cliente){    	
    	Cliente borrar = null;  
    	boolean eliminar = false;
    	Iterator<Cliente> it = clientes.iterator();
        while ((it.hasNext()) && (borrar==null)){
        	 Cliente c = it.next();
             if (c.equals(cliente)) borrar = c;
        }		
		eliminar=clientes.remove(borrar);
		return eliminar;
	}*/

	@Override
	public String toString() {
		return "Turno [idTurno=" + idTurno + ", fecha=" + fecha + ", hora=" + hora + ", estado=" + estado
				+ ", servicio=" + servicio + ", fechaCreacion=" + fechaCreacion + "]";
	}
   
   
   
   
   
   
   
}
