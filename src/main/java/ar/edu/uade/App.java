package ar.edu.uade;
import ar.edu.uade.ejemplar.Categoria;
import ar.edu.uade.ejemplar.EjemplaresFachada;
import ar.edu.uade.utils.DatosTest;
import ar.edu.uade.views.VistaPrestamos;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.SwingUtilities;
import java.time.LocalDate;

public class App {
    private static final Logger log = LogManager.getLogger(App.class);



    public static void main( String[] args )  {

        DatosTest.llenarSocios();
        DatosTest.llenarEjemplares();


        // Crear y mostrar la ventana
        SwingUtilities.invokeLater(() -> {
            VistaPrestamos vistaPrestamos = new VistaPrestamos();
            vistaPrestamos.setVisible(true);
        });
    }
}
