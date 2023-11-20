package ar.edu.uade.usuario;

import java.time.LocalDate;
import ar.edu.uade.ejemplar.Ejemplar;
import ar.edu.uade.prestamo.Prestamo;

/**
 * 
 */
public class StateSuspendido implements IStateSocio{

	@Override
	public void solicitarPrestamo(Ejemplar ejemplar, Socio socio) {
		System.out.println("Socio Suspendido. Por favor, comunicarse con el bibliotecario");
		
	}

	@Override
	public void devolucionPrestamo(int diasTranscurridos, Socio socio) {
		// TODO Auto-generated method stub

	}
	public String getDescription() {
		String description = "SUSPENDIDO";
		return description;
	};
}