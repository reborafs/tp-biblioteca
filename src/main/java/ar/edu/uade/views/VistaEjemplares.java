package ar.edu.uade.views;

import ar.edu.uade.controllers.ControladorCliente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class VistaEjemplares extends JFrame {

	private ControladorCliente controller;

	public VistaEjemplares() {
		super("Ejemplares");
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
		JLabel labelTitulo = new JLabel("Ejercicios por Sede");
		labelTitulo.setFont(new Font("Arial", Font.BOLD, 32));
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.NORTH;
		panelMenu.add(labelTitulo, gbc);
		
		gbc.gridwidth = 1;

		this.add(panelMenu, BorderLayout.NORTH);
		
		
		// Tabla de clases asignadas
		JTable tabla = new JTable();
		DefaultTableModel modelo = new DefaultTableModel();
		
		HashMap<String, ArrayList<String>> ejerciciosPorSede = controller.getEjerciciosPorSede();

		// Definicion de columnas
		String[] columnas = new String[ejerciciosPorSede.size()+1];
		columnas[0] = "Tipo de Ejercicio";
		// fila =  new String[20];
		ArrayList<String> fila = new ArrayList<>();
		int z = 1;
		for (String sede : ejerciciosPorSede.keySet()){
			columnas[z] = sede;
			z++;
			for(String valor: ejerciciosPorSede.get(sede)){
				if(!controller.estaEnLista(valor,fila)){
					fila.add(valor);
				}
			}
		}
		int cantColumnas = columnas.length;

		modelo.setColumnIdentifiers(columnas);
		
        for (String ejercicio : fila) {
            String[] ejercicioDisponible = new String[cantColumnas+1];
            ejercicioDisponible[0] = ejercicio;
            for (int j = 1; j <= ejerciciosPorSede.size(); j++) {
            	String sede = columnas[j];
				ArrayList<String> ejerciciosSede = ejerciciosPorSede.get(sede);
                if (ejerciciosSede != null && contieneEjercicio(ejerciciosSede, ejercicio)) {
                	ejercicioDisponible[j] = "Disponible";
                } else {
                	ejercicioDisponible[j] = "No Disponible";
                }
            }
            modelo.addRow(ejercicioDisponible);
        }
		
		tabla.setModel(modelo);
		
        for (int i = 0; i < cantColumnas; i++) {
            tabla.getColumnModel().getColumn(i).setPreferredWidth(100);
        }

        // Agregar la tabla a un JScrollPane y añadirlo a la ventana
        JScrollPane scrollPane = new JScrollPane(tabla);
        getContentPane().add(scrollPane, BorderLayout.CENTER);


		btnEjemplares.addActionListener(e -> abrirVistaPrestamos());
		btnEjemplares.addActionListener(e -> abrirVistaSocios());


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

    private boolean contieneEjercicio(ArrayList<String> ejercicios, String ejercicio) {
        for (String e : ejercicios) {
            if (e.equals(ejercicio)) {
                return true;
            }
        }
        return false;
    }

}
