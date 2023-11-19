package main.java.ar.edu.uade.ejemplar;

import java.util.*;

/**
 * 
 */
public class FiltrarFecha extends BusquedaLibroHandler {

    public FiltrarFecha(BusquedaLibroHandler siguienteManejador) {
		super(siguienteManejador);
    }

	@Override
	public List<Ejemplar> filtrarBusqueda(List<Busqueda> filtrosBusqueda, List<Ejemplar> busquedaEjemplares) {
	    Busqueda filtroFecha = null;
	    for (Busqueda filtro : filtrosBusqueda) {
	        if (filtro.esDeTipo(TipoFiltro.FECHA)) {
	            filtroFecha = filtro;
	            break; // encontramos un filtro de FECHA
	        }
	    }
	    if (filtroFecha != null) {
	    	List<Ejemplar> copiaBusquedaEjemplares = new ArrayList<>(busquedaEjemplares);
	        for (Ejemplar ejemplar : copiaBusquedaEjemplares) {
	            if (!ejemplar.getTitulo().toString().equals(filtroFecha.getDescripcion())) {
	                busquedaEjemplares.remove(ejemplar);
	            }
	        }
	    }
	    if (this.siguienteManejador != null) {
	        this.siguienteManejador.filtrarBusqueda(filtrosBusqueda, busquedaEjemplares);
	    }
	    return busquedaEjemplares;
	}
}