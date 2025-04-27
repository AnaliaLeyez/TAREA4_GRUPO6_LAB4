package Principal;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import javax.swing.border.LineBorder;
import validaciones.TipoErrores;
import validaciones.Validar;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaSeleccionMultiple extends JFrame {

	private static final long serialVersionUID = 1L;
	private VentanaPpal padre;
	private boolean isVentanaHijaActiva = false;

	JButton btnVolver, btnAceptar;
	ButtonGroup grupoSO;

	private JRadioButton rbWindows, rbMac, rbLinux;
	private JCheckBox cbDesarrollo, cbDiseno, cbAdmin;
	private JTextField txtCantHsPC;
	private JLabel lblErrorHoras;
	private JLabel lblEsp, lblNewLabel, lblSO;
	private JLabel lblErrorRadio;
	private JLabel lblErrorCheck;


	private JPanel panelSO, jpanelEspecialidad;
	private JLabel lblErrorChck;

	public VentanaSeleccionMultiple(VentanaPpal padre) {
		setResizable(false);
		this.padre = padre;

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				padre.setVentanaHijaActiva(false);
				setVentanaHijaActiva(false);
				dispose();
			}
		});

		setBounds(500, 100, 459, 411);
		setTitle("Selección Múltiple");
		getContentPane().setLayout(null);

		panelSO = new JPanel();
		panelSO.setLayout(null);
		panelSO.setBounds(20, 20, 381, 58);
		panelSO.setBorder(new LineBorder(Color.BLACK, 2));
		getContentPane().add(panelSO);

		lblSO = new JLabel("Elije un sistema operativo:");
		lblSO.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSO.setBounds(10, 17, 160, 20);
		panelSO.add(lblSO);

		rbWindows = new JRadioButton("Windows");
		rbWindows.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rbMac = new JRadioButton("Mac");
		rbMac.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rbLinux = new JRadioButton("Linux");
		rbLinux.setFont(new Font("Tahoma", Font.PLAIN, 13));

		grupoSO = new ButtonGroup();
		grupoSO.add(rbWindows);
		grupoSO.add(rbMac);
		grupoSO.add(rbLinux);

		rbWindows.setBounds(180, 17, 80, 20);
		rbMac.setBounds(260, 17, 60, 20);
		rbLinux.setBounds(317, 17, 60, 20);

		panelSO.add(rbWindows);
		panelSO.add(rbMac);
		panelSO.add(rbLinux);

		// btn volver
		btnVolver = new JButton();
		btnVolver.setText("Volver");
		btnVolver.setBounds(20, 294, 100, 30);

		// btn aceptar
		btnAceptar = new JButton();
		btnAceptar.setText("Aceptar");
		btnAceptar.setBounds(301, 294, 100, 30); // Esquina inferior derecha

		txtCantHsPC = new JTextField();
		txtCantHsPC.setBounds(258, 230, 86, 20);
		getContentPane().add(txtCantHsPC);
		txtCantHsPC.setColumns(10);

		lblErrorHoras = new JLabel();
		lblErrorHoras.setForeground(Color.RED);
		lblErrorHoras.setBounds(258, 253, 143, 14);
		getContentPane().add(lblErrorHoras);

		// especialidades
		lblEsp = new JLabel("Elije una especialidad:");
		lblEsp.setBounds(10, 32, 136, 20);
		jpanelEspecialidad = new JPanel();

		jpanelEspecialidad.setLayout(null);
		jpanelEspecialidad.setBounds(20, 114, 381, 86);
		jpanelEspecialidad.setBorder(new LineBorder(Color.BLACK, 2));
		getContentPane().add(jpanelEspecialidad);

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

		lblNewLabel = new JLabel("Cantidad de horas en el computador:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(20, 232, 221, 14);
		getContentPane().add(lblNewLabel);

		getContentPane().add(btnVolver);
		getContentPane().add(btnAceptar);
		btnVolver.addActionListener(new eBtnVolver(this));
		// evento btn Aceptar
		eBtnAceptar eventoAceptar = new eBtnAceptar(this);
		eventoAceptar.setCantHoras(txtCantHsPC);
		eventoAceptar.setLblErrorHs(lblErrorHoras);

		// Label para error de RadioButton
		lblErrorRadio = new JLabel();
		lblErrorRadio.setForeground(Color.RED);
		lblErrorRadio.setBounds(20, 78, 350, 14);
		lblErrorRadio.setVisible(false);
		getContentPane().add(lblErrorRadio);

		// Label para error de CheckBox
		lblErrorCheck = new JLabel();
		lblErrorCheck.setForeground(Color.RED);
		lblErrorCheck.setBounds(20, 205, 350, 14);
		lblErrorCheck.setVisible(false);
		getContentPane().add(lblErrorCheck);

		
		btnAceptar.addActionListener(eventoAceptar);

		this.setVentanaHijaActiva(false);
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

	private void setError(JLabel label, String msjError) {
		label.setText(msjError);
		label.setVisible(true);
	}
	
	public boolean hayErrorEnRadioButton() {
	    if (!rbWindows.isSelected() && !rbMac.isSelected() && !rbLinux.isSelected()) {
	        lblErrorRadio.setText(TipoErrores.getMsjRadioBtn());
	        lblErrorRadio.setVisible(true);
	        return true;
	    } else {
	        lblErrorRadio.setText("");
	        lblErrorRadio.setVisible(false);
	        return false;
	    }
	}

	public boolean hayErrorEnCheckBox() {
	    if (!cbDesarrollo.isSelected() && !cbDiseno.isSelected() && !cbAdmin.isSelected()) {
	        lblErrorCheck.setText(TipoErrores.getMsjChkBtn());
	        lblErrorCheck.setVisible(true);
	        return true;
	    } else {
	        lblErrorCheck.setText("");
	        lblErrorCheck.setVisible(false);
	        return false;
	    }
	}

	public float validarHoras() throws FueraDeRangoException, NumberFormatException {
		try {
			float valor = Float.parseFloat(txtCantHsPC.getText());
			if (valor < 0) {
				mostrarError("Solo cantidad positiva");
				throw new FueraDeRangoException("Horas por día fuera de rango");
			}
			return valor;
		} catch (NumberFormatException e) {
			mostrarError("Ingrese un número válido");
			throw new NumberFormatException();
		}
	}

	private void mostrarError(String msjError) {
		txtCantHsPC.setBackground(Color.PINK);
		lblErrorHoras.setText(msjError);
		lblErrorHoras.setVisible(true);
	}

	public void ocultarErrores() {
	    lblErrorHoras.setText("");
	    lblErrorHoras.setVisible(false);

	    lblErrorRadio.setText("");
	    lblErrorRadio.setVisible(false);

	    lblErrorCheck.setText("");
	    lblErrorCheck.setVisible(false);
	    
	    txtCantHsPC.setBackground(Color.WHITE);
	}


	public boolean hayErrorEnCampos() {
		Validar validar = new Validar();
		boolean existeError = false;

		if (validar.campoVacio(txtCantHsPC)) {
			txtCantHsPC.setBackground(Color.RED);
			existeError = true;
		} else if (validar.contieneLetras(txtCantHsPC)) {
			setError(lblErrorHoras, TipoErrores.getMSJ_CONTIENE_NRO());
			existeError = true;
		}
		return existeError;
	}

	public VentanaPpal getPadre() {
		return padre;
	}

	public void setPadre(VentanaPpal padre) {
		this.padre = padre;
	}

	public boolean isVentanaHijaActiva() {
		return isVentanaHijaActiva;
	}

	public void setVentanaHijaActiva(boolean isVentanaHijaActiva) {
		this.isVentanaHijaActiva = isVentanaHijaActiva;
		this.btnAceptar.setEnabled(!isVentanaHijaActiva);
		this.btnVolver.setEnabled(!isVentanaHijaActiva);
	}

	public void setControlesActivos(boolean activos) {
		btnAceptar.setEnabled(activos);
		btnVolver.setEnabled(activos);
	}
}

