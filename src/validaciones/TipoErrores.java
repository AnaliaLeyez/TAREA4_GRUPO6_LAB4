package validaciones;

public class TipoErrores {
	
	final String MSJ_CAMPO_VACIO = "El campo no puede estar vacío";
	final String MSJ_CONTIENE_NRO = "El campo no puede contener números";
	final String MSJ_CONTIENE_LETRAS = "El campo no puede contener letras";
	final String MSJ_TEL_LONGITUD_INCORRECTA = "El campo debe tener entre 9 y 10 dígitos";
	final String MSJ_FORMATO_DATE = "El formato debe ser dd/MM/yyyy, sin espacios ni guiones";
	
	public String getMSJ_CAMPO_VACIO() {
		return MSJ_CAMPO_VACIO;
	}
	public String getMSJ_CONTIENE_NRO() {
		return MSJ_CONTIENE_NRO;
	}
	public String getMSJ_CONTIENE_LETRAS() {
		return MSJ_CONTIENE_LETRAS;
	}
	public String getMSJ_TEL_LONGITUD_INCORRECTA() {
		return MSJ_TEL_LONGITUD_INCORRECTA;
	}
	public String getMSJ_FORMATO_DATE() {
		return MSJ_FORMATO_DATE;
	}
}
