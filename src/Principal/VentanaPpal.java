package Principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.EventQueue;
import java.awt.Font;

public class VentanaPpal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton btnEj1, btnEj2, btnEj3;	
	private final String grupo="GRUPO NRO: 6";
	
	public VentanaPpal()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500,100,417,313);
		setTitle("Ventana Principal");
		getContentPane().setLayout(null);
		
		//Label con nombre del grupo
		JLabel txtGrupo6 = new JLabel();
		txtGrupo6.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 15));
		txtGrupo6.setBackground(this.getBackground());
		txtGrupo6.setBounds(10, 22, 127, 30);
		txtGrupo6.setText(grupo);
		getContentPane().add(txtGrupo6);
		
		
		//Configuro Botón EJ 1
		btnEj1 = new JButton();
		btnEj1.setText("Ejercicio 1");
		btnEj1.setBounds(106,63, 140,30);
		
		//Configuro Botón EJ 2
		btnEj2 = new JButton();
		btnEj2.setText("Ejercicio 2");
		btnEj2.setBounds(106,117, 140,30);
		
		//Configuro Botón EJ 3
		btnEj3 = new JButton();
		btnEj3.setText("Ejercicio 3");
		btnEj3.setBounds(106,168, 140,30);

		//Agrego los botones al Panel
		getContentPane().add(btnEj1);	
		getContentPane().add(btnEj2);	
		getContentPane().add(btnEj3);	
		
		
		//Evento de cada botón
		btnEj1.addActionListener(new eBtn1());
		btnEj2.addActionListener(new eBtn1());
		btnEj3.addActionListener(new eBtn1());
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(306, 244, 89, 23);
		getContentPane().add(btnSalir);
		
	}
	
	public void cambiarVisibilidad(boolean estado)
	{
		setVisible(estado);
	}
}


class eBtn1 implements ActionListener
{
	@Override
	public void actionPerformed(ActionEvent arg0) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaContacto frame = new VentanaContacto();
					frame.setVisible(true);
					} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
