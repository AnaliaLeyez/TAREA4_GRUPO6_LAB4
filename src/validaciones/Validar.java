package validaciones;

import javax.swing.JTextField;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Validar {
	private static String errorMsg = "";

	public String getErrorMsg() {
		return errorMsg;
	}

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

	// Parsear la fecha con los formatos admitidos
	private static java.util.Date parseFecha(String fechaStr) {
		String[] formatos = { "dd.MM.yyyy", "ddMMyyyy", "dd/MM/yyyy" };

		for (String formato : formatos) {

			try {
				SimpleDateFormat sdf = new SimpleDateFormat(formato);
				return sdf.parse(fechaStr);
			} catch (ParseException e) { // Si el formato es correcto pero la fecha es inválida
				if (fechaStr.length() == formato.length()) {
					errorMsg = "Fecha inexistente";
				} else {
					errorMsg = TipoErrores.getMSJ_FORMATO_DATE();
				}
			}

		}
		return null; // Si ningún formato fue válido queda en null
	}

	public boolean fechaInvalida(JTextField fechaJtext) {
		// eliminamos espacios
		String texto = fechaJtext.getText().trim();
		java.util.Date fecha = parseFecha(texto);
		return fecha == null;
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
<<<<<<< HEAD
	/*
=======

>>>>>>> 22d63a8f5aaae82b9fa1b1b617fab35029771472
	public static boolean esDecimalValido(String texto) {

		if (texto == null || texto.trim().isEmpty())
			return false;

		try {
			Double.parseDouble(texto);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean estaEnRango(String texto, double minimo, double maximo) {
		if (!esDecimalValido(texto))
			return false;
		double valor = Double.parseDouble(texto);
		return valor >= minimo && valor <= maximo;
	}
<<<<<<< HEAD
	*/
=======

>>>>>>> 22d63a8f5aaae82b9fa1b1b617fab35029771472
}
