package ar.edu.uade.ejemplar;

import ar.edu.uade.ejemplar.Categoria;

import java.time.LocalDate;
import java.util.List;

public class MainBusqueda {

	public static void main(String[] args) {
		EjemplaresFachada ejemplaresFachada = new EjemplaresFachada();
		ejemplaresFachada.cargarEjemplar(Categoria.LIBRO, "Cien años de soledad", "Gabriel García Márquez", LocalDate.of(1967, 1, 1), "Sección A");
		ejemplaresFachada.cargarEjemplar(Categoria.DIARIO, "El País", "Varios autores", LocalDate.of(1976, 1, 1), "Sección B");
		ejemplaresFachada.cargarEjemplar(Categoria.REVISTA, "National Geographic", "Varios autores", LocalDate.of(1888, 1, 1), "Sección C");
		ejemplaresFachada.cargarEjemplar(Categoria.LIBRO, "1984", "George Orwell", LocalDate.of(1949, 1, 1), "Sección D");
		ejemplaresFachada.cargarEjemplar(Categoria.REVISTA_ESPECIALIZADA, "Nature", "Varios autores", LocalDate.of(1869, 1, 1), "Sección A");
		ejemplaresFachada.cargarEjemplar(Categoria.LIBRO, "Don Quijote de la Mancha", "Miguel de Cervantes", LocalDate.of(1605, 1, 1), "Sección B");
		ejemplaresFachada.cargarEjemplar(Categoria.DIARIO, "The New York Times", "Varios autores", LocalDate.of(1851, 1, 1), "Sección C");
		ejemplaresFachada.cargarEjemplar(Categoria.LIBRO, "Matar un ruiseñor", "Harper Lee", LocalDate.of(1960, 1, 1), "Sección D");
		ejemplaresFachada.cargarEjemplar(Categoria.REVISTA, "Time", "Varios autores", LocalDate.of(1923, 1, 1), "Sección A");
		ejemplaresFachada.cargarEjemplar(Categoria.LIBRO, "Harry Potter y la piedra filosofal", "J.K. Rowling", LocalDate.of(1997, 1, 1), "Sección B");

		List<Ejemplar> resultadoBusqueda = ejemplaresFachada.buscarEjemplar("libro", null, null, null);
		for (Ejemplar ejemplar: resultadoBusqueda) {
			System.out.println("titulo: "+ejemplar.getTitulo());

		}
		
		
		ejemplaresFachada.setCantDiasCategoria(Categoria.DIARIO, 3);
		System.out.println(ejemplaresFachada.getCantDiasCategoria(Categoria.DIARIO));

		

	}

}
