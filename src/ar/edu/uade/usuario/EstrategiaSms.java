package ar.edu.uade.usuario;

import java.time.LocalDate;

public class EstrategiaSms implements IEstrategiaAlerta {
    private String MENSAJE_SMS;
    
    public EstrategiaSms(String MENSAJE_SMS) {
    	this.MENSAJE_SMS = MENSAJE_SMS;
    }

	@Override
	public void enviarNotificacion(String contacto, String mensaje,
			TipoMotivoComunicacion motivoComunicacion) {
		System.out.println("SMS enviado a: "+contacto+
				"\n fecha: "+LocalDate.now()+
				"\n motivo: motivoComunicacion: "+motivoComunicacion
				+"\nmensaje: "+mensaje );
	}

}