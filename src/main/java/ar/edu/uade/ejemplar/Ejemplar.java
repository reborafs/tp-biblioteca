package ar.edu.uade.ejemplar;

import java.time.LocalDate;
import java.util.*;

/**
 * 
 */
public class Ejemplar implements IUbicacion {

    /**
     * Default constructor
     */
    public Ejemplar() {
    }

    /**
     * 
     */
    private UUID uuid;

    /**
     * 
     */
    private Categoria categoria;

    /**
     * 
     */
    private String titulo;

    /**
     * 
     */
    private String autor;

    /**
     * 
     */
    private LocalDate fechaPublicacion;

    /**
     * 
     */
    private String ubicacion;

    /**
     * @return
     */
    public String getUbicacion() {
        // TODO implement here
        return "";
    }

    /**
     * @param idEjemplar
     */
    public void getUbicacion(UUID idEjemplar) {
        // TODO implement here
    }

}