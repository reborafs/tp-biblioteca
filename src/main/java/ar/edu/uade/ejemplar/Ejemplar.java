package ar.edu.uade.ejemplar;

import ar.edu.uade.ejemplar.Categoria;
import ar.edu.uade.prestamo.Observer;
import ar.edu.uade.prestamo.Sujeto;
import ar.edu.uade.usuario.EstadoSocio;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Ejemplar implements IUbicacion, Observer {

	private UUID uuid;
	private Categoria categoria;
	private String titulo;
	private String autor;
	private LocalDate fechaPublicacion;
	private String ubicacion;
	private boolean disponible;

    public Ejemplar(Categoria categoria, String titulo, String autor, LocalDate fechaPublicacion,
			String ubicacion) {
		super();
		this.uuid = UUID.randomUUID();
		this.categoria = categoria;
		this.titulo = titulo;
		this.autor = autor;
		this.fechaPublicacion = fechaPublicacion;
		this.ubicacion = ubicacion;
		this.disponible = true;
	}

    public Categoria getCategoria() {
		return categoria;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public UUID getUuid() {
		return uuid;
	}

	public LocalDate getFechaPublicacion() {
		return fechaPublicacion;
	}

    public String getUbicacion(UUID idEjemplar) {
        return ubicacion;
    }

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible() {
		this.disponible = !disponible;
	}

	@Override
	public void actualizar(Sujeto observable) {
		String estadoPrestamo = observable.getEstado().toString();

		System.out.printf("Ejemplar devuelto \n");
	}

}