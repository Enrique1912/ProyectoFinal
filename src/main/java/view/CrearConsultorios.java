package view;

import com.toedter.calendar.JDateChooser;
import controller.CrearConsultoriosController;
import model.Consultorio;

import javax.swing.*;
import java.awt.*;

public class CrearConsultorios extends JFrame {
    private JPanel contentPane;
    private JButton salirCancel;
    private JLabel encabezado;
    private JButton ingresarButton;
    private JLabel etiquetaNombreConsul;
    private JLabel etiquetaFechaAtencion;
    private JLabel etiquetaHoraAtencion;
    private JLabel etiquetaTelContacto;
    private JTextField textField4;
    private JComboBox comboBoxNombreConsultorio;
    private JDateChooser JDateChooser1;
    private JComboBox comboBoxHora;
    private JComboBox comboBoxMinuto;
    private JComboBox comboHoraCierre;
    private JComboBox comboMinutoCierre;
    private JLabel cierre;

    public CrearConsultorios() {
        CrearConsultoriosController controller = new CrearConsultoriosController(comboBoxNombreConsultorio,
                JDateChooser1, comboBoxHora,comboBoxMinuto,textField4,ingresarButton,salirCancel,
                comboHoraCierre,comboMinutoCierre,this);
        ingresarButton.addActionListener(controller);
        salirCancel.addActionListener(controller);
        setContentPane(contentPane);
        this.setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

    public CrearConsultorios(Consultorio x) {
        CrearConsultoriosController controller = new CrearConsultoriosController(comboBoxNombreConsultorio,
                JDateChooser1, comboBoxHora,comboBoxMinuto,textField4,ingresarButton,salirCancel,x, comboHoraCierre,
                comboMinutoCierre);
        ingresarButton.addActionListener(controller);
        salirCancel.addActionListener(controller);
        setContentPane(contentPane);
        this.setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }


    /**public static void main(String[] args) {
        CrearConsultorios dialog = new CrearConsultorios();
        dialog.pack();
        dialog.setVisible(true);
    }*/

    private void createUIComponents() {
        // TODO: place custom component creation code here
        encabezado=new JLabel();
        ImageIcon foto123 = new ImageIcon("elNuevoConsultorio.png");
        Icon icono1234 = new ImageIcon(foto123.getImage().getScaledInstance(1920,98, Image.SCALE_DEFAULT));
        encabezado.setIcon(icono1234);

        ingresarButton=new JButton();
        ImageIcon foto1234 = new ImageIcon("ingresarConsul.png");
        Icon icono12345 = new ImageIcon(foto1234.getImage().getScaledInstance(579,93, Image.SCALE_DEFAULT));
        ingresarButton.setIcon(icono12345);

        salirCancel=new JButton();
        ImageIcon foto12345 = new ImageIcon("salirConsul.png");
        Icon icono123456 = new ImageIcon(foto12345.getImage().getScaledInstance(579,93, Image.SCALE_DEFAULT));
        salirCancel.setIcon(icono123456);

        etiquetaNombreConsul =new JLabel();
        ImageIcon foto123456 = new ImageIcon("nombreConsultorio.png");
        Icon icono1234567 = new ImageIcon(foto123456.getImage().getScaledInstance(250,35, Image.SCALE_DEFAULT));
        etiquetaNombreConsul.setIcon(icono1234567);

        etiquetaFechaAtencion =new JLabel();
        ImageIcon foto1234567 = new ImageIcon("fechaAtencion.png");
        Icon icono12345678 = new ImageIcon(foto1234567.getImage().getScaledInstance(209,30, Image.SCALE_DEFAULT));
        etiquetaFechaAtencion.setIcon(icono12345678);

        etiquetaHoraAtencion =new JLabel();
        ImageIcon foto12345678 = new ImageIcon("apertura.png");
        Icon icono123456789 = new ImageIcon(foto12345678.getImage().getScaledInstance
                (250,35, Image.SCALE_DEFAULT));
        etiquetaHoraAtencion.setIcon(icono123456789);

        cierre =new JLabel();
        ImageIcon foto123456788 = new ImageIcon("cierre.png");
        Icon icono1234567899 = new ImageIcon(foto123456788.getImage().getScaledInstance
                (250,35, Image.SCALE_DEFAULT));
        cierre.setIcon(icono1234567899);

        etiquetaTelContacto =new JLabel();
        ImageIcon foto123456789 = new ImageIcon("telContacto.png");
        Icon icono12345678910 = new ImageIcon(foto123456789.getImage().getScaledInstance
                (250,35, Image.SCALE_DEFAULT));
        etiquetaTelContacto.setIcon(icono12345678910);

        JDateChooser1=new JDateChooser();
    }
}
