package Principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

public class VentanaPpal extends Ventana {

	private static final long serialVersionUID = 1L;
	private JButton btnEj1 = new JButton();
	private JButton btnEj2 = new JButton();
	private JButton btnEj3 = new JButton();
	private JButton btnSalir = new JButton();
	private JLabel txtGrupo6 = new JLabel();
	private String grupo= "GRUPO NRO: 6";

	public VentanaPpal() {
		super(new int[] { 500, 100, 417, 313}, "Ventana Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Seteo Label con nombre del grupo
		setLblText(txtGrupo6,new Font("Lucida Sans Unicode", Font.BOLD, 15), this.getBackground(), new int[]{10, 22, 127, 30}, grupo);


		// Configuro Botones y los agrego al panel
		setButton(btnEj1,"Ejercicio 1", new int[] {106, 63, 140, 30},!getIsVentanaHijaActiva());
		setButton(btnEj2,"Ejercicio 2", new int[] {106, 117, 140, 30},!getIsVentanaHijaActiva());
		setButton(btnEj3,"Ejercicio 3", new int[] {106, 168, 140, 30},!getIsVentanaHijaActiva());
		setButton(btnSalir,"Salir", new int[] {306, 244, 89, 23},!getIsVentanaHijaActiva());


		// Evento de cada botón
		btnEj1.addActionListener(new eBtn1(this));
		btnEj2.addActionListener(new eBtn2(this));
		btnEj3.addActionListener(new eBtn3(this));
		btnSalir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0); // cierra la aplicación
			}
		});

	}

	public void ventanaHijaActiva(boolean isVentanaHijaActiva) {
		setIsVentanaHijaActiva(isVentanaHijaActiva);
		this.btnEj1.setEnabled(!isVentanaHijaActiva);
		this.btnEj2.setEnabled(!isVentanaHijaActiva);
		this.btnEj3.setEnabled(!isVentanaHijaActiva);
	}
}

class eBtn1 implements ActionListener {

	private VentanaPpal padre;

	public eBtn1(VentanaPpal padre) {
		this.padre = padre;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaContacto frame = new VentanaContacto(padre);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

class eBtn2 implements ActionListener {
	private VentanaPpal padre;
	
	public eBtn2(VentanaPpal padre) {
		this.padre = padre;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPromedio frame = new VentanaPromedio(padre);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		}
	}
		
class eBtn3 implements ActionListener {
			private VentanaPpal padre;
			
			public eBtn3(VentanaPpal padre) {
				this.padre = padre;
			}
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
			        public void run() {
			            try {
			                VentanaSeleccionMultiple frame = new VentanaSeleccionMultiple(padre);
			                frame.setVisible(true);
			                padre.ventanaHijaActiva(true);  // Desactiva los botones en VentanaPpal
			            } catch (Exception e) {
			                e.printStackTrace();
			            }
			        }
				});
	}
}

