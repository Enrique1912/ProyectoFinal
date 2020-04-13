package view;

import com.toedter.calendar.JDateChooser;
import controller.PacientController;
import model.Pacient;

import javax.swing.*;
import java.awt.*;

public class PacientView extends JFrame {
    private JPanel contentPane;
    private JButton buttonRegresar;
    private JButton buttonIngresar;
    private JLabel encabezado;
    private JTextField textFieldNomCompl;
    private JLabel nomCompleto;
    private JTextField textFieldPrimerApellido;
    private JTextField textFieldSegundoApellido;
    private JTextArea textAreaDireccion;
    private JLabel primerApellido;
    private JLabel segundoApellido;
    private JLabel direccion;
    private JLabel fechNac;
    private JLabel enferAsociadas;
    private JTextArea textAreaEnferAso;
    private JLabel observaciones;
    private JTextArea textAreaObser;
    private JPanel panel1;
    private JLabel labelNumero;
    private JTextField textFieldNumero;
    private JTextField textFieldId;
    private JLabel numeroIdentificacion;
    private JDateChooser JDateChooser1;


    public PacientView() {
        super("MENU CREAR PACIENTES");
        PacientController controller = new PacientController(textFieldNomCompl,textFieldPrimerApellido,
                textFieldSegundoApellido,textFieldId,textFieldNumero, textAreaDireccion,textAreaEnferAso,textAreaObser,
                buttonIngresar,buttonRegresar,JDateChooser1,this);
        buttonRegresar.addActionListener(controller);
        buttonIngresar.addActionListener(controller);
        setContentPane(contentPane);
        this.setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

    public PacientView(Pacient x) {
        PacientController controller = new PacientController(textFieldNomCompl,textFieldPrimerApellido,
                textFieldSegundoApellido,textFieldId,textFieldNumero, textAreaDireccion,textAreaEnferAso,textAreaObser,
                buttonIngresar,buttonRegresar,x,JDateChooser1,this);
        buttonRegresar.addActionListener(controller);
        buttonIngresar.addActionListener(controller);
        setContentPane(contentPane);
        this.setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        encabezado=new JLabel();
        ImageIcon foto123 = new ImageIcon("TituloCrear.png");
        Icon icono1234 = new ImageIcon(foto123.getImage().getScaledInstance(1920,98, Image.SCALE_DEFAULT));
        encabezado.setIcon(icono1234);

        buttonIngresar=new JButton();
        ImageIcon foto1234 = new ImageIcon("BotonIngresarPacientes.png");
        Icon icono12345 = new ImageIcon(foto1234.getImage().getScaledInstance(579,93, Image.SCALE_DEFAULT));
        buttonIngresar.setIcon(icono12345);

        buttonRegresar=new JButton();
        ImageIcon foto12345 = new ImageIcon("BotonRegresarMenuPacientes.png");
        Icon icono123456 = new ImageIcon(foto12345.getImage().getScaledInstance(579,93, Image.SCALE_DEFAULT));
        buttonRegresar.setIcon(icono123456);

        nomCompleto=new JLabel();
        ImageIcon foto123456 = new ImageIcon("JLabelNombreRosa.png");
        Icon icono1234567 = new ImageIcon(foto123456.getImage().getScaledInstance(216,35, Image.SCALE_DEFAULT));
        nomCompleto.setIcon(icono1234567);

        primerApellido=new JLabel();
        ImageIcon foto1234567 = new ImageIcon("JLabelApellidoRosa.png");
        Icon icono12345678 = new ImageIcon(foto1234567.getImage().getScaledInstance(216,35, Image.SCALE_DEFAULT));
        primerApellido.setIcon(icono12345678);

        segundoApellido=new JLabel();
        ImageIcon foto12345678 = new ImageIcon("JLabelApellido2Rosa.png");
        Icon icono123456789 = new ImageIcon(foto12345678.getImage().getScaledInstance(221,35,
                Image.SCALE_DEFAULT));
        segundoApellido.setIcon(icono123456789);

        numeroIdentificacion=new JLabel();
        ImageIcon foto123456789 = new ImageIcon("JLabelNumberIdentificacionRosa.png");
        Icon icono12345678910 = new ImageIcon(foto123456789.getImage().getScaledInstance(275,35,
                Image.SCALE_DEFAULT));
        numeroIdentificacion.setIcon(icono12345678910);

        labelNumero=new JLabel();
        ImageIcon foto12345678910 = new ImageIcon("JLabelNumeroTelRosa.png");
        Icon icono1234567891011 = new ImageIcon(foto12345678910.getImage().getScaledInstance(250,35,
                Image.SCALE_DEFAULT));
        labelNumero.setIcon(icono1234567891011);

        direccion=new JLabel();
        ImageIcon foto1234567891011 = new ImageIcon("JLabelDireccionRosa.png");
        Icon icono123456789101112 = new ImageIcon(foto1234567891011.getImage().getScaledInstance(148,35,
                Image.SCALE_DEFAULT));
        direccion.setIcon(icono123456789101112);

        fechNac=new JLabel();
        ImageIcon foto123456789101112 = new ImageIcon("JLabelFechaNacRosa.png");
        Icon icono12345678910111213 = new ImageIcon(foto123456789101112.getImage().getScaledInstance(242,35,
                Image.SCALE_DEFAULT));
        fechNac.setIcon(icono12345678910111213);

        enferAsociadas=new JLabel();
        ImageIcon foto12345678910111213 = new ImageIcon("JLabelEnferAsoRosa.png");
        Icon icono1234567891011121314 = new ImageIcon(foto12345678910111213.getImage().getScaledInstance(277,35,
                Image.SCALE_DEFAULT));
        enferAsociadas.setIcon(icono1234567891011121314);

        observaciones=new JLabel();
        ImageIcon foto1234567891011121314 = new ImageIcon("JLabelObserRosa.png");
        Icon icono123456789101112131415 = new ImageIcon(foto1234567891011121314.getImage().getScaledInstance(178,
                35, Image.SCALE_DEFAULT));
        observaciones.setIcon(icono123456789101112131415);

        JDateChooser1=new JDateChooser();
    }
}
