package ar.edu.uade.utils;

import ar.edu.uade.ejemplar.Categoria;
import ar.edu.uade.ejemplar.EjemplaresFachada;
import ar.edu.uade.prestamo.EstadoPrestamo;
import ar.edu.uade.prestamo.Prestamo;
import ar.edu.uade.prestamo.PrestamoFachada;
import ar.edu.uade.usuario.*;

import java.time.LocalDate;

public class DatosTest {
    public static void llenarEjemplares() {
        EjemplaresFachada ejemplaresFachada = EjemplaresFachada.getInstance();
        ejemplaresFachada.cargarEjemplar(Categoria.LIBRO, "Cien años de soledad", "Gabriel García Márquez", LocalDate.of(1967, 1, 1), "Sección A");
        ejemplaresFachada.cargarEjemplar(Categoria.DIARIO, "El País", "Varios autores", LocalDate.of(1976, 1, 1), "Sección B");
        ejemplaresFachada.cargarEjemplar(Categoria.REVISTA, "National Geographic", "Varios autores", LocalDate.of(1888, 1, 1), "Sección C");
        ejemplaresFachada.cargarEjemplar(Categoria.LIBRO, "1984", "George Orwell", LocalDate.of(1949, 1, 1), "Sección D");
        ejemplaresFachada.cargarEjemplar(Categoria.REVISTA_ESPECIALIZADA, "Nature", "Varios autores", LocalDate.of(1869, 1, 1), "Sección A");
        ejemplaresFachada.cargarEjemplar(Categoria.LIBRO, "Don Quijote de la Mancha", "Miguel de Cervantes", LocalDate.of(1605, 1, 1), "Sección B");
        ejemplaresFachada.cargarEjemplar(Categoria.DIARIO, "The New York Times", "Varios autores", LocalDate.of(1851, 1, 1), "Sección C");
        ejemplaresFachada.cargarEjemplar(Categoria.LIBRO, "Matar un ruiseñor", "Harper Lee", LocalDate.of(1960, 1, 1), "Sección D");
        ejemplaresFachada.cargarEjemplar(Categoria.REVISTA, "Time", "Varios autores", LocalDate.of(1923, 1, 1), "Sección A");
        ejemplaresFachada.cargarEjemplar(Categoria.LIBRO, "Harry Potter y la piedra filosofal", "J.K. Rowling", LocalDate.of(1997, 1, 1), "Sección B");


    }

    public static void llenarSocios() {
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
