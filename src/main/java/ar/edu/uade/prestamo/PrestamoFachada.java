package ar.edu.uade.prestamo;

import ar.edu.uade.ejemplar.Ejemplar;
import ar.edu.uade.ejemplar.EjemplaresFachada;
import ar.edu.uade.prestamo.Prestamo;
import ar.edu.uade.usuario.Socio;
import ar.edu.uade.usuario.SociosFacade;
import ar.edu.uade.usuario.TipoMotivoComunicacion;

import java.time.LocalDate;
import java.util.*;

import java.time.temporal.ChronoUnit;

import static ar.edu.uade.prestamo.EstadoPrestamo.*;
import static ar.edu.uade.usuario.TipoMotivoComunicacion.*;

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

    public void crearPrestamo(LocalDate fechaPrestamo, LocalDate fechaVencimiento, UUID socioID, Socio socio, UUID ejemplarID, Ejemplar ejemplar){


        Prestamo prestamo = new Prestamo(socioID, ejemplarID, fechaPrestamo, fechaVencimiento, EstadoPrestamo.ACTIVO);
        prestamo.agregar(socio);
        prestamo.agregar(ejemplar);
        prestamos.add(prestamo);


    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void notificationPrestamo(Prestamo prestamo) {

            LocalDate fechaVencimiento = prestamo.getFechaVencimiento();
            LocalDate fechaActual = LocalDate.now();
            EstadoPrestamo estadoPrestamo = prestamo.getEstado();

            SociosFacade sociosFacade = SociosFacade.getInstance();

            int diasDiferencia = (int) ChronoUnit.DAYS.between(fechaActual, fechaVencimiento);

            UUID socioId = prestamo.getSocio();
            String mensaje;
            TipoMotivoComunicacion motivoComunicacion;

            System.out.println("---------------------------------------");

            if (diasDiferencia == 2 && estadoPrestamo != DEVUELTO) {
                mensaje = "Te quedan "+diasDiferencia+" días para devolver el ejemplar\n";
                motivoComunicacion = FECHA_VENCIMIENTO_PROXIMO;
            } else if (diasDiferencia == 1 && estadoPrestamo != DEVUELTO) {
                mensaje = "Te quedan "+diasDiferencia+" día para devolver el ejemplar\n";
                motivoComunicacion = FECHA_VENCIMIENTO_PROXIMO;
            } else if (diasDiferencia <= 0 && estadoPrestamo != DEVUELTO) {
                mensaje = "Se ha pasado la entrega del ejemplar\n";
                prestamo.setEstado(VENCIDO);
                motivoComunicacion = PENALIZACION_DEVOLUCION;
            } else {
                mensaje = "Aún no ha pasado suficiente tiempo para enviar la notificación";
                motivoComunicacion = PREMIO_DEVOLUCION;
            }

            sociosFacade.notificarSocio(socioId, mensaje, motivoComunicacion);

            System.out.println("---------------------------------------");

    }

    public void devolverPrestamo(Prestamo prestamo){
        LocalDate fechaDevolucion = LocalDate.now();
        prestamo.setFechaDevolucion(fechaDevolucion);
        prestamo.setEstado(DEVUELTO);

    }
}