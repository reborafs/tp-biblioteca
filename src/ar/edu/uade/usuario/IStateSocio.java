package ar.edu.uade.usuario;

import java.util.*;

import ar.edu.uade.ejemplar.Ejemplar;
import ar.edu.uade.prestamo.Prestamo;

public interface IStateSocio {
    public void solicitarPrestamo(Ejemplar ejemplar, Socio socio);
    public void devolucionPrestamo(int diasTranscurridos, Socio socio);
}