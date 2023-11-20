package ar.edu.uade.views;

import ar.edu.uade.controllers.ControllerBiblioteca;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.util.Map;

public class VistaPrestamos extends JFrame {

    private ControllerBiblioteca controller;

	public VistaPrestamos() {
		super("Biblioteca: Prestamos activos");
        this.controller = ControllerBiblioteca.getInstance();
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

		mostrarTablaPrestamos();

        btnEjemplares.addActionListener(e -> abrirVistaEjemplares());
        btnSocios.addActionListener(e -> abrirVistaSocios());

        this.setSize(800, 600);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);


    }

    private void abrirVistaEjemplares() {
        this.dispose();
        VistaUtils.abrirVistaEjemplares();
    }

    private void abrirVistaSocios() {
        this.dispose();
        VistaUtils.abrirVistaSocios();
    }

	private void mostrarTablaPrestamos() {
		JTable tabla = new JTable();
		DefaultTableModel modelo = new DefaultTableModel();

		List<Map<String,String>> listaPrestamos = controller.getListaSocios();

		// Definicion de columnas
		String[] columnas = {"ID","fechaPrestamo","fechaVencimiento","fechaDevolucion","estado"};
		int cantColumnas = columnas.length;

		modelo.setColumnIdentifiers(columnas);

		for (Map<String, String> infoCliente : listaPrestamos) {
			String[] fila = new String[cantColumnas+1];
			fila[0] = infoCliente.get("idSocio");
			fila[1] = infoCliente.get("fechaPrestamo");
			fila[2] = infoCliente.get("fechaVencimiento");
			fila[3] = infoCliente.get("fechaDevolucion");
			fila[4] = infoCliente.get("estado");
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
