package Principal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class VentanaPromedio extends JFrame {
	private static final long serialVersionUID = 1L;

	// Defino los TextField
	private JTextField txtNota1, txtNota2,txtNota3;
	private JComboBox<String> cBoxTps;

	// Defino los Label
	private JLabel lblNota1,lblNota2,lblNota3, lblTps;

	// Defino los textos constantes
	private final String Nota1 = "Nota 1:";
	private final String Nota2 = "Nota 2:";
	private final String Nota3 = "Nota 3:";
	private final String Tps = "TPS:";
	
	// BOTON mostrar
	private JButton btnCalcular;

	public VentanaPromedio() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 100, 502, 537);
		setTitle("Promedio");
		
		getContentPane().setLayout(null);
		
		JLabel lblCPanel = new JLabel("Notas del estudiante");
		lblCPanel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCPanel.setForeground(Color.BLACK);
		lblCPanel.setBackground(Color.LIGHT_GRAY);
		lblCPanel.setBounds(10, 22, 136, 20);
		getContentPane().add(lblCPanel);

		// Nota1 Label y TextField
		lblNota1 = new JLabel(Nota1);
		lblNota1.setBounds(10, 70, 89, 41);
		lblNota1.setBackground(this.getBackground());
		lblNota1.setForeground(Color.BLACK);
		getContentPane().add(lblNota1);

		txtNota1 = new JTextField();
		txtNota1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				txtNota1.setBackground(Color.WHITE);
			}
		});
		txtNota1.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
		txtNota1.setBackground(Color.white);
		txtNota1.setBounds(109, 70, 160, 30);
		getContentPane().add(txtNota1);

		// Nota2 label y TextField
		lblNota2 = new JLabel(Nota2);
		lblNota2.setBounds(10, 118, 89, 41);
		lblNota2.setBackground(this.getBackground());
		lblNota2.setForeground(Color.BLACK);
		getContentPane().add(lblNota2);

		txtNota2 = new JTextField();
		txtNota2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				txtNota2.setBackground(Color.WHITE);
			}
		});
		txtNota2.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
		txtNota2.setBackground(Color.white);
		txtNota2.setBounds(109, 118, 160, 30);
		getContentPane().add(txtNota2);

		// nota3 label y TextField
		lblNota3 = new JLabel(Nota3);
		lblNota3.setBounds(10, 170, 89, 41);
		lblNota3.setBackground(this.getBackground());
		lblNota3.setForeground(Color.BLACK);
		getContentPane().add(lblNota3);

		txtNota3 = new JTextField();
		txtNota3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				txtNota3.setBackground(Color.WHITE);
			}
		});
		txtNota3.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
		txtNota3.setBackground(Color.white);
		txtNota3.setBounds(109, 175, 160, 30);
		getContentPane().add(txtNota3);

		// Tps label y TextField
		lblTps = new JLabel(Tps);
		lblTps.setBounds(10, 231, 89, 41);
		lblTps.setBackground(this.getBackground());
		lblTps.setForeground(Color.BLACK);
		getContentPane().add(lblTps);

		cBoxTps = new JComboBox<String>();
		cBoxTps.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				cBoxTps.setBackground(Color.WHITE);
			}
		});
		cBoxTps.setBounds(109, 241, 108, 20);
		//Opciones del Cbox:
		cBoxTps.addItem("Aprobado");
		cBoxTps.addItem("Desaprobado");
		getContentPane().add(cBoxTps);
		
		// Configuro Botón Calcular
		btnCalcular = new JButton();
		btnCalcular.setText("CALCULAR");
		btnCalcular.setBounds(306, 83, 129, 43);
		
		// Agrego el boton al Panel
		getContentPane().add(btnCalcular);

		
		// Labels para errores.
				JLabel lblNota1Error = new JLabel("Error");
				lblNota1Error.setForeground(new Color(255, 0, 0));
				lblNota1Error.setLabelFor(txtNota1);
				lblNota1Error.setBounds(109, 97, 160, 14);
				lblNota1Error.setVisible(false);
				getContentPane().add(lblNota1Error);

				JLabel lblNota2Error = new JLabel("Error");
				lblNota2Error.setLabelFor(lblNota2);
				lblNota2Error.setEnabled(true);
				lblNota2Error.setForeground(Color.RED);
				lblNota2Error.setBounds(109, 147, 160, 14);
				lblNota2Error.setVisible(false);
				getContentPane().add(lblNota2Error);

				JLabel lblNota3Error = new JLabel("Error");
				lblNota3Error.setLabelFor(lblNota3);
				lblNota3Error.setEnabled(true);
				lblNota3Error.setForeground(Color.RED);
				lblNota3Error.setBounds(109, 203, 160, 14);
				lblNota3Error.setVisible(false);
				getContentPane().add(lblNota3Error);

				JLabel lblTpsError = new JLabel("Error");
				lblTpsError.setLabelFor(lblTps);
				lblTpsError.setEnabled(true);
				lblTpsError.setForeground(Color.RED);
				lblTpsError.setBounds(109, 258, 250, 14);
				lblTpsError.setVisible(false);
				getContentPane().add(lblTpsError);

		
				JLabel lblMostrarNota1 = new JLabel();
				JLabel lblMostrarNota2 = new JLabel();
				JLabel lblMostrarNota3 = new JLabel();
				JLabel lblMostrarTps = new JLabel();
		
		// Evento del botón Calcular
		 btnCalcular.addActionListener(new eBtnCalcular(txtNota1, txtNota2, txtNota3,
		  cBoxTps, lblNota1Error, lblNota2Error, lblNota3Error, lblTpsError,
		  lblMostrarNota1, lblMostrarNota2, lblMostrarNota3, lblMostrarTps));

		
	}

	public void cambiarVisibilidad(boolean estado) {
		setVisible(estado);
	}
}

class eBtnCalcular implements ActionListener {

	/*
	 * private JTextField Nota1, Nota2, Nota3; private JComboBox<String> cBoxTps;
	 * private JLabel lblNota1Error, lblNota2Error, lblNota3Error, lblTpsError;
	 * private JLabel lblMostrarNota1, lblMostrarNota2, lblMostrarNota3,
	 * lblMostrarTps; private DatosFormularioEj1 datosFormularioEj1;
	 */

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//completar
	}

	public eBtnCalcular(JTextField txtNota1, JTextField txtNota2, JTextField txtNota3, JComboBox<String> cBoxTps,
			JLabel lblNota1Error, JLabel lblNota2Error, JLabel lblNota3Error, JLabel lblTpsError,
			JLabel lblMostrarNota1, JLabel lblMostrarNota2, JLabel lblMostrarNota3, JLabel lblMostrarTps) {
		/*
		 * this.Nota1 = txtNota1;
		 * 
		 * this.lblNota1Error = lblNota1Error;
		 * 
		 * this.lblMostrarNota1 = lblMostrarNota1;
		 */
	}

	/*
	 * private void ocultarErrores() {
	 * 
	 * lblNota1Error.setVisible(false); lblNota1Error.setText("");
	 * 
	 * }
	 */

	/*
	 * private void mostrarError(JTextField campo, JLabel label, String error) {
	 * campo.setBackground(Color.red); label.setText(error); label.setVisible(true);
	 * }
	 */
}