class eBtnAceptar implements ActionListener {
	private VentanaSeleccionMultiple padre;
	private JLabel lblErrorHs;
	private JTextField CantHoras;

	public eBtnAceptar(VentanaSeleccionMultiple padre) {
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
	public void actionPerformed(ActionEvent e) {

	    padre.ocultarErrores();
	    
        boolean errorCampos = padre.hayErrorEnCampos();
        boolean errorRadio = padre.hayErrorEnRadioButton();
        boolean errorCheck = padre.hayErrorEnCheckBox();

	    EventQueue.invokeLater(new Runnable() {
	        public void run() {
	            try {
	                if (!padre.hayErrorEnCampos() && !padre.hayErrorEnRadioButton() && !padre.hayErrorEnCheckBox()) {
	                    try {
	                        padre.validarHoras();
	                        String opElegidas = padre.obtenerOpcionesSeleccionadas();
	                        VentanaMensaje frame = new VentanaMensaje(padre, opElegidas);
	                        padre.setControlesActivos(false);
	                        frame.setVisible(true);
	                    } catch (FueraDeRangoException | NumberFormatException ex) {
	                        ex.printStackTrace();
	                    }
	                }
	            } catch (Exception ex) {
	                ex.printStackTrace();
	            }
	        }
	    });
	}
}

class eBtnVolver implements ActionListener {

	private VentanaSeleccionMultiple ventana;

	public eBtnVolver(VentanaSeleccionMultiple ventana) {
		this.ventana = ventana;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Evento ejecutado");
		ventana.getPadre().setVentanaHijaActiva(false);
		((JFrame) ventana).dispose();
	}
}
