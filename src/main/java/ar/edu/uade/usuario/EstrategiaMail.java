package ar.edu.uade.usuario;

import java.time.LocalDate;

/**
 * 
 */
public class EstrategiaMail implements IEstrategiaAlerta {

	@Override
	public void enviarNotificacion(String contacto, String mensaje,
			TipoMotivoComunicacion motivoComunicacion) {
		System.out.println("MAIL enviado a: "+contacto+
				"\n fecha: "+LocalDate.now()+
				"\n motivo: "+motivoComunicacion+
				"\n mensaje: "+mensaje);
	}

	public String getDescription() {
		String description = "MAIL";
		return description;
	};


}