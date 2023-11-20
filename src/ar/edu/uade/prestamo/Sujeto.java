package ar.edu.uade.prestamo;

public interface Sujeto {
	public void agregar(IObserverPrestamo observador);
	public void eliminar(IObserverPrestamo observador);
	public void notificar();
}
