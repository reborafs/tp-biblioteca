package main.java.ar.edu.uade.ejemplar;

import java.util.ArrayList;
import java.util.List;


public class MainBusqueda {

	public static void main(String[] args) {
		List<Ejemplar> ejemplares = new ArrayList<>();
		
		Ejemplar ejemplar = new Ejemplar(TipoCategoria.LIBRO,"potter");
		ejemplares.add(ejemplar);
		ejemplar = new Ejemplar(TipoCategoria.DIARIO, "abc");
		ejemplares.add(ejemplar);
		ejemplar = new Ejemplar (TipoCategoria.LIBRO, "rings");
		ejemplares.add(ejemplar);
		AsignadorFiltroBusqueda asignadorFiltroBusqueda = new AsignadorFiltroBusqueda();
		List<Busqueda> filtros = new ArrayList<>();
		
		
		//filtros es el array de los filtros para la busqueda
		// cada busqueda contiene un tipo de filtro (autor,categoria,titulo,fecha) y una descripcion
		Busqueda busqueda = new Busqueda(TipoFiltro.CATEGORIA, "LIBRO");
		filtros.add(busqueda);
		
		busqueda = new Busqueda(TipoFiltro.TITULO, "potter");
		filtros.add(busqueda);
		
		List<Ejemplar> resultado = asignadorFiltroBusqueda.asignarBusqueda(filtros, ejemplares);
		for (Ejemplar ejemplarBusqueda: resultado) {
			System.out.println("--------------------------\nresultado de busqueda: \n CATEGORIA:"+ejemplarBusqueda.getCategoria()+"\n TITULO: "+ejemplarBusqueda.getTitulo());
			System.out.println(" uuid: "+ejemplarBusqueda.getUuid());
		}
	}

}
