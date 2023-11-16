package ar.edu.uade.usuario;

import ar.edu.uade.usuario.ContextoAlerta;
import ar.edu.uade.usuario.IStateSocio;

import java.util.*;

public class Socio {

    private UUID id;
    private String nombre;
    private String apellido;
    private String dni;
    private String mail;
    private String nroTelefono;
    private ContextoAlerta contextoAlerta;
    private TipoAlerta tipoAlerta;
    private IStateSocio stateSocio;
    private TipoEstado estado;
    private int stateDiasHabiles;

    public Socio(String nombre, String apellido, String dni, String mail, String nroTelefono,
			ContextoAlerta contextoAlerta) {
		this.id = UUID.randomUUID();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.mail = mail;
		this.nroTelefono = nroTelefono;
		this.contextoAlerta = contextoAlerta;	
		this.estado = TipoEstado.ACTIVO;
		this.stateDiasHabiles = 0;
	}

	public void enviarAlerta() {
        
    }

    public void setContextoAlerta(IEstrategiaAlerta estrategiaAlerta) {
    	IEstrategiaAlerta estrategiaMail = new EstrategiaMail();
        contextoAlerta.setEstrategiaAlerta(estrategiaMail);
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

	public void setStateSocio(IStateSocio stateSocio) {
		this.stateSocio = stateSocio;
	}

	public int getStateDiasHabiles() {
		return stateDiasHabiles;
	}
	
	public void setStateDiasHabiles(int cantStateDiasHabiles) {
		this.stateDiasHabiles += cantStateDiasHabiles;
	}
	
}