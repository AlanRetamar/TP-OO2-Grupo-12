package datos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;


public class Turno {
   private int idTurno;
   private LocalDate fecha;
   private LocalTime hora;
   private String estado;
   private String servicio;
   private LocalDate fechaCreacion;
   private Empleado empleado;

   
   public Turno(){}

   public Turno(LocalDate fecha, LocalTime hora, String estado, String servicio, LocalDate fechaCreacion,
			Empleado empleado, Cliente cliente) {
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


	@Override
	public int hashCode() {
		return Objects.hash(idTurno);
	}

	@Override
	public boolean equals(Object obj) {
		Turno other = (Turno) obj;
		return idTurno == other.idTurno;
	}

	@Override
	public String toString() {
		return "Turno [idTurno=" + idTurno + ", fecha=" + fecha + ", hora=" + hora + ", estado=" + estado
				+ ", servicio=" + servicio + ", fechaCreacion=" + fechaCreacion + "]";
	}
   
   
   
   
   
   
   
}
