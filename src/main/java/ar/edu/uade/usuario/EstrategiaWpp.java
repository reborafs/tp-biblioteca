package ar.edu.uade.usuario;

import java.time.LocalDate;

public class EstrategiaWpp implements IEstrategiaAlerta {

    private String MENSAJE_WPP;

    public EstrategiaWpp() {
    }

	@Override
	public void enviarNotificacion(String contacto, String mensaje,
			TipoMotivoComunicacion motivoComunicacion) {
		System.out.println("mensaje de whatsApp enviado a: "+contacto+
				"\n fecha: "+ LocalDate.now() +
				"\n motivo: "+motivoComunicacion+
				" mensaje: "+mensaje);
		
	}
	public String getDescription() {
		String description = "WPP";
		return description;
	};
}