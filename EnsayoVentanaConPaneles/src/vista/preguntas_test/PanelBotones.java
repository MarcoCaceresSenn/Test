package vista.preguntas_test;

import control.GestorContador;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PanelBotones extends JPanel implements ActionListener {

    private PanelImagen panelImagen;
    private int[] respuestasUsuario = new int[60];
    private JRadioButton[] seleccionTest;
    private ButtonGroup grupoBtnes;

    public PanelBotones() {
        this.initComponents();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < this.seleccionTest.length; i++) {
            if (this.seleccionTest[i].isSelected()) {
                this.respuestasUsuario[GestorContador.getInstance().getContador() - 1] = (i + 1);;
                this.seleccionTest[i].setText("(" + "*" + ")");
            } else {
                this.seleccionTest[i].setText("");
            }
        }
    }

    private void initComponents() {
        this.setLayout(new GridLayout(2, 4, 2, 2));
        this.grupoBtnes = new ButtonGroup();
        this.seleccionTest = new JRadioButton[8];
        for (int i = 0; i < 8; i++) {
            this.seleccionTest[i] = new JRadioButton(new ImageIcon("resources//packB1//b" + i + ".png"));
            this.grupoBtnes.add(this.seleccionTest[i]);
            this.seleccionTest[i].addActionListener(this);
            this.add(this.seleccionTest[i]);
        }
        this.setBackground(Color.BLACK);
    }

    public JRadioButton[] getSeleccionTest() {
        return seleccionTest;
    }
    
    public void sobreescribirBotones(){
        int contador = GestorContador.getInstance().getContador();
        contador++;
        GestorContador.getInstance().setContador(contador);
        for (int i = 0; i < 8; i++) {
            this.seleccionTest[i].setIcon(new ImageIcon("resources//packB" + GestorContador.getInstance().getContador() + "//b" + i + ".png"));
        }
        
        validate();
        repaint();
    }

    public int[] getRespuestasUsuario() {
        return respuestasUsuario;
    }
    
    
}
