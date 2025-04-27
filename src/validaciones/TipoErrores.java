package validaciones;

public abstract class TipoErrores {
	
	static final String MSJ_CAMPO_VACIO = "El campo no puede estar vacío";
	static final String MSJ_CONTIENE_NRO = "El campo no puede contener números";
	static final String MSJ_CONTIENE_LETRAS = "El campo no puede contener letras";
	static final String MSJ_TEL_LONGITUD_INCORRECTA = "El campo debe tener entre 9 y 10 dígitos";
	static final String MSJ_FORMATO_DATE = "El formato debe ser dd/MM/yyyy";
	static final String MSJ_RADIO_BTN = "Debe seleccionar una opción";
	static final String MSJ_CHK_BTN = "Debe seleccionar al menos una opción";
	static final String MSJ_NOTA_INVALIDA= "Ingresar nro entre 1 y 10";
	
	public static String getMSJ_CAMPO_VACIO() {
		return MSJ_CAMPO_VACIO;
	}
	public static String getMSJ_CONTIENE_NRO() {
		return MSJ_CONTIENE_NRO;
	}
	public static String getMSJ_CONTIENE_LETRAS() {
		return MSJ_CONTIENE_LETRAS;
	}
	public static String getMSJ_TEL_LONGITUD_INCORRECTA() {
		return MSJ_TEL_LONGITUD_INCORRECTA;
	}
	public static String getMSJ_FORMATO_DATE() {
		return MSJ_FORMATO_DATE;
	}
	public static String getMsjRadioBtn() {
		return MSJ_RADIO_BTN;
	}
	public static String getMsjChkBtn() {
		return MSJ_CHK_BTN;
	}
	public static String getMSJ_NOTA_INVALIDA() {
		return MSJ_NOTA_INVALIDA;
	}
}
