package Principal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import interfaces.VentanaConPadre;
import utilidades.CerrarVentanaActionListener;

import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;


public class VentanaPromedio extends JFrame implements VentanaConPadre {
	private static final long serialVersionUID = 1L;
	private VentanaPpal padre;

	// Defino los TextField
	private JTextField txtNota1, txtNota2,txtNota3;
	private JComboBox<String> cBoxTps;

	// Defino los Label
	private JLabel lblNota1,lblNota2,lblNota3, lblTps;
	private JLabel lblNota1Error, lblNota2Error, lblNota3Error;

	// Defino los textos constantes
	private final String Nota1 = "Nota 1:";
	private final String Nota2 = "Nota 2:";
	private final String Nota3 = "Nota 3:";
	private final String Tps = "TPS:";
	
	// BOTON mostrar
	private JButton btnCalcular;
	private JPanel JPPromedioDelEstudiante;
	private JTextField txtPromedio;
	private JTextField txtCondicion;
	private JPanel JPNotasDelEstudiante;

	public VentanaPromedio(VentanaPpal padre) {
		
		this.padre = padre;
		padre.setVentanaHijaActiva(true);
			
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                padre.setVentanaHijaActiva(false);
                dispose();
            }
        });
		
		setBounds(500, 100, 502, 537);
		setTitle("Promedio");
		
		// Configuro Botón Calcular
		btnCalcular = new JButton();
		btnCalcular.setBounds(349, 69, 129, 43);
		btnCalcular.setText("CALCULAR");

		
		JLabel lblMostrarNota1 = new JLabel();
		JLabel lblMostrarNota2 = new JLabel();
		JLabel lblMostrarNota3 = new JLabel();
		JLabel lblMostrarTps = new JLabel();
		 getContentPane().setLayout(null);
		 getContentPane().add(btnCalcular);
		 
		 JPPromedioDelEstudiante = new JPanel();
		 JPPromedioDelEstudiante.setBorder(BorderFactory.createTitledBorder("Notas Del Estudiante"));
		 JPPromedioDelEstudiante.setBounds(20, 293, 319, 147);
		 getContentPane().add(JPPromedioDelEstudiante);
		 JPPromedioDelEstudiante.setLayout(null);
		 
		 JLabel lblPromedio = new JLabel("Promedio:");
		 lblPromedio.setBounds(10, 48, 88, 14);
		 JPPromedioDelEstudiante.add(lblPromedio);
		 lblPromedio.setBackground(this.getBackground());
		 lblPromedio.setForeground(Color.BLACK);
		 
		 JLabel lblCondicion = new JLabel("Condición:");
		 lblCondicion.setBounds(10, 89, 88, 14);
		 JPPromedioDelEstudiante.add(lblCondicion);
		 lblCondicion.setBackground(this.getBackground());
		 lblCondicion.setForeground(Color.BLACK);
		 
		 txtPromedio = new JTextField();
		 txtPromedio.setBounds(108, 45, 96, 20);
		 txtPromedio.setEditable(false);
		 JPPromedioDelEstudiante.add(txtPromedio);
		 txtPromedio.setColumns(10);
		 
		 txtCondicion = new JTextField();
		 txtCondicion.setBounds(108, 86, 96, 20);
		 txtCondicion.setEditable(false);
		 JPPromedioDelEstudiante.add(txtCondicion);
		 txtCondicion.setColumns(10);
		 
		 JPNotasDelEstudiante = new JPanel();
		 JPNotasDelEstudiante.setBorder(BorderFactory.createTitledBorder("Notas Del Estudiante"));
		 JPNotasDelEstudiante.setBounds(20, 34, 319, 248);
		 getContentPane().add(JPNotasDelEstudiante);
		 JPNotasDelEstudiante.setLayout(null);
		 
