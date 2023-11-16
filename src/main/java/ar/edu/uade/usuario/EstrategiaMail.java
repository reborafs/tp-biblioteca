package ar.edu.uade.usuario;

import java.time.LocalDate;

/**
 * 
 */
public class EstrategiaMail implements IEstrategiaAlerta {

    private String MENSAJE_MAIL;
    private String mailFrom;

    public EstrategiaMail() {
    }

    public void enviarNotificacion(String mail, String mensaje) {
        System.out.println("enviando mail: "+mensaje);
    }

	@Override
	public void enviarNotificacion(String contacto, String mensaje, LocalDate localDate,
			TipoMotivoComunicacion motivoComunicacion) {
		System.out.println("enviando MAIL a: "+contacto+"\nfecha: "+localDate);
		
	}

}