package Principal;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.border.LineBorder;

import interfaces.VentanaConPadre;
import utilidades.CerrarVentanaActionListener;
import java.awt.Font;

public class VentanaSeleccionMultiple extends JFrame implements VentanaConPadre {

	private static final long serialVersionUID = 1L;
	private VentanaPpal padre;

	private JRadioButton rbWindows, rbMac, rbLinux;
	private JCheckBox cbDesarrollo, cbDiseno, cbAdmin;
	private JTextField txtHoras;
	private JPanel jpanelEspecialidad;
	private JTextField txtCantHsPC;

	public VentanaSeleccionMultiple(VentanaPpal padre) {
		this.padre = padre;
		padre.setVentanaHijaActiva(true);

		setTitle("Selección Múltiple");
		setBounds(500, 100, 520, 400);
		getContentPane().setLayout(null);
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
		panelSO.setBounds(20, 20, 450, 50); 
		panelSO.setBorder(new LineBorder(Color.BLACK, 2));
		getContentPane().add(panelSO);

		JLabel lblSO = new JLabel("Elije un sistema operativo:");
		lblSO.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSO.setBounds(10, 20, 160, 20); 
		panelSO.add(lblSO);

		rbWindows = new JRadioButton("Windows");
		rbWindows.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rbMac = new JRadioButton("Mac");
		rbMac.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rbLinux = new JRadioButton("Linux");
		rbLinux.setFont(new Font("Tahoma", Font.PLAIN, 13));

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
		lblEsp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEsp.setBounds(20, 110, 163, 20);
		getContentPane().add(lblEsp);

		cbDesarrollo = new JCheckBox("Desarrollo");
		cbDesarrollo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbDiseno = new JCheckBox("Diseño");
		cbDiseno.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbAdmin = new JCheckBox("Administración");
		cbAdmin.setFont(new Font("Tahoma", Font.PLAIN, 13));

		cbDesarrollo.setBounds(230, 110, 150, 20);
		cbDiseno.setBounds(230, 135, 150, 20);
		cbAdmin.setBounds(230, 160, 150, 20);

		getContentPane().add(cbDesarrollo);
		getContentPane().add(cbDiseno);
		getContentPane().add(cbAdmin);
		
		//Aca iria cantidad de horas en el computador
		

		
		//btn volver
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(10, 310, 100, 30);
		getContentPane().add(btnVolver);
		btnVolver.addActionListener(new CerrarVentanaActionListener(this));
		
		//btn aceptar
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(390, 310, 100, 30); // Esquina inferior derecha
		getContentPane().add(btnAceptar);
		
		jpanelEspecialidad = new JPanel();
		jpanelEspecialidad.setLayout(null);
		jpanelEspecialidad.setBounds(20, 89, 446, 134);
		jpanelEspecialidad.setBorder(new LineBorder(Color.BLACK, 2));
		getContentPane().add(jpanelEspecialidad);
		
		JLabel lblNewLabel = new JLabel("Cantidad de horas en el computador:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(21, 249, 221, 14);
		getContentPane().add(lblNewLabel);
		
		txtCantHsPC = new JTextField();
		txtCantHsPC.setBounds(259, 247, 86, 20);
		getContentPane().add(txtCantHsPC);
		txtCantHsPC.setColumns(10);
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
	
		
		