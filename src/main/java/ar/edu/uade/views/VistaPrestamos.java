package ar.edu.uade.views;

import ar.edu.uade.controllers.ControladorCliente;

import javax.swing.*;
import java.awt.*;

public class VistaPrestamos extends JFrame {

    private ControladorCliente controller;

	public VistaPrestamos() {
		super("Biblioteca: Prestamos activos");
        this.controller = ControladorCliente.getInstance();
        this.setLayout(new BorderLayout());

        JPanel panelMenu = new JPanel();
		panelMenu.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		JButton btnEjemplares = new JButton("Ejemplares");
		panelMenu.add(btnEjemplares, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		JButton btnPrestamos = new JButton("Prestamos");
		panelMenu.add(btnPrestamos, gbc);

		gbc.gridx = 3;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		JButton btnSocios = new JButton("Socios");
		panelMenu.add(btnSocios, gbc);


		//Titulo
        JPanel panel = new JPanel();
		JLabel labelTitulo = new JLabel("Historial de Prestamos");
		labelTitulo.setFont(new Font("Arial", Font.BOLD, 32));
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.NORTH;
		panelMenu.add(labelTitulo, gbc);


		gbc.gridwidth = 1;

		this.add(panelMenu, BorderLayout.NORTH);

		JPanel panelContenido = new JPanel(new BorderLayout());

		// Tabla de clases asignadas
        JTable tabla = new JTable();

        // Agregar la tabla a un JScrollPane y añadirlo a la ventana
        JScrollPane scrollPane = new JScrollPane(tabla);
        panelContenido.add(scrollPane, BorderLayout.CENTER);
        this.add(panelContenido, BorderLayout.CENTER);

        btnEjemplares.addActionListener(e -> abrirVistaSocios());
        btnPrestamos.addActionListener(e -> abrirVistaPrestamos());

        this.setSize(800, 600);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);


    }

    private void abrirVistaSocios() {
        this.dispose();
        VistaUtils.abrirVistaSocios();
    }

    private void abrirVistaPrestamos() {
        this.dispose();
        VistaUtils.abrirVistaPrestamos();
    }


}
