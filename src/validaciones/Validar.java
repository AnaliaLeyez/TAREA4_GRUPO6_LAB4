package validaciones;

import javax.swing.JTextField;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Validar {
	public boolean campoVacio(JTextField txt) {
		return txt.getText().trim().isEmpty();
	}

	public boolean contieneLetras(JTextField txt) {
		String auxTxt = txt.getText();

		for (int i = 0; i < auxTxt.length(); i++) {
			if (!Character.isDigit(auxTxt.charAt(i)))
				return true;
		}
		return false;
	}

	public boolean fechaInvalida(JTextField txt, String formato) {
		String auxTxt = txt.getText().trim();

		if (!auxTxt.matches("\\d{8}")) {
			return true;
		}

		DateTimeFormatter TipoFecha = DateTimeFormatter.ofPattern(formato);

		try {
			LocalDate fechaTxt = LocalDate.parse(
					auxTxt.substring(0, 2) + "/" + auxTxt.substring(2, 4) + "/" + auxTxt.substring(4), TipoFecha);
			int anioActual = LocalDate.now().getYear();
			return fechaTxt.getYear() > anioActual;
		} catch (DateTimeParseException e) {
			return true;
		}
	}

	public boolean contieneNumeros(JTextField txt) {
		String texto = txt.getText();
		for (int i = 0; i < texto.length(); i++) {
			if (Character.isDigit(texto.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	public boolean telefonoInvalido(JTextField txt) {
		String numero = txt.getText().trim();
		return !numero.matches("\\d{9,10}");
	}
}