// Nota1 Label y TextField
 		lblNota1 = new JLabel(Nota1);
 		lblNota1.setBounds(10, 28, 89, 41);
 		JPNotasDelEstudiante.add(lblNota1);
 		lblNota1.setBackground(this.getBackground());
 		lblNota1.setForeground(Color.BLACK);
 		
		txtNota1 = new JTextField();
		txtNota1.setBounds(109, 33, 160, 30);
		JPNotasDelEstudiante.add(txtNota1);
		txtNota1.addKeyListener(new KeyAdapter() {
		@Override
		public void keyTyped(KeyEvent e) {
			txtNota1.setBackground(Color.WHITE);
		}
		});
		txtNota1.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
		txtNota1.setBackground(Color.white);
		 				 
		// Nota2 label y TextField
		lblNota2 = new JLabel(Nota2);
		lblNota2.setBounds(10, 86, 89, 41);
		JPNotasDelEstudiante.add(lblNota2);
		lblNota2.setBackground(this.getBackground());
		lblNota2.setForeground(Color.BLACK);
					 		
		txtNota2 = new JTextField();
		txtNota2.setBounds(109, 91, 160, 30);
		JPNotasDelEstudiante.add(txtNota2);
		txtNota2.addKeyListener(new KeyAdapter() {
		@Override
		public void keyTyped(KeyEvent e) {
		txtNota2.setBackground(Color.WHITE);
		}
		});
		txtNota2.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
		txtNota2.setBackground(Color.white);
		 				 				 
		 				 				 		
		// Labels para errores.
		lblNota1Error = new JLabel("Error");
		lblNota1Error.setBounds(109, 68, 160, 14);
		JPNotasDelEstudiante.add(lblNota1Error);
		lblNota1Error.setForeground(new Color(255, 0, 0));
		lblNota1Error.setVisible(false);
		lblNota1Error.setLabelFor(txtNota1);
		 				 				 				 
		lblNota2Error = new JLabel("Error");
		lblNota2Error.setBounds(109, 120, 160, 14);
		JPNotasDelEstudiante.add(lblNota2Error);
		lblNota2Error.setEnabled(true);
		lblNota2Error.setForeground(Color.RED);
		lblNota2Error.setVisible(false);
		lblNota2Error.setLabelFor(lblNota2);
		 				 				 				 				 
		txtNota3 = new JTextField();
		txtNota3.setBounds(109, 145, 160, 30);
		JPNotasDelEstudiante.add(txtNota3);
		txtNota3.addKeyListener(new KeyAdapter() {
		@Override
		public void keyReleased(KeyEvent e) {
		txtNota3.setBackground(Color.WHITE);
		}
		});
		txtNota3.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
		txtNota3.setBackground(Color.white);
		 				 				 				 				 		 
		lblNota3Error = new JLabel("Error");
		lblNota3Error.setBounds(109, 172, 160, 14);
		JPNotasDelEstudiante.add(lblNota3Error);
		lblNota3Error.setEnabled(true);
		lblNota3Error.setForeground(Color.RED);
		lblNota3Error.setVisible(false);
		 				 				 				 				 		 				 
		// nota3 label y TextField
		lblNota3 = new JLabel(Nota3);
		lblNota3.setBounds(10, 140, 89, 41);
		JPNotasDelEstudiante.add(lblNota3);
		lblNota3.setBackground(this.getBackground());
	    lblNota3.setForeground(Color.BLACK);
		lblNota3Error.setLabelFor(lblNota3);
		 				 				 				 				 		 				 		
		// Tps label y TextField
		lblTps = new JLabel(Tps);
		lblTps.setBounds(10, 192, 89, 41);
		JPNotasDelEstudiante.add(lblTps);
		lblTps.setBackground(this.getBackground());
		lblTps.setForeground(Color.BLACK);
		 				 				 				 				 		 				 				
		cBoxTps = new JComboBox<String>();
		cBoxTps.setBounds(109, 202, 108, 20);
		JPNotasDelEstudiante.add(cBoxTps);
		cBoxTps.addKeyListener(new KeyAdapter() {
		@Override
		public void keyTyped(KeyEvent e) {
				cBoxTps.setBackground(Color.WHITE);
		}
		});
		//Opciones del Cbox:
		cBoxTps.addItem("Aprobado");
		cBoxTps.addItem("Desaprobado");
		JLabel lblTpsError = new JLabel("Error");
		lblTpsError.setBounds(109, 219, 250, 14);
		JPNotasDelEstudiante.add(lblTpsError);
		lblTpsError.setEnabled(true);
		lblTpsError.setForeground(Color.RED);
		lblTpsError.setVisible(false);
		lblTpsError.setLabelFor(lblTps);
		
		// Evento del botón Calcular	
		 eBtnCalcular eventoCalcular = new eBtnCalcular(txtNota1, txtNota2, txtNota3,
		 cBoxTps, lblNota1Error, lblNota2Error, lblNota3Error, lblTpsError,
		 lblMostrarNota1, lblMostrarNota2, lblMostrarNota3, lblMostrarTps);

		// Le pasamos los campos resultado
		eventoCalcular.setCamposResultado(txtPromedio, txtCondicion);

		// Asociamos el evento al botón
		btnCalcular.addActionListener(eventoCalcular);		
		
		JButton btnNuevo = new JButton("NUEVO");
		btnNuevo.setBounds(349, 117, 129, 43);
		getContentPane().add(btnNuevo);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.setBounds(349, 165, 129, 43);
		btnSalir.addActionListener(new CerrarVentanaActionListener(this));
		getContentPane().add(btnSalir);
		
		btnNuevo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
			}
		});
	}

	public void cambiarVisibilidad(boolean estado) {
		setVisible(estado);
	}

	@Override
	public VentanaPpal getPadre() {
		return this.padre;
	}
	
	private void limpiarCampos() {
		ocultarErrores();
		
		this.txtNota1.setText("");
		this.txtNota2.setText("");
		this.txtNota3.setText("");
		this.txtCondicion.setText("");
		this.txtPromedio.setText("");
	}
	
	 private void ocultarErrores() {
	        lblNota1Error.setVisible(false);
	        lblNota2Error.setVisible(false);
	        lblNota3Error.setVisible(false);

	        txtNota1.setBackground(Color.WHITE);
	        txtNota2.setBackground(Color.WHITE);
	        txtNota3.setBackground(Color.WHITE);
	    }
}


