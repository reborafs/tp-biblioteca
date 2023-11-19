package main.java.ar.edu.uade.ejemplar;

import java.util.*;

/**
 * 
 */
public class FiltrarAutor extends BusquedaLibroHandler {
	
    public FiltrarAutor(BusquedaLibroHandler siguienteManejador) {
		super(siguienteManejador);
    }

	@Override
	public List<Ejemplar> filtrarBusqueda(List<Busqueda> filtrosBusqueda, List<Ejemplar> busquedaEjemplares) {
		Busqueda filtroAutor = null;
	    for (Busqueda filtro : filtrosBusqueda) {
	        if (filtro.esDeTipo(TipoFiltro.AUTOR)) {
	            filtroAutor = filtro;
	            break; //encontramos un filtro de AUTOR
	        }
	    }
	    if (filtroAutor != null) {
	    	List<Ejemplar> copiaBusquedaEjemplares = new ArrayList<>(busquedaEjemplares);
	        for (Ejemplar ejemplar : copiaBusquedaEjemplares) {
	            if (!ejemplar.getTitulo().toString().equals(filtroAutor.getDescripcion())) {
	                busquedaEjemplares.remove(ejemplar);
	            }
	        }
	    }
	    if (this.siguienteManejador != null) {
	        this.siguienteManejador.filtrarBusqueda(filtrosBusqueda, busquedaEjemplares	);
	    }
	    return busquedaEjemplares;
	}
}