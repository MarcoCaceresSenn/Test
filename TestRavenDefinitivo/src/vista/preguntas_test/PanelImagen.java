package vista.preguntas_test;

import control.GestorContador;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelImagen extends JPanel {

    private JLabel[] imagenTest;

    public PanelImagen() {
        initComponents();
    }

    private void initComponents() {
        this.setPreferredSize(new Dimension(800, 390));
        this.imagenTest = new JLabel[60];
        for (int i = 0; i < this.imagenTest.length; i++) {
//            this.imagenTest[i] = new JLabel(new ImageIcon("resources//raven" + i + ".jpg"));
            this.imagenTest[i] = new JLabel(new ImageIcon("resources//" + i + ".jpg"));

        }
        this.add(this.imagenTest[0]);
    }

    public void modificarPanel(int posicion) {
        this.add(this.imagenTest[posicion]);
        validate();
        
    }
    public void removerTodo(){
        this.removeAll();
    }
}
