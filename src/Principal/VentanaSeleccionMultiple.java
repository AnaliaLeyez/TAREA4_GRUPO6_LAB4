package Principal;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import javax.swing.border.LineBorder;
import interfaces.VentanaConPadre;
import utilidades.CerrarVentanaActionListener;
import validaciones.TipoErrores;
import validaciones.Validar;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaSeleccionMultiple extends JFrame implements VentanaConPadre {

	private static final long serialVersionUID = 1L;
	private VentanaPpal padre;

	private JRadioButton rbWindows, rbMac, rbLinux;
	private JCheckBox cbDesarrollo, cbDiseno, cbAdmin;
	private JPanel jpanelEspecialidad;
	private JTextField txtCantHsPC;
	private JLabel lblErrorHoras;

	public VentanaSeleccionMultiple(VentanaPpal padre) {
		this.padre = padre;
		padre.setVentanaHijaActiva(true);
		padre.setVentanaHija(this);

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

		// Aca iria cantidad de horas en el computador

		// btn volver
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(20, 228, 100, 30);
		getContentPane().add(btnVolver);
		btnVolver.addActionListener(new CerrarVentanaActionListener(this));

		// btn aceptar
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(301, 228, 100, 30); // Esquina inferior derecha
		getContentPane().add(btnAceptar);

		txtCantHsPC = new JTextField();
		txtCantHsPC.setBounds(258, 186, 86, 20);
		getContentPane().add(txtCantHsPC);
		txtCantHsPC.setColumns(10);

		lblErrorHoras = new JLabel();
		lblErrorHoras.setForeground(Color.RED);
		lblErrorHoras.setBounds(258, 206, 143, 14);
		getContentPane().add(lblErrorHoras);

		// evento btn Aceptar
		// Paso por setter los jlabel de errorHoras y jTextField de Horas
		eBtnAceptar eventoAceptar = new eBtnAceptar(this.getPadre());// Pasamos el padre a eBtnAceptar
		eventoAceptar.setCantHoras(txtCantHsPC);
		eventoAceptar.setLblErrorHs(lblErrorHoras);
		btnAceptar.addActionListener(eventoAceptar);

		jpanelEspecialidad = new JPanel();
		jpanelEspecialidad.setLayout(null);
		jpanelEspecialidad.setBounds(20, 89, 381, 86);
		jpanelEspecialidad.setBorder(new LineBorder(Color.BLACK, 2));
		getContentPane().add(jpanelEspecialidad);

		// especialidades falta agrega borde y acomodarlo
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

	}

	public void cambiarVisibilidad(boolean estado) {
		setVisible(estado);
	}

	public String obtenerOpcionesSeleccionadas() {
		StringBuilder opciones = new StringBuilder();
		// Sistema Operativo
		if (rbWindows.isSelected()) {
			opciones.append("Windows");
		} else if (rbMac.isSelected()) {
			opciones.append("Mac");
		} else if (rbLinux.isSelected()) {
			opciones.append("Linux");
		}

		// Especialidades
		if (cbDesarrollo.isSelected()) {
			opciones.append("- Programación");
		}
		if (cbDiseno.isSelected()) {
			opciones.append("- Administración");
		}
		if (cbAdmin.isSelected()) {
			opciones.append("- Diseño Gráfico");
		}

		// Cantidad de horas en el computador
		opciones.append("-").append(txtCantHsPC.getText()).append("HS");

		return opciones.toString();
	}

	private JLabel lblCantHsError;

	private void setError(JLabel label, String msjError) {
		label.setText(msjError);
		label.setVisible(true);
	}

	public boolean hayErrorEnCampos() {
		Validar validar = new Validar();
		boolean existeError = false;

		if (validar.campoVacio(txtCantHsPC)) {
			txtCantHsPC.setBackground(Color.RED);
			existeError = true;
		} else if (validar.contieneLetras(txtCantHsPC)) {
			setError(lblCantHsError, TipoErrores.getMSJ_CONTIENE_NRO());
			existeError = true;
		}
		return existeError;
	}

	@Override
	public VentanaPpal getPadre() {
		return padre;
	}

	public void setPadre(VentanaPpal padre) {
		this.padre = padre;
	}
}

class eBtnAceptar implements ActionListener {
	private VentanaPpal padre;
	private JLabel lblErrorHs;
	private JTextField CantHoras;

	public eBtnAceptar(VentanaPpal padre) {
		this.padre = padre;
	}

	public JLabel getLblErrorHs() {
		return lblErrorHs;
	}

	public void setLblErrorHs(JLabel lblErrorHs) {
		this.lblErrorHs = lblErrorHs;
	}

	public JTextField getCantHoras() {
		return CantHoras;
	}

	public void setCantHoras(JTextField cantHoras) {
		CantHoras = cantHoras;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		ocultarErrores(lblErrorHs, CantHoras);

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Accede a la instancia activa de VentanaSeleccionMultiple
					if (padre.isVentanaHijaActiva()) {
						VentanaSeleccionMultiple ventanaSeleccion = new VentanaSeleccionMultiple(padre);

						if (!(ventanaSeleccion.hayErrorEnCampos())) {

							// Valido que haya ingresado cantidad de horas correctas
							try {
								validarHoras(getCantHoras(), getLblErrorHs());

								// Obtener las opciones seleccionadas
								String opElegidas = ventanaSeleccion.obtenerOpcionesSeleccionadas();

								// Crear una nueva instancia de VentanaMensaje con las opciones
								VentanaMensaje frame = new VentanaMensaje(padre, opElegidas);
								frame.setVisible(true);

							} catch (FueraDeRangoException | NumberFormatException ex) {
								ex.printStackTrace();
							}
						}
					} else {
						System.err.println("No hay una ventana hija activa o la referencia no está definida.");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private float validarHoras(JTextField campo, JLabel errorLabel)
			throws FueraDeRangoException, NumberFormatException {
		try {
			float valor = Float.parseFloat(campo.getText());
			if (valor < 0 || valor > 24) {
				mostrarError(campo, errorLabel, "Debe estar entre 0 y 24");
				throw new FueraDeRangoException("Horas por día fuera de rango");
			}
			return valor;
		} catch (NumberFormatException e) {
			mostrarError(campo, errorLabel, "Ingrese un número válido");
			throw new NumberFormatException();
		}
	}

	private void mostrarError(JTextField campo, JLabel label, String error) {
		campo.setBackground(Color.PINK);
		label.setText(error);
		label.setVisible(true);
	}

	private void ocultarErrores(JLabel lblErrorHoras, JTextField TxtCantHsPC) {
		lblErrorHoras.setVisible(false);
		TxtCantHsPC.setBackground(Color.WHITE);
	}
}