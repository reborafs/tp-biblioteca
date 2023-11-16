package ar.edu.uade.usuario;

import java.time.LocalDate;

import ar.edu.uade.usuario.IEstrategiaAlerta;

public class ContextoAlerta {
	private IEstrategiaAlerta estrategia;
	
    public ContextoAlerta(IEstrategiaAlerta estrategia) {
    	this.estrategia = estrategia;
    }
    
    public void setEstrategiaAlerta(IEstrategiaAlerta estrategia) {
        this.estrategia = estrategia;
    }
    
    public void enviarAlerta(String contacto, String mensaje, TipoMotivoComunicacion motivoComunicacion) {
        this.estrategia.enviarNotificacion (contacto, mensaje, LocalDate.now(), motivoComunicacion ); 
    }

}