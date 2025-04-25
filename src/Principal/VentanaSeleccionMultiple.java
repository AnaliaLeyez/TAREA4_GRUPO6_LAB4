package Principal;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.border.LineBorder;

import interfaces.VentanaConPadre;
import utilidades.CerrarVentanaActionListener;

public class VentanaSeleccionMultiple extends JFrame implements VentanaConPadre {

	private static final long serialVersionUID = 1L;
	private VentanaPpal padre;

	private JRadioButton rbWindows, rbMac, rbLinux;
	private JCheckBox cbDesarrollo, cbDiseno, cbAdmin;
	private JTextField txtHoras;

	public VentanaSeleccionMultiple(VentanaPpal padre) {
		this.padre = padre;
		padre.setVentanaHijaActiva(true);

		setTitle("Selección Múltiple");
		setBounds(500, 100, 520, 400);
		setLayout(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				padre.setVentanaHijaActiva(false);
				dispose();
			}
		});

		//panel con borde para sist. op.
		int panelWidth = 420;
		int panelX = (520 - panelWidth) / 2;
		
		JPanel panelSO = new JPanel();
		panelSO.setLayout(null);
		panelSO.setBounds(panelX, 20, panelWidth, 50); 
		panelSO.setBorder(new LineBorder(Color.BLACK, 2));
		add(panelSO);

		JLabel lblSO = new JLabel("Elije un sistema operativo:");
		lblSO.setBounds(10, 20, 160, 20); 
		panelSO.add(lblSO);

		rbWindows = new JRadioButton("Windows");
		rbMac = new JRadioButton("Mac");
		rbLinux = new JRadioButton("Linux");

		ButtonGroup grupoSO = new ButtonGroup();
		grupoSO.add(rbWindows);
		grupoSO.add(rbMac);
		grupoSO.add(rbLinux);

		rbWindows.setBounds(180, 20, 80, 20);
		rbMac.setBounds(260, 20, 60, 20);
		rbLinux.setBounds(320, 20, 60, 20);

		panelSO.add(rbWindows);
		panelSO.add(rbMac);
		panelSO.add(rbLinux);

		//especialidades falta agrega borde y acomodarlo
		JLabel lblEsp = new JLabel("Especialidades que te interesan:");
		lblEsp.setBounds(20, 110, 250, 20);
		add(lblEsp);

		cbDesarrollo = new JCheckBox("Desarrollo");
		cbDiseno = new JCheckBox("Diseño");
		cbAdmin = new JCheckBox("Administración");

		cbDesarrollo.setBounds(230, 110, 150, 20);
		cbDiseno.setBounds(230, 135, 150, 20);
		cbAdmin.setBounds(230, 160, 150, 20);

		add(cbDesarrollo);
		add(cbDiseno);
		add(cbAdmin);
		
		//Aca iria cantidad de horas en el computador
		

		
		//btn volver
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(10, 310, 100, 30);
		add(btnVolver);
		btnVolver.addActionListener(new CerrarVentanaActionListener(this));
		
		//btn aceptar
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(390, 310, 100, 30); // Esquina inferior derecha
		add(btnAceptar);
	}

	
	public void cambiarVisibilidad(boolean estado) {
		setVisible(estado);
	}

	@Override
	public VentanaPpal getPadre() {
		return padre;
	}

	
	public void setPadre(VentanaPpal padre) {
		this.padre = padre;
	}
}
	
		
		