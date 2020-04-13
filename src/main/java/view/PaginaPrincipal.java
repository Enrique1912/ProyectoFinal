package view;

import controller.PaginaPrincipalController;
import service.CitaService;
import service.ConsultorioService;
import service.PacientService;

import javax.swing.*;
import java.awt.*;

public class PaginaPrincipal extends JFrame {
    private JPanel contentPane;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JLabel foto;
    private JLabel Bienvenido;


    public PaginaPrincipal() {
        PaginaPrincipalController a1=new PaginaPrincipalController(button1,button2,button3,contentPane,this);
        button1.addActionListener(a1);
        button2.addActionListener(a1);
        button3.addActionListener(a1);
        setContentPane(contentPane);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.dispose();
    }


    public static void main(String[] args) {
        PacientService a1= PacientService.getSingletonInstance();
        ConsultorioService a2=ConsultorioService.getSingletonInstance();
        CitaService a3 = CitaService.getSingletonInstance();
        PaginaPrincipal dialog = new PaginaPrincipal();
        dialog.pack();
        dialog.setVisible(true);

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        //Establece el tamano de la imagen

        foto=new JLabel();
        ImageIcon fot = new ImageIcon("Menu.png");
        Icon icono = new ImageIcon(fot.getImage().getScaledInstance(562,452, Image.SCALE_DEFAULT));
        foto.setIcon(icono);

        /**---------------------------------------------------------------------------------*/
        button1=new JButton();
        ImageIcon foto = new ImageIcon("Administrativo.png");
        Icon icono1 = new ImageIcon(foto.getImage().getScaledInstance(720,136, Image.SCALE_AREA_AVERAGING));
        button1.setIcon(icono1);
        button1.setFocusable(false);
        button1.setFocusPainted(false);
        /**-------------------------------------------------------------------------------*/
        button2=new JButton();
        ImageIcon foto1 = new ImageIcon("ConfirmacionPacientes.png");
        Icon icono12 = new ImageIcon(foto1.getImage().getScaledInstance(720,136, Image.SCALE_AREA_AVERAGING));
        button2.setIcon(icono12);
        button2.setFocusable(false);
        button2.setFocusPainted(false);
        /**-------------------------------------------------------------------------------*/
        button3=new JButton();
        ImageIcon foto12 = new ImageIcon("Salir del Program.png");
        Icon icono123 = new ImageIcon(foto12.getImage().getScaledInstance(720,136, Image.SCALE_DEFAULT));
        button3.setIcon(icono123);
        button3.setFocusable(true);
        button3.setFocusPainted(true);

    }
}
