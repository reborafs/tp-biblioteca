package ar.edu.uade.usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SociosFacade {
	public static SociosFacade instance;
	private List<Socio> socios;
	
	public SociosFacade () {
		this.socios = new ArrayList<>();
	}
	
	public static SociosFacade getInstance() {
		if(instance == null)
			instance = new SociosFacade();
		return instance;
	}
	
	public Socio getSocio(UUID idSocio) {
		for (Socio socio: socios) {
			if (socio.getUUID().equals(idSocio)) {
				return socio;				
			}
		}return null;
	}
	
	public void notificarSocio(String name) { //cambiar name por UUID
		for (Socio socio: socios) {
			if (socio.getNombre().equals(name)) {
				IEstrategiaAlerta ea = socio.getEstrategiaAlerta();
				socio.enviarAlerta(name, "tiene "+TipoMotivoComunicacion.FECHA_VENCIMIENTO_PROXIMO, TipoMotivoComunicacion.FECHA_VENCIMIENTO_PROXIMO);
				break;
			}			
		}
	}
	
	public void modificarNotificacion(String name, IEstrategiaAlerta ea) {
		for(Socio socio: socios) {
			if(socio.getNombre().equals(name)) {
				System.out.println("estrategia: "+socio.getEstrategiaAlerta());
				socio.setEstrategiaAlerta(ea);
				System.out.println(socio.getEstrategiaAlerta());
				break;
			}
			
		}
		
	}
	
	public void altaSocio(String nombre, String apellido, String dni, String mail, String nroTelefono, IEstrategiaAlerta ea) {
		Socio socio = new Socio(nombre, apellido, dni, mail, nroTelefono, ea);			
		socios.add(socio);
	}
	
	public void bajaSocio(String name) {
		for (Socio socio: socios) {
			if (socio.getNombre().equals(name)) {
				System.out.println("baja del socio: "+socio.getNombre());
				socios.remove(socio);
				break;
			}
		}
	}
	
	public void modificarSocio() {
		
	}
	
	
	
}

