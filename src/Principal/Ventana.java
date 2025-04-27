package Principal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public abstract class Ventana extends JFrame {

	private static final long serialVersionUID = 1L;
	private Ventana padre=null;
	private Ventana ventanaHija;
	private boolean isVentanaHijaActiva = false;
	
	public Ventana(int bounds[], String titulo){ //este constructor es solo para Ventana Ppal que es la unica sin Padre
		setResizable(false);
		setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
		setTitle(titulo);
		getContentPane().setLayout(null);
	}
	
	public Ventana(Ventana padre,int bounds[], String titulo){
		setResizable(false);
		this.setPadre(padre);
		padre.setIsVentanaHijaActiva(true);
		setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
		setTitle(titulo);
		getContentPane().setLayout(null);
	}

	public void setLabel(JLabel label, String valor, int bounds[], Color color , boolean visible) {
		label.setText(valor);
		label.setBackground(this.getBackground());
		label.setForeground(color);
		label.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
		label.setVisible(visible);
		getContentPane().add(label);
	}

	
	public void setButton(JButton btn, String nombre, int bounds[], boolean bool) {
		btn.setText(nombre);
		btn.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
		btn.setEnabled(bool);
		getContentPane().add(btn);
	}
	
	public void setLblText(JLabel txt, Font fuente, Color color, int bounds[], String texto) {
		txt.setFont(fuente);
		txt.setBackground(color);
		txt.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
		txt.setText(texto);
		getContentPane().add(txt);
	}
	
	public void finalSetLblError(JLabel lbl, JTextField lblFor) {
		lbl.setEnabled(true);
		lbl.setForeground(Color.RED);
		lbl.setVisible(false);
		lbl.setLabelFor(lblFor);
	}
	
	public void setJPanel(JPanel panel, String txtBorde,int bounds[]) {
		panel.setBorder(BorderFactory.createTitledBorder(txtBorde));
		panel.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
		getContentPane().add(panel);
		panel.setLayout(null);
	}
	
	
	
	public void setearTxt(JTextField txt, int[] bounds) {
		addEventoKeyTyped(txt);
		txt.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
		txt.setBackground(Color.white);
		txt.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
		getContentPane().add(txt);
	}
	
	public void setearTxtNoEditable(JTextField txt, int[] bounds, int col, JPanel panel) {
		addEventoKeyTyped(txt);
		txt.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
		txt.setBackground(Color.white);
		txt.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
		txt.setEditable(false);
		txt.setColumns(col);
		getContentPane().add(txt);
		panel.add(txt);
	}
	
	public void addEventoKeyTyped(JTextField txt) {
		txt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				txt.setBackground(Color.WHITE);
			}
		});
	}
	
	public Ventana getPadre() {
		return padre;
	}

	public void setPadre(Ventana padre) {
		this.padre = padre;
	}
	
	
	public boolean getIsVentanaHijaActiva() {
		return isVentanaHijaActiva;
	}

	public void setIsVentanaHijaActiva(boolean activa) {
		isVentanaHijaActiva=activa;
	}
	
	public void setVentanaHija(Ventana ventana) {
	    this.ventanaHija = ventana;
	}

	public Ventana getVentanaHija() {
	    return ventanaHija;
	}
	
	public void setError(JLabel label, String msjError) {
		label.setText(msjError);
		label.setVisible(true);
	}

	public void ocultarLabel(JLabel label) {
		label.setVisible(false);
		label.setText("");
	}
	
	
	public void cambiarVisibilidad(boolean estado) {
	setVisible(estado);
	}
}
