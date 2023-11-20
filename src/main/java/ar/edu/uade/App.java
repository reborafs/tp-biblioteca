package ar.edu.uade;
import ar.edu.uade.views.VistaPrestamos;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.SwingUtilities;

public class App {
    private static final Logger log = LogManager.getLogger(App.class);

    public static void main( String[] args )  {

        //CadenaGimnasio gym = CadenaGimnasio.getInstance();
        //gym.llenarGym();

        // Crear y mostrar la ventana
        SwingUtilities.invokeLater(() -> {
            VistaPrestamos vistaPrestamos = new VistaPrestamos();;
            vistaPrestamos.setVisible(true);
        });
    }
}
