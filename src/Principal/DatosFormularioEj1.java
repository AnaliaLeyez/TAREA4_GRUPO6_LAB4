package Principal;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import javax.swing.JTextField;

public class DatosFormularioEj1 {

	private String nombre;
	private String apellido;
	private String telefono;
	private String fechaNac;

	public DatosFormularioEj1(JTextField nombre, JTextField apellido, JTextField telefono, JTextField fechaNac) {
		this.nombre = nombre.getText();
		this.apellido = apellido.getText();
		this.telefono = telefono.getText();
		this.fechaNac = fechaNac.getText();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}

	public static DatosValidados validarCampos(JTextField nombre, JTextField apellido, JTextField telefono,
			JTextField fechaNac) {
		ArrayList<String> errores = new ArrayList<>();

		String tel = telefono.getText().trim();
		String fecha = fechaNac.getText().trim();

		if (nombre.getText().trim().isEmpty())
			errores.add("El nombre no puede estar vacío");

		if (apellido.getText().trim().isEmpty())
			errores.add("El apellido no puede estar vacío");

		
		if (tel.isEmpty()) {
			errores.add("El teléfono no puede estar vacio");
		}

	    if (fecha.isEmpty()) {
	        errores.add("La fecha no puede estar vacía");
	    } 
	    //deberia ir una validación de formato de fecha

		return new DatosValidados(errores.isEmpty(), errores);
	}

	public static class DatosValidados {
		private boolean datosCorrectos;
		private ArrayList<String> errores;

		public DatosValidados(boolean tieneErrores, ArrayList<String> errores) {
			this.datosCorrectos = tieneErrores;
			this.errores = errores;
		}

		public boolean isDatosCorrectos() {
			return datosCorrectos;
		}

		public ArrayList<String> getErrores() {
			return errores;
		}
	}

}
