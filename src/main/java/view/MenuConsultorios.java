package view;

import controller.MenuConsultoriosController;
import service.CitaService;
import service.ConsultorioService;
import service.PacientService;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import java.awt.Image;

public class MenuConsultorios extends JFrame {
    private JPanel contentPane;
    private JLabel encabezado;
    private JButton buttonIngresarConsultorio;
    private JButton buttonOtros;
    private JButton buttonSalir;

    public MenuConsultorios() {
        MenuConsultoriosController a1=new MenuConsultoriosController(buttonIngresarConsultorio,buttonOtros,
                buttonSalir,this);
        buttonIngresarConsultorio.addActionListener(a1);
        buttonOtros.addActionListener(a1);
        buttonSalir.addActionListener(a1);
        setContentPane(contentPane);
        this.setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

    /**public static void main(String[] args) {
        MenuConsultorios dialog = new MenuConsultorios();
        dialog.pack();
        dialog.setVisible(true);
    }*/

    private void createUIComponents() {
        // TODO: place custom component creation code here
        encabezado=new JLabel();
        ImageIcon foto123 = new ImageIcon("encabezadoConsultorio.png");
        Icon icono1234 = new ImageIcon(foto123.getImage().getScaledInstance(1920,98, Image.SCALE_DEFAULT));
        encabezado.setIcon(icono1234);

        buttonIngresarConsultorio=new JButton();
        ImageIcon foto1234 = new ImageIcon("crearConsultorio.png");
        Icon icono12345 = new ImageIcon(foto1234.getImage().getScaledInstance(863,250, Image.SCALE_DEFAULT));
        buttonIngresarConsultorio.setIcon(icono12345);

        buttonOtros=new JButton();
        ImageIcon foto12345 = new ImageIcon("otrosConsultorio.png");
        Icon icono123456 = new ImageIcon(foto12345.getImage().getScaledInstance(863,200, Image.SCALE_DEFAULT));
        buttonOtros.setIcon(icono123456);

        buttonSalir=new JButton();
        ImageIcon foto123456 = new ImageIcon("salirConsultorio.png");
        Icon icono1234567 = new ImageIcon(foto123456.getImage().getScaledInstance(863,200, Image.SCALE_DEFAULT));
        buttonSalir.setIcon(icono1234567);
    }
}
