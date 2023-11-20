package ar.edu.uade.usuario;

public interface IEstrategiaAlerta {

	public void enviarNotificacion(String contacto, String mensaje, TipoMotivoComunicacion motivoComunicacion);

	public String getDescription();

}
