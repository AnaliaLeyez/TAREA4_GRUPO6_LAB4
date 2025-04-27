package Principal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

import validaciones.TipoErrores;
import validaciones.Validar;

public class VentanaPromedio extends Ventana {
	private static final long serialVersionUID = 1L;

	// Defino los TextField
	private JTextField txtNota1 = new JTextField();
	private JTextField txtNota2 = new JTextField();

	public JTextField getTxtNota1() {
		return txtNota1;
	}

	public JTextField getTxtNota2() {
		return txtNota2;
	}

	public JTextField getTxtNota3() {
		return txtNota3;
	}

	private JTextField txtNota3 = new JTextField();
	private JTextField txtPromedio = new JTextField();
	private JTextField txtCondicion = new JTextField();

	// ComboBox
	private JComboBox<String> cBoxTps = new JComboBox<String>();

	public JComboBox<String> getCBoxTps() {
		return cBoxTps;
	}

	// Defino los Label
	private JLabel lblNota1 = new JLabel();
	private JLabel lblNota2 = new JLabel();
	private JLabel lblNota3 = new JLabel();
	private JLabel lblTps = new JLabel();

	private JLabel lblNota1Error = new JLabel();
	private JLabel lblNota2Error = new JLabel();
	private JLabel lblNota3Error = new JLabel();

	public JLabel getLblNota1Error() {
		return lblNota1Error;
	}

	public JLabel getLblNota2Error() {
		return lblNota2Error;
	}

	public JLabel getLblNota3Error() {
		return lblNota3Error;
	}

	private JLabel lblPromedio = new JLabel();
	private JLabel lblCondicion = new JLabel();

	// Defino los textos constantes
	private final String Nota1 = "Nota 1:";
	private final String Nota2 = "Nota 2:";
	private final String Nota3 = "Nota 3:";
	private final String Tps = "TPS:";

	// Botones
	private JButton btnCalcular = new JButton();
	private JButton btnNuevo = new JButton();
	private JButton btnSalir = new JButton();

	private JPanel JPPromedioDelEstudiante = new JPanel();
	private JPanel JPNotasDelEstudiante = new JPanel();

