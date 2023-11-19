package ar.edu.uade.usuario;

import java.time.LocalDate;

public interface IEstrategiaAlerta {
	public void enviarNotificacion(String contacto, String mensaje, TipoMotivoComunicacion motivoComunicacion);
}
