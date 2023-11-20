package ar.edu.uade.ejemplar;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AsignadorFiltroBusqueda {
	private BusquedaLibroHandler cadena;
	
	public AsignadorFiltroBusqueda() {
		BusquedaLibroHandler fecha = new FiltrarFecha(null);
		BusquedaLibroHandler titulo = new FiltrarTitulo(fecha);
		BusquedaLibroHandler autor = new FiltrarAutor(titulo);
		BusquedaLibroHandler categoria = new FiltrarCategoria(autor);
		this.cadena = categoria;
	}
	
	public List<Ejemplar> asignarBusqueda (List<Busqueda> filtrosBusqueda, List<Ejemplar> ejemplares/*Busqueda busqueda*/) {
		List<Ejemplar> resultadoBusqueda = this.cadena.filtrarBusqueda(filtrosBusqueda, ejemplares);
		return resultadoBusqueda;
	}
	
}
