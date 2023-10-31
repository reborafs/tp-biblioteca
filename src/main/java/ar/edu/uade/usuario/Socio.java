package ar.edu.uade.usuario;

import ar.edu.uade.usuario.ContextoAlerta;
import ar.edu.uade.usuario.IEstadoSocio;

import java.util.*;

/**
 * 
 */
public class Socio {

    /**
     * Default constructor
     */
    public Socio() {
    }

    /**
     * 
     */
    private UUID id;

    /**
     * 
     */
    private String nombre;

    /**
     * 
     */
    private String apellido;

    /**
     * 
     */
    private String dni;

    /**
     * 
     */
    private String mail;

    /**
     * 
     */
    private String nroTelefono;

    /**
     * 
     */
    private ContextoAlerta contextoAlerta;

    /**
     * 
     */
    private IEstadoSocio estado;

    /**
     * @return
     */
    public void enviarAlerta() {
        // TODO implement here
        return null;
    }

    /**
     * @param tipoAlerta
     */
    public void setEstrategiaAlerta(String tipoAlerta) {
        // TODO implement here
    }

}