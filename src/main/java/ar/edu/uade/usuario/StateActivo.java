package main.java.ar.edu.uade.usuario;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

import main.java.ar.edu.uade.ejemplar.Ejemplar;
import main.java.ar.edu.uade.prestamo.Prestamo;

public class StateActivo implements IStateSocio{
	
	@Override
	public void devolucionPrestamo(int diasTranscurridos, Socio socio) {
		if (diasTranscurridos > 0) { //si es > 0 la devolucion esta vencida => incrementar dias habiles (10 limite=bloqueado)
			int diasRetraso = socio.getStateDiasHabiles() + diasTranscurridos;
			socio.setStateDiasHabiles(diasTranscurridos);
			if(socio.getStateDiasHabiles()>10) {
				IStateSocio stateSuspendido = new StateSuspendido();
				socio.setStateSocio(stateSuspendido);
			}
		}
	}

	@Override
	public void solicitarPrestamo(Ejemplar ejemplar, Socio socio) {
		if(ejemplar.isDisponible()) {
			ejemplar.setDisponible(false);
			String ubicacion = ejemplar.getUbicacion(ejemplar.getUuid());
			
		}
		
	}

}