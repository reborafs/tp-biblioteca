package ar.edu.uade.prestamo;

import java.time.LocalDate;

public interface Sujeto {
	public void agregar(Observer observador);
	public void eliminar(Observer observador);
	public void notificar();

    Object getEstado();

	LocalDate getFechaVencimiento();
}
