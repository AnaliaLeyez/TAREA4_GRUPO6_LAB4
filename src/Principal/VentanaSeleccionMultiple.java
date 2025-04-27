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

public class VentanaSeleccionMultiple extends Ventana {

	private static final long serialVersionUID = 1L;
	private JButton btnVolver= new JButton();
	private JButton	btnAceptar= new JButton();;
	private ButtonGroup grupoSO= new ButtonGroup();

	private JRadioButton rbWindows=new JRadioButton();
	private JRadioButton rbMac=new JRadioButton();
	private JRadioButton rbLinux=new JRadioButton();
	private JCheckBox cbProgra = new JCheckBox();
	private JCheckBox cbDiseno = new JCheckBox();
	private JCheckBox cbAdmin = new JCheckBox();
	private JTextField txtCantHsPC= new JTextField();
	private JLabel lblErrorHoras= new JLabel();
	private JLabel lblEsp= new JLabel();
	private JLabel lblNewLabel= new JLabel();
	private JLabel lblSO = new JLabel();
	private JLabel lblErrorRadio= new JLabel();
	private JLabel lblErrorCheck= new JLabel();
	private VentanaPpal padre;

	private JPanel panelSO = new JPanel();
	private JPanel jpanelEspecialidad= new JPanel();

	public VentanaSeleccionMultiple(VentanaPpal padre) {
		super(padre, new int[] {500, 100, 459, 411},"Selección Múltiple");
		this.padre=padre;
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				padre.ventanaHijaActiva(false);
				setVentanaHijaActiva(false);
				dispose();
			}
		});

		setJPanel(panelSO, "", new int[] {20, 20, 381, 58});
		panelSO.setBorder(new LineBorder(Color.BLACK, 2));

		setLblText(lblSO, new Font("Tahoma", Font.BOLD, 12), this.getBackground(), new int[] {10, 17, 160, 20}, "Elije un sistema operativo:");
		panelSO.add(lblSO);

		//RadioButtons
		setJRadioBtn(rbWindows, "Windows", new int[] {180, 17, 80, 20}, new Font("Tahoma", Font.PLAIN, 13));		
		panelSO.add(rbWindows);
		grupoSO.add(rbWindows);
		
		setJRadioBtn(rbMac, "Mac", new int[] {260, 17, 60, 20}, new Font("Tahoma", Font.PLAIN, 13));		
		panelSO.add(rbMac);
		grupoSO.add(rbMac);
		
		setJRadioBtn(rbLinux, "Linux", new int[] {317, 17, 60, 20}, new Font("Tahoma", Font.PLAIN, 13));		
		panelSO.add(rbLinux);
		grupoSO.add(rbLinux);
		

		setearTxt(txtCantHsPC, new int[] {258, 230, 86, 20});
		txtCantHsPC.setColumns(10);

		setLabel(lblErrorHoras, "", new int[] {258, 253, 143, 14}, Color.RED, false);

		// especialidades
		setJPanel(jpanelEspecialidad, "", new int[] {20, 114, 381, 86});
		jpanelEspecialidad.setBorder(new LineBorder(Color.BLACK, 2));

		padre.setLabel(lblEsp, "Elije una especialidad:", new int[] { 10, 32, 136, 20 }, Color.BLACK, true);
		jpanelEspecialidad.add(lblEsp);

		setJcBox(cbDiseno, "Diseño Gráfico", new int[] {221, 32, 150, 20}, new Font("Tahoma", Font.PLAIN, 13));	
		jpanelEspecialidad.add(cbDiseno);
		
		setJcBox(cbAdmin, "Administración", new int[] {221, 57, 150, 20}, new Font("Tahoma", Font.PLAIN, 13));		
		jpanelEspecialidad.add(cbAdmin);		
		
		setJcBox(cbProgra, "Programación", new int[] {221, 7, 150, 20}, new Font("Tahoma", Font.PLAIN, 13));	
		jpanelEspecialidad.add(cbProgra);

		setLblText(lblNewLabel, new Font("Tahoma", Font.PLAIN, 13), this.getBackground(), new int[] {20, 232, 221, 14}, "Cantidad de horas en el computador:");

		// botones
		setButton(btnVolver, "Volver", new int[] {20, 294, 100, 30}, !getIsVentanaHijaActiva());
		setButton(btnAceptar, "Aceptar", new int[] {301, 294, 100, 30}, !getIsVentanaHijaActiva());
		btnVolver.addActionListener(new eBtnVolver(this));
		btnAceptar.addActionListener(new eBtnAceptar(this));

		// Label para error de RadioButton
		setLabel(lblErrorRadio, "", new int[] {20, 78, 350, 14}, Color.RED, false);
		lblErrorRadio.setVisible(false);
		
		// Label para error de CheckBox
		setLabel(lblErrorCheck, "", new int[] {20, 205, 350, 14}, Color.RED, false);
		lblErrorCheck.setVisible(false);


		this.setVentanaHijaActiva(false);
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
		if (cbProgra.isSelected()) {
			opciones.append("- Programación");
		}
		if (cbAdmin.isSelected()) {
			opciones.append("- Administración");
		}
		if (cbDiseno.isSelected()) {
			opciones.append("- Diseño Gráfico");
		}

		// Cantidad de horas en el computador
		opciones.append("-").append(txtCantHsPC.getText()).append("HS");

		return opciones.toString();
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
	    if (!cbProgra.isSelected() && !cbDiseno.isSelected() && !cbAdmin.isSelected()) {
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

	@Override
	public VentanaPpal getPadre() {
		return this.padre;
	}

	public void setVentanaHijaActiva(boolean isVentanaHijaActiva) {
		setIsVentanaHijaActiva(isVentanaHijaActiva);
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
		ventana.getPadre().ventanaHijaActiva(false);
		ventana.setVentanaHijaActiva(false);
		((JFrame) ventana).dispose();
	}
}
