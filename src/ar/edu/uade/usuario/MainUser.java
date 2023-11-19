package ar.edu.uade.usuario;

public class MainUser {

	public static void main(String[] args) {
		FachadaSocio fachadaSocio = FachadaSocio.getInstance();
		
		for (int i = 0; i<10; i++) {
			String nombre = "name"+i;
			String apellido = "apellido"+i;
			String dni = ""+i;
			String mail = i+"@hotmail.com";
			String nroTelefono = "011-"+i;
			IEstrategiaAlerta estrategiaAlerta = new EstrategiaWpp();
			fachadaSocio.altaSocio(nombre, apellido, dni, mail, nroTelefono, estrategiaAlerta);		
		}
					
		IEstrategiaAlerta estrategiaMail = new EstrategiaMail();
		IEstrategiaAlerta estrategiaSms = new EstrategiaSms(null);
		
		System.out.println("---------------------------------------\n baja Socio: ");

		fachadaSocio.bajaSocio("name4");
		System.out.println("---------------------------------------\n update estrategia:");
		fachadaSocio.modificarNotificacion("name5", estrategiaSms);
		System.out.println("---------------------------------------\n notificacion:");
		fachadaSocio.notificarSocio("name5");
		System.out.println("---------------------------------------");
	}

}
