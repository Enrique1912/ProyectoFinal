package view;

import com.toedter.calendar.JDateChooser;
import controller.CitasMostrarController;
import model.Consultorio;
import model.Hora;
import model.Pacient;
import service.CitaService;
import service.ConsultorioService;
import service.PacientService;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import javax.swing.table.DefaultTableModel;

import java.awt.Image;

public class CitasMostrar extends JFrame {
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
    private JComboBox comboBox2;
    private JComboBox comboBox4;
    private JComboBox comboBox3;
    private JComboBox comboBox5;
    private JDateChooser JDateChooser1;
    private JLabel jLabelHoraInicio;
    private JLabel jLabelHoraFin;
    DefaultTableModel tableModel = new DefaultTableModel();

    public CitasMostrar() {
        CitasMostrarController controller = new CitasMostrarController
                (table1, tableModel, comboBox1, JDateChooser1,buttonRegresar, buttonBuscar, buttonEliminar,
                        buttonModificar,comboBox2,comboBox3,comboBox4,comboBox5,this);
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

        PacientService a1 = PacientService.getSingletonInstance();
        ConsultorioService a2 = ConsultorioService.getSingletonInstance();
        CitaService a3= CitaService.getSingletonInstance();
        Hora a11 = new Hora("02", "30");
        Pacient p1=new Pacient("Nora","Alvarez","Mena","5",5555555,"Puntarenas","Rinitis","Ninguna observacion que aportar","26/04/1999");
        Pacient p2=new Pacient("Pedro","Vargas","Alvarado","4",44444444,"Limon","Fiebre","Ninguna observacion que aportar","26/04/1999");
        Pacient p3=new Pacient("Maria","Arrieta","Lopez","3",33333333,"Guanacaste","Alergia","Ninguna observacion que aportar","26/04/1999");
        Pacient p4=new Pacient("Daniel","Mora","Ramirez","1",111111111,"San Jose","Resfrio","Ninguna observacion que aportar","26/04/1999");
        Pacient p5=new Pacient("Mario","Gonzalez","Herrera","2",22222222,"Alajuela","N/A","Ninguna observacion que aportar","26/04/1999");
        Pacient p6=new Pacient("Enrique","Mata","Parajeles","117590577",85835867,"Heredia, Mercedes Norte","Asma","Ninguna observacion que aportar","26/04/1999");

        Consultorio c1=new Consultorio("Consultorio Hospital CYM","29/04/2020",new Hora("13","00"),new Hora("16","00"),"00",22634651);
        Consultorio c2=new Consultorio("Consultorio Centro Medico del Este","28/04/2020",new Hora("13","00"),new Hora("16","00"),"00",22634651);
        Consultorio c3=new Consultorio("Consultorio Hospital CYM","27/04/2020",new Hora("13","00"),new Hora("16","00"),"00",22634651);
        Consultorio c4=new Consultorio("Consultorio Centro Medico del Este","26/04/2020",new Hora("13","00"),new Hora("16","00"),"00",22634651);

        a3.addCita(p1, c1, a11, a11, "NO");
        a3.addCita(p2, c2, a11, a11, "NO");
        a3.addCita(p3, c2, a11, a11, "NO");
        a3.addCita(p4, c2, a11, a11, "NO");
        a3.addCita(p5, c2, a11, a11, "NO");
        a3.addCita(p6, c2, a11, a11, "NO");
        CitasMostrar dialog = new CitasMostrar();
        dialog.pack();
        dialog.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        encabezado = new JLabel();
        ImageIcon foto123 = new ImageIcon("aaa.png");
        Icon icono1234 = new ImageIcon(foto123.getImage().getScaledInstance(1920, 98, Image.SCALE_DEFAULT));
        encabezado.setIcon(icono1234);

        buttonRegresar = new JButton();
        ImageIcon foto1234 = new ImageIcon("botonRegresarCita.png");
        Icon icono12345 = new ImageIcon(foto1234.getImage().getScaledInstance(435, 93, Image.SCALE_DEFAULT));
        buttonRegresar.setIcon(icono12345);

        buttonBuscar = new JButton();
        ImageIcon foto12345 = new ImageIcon("botonBuscarCita.png");
        Icon icono123456 = new ImageIcon(foto12345.getImage().getScaledInstance(435, 93, Image.SCALE_DEFAULT));
        buttonBuscar.setIcon(icono123456);

        buttonModificar = new JButton();
        ImageIcon foto123456 = new ImageIcon("botonModificarCita.png");
        Icon icono1234567 = new ImageIcon(foto123456.getImage().getScaledInstance(435, 93, Image.SCALE_DEFAULT));
        buttonModificar.setIcon(icono1234567);

        buttonEliminar = new JButton();
        ImageIcon foto1234567 = new ImageIcon("botonEliminarCita.png");
        Icon icono12345678 = new ImageIcon(foto1234567.getImage().getScaledInstance
                (435, 93, Image.SCALE_DEFAULT));
        buttonEliminar.setIcon(icono12345678);

        jLabelNombre = new JLabel();
        ImageIcon foto12345678 = new ImageIcon("nombreConsultorioCitas.png");
        Icon icono123456789 = new ImageIcon(foto12345678.getImage().getScaledInstance
                (447, 39, Image.SCALE_DEFAULT));
        jLabelNombre.setIcon(icono123456789);

        jLabelFecha = new JLabel();
        ImageIcon foto123456789 = new ImageIcon("fechaAtencionCitas.png");
        Icon icono12345678910 = new ImageIcon(foto123456789.getImage().getScaledInstance
                (447, 39, Image.SCALE_DEFAULT));
        jLabelFecha.setIcon(icono12345678910);

        jLabelHoraInicio = new JLabel();
        ImageIcon foto1234567899 = new ImageIcon("horaInicioCita.png");
        Icon icono123456789109 = new ImageIcon(foto1234567899.getImage().getScaledInstance
                (447, 39, Image.SCALE_DEFAULT));
        jLabelHoraInicio.setIcon(icono123456789109);

        jLabelHoraFin = new JLabel();
        ImageIcon foto12345678999 = new ImageIcon("horaFinCita.png");
        Icon icono1234567891099 = new ImageIcon(foto12345678999.getImage().getScaledInstance
                (447, 39, Image.SCALE_DEFAULT));
        jLabelHoraFin.setIcon(icono1234567891099);

        JDateChooser1 = new JDateChooser();
    }
}