class eBtnCalcular implements ActionListener {
    private JTextField txtNota1, txtNota2, txtNota3;
    private JComboBox<String> cBoxTps;
    private JLabel lblNota1Error, lblNota2Error, lblNota3Error, lblTpsError;
    private JTextField txtPromedio, txtCondicion;

    public eBtnCalcular(JTextField txtNota1, JTextField txtNota2, JTextField txtNota3,
            JComboBox<String> cBoxTps,
            JLabel lblNota1Error, JLabel lblNota2Error, JLabel lblNota3Error, JLabel lblTpsError,
            JLabel lblMostrarNota1, JLabel lblMostrarNota2, JLabel lblMostrarNota3, JLabel lblMostrarTps) {
        this.txtNota1 = txtNota1;
        this.txtNota2 = txtNota2;
        this.txtNota3 = txtNota3;
        this.cBoxTps = cBoxTps;
        this.lblNota1Error = lblNota1Error;
        this.lblNota2Error = lblNota2Error;
        this.lblNota3Error = lblNota3Error;
        this.lblTpsError = lblTpsError;
    }

    public void setCamposResultado(JTextField txtPromedio, JTextField txtCondicion) {
        this.txtPromedio = txtPromedio;
        this.txtCondicion = txtCondicion;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ocultarErrores();

        boolean tieneErrores = false;
        float nota1 = 0, nota2 = 0, nota3 = 0;

        try {
            nota1 = validarNota(txtNota1, lblNota1Error);
         
        } catch (Exception ex) {
            tieneErrores = true;
        }

        try {
            nota2 = validarNota(txtNota2, lblNota2Error);
        } catch (Exception ex) {
            tieneErrores = true;
        }

        
        try {
            nota3 = validarNota(txtNota3, lblNota3Error);
        } catch (Exception ex) {
            tieneErrores = true;
        }

        if (tieneErrores) {
            return; 
        }

        String tp = (String) cBoxTps.getSelectedItem();

        float promedio = (nota1 + nota2 + nota3) / 3;
        String condicion;

        if (tp.equals("Desaprobado") || nota1 < 6 || nota2 < 6 || nota3 < 6) {
            condicion = "Libre";
        } else if (nota1 >= 8 && nota2 >= 8 && nota3 >= 8) {
            condicion = "Promocionado";
        } else {
            condicion = "Regular";
        }

        txtPromedio.setText(String.format("%.2f", promedio));
        txtCondicion.setText(condicion);
    }
    
    
    private float validarNota(JTextField campo, JLabel errorLabel) throws FueraDeRangoException, NumberFormatException {
    	try {
        float valor = Float.parseFloat(campo.getText());
        if (valor < 1 || valor > 10) {
            mostrarError(campo, errorLabel, "Debe estar entre 1 y 10");
            throw new FueraDeRangoException("Nota fuera de rango");
        }
        return valor;
    	} catch (NumberFormatException e) {
            mostrarError(campo, errorLabel, "Ingrese un número válido");
            throw new NumberFormatException(); 
        }
    }
    
    private boolean esNumeroValido(String texto) {
        return texto.matches("\\d+(\\.\\d+)?");
    }
    
    private void ocultarErrores() {
        lblNota1Error.setVisible(false);
        lblNota2Error.setVisible(false);
        lblNota3Error.setVisible(false);

        txtNota1.setBackground(Color.WHITE);
        txtNota2.setBackground(Color.WHITE);
        txtNota3.setBackground(Color.WHITE);
    }
    
    
    private void mostrarError(JTextField campo, JLabel label, String error) {
        campo.setBackground(Color.PINK);
        label.setText(error);
        label.setVisible(true);
    }
}



	

