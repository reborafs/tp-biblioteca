package ar.edu.uade.views;

import javax.swing.*;

public class VistaUtils {

    static public void abrirVistaEjemplares() {
        SwingUtilities.invokeLater(() -> {
            VistaEjemplares vistaEjemplares = new VistaEjemplares();
            vistaEjemplares.setVisible(true);
        });
    }

    static public void abrirVistaPrestamos() {
        SwingUtilities.invokeLater(() -> {
            VistaPrestamos vistaPrestamos = new VistaPrestamos();
            vistaPrestamos.setVisible(true);
        });
    }

    static public void abrirVistaSocios() {
        SwingUtilities.invokeLater(() -> {
            VistaSocios vistaSocios = new VistaSocios();
            vistaSocios.setVisible(true);
        });
    }
}
