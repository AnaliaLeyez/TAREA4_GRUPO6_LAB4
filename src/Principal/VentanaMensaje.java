package Principal;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaMensaje extends Ventana {
	
		private static final long serialVersionUID = 1L;
	    private JLabel lblOpciones;
	    private JButton btnAceptar;

		
		public VentanaMensaje(VentanaSeleccionMultiple padre,String opciones) {
			super(padre, new int[] {300, 200, 450, 250},"Mensaje");
			padre.setVentanaHijaActiva(true);
			
			// Mostrar las opciones seleccionadas
			 lblOpciones = new JLabel("<html><b>" + opciones.replace("\n", "<br>") + "</b></html>");
		     lblOpciones.setBounds(10, 0, 200, 100);
		     lblOpciones.setHorizontalAlignment(SwingConstants.CENTER); 
		     lblOpciones.setVerticalAlignment(SwingConstants.TOP);  

		        // Calcular la posición para centrar el JLabel en la ventana
		        int labelWidth = 400; 
		        int labelHeight = 100; 
		        int xPosition = (438 - labelWidth) / 2; 
		        int yPosition = (163 - labelHeight) / 2; 

		        lblOpciones.setBounds(xPosition, yPosition, labelWidth, labelHeight);
		        getContentPane().add(lblOpciones);
		
			btnAceptar = new JButton("Aceptar");
			btnAceptar.setIcon(null);
			btnAceptar.setBounds(157, 80, 110, 33);
			
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					padre.setControlesActivos(true);
					cerrarVentana();
				}
			});
			
			getContentPane().add(btnAceptar);
			setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

			addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					padre.setVentanaHijaActiva(false);
					dispose();
				}
			});
		}
		
		public void cerrarVentana() {
		    dispose(); 
		}
		
}



