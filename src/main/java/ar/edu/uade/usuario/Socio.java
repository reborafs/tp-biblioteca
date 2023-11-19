package main.java.ar.edu.uade.usuario;

import java.util.*;

import main.java.ar.edu.uade.usuario.IStateSocio;

public class Socio {

    private UUID id;
    private String nombre;
    private String apellido;
    private String dni;
    private String mail;
    private String nroTelefono;
    //private ContextoAlerta contextoAlerta;
    //private TipoAlerta tipoAlerta;
    private IEstrategiaAlerta estrategiaAlerta;
    private IStateSocio stateSocio;
    //private TipoEstado estado;
    private int stateDiasHabiles;

    public Socio(String nombre, String apellido, String dni, String mail, String nroTelefono,
			IEstrategiaAlerta estrategiaAlerta) {
		this.id = UUID.randomUUID();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.mail = mail;
		this.nroTelefono = nroTelefono;
		this.estrategiaAlerta = estrategiaAlerta;	
		this.stateSocio = new StateActivo();
		this.stateDiasHabiles = 0;
	}
    
    
	public void enviarAlerta(String contacto, String mensaje, TipoMotivoComunicacion motivoComunicacion) {
		estrategiaAlerta.enviarNotificacion(contacto, mensaje, motivoComunicacion);
	}
	
    public void setStateSocio(IStateSocio stateSocio) {
		this.stateSocio = stateSocio;
	}
	
	public void setEstrategiaAlerta(IEstrategiaAlerta estrategiaAlerta) {
		this.estrategiaAlerta = estrategiaAlerta;

	}
	
	public void setStateDiasHabiles(int cantStateDiasHabiles) {
		this.stateDiasHabiles += cantStateDiasHabiles;
	}
	
	public IEstrategiaAlerta getEstrategiaAlerta () {
		return estrategiaAlerta;
	}
	
	public UUID getUUID () {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getMail() {
		return mail;
	}

	public String getNroTelefono() {
		return nroTelefono;
	}

	public IStateSocio getStateSocio() {
		return stateSocio;
	}


	public int getStateDiasHabiles() {
		return stateDiasHabiles;
	}
	
	
}