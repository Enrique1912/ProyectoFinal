package view;

import controller.MenuAdministracionPacientesController;

import javax.swing.*;
import java.awt.*;



public class MenuAdministracionPacientes extends JFrame {
    private JPanel contentPane;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JLabel encabezado;
    private JButton button5;


    public MenuAdministracionPacientes() {
       // this.elArreglo=elArreglo;
         MenuAdministracionPacientesController a1=new MenuAdministracionPacientesController(button1,button2,button3,
                 button4,button5,this);
         button1.addActionListener(a1);
         button2.addActionListener(a1);
         button3.addActionListener(a1);
         button4.addActionListener(a1);
         button5.addActionListener(a1);
        setContentPane(contentPane);
        this.setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }



    public static void main(String[] args) {
       // MenuAdministracionPacientes dialog = new MenuAdministracionPacientes();
      //  dialog.pack();
       // dialog.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        encabezado=new JLabel();
        ImageIcon foto123 = new ImageIcon("rojo.png");
        Icon icono1234 = new ImageIcon(foto123.getImage().getScaledInstance(1920,98, Image.SCALE_DEFAULT));
        encabezado.setIcon(icono1234);

        button1=new JButton();
        ImageIcon foto1234 = new ImageIcon("rosa.png");
        Icon icono12345 = new ImageIcon(foto1234.getImage().getScaledInstance(894,156, Image.SCALE_DEFAULT));
        button1.setIcon(icono12345);

        button2=new JButton();
        ImageIcon foto12345 = new ImageIcon("Leer.png");
        Icon icono123456 = new ImageIcon(foto12345.getImage().getScaledInstance(904,156, Image.SCALE_DEFAULT));
        button2.setIcon(icono123456);

        button3=new JButton();
        ImageIcon foto123456 = new ImageIcon("Modificar.png");
        Icon icono1234567 = new ImageIcon(foto123456.getImage().getScaledInstance(894,156, Image.SCALE_DEFAULT));
        button3.setIcon(icono1234567);

        button4=new JButton();
        ImageIcon foto1234567 = new ImageIcon("Eliminar.png");
        Icon icono12345678 = new ImageIcon(foto1234567.getImage().getScaledInstance
                (894,156, Image.SCALE_DEFAULT));
        button4.setIcon(icono12345678);

        button5=new JButton();
        ImageIcon foto12345678 = new ImageIcon("Salir.png");
        Icon icono123456789 = new ImageIcon(foto12345678.getImage().getScaledInstance
                (899,157, Image.SCALE_DEFAULT));
        button5.setIcon(icono123456789);

    }
}
