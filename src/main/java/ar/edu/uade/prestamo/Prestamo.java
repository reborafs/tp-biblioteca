package ar.edu.uade.prestamo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import ar.edu.uade.prestamo.EstadoPrestamo;
import ar.edu.uade.usuario.Socio;

/**
 * 
 */
public class Prestamo implements Sujeto{
	
	private UUID idSocio;
	private UUID ejemplarID;
    private LocalDate fechaPrestamo;
    private LocalDate fechaVencimiento;
    private LocalDate fechaDevolucion;
    private EstadoPrestamo estado;
	private List<Observer> observers;

    public Prestamo(UUID idSocio, UUID ejemplarID, LocalDate fechaPrestamo, LocalDate fechaVencimiento, EstadoPrestamo estado) {
		this.idSocio = idSocio;
		this.ejemplarID = ejemplarID;
		this.fechaPrestamo = fechaPrestamo;
		this.fechaVencimiento = fechaVencimiento;
		this.estado = estado;
		this.fechaDevolucion = null;
		this.observers = new ArrayList<>();
	}

	public UUID getSocio() {
		return idSocio;
	}

	public LocalDate getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(LocalDate fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	public LocalDate getFechaPrestamo() {
		return fechaPrestamo;
	}

	public EstadoPrestamo getEstado() {
		return estado;
	}

	public void setEstado(EstadoPrestamo estado){
		this.estado = estado;
		System.out.println("Cambio de estado");
		this.notificar();
	}

    public LocalDate getFechaVencimiento() {
		return fechaVencimiento;
	}
    
	public void setFechaVencimiento(LocalDate fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public void guardarPrestamo() {
        // TODO implement here
    
    }


	@Override
	public void agregar(Observer observador) {
		this.observers.add(observador);
		System.out.println("Suscribiendo observador");
	}

	@Override
	public void eliminar(Observer observador) {
		this.observers.remove(observador);
		System.out.println("Desuscribiendo observador");
	}

	@Override
	public void notificar() {
		this.observers.forEach(observer -> observer.actualizar(this));
	}

	public Map<String, String> getInfo() {
		return 	Map.of(
				"idSocio", String.valueOf(this.idSocio),
				"fechaPrestamo", String.valueOf(this.fechaPrestamo),
				"fechaVencimiento", String.valueOf(this.fechaVencimiento),
				"fechaDevolucion" ,String.valueOf(this.fechaDevolucion),
				"estado", String.valueOf(this.estado));
	}

}