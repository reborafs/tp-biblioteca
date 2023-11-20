package ar.edu.uade.prestamo;

import ar.edu.uade.ejemplar.Ejemplar;
import ar.edu.uade.usuario.Socio;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * 
 */
public class PrestamoFachada {
    public static PrestamoFachada instance;
    public List<Prestamo> prestamos;

    private PrestamoFachada () {
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


    public List<Map<String, String>> getInfoPrestamos() {
        return prestamos.stream().map(Prestamo::getInfo).collect(Collectors.toList());
    }
}