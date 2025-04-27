package Principal;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

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
