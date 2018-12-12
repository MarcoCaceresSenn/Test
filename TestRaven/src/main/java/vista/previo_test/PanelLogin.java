package vista.previo_test;

import gestion_datos.FileMaker;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class PanelLogin extends JPanel implements ActionListener, MouseListener {
    
    private PanelInstrucciones panelIstrucciones;
    private JLabel imagenDeFondo;
    private JButton botonSiguiente;
    private JLabel labelNombre;
    private JLabel labelEdad;
    private JLabel condPsico;
    private JTextField campoNombre;
    private JComboBox opcionesEdad;
    private ButtonGroup grupoBtn;
    private JRadioButton condSi;
    private JRadioButton condNo;
    private String textoInicialNombre;

    public PanelLogin() {
        initComponets();
    }

    private void initComponets() {
        
        String[] itemsComboBox = {"", "12 años", "13 - 14 años", "15 - 16 años", "17 años", "18 años", "19 años", "20 - 21 años", "22 - 65 años"};
        this.textoInicialNombre = "Ejm :  Juan";
        this.imagenDeFondo = new JLabel(new ImageIcon("resources//login.jpg"));
        this.botonSiguiente = new JButton("Siguiente");
        this.labelNombre = new JLabel("Nombre: ");
        this.labelEdad = new JLabel("Rango etario: ");
        this.condPsico = new JLabel("Posee alguna condicion psicologica?:");
        this.condSi = new JRadioButton("Si");
        this.condNo = new JRadioButton("No");
        this.campoNombre = new JTextField(this.textoInicialNombre, 12);
        this.opcionesEdad = new JComboBox(itemsComboBox);
        this.grupoBtn = new ButtonGroup();
        this.grupoBtn.add(this.condSi);
        this.grupoBtn.add(this.condNo);

        this.labelNombre.setForeground(Color.white);
        this.condPsico.setForeground(Color.white);
        this.labelEdad.setForeground(Color.white);
        this.labelNombre.setBounds(205, 225, 250, 35);
        this.labelEdad.setBounds(205, 280, 250, 35);
        this.condPsico.setBounds(100, 340, 250, 35);
        this.campoNombre.setBounds(325, 225, 250, 35);
        this.condSi.setBounds(325, 350, 50, 15);
        this.condNo.setBounds(400, 350, 50, 15);
        this.botonSiguiente.setBounds(325, 450, 150, 35);
        this.opcionesEdad.setBounds(325, 280, 250, 35);
        this.imagenDeFondo.setLayout(null);
        this.imagenDeFondo.add(this.botonSiguiente);
        this.imagenDeFondo.add(this.opcionesEdad);
        this.imagenDeFondo.add(this.campoNombre);
        this.imagenDeFondo.add(this.condNo);
        this.imagenDeFondo.add(this.condPsico);
        this.imagenDeFondo.add(this.condSi);
        this.imagenDeFondo.add(this.labelEdad);
        this.imagenDeFondo.add(this.labelNombre);
        this.setPreferredSize(new Dimension(800, 600));
        this.botonSiguiente.addActionListener(this);
        this.campoNombre.addMouseListener(this);
        this.add(this.imagenDeFondo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonSiguiente && !this.campoNombre.getText().equals("") && !this.campoNombre.getText().equals(this.textoInicialNombre) && this.opcionesEdad.getSelectedIndex() != 0 && (this.condSi.isSelected() || this.condNo.isSelected())){
            FileMaker.almacenarDatosUsuario("nombreUsuario", this.campoNombre.getText());
            FileMaker.almacenarDatosUsuario("rangoEtario", (String)this.opcionesEdad.getSelectedItem());
            
            Container ventana = this.getParent();
            this.panelIstrucciones = new PanelInstrucciones();
            ventana.remove(this);
            ventana.add(this.panelIstrucciones);
            ventana.validate();
            
        }else{
            JOptionPane.showMessageDialog(null, "Rellene todos los campos");
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getComponent() == this.campoNombre && this.campoNombre.getText().equals(this.textoInicialNombre)){
            this.campoNombre.setText("");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) {}

}
