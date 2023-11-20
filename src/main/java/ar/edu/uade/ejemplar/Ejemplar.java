package ar.edu.uade.ejemplar;

import ar.edu.uade.ejemplar.Categoria;
import java.time.LocalDate;
import java.util.*;

public class Ejemplar implements IUbicacion {

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


	public Map<String, String> getInfo() {
		return 	Map.of(
				"uuid", String.valueOf(this.uuid),
				"categoria", String.valueOf(this.categoria),
				"titulo", String.valueOf(this.titulo),
				"autor", String.valueOf(this.autor),
				"fechaPublicacion", String.valueOf(this.fechaPublicacion),
				"ubicacion", String.valueOf(this.ubicacion),
				"disponible", this.disponible? "SI" : "NO");
	}
}