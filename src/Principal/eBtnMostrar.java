package Principal;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

import Principal.DatosFormularioEj1.DatosValidados;

class eBtnMostrar implements ActionListener {

	private JTextField nombre, apellido, telefono, fechaNac;
	private JLabel lblNombreError, lblApellidoError, lblTelefonoError, lblFNacError;
	private JLabel lblMostrarNombre, lblMostrarApellido, lblMostrarTel, lblMostrarFecha;
	private DatosFormularioEj1 datosFormularioEj1;

	public eBtnMostrar(JTextField nombre, JTextField apellido, JTextField telefono, JTextField fechaNac,
			JLabel lblNombreError, JLabel lblApellidoError, JLabel lblTelefonoError, JLabel lblFNacError,
			JLabel lblMostrarNombre, JLabel lblMostrarApellido, JLabel lblMostrarTel, JLabel lblMostrarFecha) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.fechaNac = fechaNac;

		this.lblNombreError = lblNombreError;
		this.lblApellidoError = lblApellidoError;
		this.lblTelefonoError = lblTelefonoError;
		this.lblFNacError = lblFNacError;

		this.lblMostrarNombre = lblMostrarNombre;
		this.lblMostrarApellido = lblMostrarApellido;
		this.lblMostrarTel = lblMostrarTel;
		this.lblMostrarFecha = lblMostrarFecha;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// A definir
		DatosValidados datosValidados = DatosFormularioEj1.validarCampos(nombre, apellido, telefono, fechaNac);

		ocultarErrores();

		if (datosValidados.isDatosCorrectos()) {
			datosFormularioEj1 = new DatosFormularioEj1(nombre, apellido, telefono, fechaNac);

			lblMostrarNombre.setText("Nombre:   " + datosFormularioEj1.getNombre());
			lblMostrarApellido.setText("Apellido: " + datosFormularioEj1.getApellido());
			lblMostrarTel.setText("Teléfono: " + datosFormularioEj1.getTelefono());
			lblMostrarFecha.setText("Fecha nac.: " + datosFormularioEj1.getFechaNac());

			lblMostrarNombre.setVisible(true);
			lblMostrarApellido.setVisible(true);
			lblMostrarTel.setVisible(true);
			lblMostrarFecha.setVisible(true);
		} else {
			for (String error : datosValidados.getErrores()) {
				if (error.toLowerCase().contains("nombre")) 
					mostrarError(nombre, lblNombreError, error);

				if (error.toLowerCase().contains("apellido")) 
					mostrarError(apellido, lblApellidoError, error);

				if (error.toLowerCase().contains("teléfono") || error.toLowerCase().contains("número")) 
					mostrarError(telefono, lblTelefonoError, error);

				if (error.toLowerCase().contains("fecha"))
					mostrarError(fechaNac, lblFNacError, error);
				
				if (error.toLowerCase().contains("dd/MM/yyyy"))
					mostrarError(fechaNac, lblFNacError, error);
			}
		}
		
	}
		
		
	private void ocultarErrores() {
			
			lblNombreError.setVisible(false);
			lblNombreError.setText("");

			lblApellidoError.setVisible(false);
			lblApellidoError.setText("");

			lblTelefonoError.setVisible(false);
			lblTelefonoError.setText("");

			lblFNacError.setVisible(false);
			lblFNacError.setText("");
		}
			
	private void mostrarError(JTextField campo, JLabel label, String error)
	{
			campo.setBackground(Color.red);
			label.setText(error);
			label.setVisible(true);
	}
}
