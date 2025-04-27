package Principal;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaMensaje  extends JFrame {
	
		private static final long serialVersionUID = 1L;
		private VentanaSeleccionMultiple padre;
	    private JLabel lblOpciones;

		
		public VentanaMensaje(VentanaSeleccionMultiple padre,String opciones) {
			this.padre = padre;
			padre.setVentanaHijaActiva(true);

			setTitle("Mensaje");
			setBounds(500, 100, 438, 163);
			getContentPane().setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBounds(386, 25, 24, 10);
			getContentPane().add(panel);
			
			// Mostrar las opciones seleccionadas
			 lblOpciones = new JLabel("<html><b>" + opciones.replace("\n", "<br>") + "</b></html>");
		     lblOpciones.setBounds(19, 11, 400, 120);
		     getContentPane().add(lblOpciones);
		     lblOpciones.setHorizontalAlignment(SwingConstants.CENTER); 
		     lblOpciones.setVerticalAlignment(SwingConstants.TOP);  

		        // Calcular la posición para centrar el JLabel en la ventana
		        int labelWidth = 400; 
		        int labelHeight = 100; 
		        int xPosition = (438 - labelWidth) / 2; 
		        int yPosition = (163 - labelHeight) / 2; 

		        lblOpciones.setBounds(xPosition, yPosition, labelWidth, labelHeight);
		        getContentPane().add(lblOpciones);
		
			JButton btnAceptar = new JButton("Aceptar");
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
		
		public VentanaSeleccionMultiple getPadre() {
			return padre;
		}

		
		public void setPadre(VentanaSeleccionMultiple padre) {
			this.padre = padre;
		}
}



