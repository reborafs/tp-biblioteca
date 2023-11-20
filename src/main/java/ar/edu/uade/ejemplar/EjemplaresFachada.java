package ar.edu.uade.ejemplar;

import ar.edu.uade.ejemplar.Categoria;
import ar.edu.uade.usuario.Socio;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class EjemplaresFachada {
	private static EjemplaresFachada instance;
	private List<Busqueda> filtros;
	private List<Ejemplar> ejemplares;

    public EjemplaresFachada() {
    	this.ejemplares = new ArrayList<>();
    }

    public static EjemplaresFachada getInstance() {
    	if (instance == null) {
    		instance = new EjemplaresFachada();
    	}
    	return instance;
    }

    public void setCantDiasCategoria(Categoria categoria, int dias) {
    	categoria.setCantDiasPrestamo(dias);
    }

    public int getCantDiasCategoria(Categoria categoria) {
    	return categoria.getCantDiasPrestamo();
    }

    public void cargarEjemplar(Categoria categoria,String titulo,String autor,LocalDate fechaPublicacion,String ubicacion) {
    	Ejemplar ejemplar = new Ejemplar(categoria, titulo, autor, fechaPublicacion, ubicacion);
    	ejemplares.add(ejemplar);
    }

    //cambiar fechaPublicacion a String --> luego en la busqueda pasarla a fecha ????
    public List<Ejemplar> buscarEjemplar(String categoria, String titulo,String autor, LocalDate fechaPublicacion) {
    	filtros = new ArrayList<>();
    	if (categoria!=null) {
    		Busqueda busqueda = new Busqueda(TipoFiltro.CATEGORIA, categoria);
    		filtros.add(busqueda);
    	}
    	if (autor!=null) {
    		Busqueda busqueda = new Busqueda(TipoFiltro.AUTOR,autor);
    		filtros.add(busqueda);
    	}
    	if (titulo!=null) {
    		Busqueda busqueda = new Busqueda(TipoFiltro.TITULO,titulo);
    		filtros.add(busqueda);
    	}
    	if (fechaPublicacion!=null) {
    		Busqueda busqueda = new Busqueda(TipoFiltro.FECHA,fechaPublicacion.toString());
    		filtros.add(busqueda);
    	}
    	AsignadorFiltroBusqueda asignadorFiltroBusqueda = new AsignadorFiltroBusqueda();
        return asignadorFiltroBusqueda.asignarBusqueda(filtros, ejemplares);
    }

    public void actualizarEstadoEjemplar(UUID idEjemplar) {
        for (Ejemplar ejemplar: ejemplares) {
        	if (ejemplar.getUuid().equals(idEjemplar)) {
        		ejemplar.setDisponible();
        		break;
        	}
        }
    }

    public List<Map<String, String>> getInfoEjemplares() {
		return ejemplares.stream().map(Ejemplar::getInfo).collect(Collectors.toList());
    }
}