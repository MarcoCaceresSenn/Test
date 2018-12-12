package vista.previo_test;
import vista.previo_test.PanelLogin;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Ventana extends JFrame{
    
    private PanelLogin panelLogin;

    public Ventana() {
        initComponents();
    }
    
    private void initComponents(){
        this.panelLogin = new PanelLogin();
        this.setIconImage(new ImageIcon("resources//b1.png").getImage());
        this.setTitle("Ensayo Jpanel");
        this.setDefaultCloseOperation(3);
        this.setLayout(new BorderLayout());
        this.add(this.panelLogin, BorderLayout.CENTER);
        this.pack();
        this.setResizable(true);
        this.setVisible(true);
    }
    
}
