package utilidades;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FormatoLabel extends JLabel{
	
	private JLabel label;
	
	public FormatoLabel() {
		
	}
	
	public JLabel crearLabelError(JTextField txtReferencia, int[] posicion)
	{
		label = new JLabel();
		label.setForeground(Color.red);
		label.setLabelFor(txtReferencia);
		label.setBounds(posicion[0], posicion[1], posicion[2], posicion[3]);
		label.setVisible(false);
		
		return this.label;
	}
}
