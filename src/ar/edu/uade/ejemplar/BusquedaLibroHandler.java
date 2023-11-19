package ar.edu.uade.ejemplar;

import java.util.*;

public abstract class BusquedaLibroHandler {
	protected List<Ejemplar> busquedaEjemplares;
	protected BusquedaLibroHandler siguienteManejador;

    public BusquedaLibroHandler(BusquedaLibroHandler siguienteManejador) {
		this.siguienteManejador = siguienteManejador;
    }
    
    public abstract List<Ejemplar> filtrarBusqueda (List<Busqueda> filtrosBusqueda, List<Ejemplar> ejemplares);
}