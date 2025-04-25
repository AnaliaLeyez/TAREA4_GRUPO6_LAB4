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
	private JPanel jpanelEspecialidad;
	private JTextField txtCantHsPC;

	public VentanaSeleccionMultiple(VentanaPpal padre) {
		this.padre = padre;
		padre.setVentanaHijaActiva(true);

		setTitle("Selección Múltiple");
		setBounds(500, 100, 436, 304);
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
		panelSO.setBounds(20, 20, 381, 58); 
		panelSO.setBorder(new LineBorder(Color.BLACK, 2));
		getContentPane().add(panelSO);

		JLabel lblSO = new JLabel("Elije un sistema operativo:");
		lblSO.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSO.setBounds(10, 17, 160, 20); 
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

		rbWindows.setBounds(180, 17, 80, 20);
		rbMac.setBounds(260, 17, 60, 20);
		rbLinux.setBounds(317, 17, 60, 20);

		panelSO.add(rbWindows);
		panelSO.add(rbMac);
		panelSO.add(rbLinux);
		
		//Aca iria cantidad de horas en el computador
		
		//btn volver
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(20, 228, 100, 30);
		getContentPane().add(btnVolver);
		btnVolver.addActionListener(new CerrarVentanaActionListener(this));
		
		//btn aceptar
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(301, 228, 100, 30); // Esquina inferior derecha
		getContentPane().add(btnAceptar);
		
		jpanelEspecialidad = new JPanel();
		jpanelEspecialidad.setLayout(null);
		jpanelEspecialidad.setBounds(20, 89, 381, 86);
		jpanelEspecialidad.setBorder(new LineBorder(Color.BLACK, 2));
		getContentPane().add(jpanelEspecialidad);
		
				//especialidades falta agrega borde y acomodarlo
				JLabel lblEsp = new JLabel("Elije una especialidad:");
				lblEsp.setBounds(10, 32, 136, 20);
				jpanelEspecialidad.add(lblEsp);
				lblEsp.setFont(new Font("Tahoma", Font.PLAIN, 13));
				cbAdmin = new JCheckBox("Diseño Gráfico");
				cbAdmin.setBounds(221, 57, 150, 20);
				jpanelEspecialidad.add(cbAdmin);
				cbAdmin.setFont(new Font("Tahoma", Font.PLAIN, 13));
				cbDiseno = new JCheckBox("Administración");
				cbDiseno.setBounds(221, 32, 150, 20);
				jpanelEspecialidad.add(cbDiseno);
				cbDiseno.setFont(new Font("Tahoma", Font.PLAIN, 13));
				
						cbDesarrollo = new JCheckBox("Programación");
						cbDesarrollo.setBounds(221, 7, 150, 20);
						jpanelEspecialidad.add(cbDesarrollo);
						cbDesarrollo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblNewLabel = new JLabel("Cantidad de horas en el computador:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(20, 188, 221, 14);
		getContentPane().add(lblNewLabel);
		
		txtCantHsPC = new JTextField();
		txtCantHsPC.setBounds(258, 186, 86, 20);
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
	
		
		