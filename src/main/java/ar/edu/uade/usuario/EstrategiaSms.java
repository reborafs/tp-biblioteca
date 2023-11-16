package ar.edu.uade.usuario;

import java.time.LocalDate;

public class EstrategiaSms implements IEstrategiaAlerta {
    private String MENSAJE_SMS;
    
    public EstrategiaSms(String MENSAJE_SMS) {
    	this.MENSAJE_SMS = MENSAJE_SMS;
    }

	@Override
	public void enviarNotificacion(String contacto, String mensaje, LocalDate localDate,
			TipoMotivoComunicacion motivoComunicacion) {
		System.out.println("enviando SMS a: "+contacto+"\nmensaje: "+mensaje );
		
	}

}