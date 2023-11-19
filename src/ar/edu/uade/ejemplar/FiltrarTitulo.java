package ar.edu.uade.ejemplar;

import java.util.*;

/**
 * 
 */
public class FiltrarTitulo extends BusquedaLibroHandler {
    
	public FiltrarTitulo(BusquedaLibroHandler siguienteManejador) {
		super(siguienteManejador);
    }
	
	@Override
	public List<Ejemplar> filtrarBusqueda(List<Busqueda> filtrosBusqueda, List<Ejemplar> busquedaEjemplares) {
	    Busqueda filtroTitulo = null;
	    for (Busqueda filtro : filtrosBusqueda) {
	        if (filtro.esDeTipo(TipoFiltro.TITULO)) {
	            filtroTitulo = filtro;
	            System.out.println("TITULO: "+filtroTitulo.getDescripcion());
	            System.out.println("filtros de busqueda "+busquedaEjemplares.get(1).getTitulo());
	            break; //encontramos un filtro de título
	        }
	    }
	    if (filtroTitulo != null) {
	    	List<Ejemplar> copiaBusquedaEjemplares = new ArrayList<>(busquedaEjemplares);
	    	for (Ejemplar ejemplar : copiaBusquedaEjemplares) {
	            if (!ejemplar.getTitulo().toString().equals(filtroTitulo.getDescripcion())) {
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