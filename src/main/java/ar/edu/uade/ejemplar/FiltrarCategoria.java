package main.java.ar.edu.uade.ejemplar;

import java.util.*;

/**
 * +}
 */
public class FiltrarCategoria extends BusquedaLibroHandler {

    public FiltrarCategoria(BusquedaLibroHandler siguienteManejador) {
		super(siguienteManejador);
    }

	@Override
	public List<Ejemplar> filtrarBusqueda(List<Busqueda> filtrosBusqueda, List<Ejemplar> ejemplares) {
		busquedaEjemplares = new ArrayList<>(); //creo un array donde guardar los ejemplares que coincidan con el primer eslabon de la cadena
		Busqueda filtroCategoria = null;
	    for (Busqueda filtro : filtrosBusqueda) {
	        if (filtro.esDeTipo(TipoFiltro.CATEGORIA)) {
	            filtroCategoria = filtro;
	            break; // Encontramos un filtro de CATEGORIA
	        }
	    }
	    System.out.println("-----------------------------------");
	    if (filtroCategoria.getTipo() != null) {
	        for (Ejemplar ejemplar : ejemplares) {
	            if (ejemplar.getCategoria().toString().equals(filtroCategoria.getDescripcion())) {
	                busquedaEjemplares.add(ejemplar);
	            }
	        }
	    }
	    if (this.siguienteManejador != null) {
	        this.siguienteManejador.filtrarBusqueda(filtrosBusqueda, busquedaEjemplares);
	    }
	    return busquedaEjemplares;
	}
}