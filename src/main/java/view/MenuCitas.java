package view;

import controller.MenuCitasController;
import service.CitaService;
import service.ConsultorioService;
import service.PacientService;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.Icon;

import java.awt.Image;

public class MenuCitas extends JFrame {
    private JPanel contentPane;
    private JLabel encabezado;
    private JButton buttonIngresarConsultorio;
    private JButton buttonOtros;
    private JButton buttonSalir;

    public MenuCitas() {
        MenuCitasController a1=new MenuCitasController(buttonIngresarConsultorio,buttonOtros,buttonSalir,this);
        buttonIngresarConsultorio.addActionListener(a1);
        buttonOtros.addActionListener(a1);
        buttonSalir.addActionListener(a1);
        setContentPane(contentPane);
        this.setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

    public static void main(String[] args) {
        PacientService a1=PacientService.getSingletonInstance();
        ConsultorioService a2=ConsultorioService.getSingletonInstance();
        CitaService a3=CitaService.getSingletonInstance();
        MenuCitas dialog = new MenuCitas();
        dialog.pack();
        dialog.setVisible(true);
     }

    private void createUIComponents() {
        // TODO: place custom component creation code here

        encabezado=new JLabel();
        ImageIcon foto123 = new ImageIcon("encabezadoCitas.png");
        Icon icono1234 = new ImageIcon(foto123.getImage().getScaledInstance(1920,98, Image.SCALE_DEFAULT));
        encabezado.setIcon(icono1234);

        buttonIngresarConsultorio=new JButton();
        ImageIcon foto1234 = new ImageIcon("crearCita.png");
        Icon icono12345 = new ImageIcon(foto1234.getImage().getScaledInstance(894,156, Image.SCALE_DEFAULT));
        buttonIngresarConsultorio.setIcon(icono12345);

        buttonOtros=new JButton();
        ImageIcon foto12345 = new ImageIcon("otrosCita.png");
        Icon icono123456 = new ImageIcon(foto12345.getImage().getScaledInstance(904,156, Image.SCALE_DEFAULT));
        buttonOtros.setIcon(icono123456);

        buttonSalir=new JButton();
        ImageIcon foto123456 = new ImageIcon("salirCita.png");
        Icon icono1234567 = new ImageIcon(foto123456.getImage().getScaledInstance(899,156, Image.SCALE_DEFAULT));
        buttonSalir.setIcon(icono1234567);
    }
}

