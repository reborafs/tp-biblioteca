package main.java.ar.edu.uade.prestamo;

import java.time.LocalDate;
import java.util.UUID;

import main.java.ar.edu.uade.prestamo.EstadoPrestamo;
import main.java.ar.edu.uade.usuario.Socio;

/**
 * 
 */
public class Prestamo {
	
	private UUID idSocio;
    private LocalDate fechaPrestamo;
    private LocalDate fechaVencimiento;
    private LocalDate fechaDevolucion;
    private EstadoPrestamo estado;
    
    public Prestamo(UUID idSocio, LocalDate fechaPrestamo, LocalDate fechaVencimiento, EstadoPrestamo estado) {
		this.idSocio = idSocio;
		this.fechaPrestamo = fechaPrestamo;
		this.fechaVencimiento = fechaVencimiento;
		this.estado = estado;
		this.fechaDevolucion = null;
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

    public LocalDate getFechaVencimiento() {
		return fechaVencimiento;
	}
    
	public void setFechaVencimiento(LocalDate fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public void guardarPrestamo() {
        // TODO implement here
    
    }

}