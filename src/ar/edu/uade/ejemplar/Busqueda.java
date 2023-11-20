package ar.edu.uade.ejemplar;

import java.util.List;

public class Busqueda {
	private TipoFiltro tipo;
	private String descripcion;
	
	public Busqueda(TipoFiltro tipo, String descripcion) {
		this.tipo = tipo;
		this.descripcion = descripcion;
	}
	
	public boolean esDeTipo (TipoFiltro tipo) {
		return this.tipo.equals(tipo);
	}
	
	public TipoFiltro getTipo () {
		return this.tipo;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
}
