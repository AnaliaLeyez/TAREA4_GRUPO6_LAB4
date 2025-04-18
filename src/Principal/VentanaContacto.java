package Principal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaContacto extends JFrame {
private static final long serialVersionUID = 1L;
	
	//Defino los TextField
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JTextField txtFechaNac;
	
	//Defino los Label
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblTelefono;
	private JLabel lblFechaNac;
	private JLabel lblDatosIng;
	
	//Defino los textos constantes
	private final String Nombre="Nombre:";
	private final String Apellido="Apellido:";
	private final String Telefono="Teléfono:";
	private final String FechaNac="Fecha Nac.:";
	private final String DatosIng="Los datos ingresados fueron:";
	
	//BOTON mostrar
	private JButton btnMostrar;
	
	public VentanaContacto()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500,100,417,313);
		setTitle("Contactos");
		getContentPane().setLayout(null);
		
		//Nombre Label y TextField
		lblNombre = new JLabel(Nombre);
		lblNombre.setBounds(10, 11, 89, 41);
		lblNombre.setBackground(this.getBackground());
		lblNombre.setForeground(Color.BLACK);
		getContentPane().add(lblNombre);
		
		txtNombre= new JTextField();
		txtNombre.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
		txtNombre.setBackground(Color.white);
		txtNombre.setBounds(109, 16, 248, 30);
		getContentPane().add(txtNombre);
		
		
		//APELLIDO label y TextField
		lblApellido = new JLabel(Apellido);
		lblApellido.setBounds(10, 53, 89, 41);
		lblApellido.setBackground(this.getBackground());
		lblApellido.setForeground(Color.BLACK);
		getContentPane().add(lblApellido);
				
		txtApellido= new JTextField();
		txtApellido.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
		txtApellido.setBackground(Color.white);
		txtApellido.setBounds(109, 58, 248, 30);
		getContentPane().add(txtApellido);
		
		//TELÉFONO label y TextField
		lblTelefono = new JLabel(Telefono);
		lblTelefono.setBounds(10, 94, 89, 41);
		lblTelefono.setBackground(this.getBackground());
		lblTelefono.setForeground(Color.BLACK);
		getContentPane().add(lblTelefono);
						
		txtTelefono= new JTextField();
		txtTelefono.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
		txtTelefono.setBackground(Color.white);
		txtTelefono.setBounds(109, 143, 248, 30);
		getContentPane().add(txtTelefono);
		
		//FECHA NAC label y TextField
		lblFechaNac = new JLabel(FechaNac);
		lblFechaNac.setBounds(10, 138, 89, 41);
		lblFechaNac.setBackground(this.getBackground());
		lblFechaNac.setForeground(Color.BLACK);
		getContentPane().add(lblFechaNac);
						
		txtFechaNac= new JTextField();
		txtFechaNac.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
		txtFechaNac.setBackground(Color.white);
		txtFechaNac.setBounds(109, 99, 248, 30);
		getContentPane().add(txtFechaNac);
		
		//Configuro Botón Mostrar
		btnMostrar = new JButton();
		btnMostrar.setText("Mostrar");
		btnMostrar.setBounds(268,184, 89,30);
		
		//Agrego el boton al Panel
		getContentPane().add(btnMostrar);
				
		//Evento del botón
		btnMostrar.addActionListener(new eBtnMostrar());
		
		//Datos Ingresados label
		lblDatosIng = new JLabel(DatosIng);
		lblDatosIng.setBounds(10, 226, 183, 41);
		lblDatosIng.setBackground(this.getBackground());
		lblDatosIng.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 11));
		lblDatosIng.setForeground(Color.BLACK);
		getContentPane().add(lblDatosIng);
	}
	
	
	public void cambiarVisibilidad(boolean estado)
	{
		setVisible(estado);
	}
}

class eBtnMostrar implements ActionListener
{
	@Override
	public void actionPerformed(ActionEvent arg0) {
		//A definir
	}
}