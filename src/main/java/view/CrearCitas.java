package view;

import com.toedter.calendar.JDateChooser;
import controller.CrearCitasController;
import model.Cita;
import model.Hora;
import service.CitaService;
import service.ConsultorioService;
import service.PacientService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CrearCitas extends JFrame {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTable tablePacientes;
    private JDateChooser JDateChooser1;
    private JTable tableConsultorios;
    private JComboBox comboBoxHoraInicio;
    private JComboBox comboBoxMinutoInicio;
    private JComboBox comboBoxHoraFin;
    private JComboBox comboBoxMinFin;
    private JLabel encabezado;
    private JLabel jLabelIDPaciente;
    private JLabel jLabelNomConsultorio;
    private JLabel jLabelfecahAtencion;
    private JLabel jLabelHoraInicioCita;
    private JLabel jLabelFinalizaCita;
    private JTextField textFieldIdPaciente;
    private JComboBox comboBoxNombreConsul;
    DefaultTableModel tableModel1 = new DefaultTableModel();
    DefaultTableModel tableModel2 = new DefaultTableModel();


    public CrearCitas() {
        CrearCitasController controller = new CrearCitasController
                (textFieldIdPaciente,comboBoxNombreConsul,JDateChooser1, comboBoxHoraInicio,comboBoxMinutoInicio,
                        buttonOK,buttonCancel,comboBoxHoraFin,comboBoxMinFin,tablePacientes,tableModel1,
                        tableConsultorios,tableModel2,this);
        buttonOK.addActionListener(controller);
        buttonCancel.addActionListener(controller);
        setContentPane(contentPane);
        tableConsultorios.setModel(tableModel1);
        tablePacientes.setModel(tableModel2);
        this.setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

    public CrearCitas(Cita x) {
        CrearCitasController controller = new CrearCitasController(textFieldIdPaciente,comboBoxNombreConsul,
                JDateChooser1, comboBoxHoraInicio,comboBoxMinutoInicio,buttonOK,buttonCancel, comboBoxHoraFin,
                comboBoxMinFin,tablePacientes,tableModel1,tableConsultorios,tableModel2,x);
        buttonOK.addActionListener(controller);
        buttonCancel.addActionListener(controller);
        setContentPane(contentPane);
        tableConsultorios.setModel(tableModel1);
        tablePacientes.setModel(tableModel2);
        this.setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }


    public static void main(String[] args) {
        /**----------Arreglos----------------------------*/
        PacientService a1= PacientService.getSingletonInstance();
        ConsultorioService a2= ConsultorioService.getSingletonInstance();
        CitaService a3= CitaService.getSingletonInstance();
        /**---------------------------------------------*/
        /**------Pacientes------------------------------*/
        a1.addPacient("Enrique","Mata","Parajeles","117590577",85835867,"Heredia, Mercedes Norte","Asma","Ninguna observacion que aportar","26/04/1999");
        a1.addPacient("Mario","Gonzalez","Herrera","2",22222222,"Alajuela","N/A","Ninguna observacion que aportar","26/04/1999");
        a1.addPacient("Daniel","Mora","Ramirez","1",111111111,"San Jose","Resfrio","Ninguna observacion que aportar","26/04/1999");
        a1.addPacient("Maria","Arrieta","Lopez","3",33333333,"Guanacaste","Alergia","Ninguna observacion que aportar","26/04/1999");
        a1.addPacient("Pedro","Vargas","Alvarado","4",44444444,"Limon","Fiebre","Ninguna observacion que aportar","26/04/1999");
        a1.addPacient("Nora","Alvarez","Mena","5",5555555,"Puntarenas","Rinitis","Ninguna observacion que aportar","26/04/1999");

        /**---------------------------------------------*/
        /**-----------Consultorios----------------------*/

        a2.addConsultorio("Consultorio Hospital CYM","29/04/2020",new Hora("13","00"),new Hora("16","00"),"00",22634651);
        a2.addConsultorio("Consultorio Centro Medico del Este","28/04/2020",new Hora("13","00"),new Hora("16","00"),"00",22634651);
        a2.addConsultorio("Consultorio Hospital CYM","27/04/2020",new Hora("13","00"),new Hora("16","00"),"00",22634651);
        a2.addConsultorio("Consultorio Centro Medico del Este","26/04/2020",new Hora("13","00"),new Hora("16","00"),"00",22634651);
        /**---------------------------------------------*/
        CrearCitas dialog = new CrearCitas();
        dialog.pack();
        dialog.setVisible(true);
     }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        encabezado=new JLabel();
        ImageIcon foto123 = new ImageIcon("encabezado.png");
        Icon icono1234 = new ImageIcon(foto123.getImage().getScaledInstance(1920,98, Image.SCALE_DEFAULT));
        encabezado.setIcon(icono1234);

        buttonOK=new JButton();
        ImageIcon foto1234 = new ImageIcon("botonIngresar.png");
        Icon icono12345 = new ImageIcon(foto1234.getImage().getScaledInstance
                (579,93, Image.SCALE_DEFAULT));
        buttonOK.setIcon(icono12345);

        buttonCancel=new JButton();
        ImageIcon foto12345 = new ImageIcon("botonSalir.png");
        Icon icono123456 = new ImageIcon(foto12345.getImage().getScaledInstance
                (579,93, Image.SCALE_DEFAULT));
        buttonCancel.setIcon(icono123456);

        jLabelIDPaciente =new JLabel();
        ImageIcon foto123456 = new ImageIcon("numeroID.png");
        Icon icono1234567 = new ImageIcon(foto123456.getImage().getScaledInstance
                (400,35, Image.SCALE_DEFAULT));
        jLabelIDPaciente.setIcon(icono1234567);

        jLabelNomConsultorio =new JLabel();
        ImageIcon foto1234567 = new ImageIcon("nC.png");
        Icon icono12345678 = new ImageIcon(foto1234567.getImage().getScaledInstance
                (250,35, Image.SCALE_DEFAULT));
        jLabelNomConsultorio.setIcon(icono12345678);

        jLabelfecahAtencion =new JLabel();
        ImageIcon foto12345678 = new ImageIcon("fechaAtencionConsultorio.png");
        Icon icono123456789 = new ImageIcon(foto12345678.getImage().getScaledInstance
                (370,35, Image.SCALE_DEFAULT));
        jLabelfecahAtencion.setIcon(icono123456789);

        jLabelHoraInicioCita =new JLabel();
        ImageIcon foto123456788 = new ImageIcon("hICita.png");
        Icon icono1234567899 = new ImageIcon(foto123456788.getImage().getScaledInstance
                (250,35, Image.SCALE_DEFAULT));
        jLabelHoraInicioCita.setIcon(icono1234567899);

        jLabelFinalizaCita =new JLabel();
        ImageIcon foto123456789 = new ImageIcon("hFCita.png");
        Icon icono12345678910 = new ImageIcon(foto123456789.getImage().getScaledInstance
                (320,35, Image.SCALE_DEFAULT));
        jLabelFinalizaCita.setIcon(icono12345678910);

        JDateChooser1=new JDateChooser();
    }
}
