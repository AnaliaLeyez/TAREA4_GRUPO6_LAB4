package utilidades;
import interfaces.VentanaConPadre;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;


public class CerrarVentanaActionListener implements ActionListener {

	VentanaConPadre ventana;

	public CerrarVentanaActionListener(VentanaConPadre ventana) {
		this.ventana = ventana;

	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Evento ejecutado");
		ventana.getPadre().setVentanaHijaActiva(false);
		((JFrame)ventana).dispose();
		
	}

}
