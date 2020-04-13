package view;

import com.toedter.calendar.JDateChooser;
import controller.ConsultoriosMostrarController;
import model.Hora;
import service.CitaService;
import service.ConsultorioService;
import service.PacientService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ConsultoriosMostrar extends JFrame {
    private JPanel contentPane;
    private JButton buttonRegresar;
    private JButton buttonBuscar;
    private JLabel encabezado;
    private JButton buttonModificar;
    private JButton buttonEliminar;
    private JLabel jLabelNombre;
    private JLabel jLabelFecha;
    private JTable table1;
    private JComboBox comboBox1;
    private JDateChooser JDateChooser1;
    DefaultTableModel tableModel = new DefaultTableModel();

    public ConsultoriosMostrar() {
        ConsultoriosMostrarController controller = new ConsultoriosMostrarController
                (table1,tableModel,comboBox1,JDateChooser1,buttonRegresar,buttonBuscar,
                        buttonEliminar,buttonModificar,this);
        buttonBuscar.addActionListener(controller);
        buttonRegresar.addActionListener(controller);
        buttonEliminar.addActionListener(controller);
        buttonModificar.addActionListener(controller);
        setContentPane(contentPane);
        table1.setModel(tableModel);
        this.setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }


    public static void main(String[] args) {

        PacientService a1= PacientService.getSingletonInstance();
        ConsultorioService a2= ConsultorioService.getSingletonInstance();
        Hora a11=new Hora("2","30");
        a2.addConsultorio("Consultorio Centro Medico del Este","04/05/2020",a11,a11,"30",22634651);
        a2.addConsultorio("Consultorio Centro Medico del Este","05/11/1999",a11,a11,"30",22634651);
        a2.addConsultorio("Consultorio Hospital CYM","04/07/2022",a11,a11,"30",22634651);
        a2.addConsultorio("Consultorio Centro Medico del Este","04/08/2023",a11,a11,"30",22634651);
        a2.addConsultorio("Consultorio Centro Medico del Este","04/09/2024",a11,a11,"30",22634651);
        a2.addConsultorio("Consultorio Hospital CYM","04/10/2025",a11,a11,"30",22634651);
        //ConsultoriosMostrar dialog = new ConsultoriosMostrar(a1,a2);
      ///  dialog.pack();
       // dialog.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        encabezado=new JLabel();
        ImageIcon foto123 = new ImageIcon("mostrarConsultorio.png");
        Icon icono1234 = new ImageIcon(foto123.getImage().getScaledInstance
                (1920,98, Image.SCALE_DEFAULT));
        encabezado.setIcon(icono1234);

        buttonRegresar=new JButton();
        ImageIcon foto1234 = new ImageIcon("buttonRegresar.png");
        Icon icono12345 = new ImageIcon(foto1234.getImage().getScaledInstance
                (435,93, Image.SCALE_DEFAULT));
        buttonRegresar.setIcon(icono12345);

        buttonBuscar=new JButton();
        ImageIcon foto12345 = new ImageIcon("buttonBuscar.png");
        Icon icono123456 = new ImageIcon(foto12345.getImage().getScaledInstance
                (435,93, Image.SCALE_DEFAULT));
        buttonBuscar.setIcon(icono123456);

        buttonModificar=new JButton();
        ImageIcon foto123456 = new ImageIcon("buttonModificar.png");
        Icon icono1234567 = new ImageIcon(foto123456.getImage().getScaledInstance
                (435,93, Image.SCALE_DEFAULT));
        buttonModificar.setIcon(icono1234567);

        buttonEliminar=new JButton();
        ImageIcon foto1234567 = new ImageIcon("buttonEliminar.png");
        Icon icono12345678 = new ImageIcon(foto1234567.getImage().getScaledInstance
                (435,93, Image.SCALE_DEFAULT));
        buttonEliminar.setIcon(icono12345678);

        jLabelNombre=new JLabel();
        ImageIcon foto12345678 = new ImageIcon("jLabelNombre.png");
        Icon icono123456789 = new ImageIcon(foto12345678.getImage().getScaledInstance
                (447,39, Image.SCALE_DEFAULT));
        jLabelNombre.setIcon(icono123456789);

        jLabelFecha=new JLabel();
        ImageIcon foto123456789 = new ImageIcon("jLabelFecha.png");
        Icon icono12345678910 = new ImageIcon(foto123456789.getImage().getScaledInstance
                (216,35, Image.SCALE_DEFAULT));
        jLabelFecha.setIcon(icono12345678910);

        JDateChooser1=new JDateChooser();
    }
}
