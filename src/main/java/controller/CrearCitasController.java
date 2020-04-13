package controller;

import com.toedter.calendar.JDateChooser;
import model.Cita;
import model.Consultorio;
import model.Hora;
import model.Pacient;
import service.CitaService;
import service.ConsultorioService;
import service.PacientService;
import view.CrearCitas;
import view.MenuCitas;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CrearCitasController implements ActionListener {
    private JTextField iD;
    private JComboBox nombreConsultorio;
    private JDateChooser fechaConsulta;
    private JComboBox horaConsulta;
    private JComboBox minutoConsulta;
    private JButton botonIngresar;
    private JButton botonSalir;
    private Cita laCita;
    private ConsultorioService elArreglo;
    private PacientService losPacientes;
    private Date laFech;
    private CitaService lasCitas;
    private SimpleDateFormat formateador=new SimpleDateFormat("dd/MM/yyyy");
    private Hora horaInicioAtencion;
    private JComboBox horaFinalizacion;
    private JComboBox minutoFinalizacion;
    String [] losTitulos1={"Primer Apellido", "Segundo Apellido","Nombre Completo","Identificacion",
            "Numero de Telefono","Direccion", "Fecha de Nacimiento","Enfermedades Asociadas","Observaciones"};
   private DefaultTableModel tableModel1;
   private DefaultTableModel tableModel2;
    private Object[][] pacientes;
    private Object[][] consultorios;
    String [] losTitulos2={"Nombre del Consultorio", "Fecha de Atencion","Hora de Apertura","Hora de Cierre",
            "Telefono de Contacto"};
    private CrearCitas laPagina;

    public CrearCitasController(JTextField iD, JComboBox nombreConsultorio, JDateChooser fechaConsulta,
                                JComboBox horaConsulta, JComboBox minutoConsulta, JButton ingresar, JButton salir,
                                JComboBox horaCierre, JComboBox minutoCierre, JTable laTabla1, DefaultTableModel
                                        tableModel1,JTable laTabla2,DefaultTableModel tableModel2,CrearCitas x){
        this.nombreConsultorio=nombreConsultorio;
        this.fechaConsulta=fechaConsulta;
        this.horaConsulta=horaConsulta;
        this.minutoConsulta=minutoConsulta;
        this.iD=iD;
        this.botonIngresar=ingresar;
        this.botonSalir=salir;
        this.elArreglo=elArreglo.getSingletonInstance();
        this.losPacientes=losPacientes.getSingletonInstance();
        this.laFech=new Date();
        this.formateador.setLenient(false);
        this.horaFinalizacion=horaCierre;
        this.minutoFinalizacion=minutoCierre;
        nombreConsultorio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione el Nombre del " +
                "Consultorio","Consultorio Hospital CYM", "Consultorio Centro Medico del Este" }));

        horaConsulta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una Hora", "00", "01",
                "02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21",
                "22","23"
        }));

        minutoConsulta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione los Minutos", "00",
                "15", "30","45" }));

        horaFinalizacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una Hora", "00",
                "01", "02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20",
                "21", "22","23"
        }));

        minutoFinalizacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione los Minutos",
                "00", "15", "30","45" }));
        this.lasCitas=lasCitas.getSingletonInstance();
        pacientes = losPacientes.retornaEstCargados();
        consultorios = elArreglo.retornaEstCargados();
        this.tableModel1=tableModel2;
        this.tableModel2=tableModel1;
        tableModel2.setDataVector(pacientes, losTitulos1);
        tableModel1.setDataVector(consultorios, losTitulos2);
        this.laPagina=x;
    }

    public CrearCitasController(JTextField iD, JComboBox nombreConsultorio, JDateChooser fechaConsulta,
                                JComboBox horaConsulta, JComboBox minutoConsulta, JButton ingresar,
                                JButton salir, JComboBox horaCierre, JComboBox minutoCierre, JTable laTabla1,
                                DefaultTableModel tableModel1,JTable laTabla2, DefaultTableModel tableModel2,Cita x){
        this.nombreConsultorio=nombreConsultorio;
        this.fechaConsulta=fechaConsulta;
        this.horaConsulta=horaConsulta;
        this.minutoConsulta=minutoConsulta;
        this.iD=iD;
        this.botonIngresar=ingresar;
        this.botonSalir=salir;
        this.elArreglo=elArreglo.getSingletonInstance();
        this.losPacientes=losPacientes.getSingletonInstance();
        this.laFech=new Date();
        this.formateador.setLenient(false);
        this.horaFinalizacion=horaCierre;
        this.minutoFinalizacion=minutoCierre;
        nombreConsultorio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione el Nombre del " +
                "Consultorio","Consultorio Hospital CYM", "Consultorio Centro Medico del Este" }));

        horaConsulta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una Hora", "00", "01",
                "02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21",
                "22","23"
        }));

        minutoConsulta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione los Minutos", "00",
                "15", "30","45" }));

        horaFinalizacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una Hora", "00",
                "01", "02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20",
                "21", "22","23"
        }));

        minutoFinalizacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione los Minutos",
                "00", "15", "30","45" }));
        this.lasCitas=lasCitas.getSingletonInstance();

        pacientes = losPacientes.retornaEstCargados();
        consultorios = elArreglo.retornaEstCargados();
        this.tableModel1=tableModel2;
        this.tableModel2=tableModel1;
        tableModel2.setDataVector(pacientes, losTitulos1);
        tableModel1.setDataVector(consultorios, losTitulos2);
        this.laCita=x;
        this.iD.setText(x.getNombrePaciente().getId());
        this.fechaConsulta.setDate(retornaFecha(x.getElConsultorio().getLaFecha()));
        this.horaConsulta.setSelectedIndex(estableceHoras(x.getHoraInicio().getHora()));
        this.minutoConsulta.setSelectedIndex(estableceMinutos(x.getHoraInicio().getMinutos()));
        this.horaFinalizacion.setSelectedIndex(estableceHoras(x.getHoraFinal().getHora()));
        this.horaFinalizacion.setSelectedIndex(estableceMinutos(x.getHoraFinal().getMinutos()));
        this.nombreConsultorio.setSelectedIndex(estableceNombreConsultorio(x.getElConsultorio().getNombreConsultorio()));
        this.minutoConsulta.setSelectedIndex(estableceMinutos(x.getHoraInicio().getMinutos()));
        this.minutoFinalizacion.setSelectedIndex(estableceMinutos(x.getHoraFinal().getMinutos()));
        horaConsulta.setSelectedIndex(estableceHoras(x.getHoraInicio().getHora()));
        //String tel=String.valueOf(x.getTelefonoContactos());
        //fechaConsulta.setDate(retornaFecha(x.getLaFecha()));
        //numContacto.setText(tel);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
            String numeroCedula=iD.getText();
            String nombreConsul=nombreConsultorio.getSelectedItem().toString();
            Hora horaConsul=new Hora(horaConsulta.getSelectedItem().toString(),
                    minutoConsulta.getSelectedItem().toString());
            Hora horaFinConsul=new Hora(horaFinalizacion.getSelectedItem().toString(),
                    minutoFinalizacion.getSelectedItem().toString());
            String confirmacion="No ha confirmado";
            Pacient elEncontrado=new Pacient();
            Consultorio elEncontrado1=new Consultorio();
            Cita laFinal=new Cita();
            String fechAtencion=new String();
            if(verificaFecha(fechaConsulta)==true){
                laFech=new Date();
            }else{
                laFech=fechaConsulta.getDate();
                fechAtencion=formateador.format(laFech);
            }
            Object source = actionEvent.getSource();
            if (source == botonSalir){
                MenuCitas x1=new MenuCitas();
                x1.setVisible(true);
                laPagina.dispose();

            }
            else {
                try {
                    if (verificaSiTodoEstaCompleto(numeroCedula, nombreConsul, fechAtencion, horaConsul,
                            horaFinConsul) == true) {
                        if (verificaExistenciaPaciente(numeroCedula) == true) {
                            if (verificaFechasYConsultorios(nombreConsul, fechAtencion) == true) {
                                elEncontrado = losPacientes.buscarPaciente(numeroCedula);
                                elEncontrado1 = elArreglo.buscarConsultorio(nombreConsul, fechAtencion);
                                if(verificaRangoDeCita(horaConsul,horaFinConsul,elEncontrado1)==true){
                                    if(verificaCantTiempo(horaConsul,horaFinConsul)==true){
                                        if(lasCitas.buscarCitaX(nombreConsul,fechAtencion,horaConsul,horaFinConsul)==false){
                                agregarCitas(elEncontrado, elEncontrado1, horaConsul, horaFinConsul, confirmacion);
                                laFinal = new Cita(elEncontrado, elEncontrado1, horaConsul, horaFinConsul,
                                        confirmacion);}
                                    else{
                                            JOptionPane.showMessageDialog(null, "Esta cita ya existe",
                                                    "ERROR", JOptionPane.ERROR_MESSAGE);
                                        }}else{
                                        JOptionPane.showMessageDialog(null, "La consulta dura 15 minutos",
                                                "ERROR", JOptionPane.ERROR_MESSAGE);
                                    }}
                                else{
                                    JOptionPane.showMessageDialog(null, "El rango de la fecha de la " +
                                                    "cita es invalido", "ERROR", JOptionPane.ERROR_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "No se ha ingresado este" +
                                                " consultorio en el sistema, por favor intente con otro", "ERROR",
                                        JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "No se ha ingresado este paciente en el "
                                            + "sistema, por favor intente con otro", "ERROR",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Por favor, complete todos los espacios",
                                "ERROR", JOptionPane.ERROR_MESSAGE);
                    }

                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "No ingreso las horas o los minutos", "ERROR",
                            JOptionPane.ERROR_MESSAGE);
                    //numContacto.setText("*");
                    //numContacto.setBackground(Color.RED);
                }
                if(laFinal!=null){
                    CrearCitas x1=new CrearCitas();
                    x1.setVisible(true);
                    laPagina.dispose();
                }
                else{ }
            }
    }

    public void agregarCitas(Pacient a, Consultorio b, Hora c,Hora c1,String x){
        if(a==null || b==null || c==null || x.isEmpty()  ){
            JOptionPane.showMessageDialog(null,
                    "Por Favor complete todos los espacios", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null,
                    "Se ha ingresado correctamente", "Confirmacion",
                    JOptionPane.INFORMATION_MESSAGE);
            lasCitas.addCita(a,b,c,c1,x);
        }
    }

    public boolean verificaExistenciaPaciente(String x){
        if(losPacientes.confirmaPaciente(x))
            return true; /**Significa que si puede meter la cita*/
        else
            return false;/**No podria meter la consulta en cualquier otro caso*/
    }
    public boolean verificaFechasYConsultorios(String x, String fecha){
        System.out.println("El nombre del consultorio es: "+x);
        System.out.println("La fecha ingresada es: "+ fecha);
        if(elArreglo.confirmaConsultorio(x,fecha)==true)
            return true; /**Significa que si puede meter la cita*/
        else
            return false;/**No podria meter la consulta en cualquier otro caso*/
    }

    public boolean verificaSiTodoEstaCompleto(String a,String b,String c,Hora d,Hora e){
        if((a!=null) && (b!=null) && (c!=null) && (d!=null)&&(e!=null))
            return true;
        else
            return false;

    }

    public int estableceNombreConsultorio(String x){
        if(x=="Consultorio Hospital CYM")
            return 1;
        else
            return 2;
    }

    public int estableceMinutos(String x){

        if(x=="00")
            return 1;
        else
            if(x=="15")
                return 2;
            else
                if(x=="30")
                    return 3;
                else
                    return 4;
    }

    public int estableceHoras(String x){
        if(x=="00")
            return 1;
        else
            if(x=="01")
                return 2;
            else
                if(x=="02")
                    return 3;
                else
                    if(x=="03")
                        return 4;
                    else
                        if(x=="04")
                            return 5;
                        else
                            if(x=="05")
                                return 6;
                            else
                                if(x=="06")
                                    return 7;
                                else
                                    if(x=="07")
                                        return 8;
                                    else
                                        if(x=="08")
                                            return 9;
                                        else
                                            if(x=="09")
                                                return 10;
                                            else
                                                if(x=="10")
                                                    return 11;
                                                else
                                                    if(x=="11")
                                                        return 12;
                                                    else
                                                        if(x=="12")
                                                            return 13;
                                                        else
                                                            if(x=="13")
                                                                return 14;
                                                            else
                                                                if(x=="14")
                                                                    return 15;
                                                                else
                                                                    if(x=="15")
                                                                        return 16;
                                                                    else
                                                                        if(x=="16")
                                                                            return 17;
                                                                        else
                                                                            if(x=="17")
                                                                                return 18;
                                                                            else
                                                                                if(x=="18")
                                                                                    return 19;
                                                                                else
                                                                                    if(x=="19")
                                                                                        return 20;
                                                                                    else
                                                                                        if(x=="20")
                                                                                            return 21;
                                                                                        else
                                                                                            if(x=="21")
                                                                                                return 22;
                                                                                            else
                                                                                                if(x=="22")
                                                                                                    return 23;
                                                                                                else
                                                                                                    return 24;
    }

    public Date retornaFecha(String x){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(x);
        }
        catch (ParseException ex)
        {
            System.out.println(ex);
        }
        return fechaDate;
    }

    public boolean verificaFecha(JDateChooser x){
        if(x.getDate()==null)
            return true;
        else
            return false;
    }

    public boolean verificaRangoDeCita(Hora horaInicio,Hora horaFinal,Consultorio elEncontrado){
        int horaInicioInsertada= Integer.parseInt(horaInicio.getHora());
        int horaFinalInsertada= Integer.parseInt(horaFinal.getHora());
        int horaAperturaConsultorio=Integer.parseInt(elEncontrado.getHoraInicioAtencion().getHora());
        int horaCierreConsultorio=Integer.parseInt(elEncontrado.getHoraFinalizacionAtencion().getHora());
        if(horaAperturaConsultorio<=horaInicioInsertada && horaCierreConsultorio>=horaFinalInsertada)
            return true;
        else
            return false;
    }

    public int cantidadDeTiempo(Hora laHoraDeInicio,Hora laHoraFinal){
        int minutosDeInicio=Integer.parseInt(laHoraDeInicio.getMinutos());
        int minutosDeFin=Integer.parseInt(laHoraFinal.getMinutos());
        int resta=0;
        resta=minutosDeFin-minutosDeInicio;
        return resta;

    }

    public boolean verificaCantTiempo(Hora laHoraDeInicio,Hora laHoraFinal){
        if((cantidadDeTiempo(laHoraDeInicio,laHoraFinal)==15) && (laHoraDeInicio.getHora()==laHoraFinal.getHora()))
            return true;
        else
            return false;
    }


}
