package ar.edu.uade.views;

import ar.edu.uade.controllers.ControladorCliente;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VistaSocios extends JFrame {

    private ControladorCliente controller;

    public VistaSocios() {
        super("Cliente: Membresia");
        this.controller = ControladorCliente.getInstance();
        this.setLayout(new BorderLayout());

        JPanel panelMenu = new JPanel();
        panelMenu.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        /* Ejercicios Disponibles por Sedes */
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        JButton btnClaseAsignada = new JButton("Clases Asignadas");
        panelMenu.add(btnClaseAsignada, gbc);

        /* Ejercicios Disponibles por Sedes */
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        JButton btnEjerciciosSedes = new JButton("Ejercicios Disponibles por Sedes");
        panelMenu.add(btnEjerciciosSedes, gbc);

        /* Membresia */
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        JButton btnMembresia = new JButton("Membresia");
        panelMenu.add(btnMembresia, gbc);

        // Titulo
        JPanel panel = new JPanel();
        JLabel labelTitulo = new JLabel("Membresia Activa:");
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 32));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.NORTH;
        panelMenu.add(labelTitulo, gbc);

        gbc.gridwidth = 1;
        this.add(panelMenu, BorderLayout.NORTH);

        JLabel lblMembresiaActiva = new JLabel(controller.getMembresiaUsuario());
        lblMembresiaActiva.setFont(new Font("Arial", Font.BOLD, 32));
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.NORTH;
        panelMenu.add(lblMembresiaActiva, gbc);

        gbc.gridwidth = 1;
        this.add(panelMenu, BorderLayout.NORTH);



        JLabel labelDesc = new JLabel("Descripcion de membresias: ");
        labelDesc.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 0;
        panelMenu.add(labelDesc, gbc);

        //gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.gridy = 8;
        ArrayList<String[]> membresias = controller.getMembresias();

        for (String[] membresia : membresias) {
            JLabel labelMembresia1 = new JLabel(membresia[0]);
            labelMembresia1.setFont(new Font("Arial", Font.BOLD, 20));
            gbc.anchor = GridBagConstraints.NORTHWEST;
            panelMenu.add(labelMembresia1, gbc);
            gbc.gridy++;

            JLabel labelMembresia1Desc = new JLabel(membresia[1]);
            gbc.anchor = GridBagConstraints.NORTHWEST;
            panelMenu.add(labelMembresia1Desc, gbc);
            gbc.gridy++;
        }


        btnClaseAsignada.addActionListener(e -> abrirVistaEjemplares());
        btnEjerciciosSedes.addActionListener(e -> abrirVistaPrestamos());

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


}