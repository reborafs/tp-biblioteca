package ar.edu.uade.usuario;

import java.time.LocalDate;

public class EstrategiaWpp implements IEstrategiaAlerta {

    private String MENSAJE_WPP;

    public EstrategiaWpp() {
    }

	@Override
	public void enviarNotificacion(String contacto, String mensaje, LocalDate localDate,
			TipoMotivoComunicacion motivoComunicacion) {
		System.out.println("enviando whatsApp a: "+contacto+"\nmensaje: "+mensaje);
		
	}

}