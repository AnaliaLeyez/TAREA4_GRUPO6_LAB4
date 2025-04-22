package Principal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VentanaContacto extends JFrame {
	private static final long serialVersionUID = 1L;

	// Defino los TextField
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JTextField txtFechaNac;

	// Defino los Label
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblTelefono;
	private JLabel lblFechaNac;
	private JLabel lblDatosIng;

	// Defino los textos constantes
	private final String Nombre = "Nombre:";
	private final String Apellido = "Apellido:";
	private final String Telefono = "Teléfono:";
	private final String FechaNac = "Fecha Nac.:";
	private final String DatosIng = "Los datos ingresados fueron:";

	// BOTON mostrar
	private JButton btnMostrar;
	private JLabel lblMostrarNombre;
	private JLabel lblMostrarApellido;
	private JLabel lblMostrarTel;
	private JLabel lblMostrarFecha;

	public VentanaContacto() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 100, 406, 537);
		setTitle("Contactos");
		getContentPane().setLayout(null);

		// Nombre Label y TextField
		lblNombre = new JLabel(Nombre);
		lblNombre.setBounds(10, 11, 89, 41);
		lblNombre.setBackground(this.getBackground());
		lblNombre.setForeground(Color.BLACK);
		getContentPane().add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				txtNombre.setBackground(Color.WHITE);
			}
		});
		txtNombre.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
		txtNombre.setBackground(Color.white);
		txtNombre.setBounds(109, 16, 248, 30);
		getContentPane().add(txtNombre);

		// APELLIDO label y TextField
		lblApellido = new JLabel(Apellido);
		lblApellido.setBounds(10, 65, 89, 41);
		lblApellido.setBackground(this.getBackground());
		lblApellido.setForeground(Color.BLACK);
		getContentPane().add(lblApellido);

		txtApellido = new JTextField();
		txtApellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				txtApellido.setBackground(Color.WHITE);
			}
		});
		txtApellido.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
		txtApellido.setBackground(Color.white);
		txtApellido.setBounds(109, 70, 248, 30);
		getContentPane().add(txtApellido);

		// TELÉFONO label y TextField
		lblTelefono = new JLabel(Telefono);
		lblTelefono.setBounds(10, 117, 89, 41);
		lblTelefono.setBackground(this.getBackground());
		lblTelefono.setForeground(Color.BLACK);
		getContentPane().add(lblTelefono);

		txtTelefono = new JTextField();
		txtTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				txtTelefono.setBackground(Color.WHITE);
			}
		});
		txtTelefono.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
		txtTelefono.setBackground(Color.white);
		txtTelefono.setBounds(109, 122, 248, 30);
		getContentPane().add(txtTelefono);

		// FECHA NAC label y TextField
		lblFechaNac = new JLabel(FechaNac);
		lblFechaNac.setBounds(10, 164, 89, 41);
		lblFechaNac.setBackground(this.getBackground());
		lblFechaNac.setForeground(Color.BLACK);
		getContentPane().add(lblFechaNac);

		txtFechaNac = new JTextField();
		txtFechaNac.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				txtFechaNac.setBackground(Color.WHITE);
			}
		});
		txtFechaNac.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
		txtFechaNac.setBackground(Color.white);
		txtFechaNac.setBounds(109, 175, 248, 30);
		getContentPane().add(txtFechaNac);

		// Configuro Botón Mostrar
		btnMostrar = new JButton();
		btnMostrar.setText("Mostrar");
		btnMostrar.setBounds(264, 236, 89, 30);
		
		//agreo un btn volver
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(10, 450, 100, 30);  // Ajusta la posición y tamaño
		getContentPane().add(btnVolver);

		// Agrego el boton al Panel
		getContentPane().add(btnMostrar);

		// Datos Ingresados label
		lblDatosIng = new JLabel(DatosIng);
		lblDatosIng.setBounds(10, 261, 183, 41);
		lblDatosIng.setBackground(this.getBackground());
		lblDatosIng.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 11));
		lblDatosIng.setForeground(Color.BLACK);
		getContentPane().add(lblDatosIng);

		// Labels para errores.
		JLabel lblNombreError = new JLabel("Error");
		lblNombreError.setForeground(new Color(255, 0, 0));
		lblNombreError.setLabelFor(txtNombre);
		lblNombreError.setBounds(109, 45, 250, 14);
		lblNombreError.setVisible(false);
		getContentPane().add(lblNombreError);

		JLabel lblApellidoError = new JLabel("Error");
		lblApellidoError.setLabelFor(lblApellido);
		lblApellidoError.setEnabled(true);
		lblApellidoError.setForeground(Color.RED);
		lblApellidoError.setBounds(109, 97, 250, 14);
		lblApellidoError.setVisible(false);
		getContentPane().add(lblApellidoError);

		JLabel lblTelefonoError = new JLabel("Error");
		lblTelefonoError.setLabelFor(lblTelefono);
		lblTelefonoError.setEnabled(true);
		lblTelefonoError.setForeground(Color.RED);
		lblTelefonoError.setBounds(109, 152, 250, 14);
		lblTelefonoError.setVisible(false);
		getContentPane().add(lblTelefonoError);

		JLabel lblFNacError = new JLabel("Error");
		lblFNacError.setLabelFor(lblFechaNac);
		lblFNacError.setEnabled(true);
		lblFNacError.setForeground(Color.RED);
		lblFNacError.setBounds(109, 205, 250, 14);
		lblFNacError.setVisible(false);
		getContentPane().add(lblFNacError);

		lblMostrarNombre = new JLabel("New label");
		lblMostrarNombre.setBounds(20, 325, 266, 14);
		lblMostrarNombre.setVisible(false);
		getContentPane().add(lblMostrarNombre);

		lblMostrarApellido = new JLabel("New label");
		lblMostrarApellido.setBounds(20, 350, 266, 14);
		lblMostrarApellido.setVisible(false);
		getContentPane().add(lblMostrarApellido);

		lblMostrarTel = new JLabel("New label");
		lblMostrarTel.setBounds(20, 375, 266, 14);
		lblMostrarTel.setVisible(false);
		getContentPane().add(lblMostrarTel);

		lblMostrarFecha = new JLabel("New label");
		lblMostrarFecha.setBounds(20, 400, 266, 14);
		lblMostrarFecha.setVisible(false);
		getContentPane().add(lblMostrarFecha);

		// Evento del botón mostrar
		btnMostrar.addActionListener(new eBtnMostrar(txtNombre, txtApellido, txtTelefono, txtFechaNac, lblNombreError,
				lblApellidoError, lblTelefonoError, lblFNacError, lblMostrarNombre, lblMostrarApellido, lblMostrarTel,
				lblMostrarFecha));

		//Evento del btn volver 
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
}


