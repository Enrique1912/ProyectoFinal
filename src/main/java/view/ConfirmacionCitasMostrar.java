package view;

import controller.ConfirmacionCitasController;
import service.CitaService;
import service.ConsultorioService;
import service.PacientService;

import javax.swing.*;
import java.awt.*;

;

public class ConfirmacionCitasMostrar extends JFrame {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel encabezado;
    private JTextField textField1;
    private JLabel bienvenido;
    private JLabel descripcion;
    private JLabel IdAmarillo;
    private JLabel confirmacion;
    private JComboBox comboBox1;

    public ConfirmacionCitasMostrar() {
        setContentPane(contentPane);
        // call onCancel() when cross is clicked
        ConfirmacionCitasController controller = new ConfirmacionCitasController
                (textField1,comboBox1,buttonOK,buttonCancel,this);
        buttonOK.addActionListener(controller);
        buttonCancel.addActionListener(controller);
        this.setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        PacientService a1= PacientService.getSingletonInstance();
        ConsultorioService a2= ConsultorioService.getSingletonInstance();
        CitaService a3= CitaService.getSingletonInstance();
        ConfirmacionCitasMostrar dialog = new ConfirmacionCitasMostrar();
        dialog.pack();
        dialog.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        encabezado=new JLabel();
        ImageIcon foto123 = new ImageIcon("encabezadoConfirmacion.png");
        Icon icono1234 = new ImageIcon(foto123.getImage().getScaledInstance
                (1920,98, Image.SCALE_DEFAULT));
        encabezado.setIcon(icono1234);

        buttonOK=new JButton();
        ImageIcon foto1234 = new ImageIcon("confirmar.png");
        Icon icono12345 = new ImageIcon(foto1234.getImage().getScaledInstance
                (579,93, Image.SCALE_DEFAULT));
        buttonOK.setIcon(icono12345);

        buttonCancel=new JButton();
        ImageIcon foto12345 = new ImageIcon("ok.png");
        Icon icono123456 = new ImageIcon(foto12345.getImage().getScaledInstance
                (579,93, Image.SCALE_DEFAULT));
        buttonCancel.setIcon(icono123456);

        bienvenido=new JLabel();
        ImageIcon foto123456 = new ImageIcon("bienvenido.png");
        Icon icono1234567 = new ImageIcon(foto123456.getImage().getScaledInstance
                (500,45, Image.SCALE_DEFAULT));
        bienvenido.setIcon(icono1234567);

        descripcion=new JLabel();
        ImageIcon foto1234567 = new ImageIcon("descripcion.png");
        Icon icono12345678 = new ImageIcon(foto1234567.getImage().getScaledInstance
                (1425,160, Image.SCALE_DEFAULT));
        descripcion.setIcon(icono12345678);

        IdAmarillo=new JLabel();
        ImageIcon foto12345678 = new ImageIcon("iDAmarillo.png");
        Icon icono123456789 = new ImageIcon(foto12345678.getImage().getScaledInstance
                (400,35, Image.SCALE_DEFAULT));
        IdAmarillo.setIcon(icono123456789);

        confirmacion=new JLabel();
        ImageIcon foto123456789 = new ImageIcon("confirmacion.png");
        Icon icono1234567899 = new ImageIcon(foto123456789.getImage().getScaledInstance
                (400,35, Image.SCALE_DEFAULT));
        confirmacion.setIcon(icono1234567899);

    }
}
