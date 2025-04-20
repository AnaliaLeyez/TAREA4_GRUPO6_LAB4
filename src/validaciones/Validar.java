package validaciones;

import javax.swing.JTextField;

public class Validar {
	public boolean campoVacio(JTextField txt)
	{
		return txt.getText().trim().isEmpty();
	}
	
	public boolean contieneLetras(JTextField txt)
	{
		String auxTxt = txt.getText();
		
		for (int i = 0; i < auxTxt.length(); i++) 
		{
			if (!Character.isDigit(auxTxt.charAt(i)))
				return true;
		}
		return false;
	}
}
