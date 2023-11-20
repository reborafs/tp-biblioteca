package ar.edu.uade.prestamo;

public interface Sujeto {
	public void agregar(Observer observador);
	public void eliminar(Observer observador);
	public void notificar();
}
