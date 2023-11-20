package ar.edu.uade.usuario;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import ar.edu.uade.ejemplar.Ejemplar;
import ar.edu.uade.prestamo.Prestamo;

public class StateActivo implements IStateSocio{
	
	//Socio debe conocer sus prestamos y pasar el actual por parametro
	@Override
	public void devolucionPrestamo(int diasTranscurridos, Socio socio) {
		//Socio socio = prestamo.getSocio(); //accedo a SOCIO a traves de PRESTAMO
		//if (diasTranscurridos > 0) { //si es > 0 la devolucion esta vencida => incrementar dias habiles (10 limite=bloqueado)
		//	int diasRetraso = socio.getStateDiasHabiles() + diasTranscurridos;
		//	socio.setStateDiasHabiles(diasTranscurridos);
		//	if(socio.getStateDiasHabiles()>10) {
		//		IStateSocio stateSuspendido = new StateSuspendido();
		//		socio.setStateSocio(stateSuspendido);
		//	}
		//}
	}

	@Override
	public void solicitarPrestamo(Ejemplar ejemplar, Socio socio) {
		if(ejemplar.isDisponible()) {
			ejemplar.setDisponible();
			String ubicacion = ejemplar.getUbicacion(ejemplar.getUuid());

			//agregar a lista de prestamos
			//o a lista de prestamos del socio
		}
		
	}
	public String getDescription() {
		String description = "ACTIVO";
		return description;
	};

}