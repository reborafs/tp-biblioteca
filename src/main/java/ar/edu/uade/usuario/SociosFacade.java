package ar.edu.uade.usuario;

import ar.edu.uade.ejemplar.Ejemplar;
import ar.edu.uade.ejemplar.EjemplaresFachada;
import ar.edu.uade.prestamo.PrestamoFachada;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SociosFacade {
	public static SociosFacade instance;
	public List<Socio> socios;
	
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
	
	public void notificarSocio(UUID socioId, String mensaje, TipoMotivoComunicacion motivoComunicacion) { //cambiar name por UUID
		Socio socio = SociosFacade.getInstance().getSocio(socioId);
		String name = socio.getNombre();
		socio.enviarAlerta(name, mensaje, motivoComunicacion);
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

	public void solicitarPrestamo(Socio socio, String nameEjemplar){
		PrestamoFachada prestamoFachada = PrestamoFachada.getInstance();

		EjemplaresFachada ejemplarFacade = EjemplaresFachada.getInstance();

		//ejemplarFacade.cargarEjemplar();

		List<Ejemplar> resultadoBusqueda = ejemplarFacade.buscarEjemplar("LIBRO", nameEjemplar, null, null);

		Ejemplar ejemplar = resultadoBusqueda.get(0);

		if(socio.getEstadoSocio().equals(EstadoSocio.ACTIVO)){
			LocalDate fechaPrestamo = LocalDate.of(2023, 1, 18);
			LocalDate fechaVencimiento = LocalDate.of(2023, 11, 10);

			UUID socioID = socio.getUUID();

			UUID ejemplarID = ejemplar.getUuid();

			prestamoFachada.crearPrestamo(fechaPrestamo, fechaVencimiento, socioID, socio, ejemplarID, ejemplar);
		}



	}


	public List<Socio> getSocios() {
		return socios;
	}
}

