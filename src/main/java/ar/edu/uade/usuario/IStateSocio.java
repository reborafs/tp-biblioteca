package ar.edu.uade.usuario;


import ar.edu.uade.ejemplar.Ejemplar;
import ar.edu.uade.prestamo.Prestamo;

public abstract class IStateSocio {

    protected Socio socio;

    public IStateSocio(Socio socio) {
        this.socio = socio;
    }


    public abstract void solicitarPrestamo(Ejemplar ejemplar, Socio socio);
    public abstract void devolucionPrestamo(int diasTranscurridos, Socio socio);
}