package ar.edu.uade.main;

import ar.edu.uade.prestamo.EstadoPrestamo;
import ar.edu.uade.prestamo.Prestamo;
import ar.edu.uade.prestamo.PrestamoFachada;
import ar.edu.uade.usuario.*;

import java.time.LocalDate;
import java.util.UUID;

public class MainFinal {
    public static void main(String[] args) {
        SociosFacade sociosFacade = SociosFacade.getInstance();
        PrestamoFachada prestamoFachada = PrestamoFachada.getInstance();


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
        sociosFacade.notificarSocio("name5");
        System.out.println("---------------------------------------");



        Socio socio = sociosFacade.getSocios().get(5);
        EstadoPrestamo estadoPrestamo = EstadoPrestamo.ACTIVO;
        LocalDate fechaPrestamo = LocalDate.of(2023, 1, 18);
        LocalDate fechaVencimiento = LocalDate.of(2023, 3, 12);

        prestamoFachada.crearPrestamo(fechaPrestamo, fechaVencimiento, estadoPrestamo, socio);

        Prestamo prestamoTest = prestamoFachada.getPrestamos().get(0);

        prestamoTest.setEstado(EstadoPrestamo.DEVUELTO);

    }
}
