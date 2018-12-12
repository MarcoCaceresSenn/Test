package vista.preguntas_test;

import control.GestorContador;
import gestion_datos.CalculoPuntaje;
import gestion_datos.FileMaker;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PanelPreguntasTest extends JPanel implements ActionListener {

    private PanelBotones panelBotones;
    private PanelImagen panelImagen;
    private JButton botonSiguiente;
    private int contador;
    private Container ventana;

    public PanelPreguntasTest(Container ventana) {
        this.ventana = ventana;
        initComponents();
    }

    private void initComponents() {
        this.contador = GestorContador.getInstance().getContador();
        this.setLayout(new BorderLayout());
        this.panelBotones = new PanelBotones();
        this.panelImagen = new PanelImagen();
        this.botonSiguiente = new JButton("Siguiente");
        JPanel panelInferior = new JPanel(new BorderLayout());
        JPanel panelInferiorBtnSig = new JPanel(new FlowLayout());
        panelInferiorBtnSig.add(this.botonSiguiente);
        panelInferior.add(this.panelBotones, BorderLayout.CENTER);
        panelInferior.add(panelInferiorBtnSig, BorderLayout.PAGE_END);
        this.botonSiguiente.addActionListener(this);
        this.add(this.panelImagen, BorderLayout.NORTH);
        this.add(panelInferior, BorderLayout.SOUTH);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.botonSiguiente) {
            for (JRadioButton seleccionTest : this.panelBotones.getSeleccionTest()) {
                if (seleccionTest.isSelected()) {
                    if (GestorContador.getInstance().getContador() != 3) {
                        this.panelImagen.removerTodo();
                        this.panelImagen.modificarPanel(GestorContador.getInstance().getContador());
                        
                        this.panelBotones.sobreescribirBotones();
                    } else {
                        CalculoPuntaje cal = new CalculoPuntaje(this.panelBotones.getRespuestasUsuario());
                        System.exit(0);
                    }
                }
            }
        }
    }

}
