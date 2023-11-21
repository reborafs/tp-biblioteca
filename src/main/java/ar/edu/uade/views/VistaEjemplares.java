package ar.edu.uade.views;

import ar.edu.uade.controllers.ControllerBiblioteca;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VistaEjemplares extends JFrame {

	private ControllerBiblioteca controller;

	public VistaEjemplares() {
		super("Ejemplares");
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
		JLabel labelTitulo = new JLabel("Lista de Ejemplares");
		labelTitulo.setFont(new Font("Arial", Font.BOLD, 32));
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.NORTH;
		panelMenu.add(labelTitulo, gbc);
		
		gbc.gridwidth = 1;

		this.add(panelMenu, BorderLayout.NORTH);


		mostrarTablaEjemplares();

		btnPrestamos.addActionListener(e -> abrirVistaPrestamos());
		btnSocios.addActionListener(e -> abrirVistaSocios());


		this.setSize(800, 600);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);

	}

	private void abrirVistaPrestamos() {
		this.dispose();
		VistaUtils.abrirVistaPrestamos();
	}

	private void abrirVistaSocios() {
		this.dispose();
		VistaUtils.abrirVistaSocios();
	}


	private void mostrarTablaEjemplares() {
		JTable tabla = new JTable();
		DefaultTableModel modelo = new DefaultTableModel();

		List<Map<String,String>> listaEjemplares = controller.getListaEjemplares();

		// Definicion de columnas
		String[] columnas = {"ID","Titulo","Autor","Categoria","Fecha Publicacion",
				"Ubicacion","Disponible"};
		int cantColumnas = columnas.length;

		modelo.setColumnIdentifiers(columnas);

		for (Map<String, String> infoCliente : listaEjemplares) {
			String[] fila = new String[cantColumnas+1];
			fila[0] = infoCliente.get("uuid");
			fila[1] = infoCliente.get("titulo");
			fila[2] = infoCliente.get("autor");
			fila[3] = infoCliente.get("categoria");
			fila[4] = infoCliente.get("fechaPublicacion");
			fila[5] = infoCliente.get("ubicacion");
			fila[6] = infoCliente.get("disponible");
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
