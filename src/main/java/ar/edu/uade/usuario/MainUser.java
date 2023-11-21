package ar.edu.uade.usuario;

import java.util.UUID;

public class MainUser {

	public static void main(String[] args) {
		SociosFacade sociosFacade = SociosFacade.getInstance();
		
		for (int i = 0; i<10; i++) {
			String nombre = "name"+i;
			String apellido = "apellido"+i;
			String dni = ""+i;
			String mail = i+"@hotmail.com";
			String nroTelefono = "011-"+i;
			IEstrategiaAlerta estrategiaAlerta = new EstrategiaWpp();
			sociosFacade.altaSocio(nombre, apellido, dni, mail, nroTelefono, estrategiaAlerta);		
		}
					
		IEstrategiaAlerta estrategiaMail = new EstrategiaMail();
		IEstrategiaAlerta estrategiaSms = new EstrategiaSms(null);
		
		System.out.println("---------------------------------------\n baja Socio: ");

		sociosFacade.bajaSocio("name4");
		System.out.println("---------------------------------------\n update estrategia:");
		sociosFacade.modificarNotificacion("name5", estrategiaSms);
		System.out.println("---------------------------------------\n notificacion:");
		UUID socioID5 =  sociosFacade.getSocios().get(5).getUUID();
		sociosFacade.notificarSocio(socioID5, "tiene "+TipoMotivoComunicacion.FECHA_VENCIMIENTO_PROXIMO, TipoMotivoComunicacion.FECHA_VENCIMIENTO_PROXIMO);
		System.out.println("---------------------------------------");
	}

}
