package main.java.ar.edu.uade.ejemplar;

import java.time.LocalDate;
import java.util.*;

public class Ejemplar implements IUbicacion {

	private UUID uuid;
	private TipoCategoria categoria;
	private String titulo;
	private String autor;
	private LocalDate fechaPublicacion;
	private String ubicacion;
	private boolean disponible;

    public Ejemplar(TipoCategoria categoria, String titulo) {
    	this.uuid = UUID.randomUUID();
    	this.categoria = categoria;
    	this.titulo = titulo;
    }

    public TipoCategoria getCategoria() {
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

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
    
    

}