	public VentanaPromedio(VentanaPpal padre) {
		super(padre, new int[] { 500, 100, 502, 537 }, "Promedio");

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

		setJPanel(JPPromedioDelEstudiante, "Promedio Del Estudiante", new int[] { 20, 293, 319, 147 });

		setLblText(lblPromedio, new Font("Lucida Sans Unicode", Font.BOLD, 12), this.getBackground(),
				new int[] { 10, 48, 88, 14 }, "Promedio:");
		JPPromedioDelEstudiante.add(lblPromedio);

		setLblText(lblCondicion, new Font("Lucida Sans Unicode", Font.BOLD, 12), this.getBackground(),
				new int[] { 10, 89, 88, 14 }, "Condición:");
		JPPromedioDelEstudiante.add(lblCondicion);

		// Textos promedio y condicion que se muestran como resultado:
		setearTxtNoEditable(txtPromedio, new int[] { 108, 45, 96, 20 }, 10, JPPromedioDelEstudiante);
		setearTxtNoEditable(txtCondicion, new int[] { 108, 86, 96, 20 }, 10, JPPromedioDelEstudiante);

		setJPanel(JPNotasDelEstudiante, "Notas Del Estudiante", new int[] { 20, 34, 319, 248 });

		// Nota1 Label y TextField
		setLblText(lblNota1, new Font("Lucida Sans Unicode", Font.BOLD, 12), this.getBackground(),
				new int[] { 10, 28, 89, 41 }, Nota1);
		JPNotasDelEstudiante.add(lblNota1);

		setearTxt(txtNota1, new int[] { 109, 33, 160, 30 });
		JPNotasDelEstudiante.add(txtNota1);
		addEventoKeyTyped(txtNota1);

		// Nota2 label y TextField
		setLblText(lblNota2, new Font("Lucida Sans Unicode", Font.BOLD, 12), this.getBackground(),
				new int[] { 10, 86, 89, 41 }, Nota2);
		JPNotasDelEstudiante.add(lblNota2);

		setearTxt(txtNota2, new int[] { 109, 91, 160, 30 });
		JPNotasDelEstudiante.add(txtNota2);
		addEventoKeyTyped(txtNota2);

		// Nota3 label y TextField
		setLblText(lblNota3, new Font("Lucida Sans Unicode", Font.BOLD, 12), this.getBackground(),
				new int[] { 10, 140, 89, 41 }, Nota3);
		JPNotasDelEstudiante.add(lblNota3);

		setearTxt(txtNota3, new int[] { 109, 145, 160, 30 });
		JPNotasDelEstudiante.add(txtNota3);
		addEventoKeyTyped(txtNota3);

		// Labels para errores.
		setLblText(lblNota1Error, new Font("Lucida Sans Unicode", Font.BOLD, 12), this.getBackground(),
				new int[] { 109, 68, 160, 14 }, "");
		JPNotasDelEstudiante.add(lblNota1Error);
		finalSetLblError(lblNota1Error, txtNota1);

		setLblText(lblNota2Error, new Font("Lucida Sans Unicode", Font.BOLD, 12), this.getBackground(),
				new int[] { 109, 120, 160, 14 }, "");
		JPNotasDelEstudiante.add(lblNota2Error);
		finalSetLblError(lblNota2Error, txtNota1);

		setLblText(lblNota3Error, new Font("Lucida Sans Unicode", Font.BOLD, 12), this.getBackground(),
				new int[] { 109, 172, 160, 14 }, "");
		JPNotasDelEstudiante.add(lblNota3Error);
		finalSetLblError(lblNota3Error, txtNota1);

		// Tps label
		setLblText(lblTps, new Font("Lucida Sans Unicode", Font.BOLD, 12), this.getBackground(),
				new int[] { 10, 192, 89, 41 }, Tps);
		JPNotasDelEstudiante.add(lblTps);

		// CBox
		cBoxTps.setBounds(109, 202, 108, 20);
		JPNotasDelEstudiante.add(cBoxTps);
		// Opciones del Cbox:
		cBoxTps.addItem("Aprobado");
		cBoxTps.addItem("Desaprobado");

		// Botones
		setButton(btnCalcular, "CALCULAR", new int[] { 349, 69, 129, 43 }, !getIsVentanaHijaActiva());
		btnCalcular.addActionListener(new eBtnCalcular(this));

		setButton(btnSalir, "SALIR", new int[] { 349, 165, 129, 43 }, !getIsVentanaHijaActiva());
		btnSalir.addActionListener(e -> System.exit(0));

		setButton(btnNuevo, "NUEVO", new int[] { 349, 117, 129, 43 }, !getIsVentanaHijaActiva());
		btnNuevo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
			}
		});
	}

	private void limpiarCampos() {
		ocultarErrores();

		this.txtNota1.setText("");
		this.txtNota2.setText("");
		this.txtNota3.setText("");
		this.txtCondicion.setText("");
		this.txtPromedio.setText("");
	}

	public void ocultarErrores() {
		lblNota1Error.setVisible(false);
		lblNota2Error.setVisible(false);
		lblNota3Error.setVisible(false);

		txtNota1.setBackground(Color.WHITE);
		txtNota2.setBackground(Color.WHITE);
		txtNota3.setBackground(Color.WHITE);
	}

	public void mostrarDatos(float prom, String cond) {
		txtPromedio.setText(String.valueOf(prom));
		txtCondicion.setText(cond);

		txtPromedio.setVisible(true);
		txtCondicion.setVisible(true);
	}

}

class eBtnCalcular implements ActionListener {
	private VentanaPromedio ventana;
	private float promedio;
	private String tp, condicion;
	Validar validar = new Validar();

	public eBtnCalcular(VentanaPromedio ventana) {
		this.ventana = ventana;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ventana.ocultarErrores();

		try {
			float nota1 = 0, nota2 = 0, nota3 = 0;

			nota1 = validarNota(ventana.getTxtNota1(), ventana.getLblNota1Error());
			nota2 = validarNota(ventana.getTxtNota2(), ventana.getLblNota2Error());
			nota3 = validarNota(ventana.getTxtNota3(), ventana.getLblNota3Error());

			if (nota1 != 0 && nota2 != 0 && nota3 != 0) {

				promedio = (nota1 + nota2 + nota3) / 3;

				tp = (String) ventana.getCBoxTps().getSelectedItem();

				if (tp.equals("Desaprobado") || nota1 < 6 || nota2 < 6 || nota3 < 6) {
					condicion = "Libre";
				} else if (nota1 >= 8 && nota2 >= 8 && nota3 >= 8) {
					condicion = "Promocionado";
				} else {
					condicion = "Regular";
				}

				ventana.mostrarDatos(promedio, condicion);
			}

		} catch (Exception ex) {
		}

	}

	private float validarNota(JTextField campo, JLabel errorLabel) throws FueraDeRangoException, NumberFormatException {

		String texto = campo.getText().trim();

		if (texto.isEmpty()) {
			campo.setBackground(Color.RED);
			errorLabel.setVisible(false);
			return 0;
		}

		float valor = 0;
		try {
			valor = Float.parseFloat(texto);

			if (valor < 1 || valor > 10) {
				mostrarError(campo, errorLabel, "Debe estar entre 1 y 10");
				valor = 0;
			}

		} catch (NumberFormatException e) {
			mostrarError(campo, errorLabel, "Ingrese un número válido");
		}
		return valor;
	}

	private void mostrarError(JTextField campo, JLabel label, String error) {
		campo.setBackground(Color.PINK);
		label.setText(error);
		label.setVisible(true);
	}
}
