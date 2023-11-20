package ar.edu.uade.ejemplar;

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
	    	System.out.println("ingreso a filtrar categoria: \n");
	        for (Ejemplar ejemplar : ejemplares) {
	        	System.out.println("ejemplar:\n "+ejemplar.getTitulo()+"\n "+ejemplar.getCategoria());
	        	System.out.println(" "+ejemplar.getCategoria().toString().equalsIgnoreCase(filtroCategoria.getDescripcion()));

	        	if (ejemplar.getCategoria().toString().equalsIgnoreCase(filtroCategoria.getDescripcion())) {
	            	System.out.println("\ningresando coincidencia: "+ejemplar.getCategoria()+"en busqueda");
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