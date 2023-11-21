package ar.edu.uade.usuario;


import ar.edu.uade.prestamo.Observer;
import ar.edu.uade.prestamo.Sujeto;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.io.Serializable;
import java.util.*;


public class Socio implements Observer{

    private UUID id;
    private String nombre;
    private String apellido;
    private String dni;
    private String mail;
    private String nroTelefono;
    //private ContextoAlerta contextoAlerta;
    //private TipoAlerta tipoAlerta;
    private IEstrategiaAlerta estrategiaAlerta;
    private EstadoSocio estadoSocio;
    //private TipoEstado estado;
    private int stateDiasHabiles;
	private int devolucionesTermino;

    public Socio(String nombre, String apellido, String dni, String mail, String nroTelefono,
			IEstrategiaAlerta estrategiaAlerta) {
		this.id = UUID.randomUUID();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.mail = mail;
		this.nroTelefono = nroTelefono;
		this.estrategiaAlerta = estrategiaAlerta;	
		this.estadoSocio = EstadoSocio.ACTIVO;
		this.stateDiasHabiles = 0;
		this.devolucionesTermino = 0;
	}
    
    
	public void enviarAlerta(String contacto, String mensaje, TipoMotivoComunicacion motivoComunicacion) {
		estrategiaAlerta.enviarNotificacion(contacto, mensaje, motivoComunicacion);
	}
	
    public void setEstadoSocio(EstadoSocio estadoSocio) {
		this.estadoSocio = estadoSocio;
	}
	
	public void setEstrategiaAlerta(IEstrategiaAlerta estrategiaAlerta) {
		this.estrategiaAlerta = estrategiaAlerta;

	}
	
	public void setStateDiasHabiles(int cantStateDiasHabiles) {
		this.stateDiasHabiles += cantStateDiasHabiles;
	}
	
	public IEstrategiaAlerta getEstrategiaAlerta () {
		return estrategiaAlerta;
	}
	
	public UUID getUUID () {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getMail() {
		return mail;
	}

	public String getNroTelefono() {
		return nroTelefono;
	}

	public EstadoSocio getEstadoSocio() {
		return estadoSocio;
	}


	public int getStateDiasHabiles() {
		return stateDiasHabiles;
	}

	public void setDevolucionesTermino() {
		this.devolucionesTermino++;
	}

	public void resetDevolucionesTermino() {
		this.devolucionesTermino = 0;
	}


	@Override
	public void actualizar(Sujeto observable) {
		String estadoPrestamo = observable.getEstado().toString();
		if(estadoPrestamo.equals("DEVUELTO")){
			LocalDate fechaEnvioNotificacion = observable.getFechaVencimiento();
			LocalDate fechaActual = LocalDate.now();
			int diasDiferencia = (int) ChronoUnit.DAYS.between(fechaEnvioNotificacion, fechaActual);
			this.setStateDiasHabiles(diasDiferencia);
			System.out.println("diasDiferencia: " + diasDiferencia);
			if(diasDiferencia > 0){
				this.setDevolucionesTermino();
				if(this.devolucionesTermino == 5){
					this.setStateDiasHabiles(1);
					this.resetDevolucionesTermino();
				}
			} else if (diasDiferencia < 0) {
				this.resetDevolucionesTermino();
				this.setEstadoSocio(EstadoSocio.SUSPENDIDO);
				System.out.println("Aqui estadoSocio: " + this.getEstadoSocio().toString());
			}
		} else if(estadoPrestamo.equals("VENCIDO")){
			this.resetDevolucionesTermino();
			this.setEstadoSocio(EstadoSocio.SUSPENDIDO);
			System.out.println("Aqui estadoSocio: " + this.getEstadoSocio().toString());
		}
		System.out.printf("Socio te informo el cambio de estado tu prestamo a "+ estadoPrestamo+"\n");
	}

	public Map<String, String> getInfo() {
		return 	Map.of(
				"id", this.id.toString(),
				"nombre", this.nombre,
				"apellido", this.apellido,
				"dni", this.dni,
				"mail", this.mail,
				"nroTelefono", this.nroTelefono,
				"estrategiaAlerta", this.estrategiaAlerta.getDescription(),
				"stateSocio", this.estadoSocio.toString());
	}
}