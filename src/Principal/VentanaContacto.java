package Principal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import validaciones.Validar;
import validaciones.TipoErrores;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class VentanaContacto extends Ventana {
	private static final long serialVersionUID = 1L;
	// Defino los TextField
	private JTextField txtNombre = new JTextField();
	private JTextField txtApellido = new JTextField();
	private JTextField txtTelefono = new JTextField();
	private JTextField txtFechaNac = new JTextField();
	private ArrayList<JTextField> txts = new ArrayList<JTextField>();

	// Defino los Label
	private JLabel lblNombre = new JLabel();
	private JLabel lblApellido = new JLabel();
	private JLabel lblTelefono = new JLabel();
	private JLabel lblFechaNac = new JLabel();
	private JLabel lblDatosIng = new JLabel();

	// Defino los textos constantes
	private final String Nombre = "Nombre:";
	private final String Apellido = "Apellido:";
	private final String Telefono = "Teléfono:";
	private final String FechaNac = "Fecha Nac.:";
	private final String DatosIng = "Los datos ingresados fueron:";

	// BOTON mostrar
	private JButton btnMostrar = new JButton();
	private JLabel lblMostrarNombre = new JLabel();
	private JLabel lblMostrarApellido = new JLabel();
	private JLabel lblMostrarTel = new JLabel();
	private JLabel lblMostrarFecha = new JLabel();

	private JLabel lblNombreError = new JLabel();
	private JLabel lblApellidoError = new JLabel();
	private JLabel lblTelefonoError = new JLabel();
	private JLabel lblFNacError = new JLabel();

	public VentanaContacto(VentanaPpal padre) {
		super(padre, new int[] { 500, 100, 406, 537 }, "Contactos");

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				padre.ventanaHijaActiva(false);
				dispose();
			}

			public void windowActivated(WindowEvent e) {
				padre.ventanaHijaActiva(true);
			}
		});

		setearTxt(txtNombre, new int[] { 109, 16, 248, 30 });
		setearTxt(txtApellido, new int[] { 109, 70, 248, 30 });
		setearTxt(txtTelefono, new int[] { 109, 122, 248, 30 });
		setearTxt(txtFechaNac, new int[] { 109, 175, 248, 30 });
		txts.add(txtNombre);
		txts.add(txtFechaNac);
		txts.add(txtTelefono);
		txts.add(txtFechaNac);

		setLabel(lblNombre, Nombre, new int[] { 10, 11, 89, 41 }, Color.BLACK, true);
		setLabel(lblApellido, Apellido, new int[] { 10, 65, 89, 41 }, Color.BLACK, true);
		setLabel(lblTelefono, Telefono, new int[] { 10, 117, 89, 41 }, Color.BLACK, true);
		setLabel(lblFechaNac, FechaNac, new int[] { 10, 164, 89, 41 }, Color.BLACK, true);

		// Label para mostrar los datos
		setLabel(lblMostrarNombre, "", new int[] { 20, 325, 266, 14 }, Color.BLACK, false);
		setLabel(lblMostrarApellido, "", new int[] { 20, 350, 266, 14 }, Color.BLACK, false);
		setLabel(lblMostrarTel, "", new int[] { 20, 375, 266, 14 }, Color.BLACK, false);
		setLabel(lblMostrarFecha, "", new int[] { 20, 400, 266, 14 }, Color.BLACK, false);

		// Configuro Botón Mostrar
		btnMostrar = new JButton();
		btnMostrar.setText("Mostrar");
		btnMostrar.setBounds(264, 236, 89, 30);

		// Agrego el boton al Panel
		getContentPane().add(btnMostrar);

		// Datos Ingresados label
		setLblText(lblDatosIng, new Font("Lucida Sans Unicode", Font.BOLD, 12), this.getBackground(),
				new int[] { 10, 261, 183, 41 }, DatosIng);

		// Labels para errores.
		setLabel(lblNombreError, "", new int[] { 109, 45, 250, 14 }, Color.red, false);
		setTxtReferencia(lblNombreError, txtNombre);
		getContentPane().add(lblNombreError);

		setLabel(lblApellidoError, "", new int[] { 109, 97, 250, 14 }, Color.red, false);
		setTxtReferencia(lblApellidoError, txtApellido);
		getContentPane().add(lblApellidoError);

		setLabel(lblTelefonoError, "", new int[] { 109, 152, 250, 14 }, Color.red, false);
		setTxtReferencia(lblTelefonoError, txtTelefono);
		getContentPane().add(lblTelefonoError);

		setLabel(lblFNacError, "", new int[] { 109, 205, 250, 14 }, Color.red, false);
		setTxtReferencia(lblFNacError, txtFechaNac);
		getContentPane().add(lblFNacError);

		btnMostrar.addActionListener(new eBtnMostrar(this));

	}

	public ArrayList<JTextField> getTexts() {
		return txts;
	}

	public boolean hayErrorEnCampos() {
		Validar validar = new Validar();
		boolean existeError = false;

		if (validar.campoVacio(txtNombre)) {
			setError(lblNombreError, TipoErrores.getMSJ_CAMPO_VACIO());
			txtNombre.setBackground(Color.RED);
			existeError = true;
		} else if (!validar.nombreApellidoValido(txtNombre)) {
			setError(lblNombreError, TipoErrores.getMSJ_CONTIENE_SIMBOLOS());
			existeError = true;
		}

		if (validar.campoVacio(txtApellido)) {
			setError(lblApellidoError, TipoErrores.getMSJ_CAMPO_VACIO());
			txtApellido.setBackground(Color.RED);
			existeError = true;
		} else if (!validar.nombreApellidoValido(txtApellido)) {
			setError(lblApellidoError, TipoErrores.getMSJ_CONTIENE_SIMBOLOS());
			existeError = true;
		}

		if (validar.campoVacio(txtTelefono)) {
			setError(lblTelefonoError, TipoErrores.getMSJ_CAMPO_VACIO());
			txtTelefono.setBackground(Color.RED);
			existeError = true;
		} else if (validar.contieneLetras(txtTelefono)) {
			setError(lblTelefonoError, TipoErrores.getMSJ_CONTIENE_LETRAS());
			existeError = true;
		} else if (validar.telefonoInvalido(txtTelefono)) {
			setError(lblTelefonoError, TipoErrores.getMSJ_TEL_LONGITUD_INCORRECTA());
			existeError = true;
		}

		if (validar.campoVacio(txtFechaNac)) {
			setError(lblFNacError, TipoErrores.getMSJ_CAMPO_VACIO());
			txtFechaNac.setBackground(Color.RED);
			existeError = true;
		}
		if (validar.fechaInvalida(txtFechaNac)) {

			setError(lblFNacError, validar.getErrorMsg());
			existeError = true;
		}
		return existeError;
	}

	public void mostrarDatosContacto() {

		lblMostrarNombre.setText("Nombre:   " + txtNombre.getText());
		lblMostrarApellido.setText("Apellido: " + txtApellido.getText());
		lblMostrarTel.setText("Teléfono: " + txtTelefono.getText());
		lblMostrarFecha.setText("Fecha nac.: " + txtFechaNac.getText());

		lblMostrarNombre.setVisible(true);
		lblMostrarApellido.setVisible(true);
		lblMostrarTel.setVisible(true);
		lblMostrarFecha.setVisible(true);

		limpiarCampos();
	}

	public void limpiarCampos() {
		txtNombre.setText("");
		txtApellido.setText("");
		txtTelefono.setText("");
		txtFechaNac.setText("");
	}

	public void ocultarErrores() {
		ocultarLabel(lblNombreError);
		ocultarLabel(lblApellidoError);
		ocultarLabel(lblTelefonoError);
		ocultarLabel(lblFNacError);
	}

	private void setTxtReferencia(JLabel label, JTextField txt) {
		label.setLabelFor(txt);
	}

}

class eBtnMostrar implements ActionListener {

	private VentanaContacto ventana;

	public eBtnMostrar(VentanaContacto ventana) {
		this.ventana = ventana;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		ventana.ocultarErrores();
		for (JTextField text : ventana.getTexts()) {
			text.setBackground(Color.WHITE);
		}
		;

		if (!(ventana.hayErrorEnCampos()))
			ventana.mostrarDatosContacto();

	}
}
