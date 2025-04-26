package Principal;

import java.util.ArrayList;
import javax.swing.JTextField;
import validaciones.TipoErrores;
import validaciones.Validar;

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
		return fechaNac.substring(0, 2) + "-" + fechaNac.substring(2, 4) + "-" + fechaNac.substring(4);

	}

	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}

	public static DatosValidados validarCampos(JTextField nombre, JTextField apellido, JTextField telefono,
			JTextField fechaNac) {
		ArrayList<String> errores = new ArrayList<>();

		Validar validar = new Validar();

		if (validar.campoVacio(nombre)) {
			errores.add(TipoErrores.getMSJ_CAMPO_VACIO());
		} else if (validar.contieneNumeros(nombre)) {
			errores.add(TipoErrores.getMSJ_CONTIENE_NRO());
		}

		if (validar.campoVacio(apellido)) {
			errores.add(TipoErrores.getMSJ_CAMPO_VACIO());
		} else if (validar.contieneNumeros(apellido)) {
			errores.add(TipoErrores.getMSJ_CONTIENE_NRO());
		}

		if (validar.campoVacio(telefono)) {
			errores.add(TipoErrores.getMSJ_CAMPO_VACIO());
		} else if (validar.contieneLetras(telefono)) {
			errores.add(TipoErrores.getMSJ_CONTIENE_LETRAS());
		} else if (validar.telefonoInvalido(telefono)) {
			errores.add(TipoErrores.getMSJ_TEL_LONGITUD_INCORRECTA());
		}

		if (validar.campoVacio(fechaNac)) {
			errores.add(TipoErrores.getMSJ_CAMPO_VACIO());
		}
		if (validar.fechaInvalida(fechaNac)) {
			errores.add(TipoErrores.getMSJ_FORMATO_DATE());
		}

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
