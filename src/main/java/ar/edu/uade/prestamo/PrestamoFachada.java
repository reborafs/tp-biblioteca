package ar.edu.uade.prestamo;

import ar.edu.uade.prestamo.Prestamo;
import ar.edu.uade.usuario.Socio;
import ar.edu.uade.usuario.SociosFacade;

import java.time.LocalDate;
import java.util.*;

/**
 * 
 */
public class PrestamoFachada {
    public static PrestamoFachada instance;
    public List<Prestamo> prestamos;

    public PrestamoFachada () {
        this.prestamos = new ArrayList<>();
    }

    public static PrestamoFachada getInstance() {
        if(instance == null)
            instance = new PrestamoFachada();
        return instance;
    }


    public void prestarLibro(UUID idEjemplar, UUID idSocio, Integer plazoPrestamo) {

    }

    public List<Prestamo> getHistorialPrestamos(UUID idSocio) {

        return null;
    }

    public void crearPrestamo(LocalDate fechaPrestamo, LocalDate fechaVencimiento, EstadoPrestamo estado, Socio socio){
        UUID idSocio = socio.getUUID();
        Prestamo prestamo = new Prestamo(idSocio, fechaPrestamo, fechaVencimiento, estado);
        prestamo.agregar(socio);
        prestamos.add(prestamo);
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }
}