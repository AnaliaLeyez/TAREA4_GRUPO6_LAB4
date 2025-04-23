package Principal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import Principal.DatosFormularioEj1.DatosValidados;
import utilidades.FormatoLabel;
import validaciones.Validar;
import validaciones.TipoErrores;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VentanaContacto extends JFrame {
	private static final long serialVersionUID = 1L;

	// Defino los TextField
	private JTextField txtNombre = new JTextField();;
	private JTextField txtApellido = new JTextField();;
	private JTextField txtTelefono = new JTextField();;
	private JTextField txtFechaNac = new JTextField();;

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
	private JButton btnMostrar;
	private JLabel lblMostrarNombre = new JLabel();
	private JLabel lblMostrarApellido = new JLabel();
	private JLabel lblMostrarTel = new JLabel();
	private JLabel lblMostrarFecha = new JLabel();
	
	private JLabel lblNombreError;
	private JLabel lblApellidoError;
	private JLabel lblTelefonoError;
	private JLabel lblFNacError;

	public VentanaContacto() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 100, 406, 537);
		setTitle("Contactos");
		getContentPane().setLayout(null);
		
		// Clase para manejar los formatos básicos de lbl 
		FormatoLabel modeloLabel = new FormatoLabel();
		
		setearTxt(txtNombre, new int[] {109, 16, 248, 30});
		setearTxt(txtApellido, new int[] {109, 70, 248, 30});
		setearTxt(txtTelefono, new int[] {109, 122, 248, 30});
		setearTxt(txtFechaNac, new int[] {109, 175, 248, 30});

		setLabel(lblNombre, Nombre,  new int[] {10, 11, 89, 41}, true);
		setLabel(lblApellido, Apellido, new int[] {10, 65, 89, 41}, true);
		setLabel(lblTelefono, Telefono, new int[] {10, 117, 89, 41}, true);
		setLabel(lblFechaNac, FechaNac, new int[] {10, 164, 89, 41}, true);
		
		// Label para mostrar los datos
		setLabel(lblMostrarNombre, "" , new int[] {20, 325, 266, 14}, false);
		setLabel(lblMostrarApellido, "" , new int[] {20, 350, 266, 14}, false);
		setLabel(lblMostrarTel, "" , new int[] {20, 375, 266, 14}, false);
		setLabel(lblMostrarFecha, "" , new int[] {20, 400, 266, 14}, false);
		
		// Configuro Botón Mostrar
		btnMostrar = new JButton();
		btnMostrar.setText("Mostrar");
		btnMostrar.setBounds(264, 236, 89, 30);

		// agreo un btn volver
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(10, 450, 100, 30); // Ajusta la posición y tamaño
		getContentPane().add(btnVolver);

		// Agrego el boton al Panel
		getContentPane().add(btnMostrar);

		// Datos Ingresados label
		lblDatosIng = new JLabel(DatosIng);
		lblDatosIng.setBounds(10, 261, 183, 41);
		lblDatosIng.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 11));
		getContentPane().add(lblDatosIng);

		// Labels para errores.
		lblNombreError = modeloLabel.crearLabelError(txtNombre, new int[] {109, 45, 250, 14});
		getContentPane().add(lblNombreError);
		lblApellidoError = modeloLabel.crearLabelError(txtApellido, new int[] {109, 97, 250, 14});
		getContentPane().add(lblApellidoError);
		lblTelefonoError = modeloLabel.crearLabelError(txtTelefono, new int[] {109, 152, 250, 14});
		getContentPane().add(lblTelefonoError);
		lblFNacError = modeloLabel.crearLabelError(txtFechaNac, new int[] {109, 205, 250, 14});
		getContentPane().add(lblFNacError);
		

		btnMostrar.addActionListener(new eBtnMostrar(this));

		// Evento del btn volver
		btnVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// cierro la ventana actual de contactos
				dispose();

				// muestro la ventana principal
				VentanaPpal ventanaPrincipal = new VentanaPpal();
				ventanaPrincipal.cambiarVisibilidad(true);
			}
		});
	}

	public void cambiarVisibilidad(boolean estado) {
		setVisible(estado);
	}
		
	public boolean hayErrorEnCampos() {
		Validar validar = new Validar();
		TipoErrores tipoError = new TipoErrores();
		boolean existeError = false;

		if (validar.campoVacio(txtNombre)) {
			setError(lblNombreError, tipoError.getMSJ_CAMPO_VACIO());
			existeError = true;
		} else if (validar.contieneNumeros(txtNombre)) {
			setError(lblNombreError, tipoError.getMSJ_CONTIENE_NRO());
			existeError = true;
		}

		if (validar.campoVacio(txtApellido)) {
			setError(lblApellidoError, tipoError.getMSJ_CAMPO_VACIO());
		} else if (validar.contieneNumeros(txtApellido)) {
			setError(lblApellidoError, tipoError.getMSJ_CONTIENE_NRO());
		}

		if (validar.campoVacio(txtTelefono)) {
			setError(lblTelefonoError, tipoError.getMSJ_CAMPO_VACIO());
			existeError = true;
		} else if (validar.contieneLetras(txtTelefono)) {
			setError(lblTelefonoError, tipoError.getMSJ_CONTIENE_LETRAS());
			existeError = true;
		} else if (validar.telefonoInvalido(txtTelefono)) {
			setError(lblTelefonoError, tipoError.getMSJ_TEL_LONGITUD_INCORRECTA());
			existeError = true;
		}

		if (validar.campoVacio(txtFechaNac)) {
			setError(lblFNacError, tipoError.getMSJ_CAMPO_VACIO());
			existeError = true;
		}
		if (validar.fechaInvalida(txtFechaNac, "dd/MM/yyyy")) {
			setError(lblFNacError, tipoError.getMSJ_FORMATO_DATE());
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
	}
	
	public void ocultarErrores() {
		ocultarLabel(lblNombreError);
		ocultarLabel(lblApellidoError);
		ocultarLabel(lblTelefonoError);
		ocultarLabel(lblFNacError);
	}
	
	private void setError(JLabel label, String msjError) {
		label.setText(msjError);
		label.setVisible(true);
	}
	
	private void ocultarLabel(JLabel label) {
		label.setVisible(false);
		label.setText("");
	}
	
	private void setearTxt(JTextField txt, int[] bounds) {
		addEventoKeyTyped(txt);
		txt.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
		txt.setBackground(Color.white);
		txt.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
		getContentPane().add(txt);
	}
	
	private void addEventoKeyTyped(JTextField txt)
	{
		txt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				txt.setBackground(Color.WHITE);
			}
		});
	}
	
	private void setLabel(JLabel label, String valor, int bounds[], boolean visible) {
		label.setText(valor);
		label.setBackground(this.getBackground());
		label.setForeground(Color.BLACK);
		label.setBounds(bounds[0], bounds[1], bounds[2], bounds[3] );
		label.setVisible(visible);
		getContentPane().add(label);
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

		if (!(ventana.hayErrorEnCampos()))
			ventana.mostrarDatosContacto();
	}
}