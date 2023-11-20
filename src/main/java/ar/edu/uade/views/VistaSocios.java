package ar.edu.uade.views;

import ar.edu.uade.controllers.ControllerBiblioteca;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Map;
import java.util.List;

public class VistaSocios extends JFrame {

    private ControllerBiblioteca controller;

    public VistaSocios() {
        super("Cliente: Membresia");
        this.controller = ControllerBiblioteca.getInstance();
        this.setLayout(new BorderLayout());

        JPanel panelMenu = new JPanel();
        panelMenu.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        /* Ejercicios Disponibles por Sedes */
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        JButton btnEjemplares = new JButton("Ejemplares");
        panelMenu.add(btnEjemplares, gbc);

        /* Ejercicios Disponibles por Sedes */
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        JButton btnPrestamos = new JButton("Prestamos");
        panelMenu.add(btnPrestamos, gbc);

        /* Membresia */
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        JButton btnSocios = new JButton("Socios");
        panelMenu.add(btnSocios, gbc);

        // Titulo
        JPanel panel = new JPanel();
        JLabel labelTitulo = new JLabel("Lista de Socios");
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 32));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.NORTH;
        panelMenu.add(labelTitulo, gbc);

        gbc.gridwidth = 1;
        this.add(panelMenu, BorderLayout.NORTH);




        btnEjemplares.addActionListener(e -> abrirVistaEjemplares());
        btnPrestamos.addActionListener(e -> abrirVistaPrestamos());


        mostrarTablaSocios();

        this.setSize(800, 600);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);


    }

    private void abrirVistaEjemplares() {
        this.dispose();
        VistaUtils.abrirVistaEjemplares();
    }

    private void abrirVistaPrestamos() {
        this.dispose();
        VistaUtils.abrirVistaPrestamos();
    }

    private void mostrarTablaSocios() {
        JTable tabla = new JTable();
        DefaultTableModel modelo = new DefaultTableModel();

        List<Map<String,String>> listaSocios = controller.getListaSocios();

        // Definicion de columnas
        String[] columnas = {"ID","Nombre","Apellido","DNI","Mail",
                "NroTelefono","EstrategiaAlerta","StateSocio"};
        int cantColumnas = columnas.length;

        modelo.setColumnIdentifiers(columnas);

        for (Map<String, String> infoCliente : listaSocios) {
            String[] fila = new String[cantColumnas+1];
            fila[0] = infoCliente.get("id");
            fila[1] = infoCliente.get("nombre");
            fila[2] = infoCliente.get("apellido");
            fila[3] = infoCliente.get("dni");
            fila[4] = infoCliente.get("mail");
            fila[5] = infoCliente.get("nroTelefono");
            fila[6] = infoCliente.get("estrategiaAlerta");
            fila[7] = infoCliente.get("stateSocio");
            modelo.addRow(fila);
        }

        tabla.setModel(modelo);

        for (int i = 0; i < cantColumnas; i++) {
            tabla.getColumnModel().getColumn(i).setPreferredWidth(100);
        }

        // Agregar la tabla a un JScrollPane y añadirlo a la ventana
        JScrollPane scrollPane = new JScrollPane(tabla);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

}