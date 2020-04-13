package controller;

import com.toedter.calendar.JDateChooser;
import model.Consultorio;
import model.Hora;
import service.ConsultorioService;
import view.CrearConsultorios;
import view.MenuConsultorios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CrearConsultoriosController implements ActionListener {

    private JTextField numContacto;
    private JComboBox nombreConsultorio;
    private JDateChooser fechaConsulta;
    private JComboBox horaConsulta;
    private JComboBox minutoConsulta;
    private JButton botonIngresar;
    private JButton botonSalir;
    private Consultorio elConsultorio;
    private ConsultorioService elArreglo;
   // private PacientService losPacientes;
    private Date laFech;
   // private CitaService lasCitas;
    private SimpleDateFormat formateador=new SimpleDateFormat("dd/MM/yyyy");
    private Hora horaInicioAtencion;
    private JComboBox horaFinalizacion;
    private JComboBox minutoFinalizacion;
    private CrearConsultorios laPagina;

    public CrearConsultoriosController(JComboBox nombreConsultorio, JDateChooser fechaConsulta, JComboBox horaConsulta,
                                       JComboBox minutoConsulta, JTextField numero, JButton ingresar, JButton salir,
                                       JComboBox horaCierre, JComboBox minutoCierre,CrearConsultorios x){
        this.nombreConsultorio=nombreConsultorio;
        this.fechaConsulta=fechaConsulta;
        this.horaConsulta=horaConsulta;
        this.minutoConsulta=minutoConsulta;
        this.numContacto=numero;
        this.botonIngresar=ingresar;
        this.botonSalir=salir;
        this.elArreglo=elArreglo.getSingletonInstance();
       // this.losPacientes=losPacientes.getSingletonInstance();
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
       // this.lasCitas=lasCitas.getSingletonInstance();
        laPagina=x;
    }

    public CrearConsultoriosController(JComboBox nombreConsultorio, JDateChooser fechaConsulta, JComboBox horaConsulta,
                                       JComboBox minutoConsulta, JTextField numero, JButton ingresar, JButton salir,
                                       Consultorio x,JComboBox horaCierre,JComboBox minutoCierre){
        this.nombreConsultorio=nombreConsultorio;
        this.horaConsulta=horaConsulta;
        this.minutoConsulta=minutoConsulta;
        this.horaFinalizacion=horaCierre;
        this.minutoFinalizacion=minutoCierre;
        nombreConsultorio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione el Nombre del " +
                "Consultorio","Consultorio Hospital CYM", "Consultorio Centro Medico del Este" }));

        horaConsulta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una Hora", "00", "01",
                "02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21",
                "22","23"
        }));

        horaFinalizacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una Hora", "00",
                "01", "02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20",
                "21", "22","23"
        }));

        minutoFinalizacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione los Minutos",
                "00", "15", "30","45" }));

        minutoConsulta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione los Minutos", "00",
                "15", "30","45" }));
        this.fechaConsulta=fechaConsulta;
        this.numContacto=numero;
        this.botonIngresar=ingresar;
        this.botonSalir=salir;
        this.elArreglo=elArreglo.getSingletonInstance();
       // this.losPacientes=losPacientes.getSingletonInstance();
        this.laFech=new Date();
        this.formateador.setLenient(false);
        this.elConsultorio=x;
        nombreConsultorio.setSelectedIndex(estableceNombreConsultorio(x.getNombreConsultorio()));
        horaConsulta.setSelectedIndex(estableceHoras(x.getHoraInicioAtencion().getHora()));
        minutoConsulta.setSelectedIndex(estableceMinutos(x.getHoraInicioAtencion().getMinutos()));
        horaFinalizacion.setSelectedIndex(estableceHoras(x.getHoraFinalizacionAtencion().getHora()));
        minutoCierre.setSelectedIndex(estableceMinutos(x.getHoraFinalizacionAtencion().getMinutos()));
        String tel=String.valueOf(x.getTelefonoContactos());
        fechaConsulta.setDate(retornaFecha(x.getLaFecha()));
        numContacto.setText(tel);
        //lasCitas=lasCitas.getSingletonInstance();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
            String nombreConsul=nombreConsultorio.getSelectedItem().toString();
            Hora horaConsul=new Hora(horaConsulta.getSelectedItem().toString(),minutoConsulta.getSelectedItem().
                    toString());
            Hora horaFinConsul=new Hora(horaFinalizacion.getSelectedItem().toString(),minutoFinalizacion.
                    getSelectedItem().toString());
            String minutConsul=minutoConsulta.getSelectedItem().toString();
            if(verificaFecha(fechaConsulta)==true){
                laFech=new Date();
            }else{
                laFech=fechaConsulta.getDate();
            }
            String fechAtencion=formateador.format(laFech);
            String numero= numContacto.getText();
            int telFinal;
            Object source = actionEvent.getSource();
            if (source == botonSalir){
                MenuConsultorios x1=new MenuConsultorios();
                x1.setVisible(true);
                laPagina.dispose();

            }
            else {
                    try {
                        if(elConsultorio!=null){
                            elArreglo.eliminaUnElemento(elConsultorio);
                        }
                        if(verificaQueTodoSeaFalse(nombreConsul,horaConsul.getHora(),horaConsul.getMinutos(),
                                horaFinConsul.getHora(),horaFinConsul.getMinutos(),numero)==true &&
                                verificaFecha(fechaConsulta)==false){
                        if (verificaFechasYConsultorios(nombreConsul, laFech) == true) {
                           if(verificaHoraAperturaYCierre(horaConsul,horaFinConsul)==true){
                               if(verificaQueLaFechaNoSeaMenor(fechaConsulta)==true){
                                   if(verificaUnConsultorioPorDia(nombreConsul,fechAtencion)==true){
                            telFinal = Integer.parseInt(numero);
                            agregarConsultorios(nombreConsul, fechAtencion, horaConsul,horaFinConsul ,minutConsul,
                                    telFinal);
                            elConsultorio = new Consultorio(nombreConsul, fechAtencion, horaConsul,horaFinConsul,
                                    minutConsul, telFinal);
                                   }else{
                                       JOptionPane.showMessageDialog(null, "Solo se puede un consultorio " +
                                               "por dia", "ERROR", JOptionPane.ERROR_MESSAGE);
                                   }
                               }else{
                                   JOptionPane.showMessageDialog(null, "La fecha debe de ser mayor a la de " +
                                           "hoy", "ERROR", JOptionPane.ERROR_MESSAGE);
                               }
                           }else{
                               JOptionPane.showMessageDialog(null, "La hora de inicio debe de ser menor a la hora mayor",
                                       "ERROR", JOptionPane.ERROR_MESSAGE);
                           }
                        } else {
                            JOptionPane.showMessageDialog(null, "No puede ingresar este consultorio." +
                                            "RECUERDE que el doctor atiende personas en el consultorio del Hospital " +
                                            "CYM los dias Lunes y Martes, por otra parte, los dias Jueves y Viernes " +
                                            "los dedica para el Consultorio Centro Medico del Este ", "ERROR",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                        }else{
                            JOptionPane.showMessageDialog(null, "Complete todos los espacios", "ERROR",
                                    JOptionPane.ERROR_MESSAGE);
                        }

                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "No es un numero", "ERROR",
                                JOptionPane.ERROR_MESSAGE);
                        numContacto.setText("*");
                        numContacto.setForeground(Color.RED);
                    }

            }


            if(elConsultorio!=null){//Valida si puede o no ponerse en blanco
                CrearConsultorios x1=new CrearConsultorios();
                x1.setVisible(true);
                laPagina.dispose();
            }
            else{ }

    }

    public void agregarConsultorios(String a, String b, Hora c,Hora c1,String x ,int d){
       if(a.isEmpty() || b==null || c==null || x.isEmpty()  ){
            JOptionPane.showMessageDialog(null,
                    "Por Favor complete todos los espacios", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null,
                    "Se ha ingresado correctamente", "Confirmacion",
                    JOptionPane.INFORMATION_MESSAGE);
            elArreglo.addConsultorio(a,b,c,c1,x,d);
        }
    }

    public static boolean isNumeric(String cadena) {

        boolean resultado;

        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }

    public boolean verificaFechasYConsultorios(String x, Date fecha){
        if(x=="Consultorio Hospital CYM" && (fecha.getDay()==1 || fecha.getDay()==2))
            return true; /**Significa que si puede meter la cita*/
            else
                if(x=="Consultorio Centro Medico del Este" && (fecha.getDay()==4 || fecha.getDay()==5)){
                    return true;/**Significa que si puede*/
                }
                else
                    return false;/**No podria meter la consulta en cualquier otro caso**/
    }

    public int estableceNombreConsultorio(String x){
        if(x=="Consultorio Hospital CYM")
            return 1;
        else
            return 2;
    }

    public int estableceMinutos(String x){
        System.out.println("El minuto ingresado corresponde a: "+ x);
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
        System.out.println("EL NUMERO ES: "+ x);
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

    public boolean verificaQueTodoSeaFalse(String a,String b,String c,String d,String e,String f){
        if(nomConsultorioCombo(a)==true && horaCombo(b)==true && minutoCombo(c)==true && telContacto(d)==true)
            return true;
        else
            return false;
    }

    public boolean verificaFecha(JDateChooser x){
        if(x.getDate()==null)
            return true;
        else
            return false;
    }

    public boolean nomConsultorioCombo(String x){
        if(x=="Consultorio Hospital CYM" || x=="Consultorio Centro Medico del Este")
            return true;
        else
            return false;
    }

    public boolean horaCombo(String x){
        if(x!="Seleccione una Hora"){
            return true;
        }
        else
            return false;
    }

    public boolean minutoCombo(String x){
        if(x!="Seleccione los Minutos")
            return true;
        else
            return false;
    }

    public boolean telContacto(String x){
        if(x!=null)
            return true;
        else
            return false;
    }

    public boolean verificaHoraAperturaYCierre(Hora horaApertura,Hora horaCierre){
        int horaInicio=Integer.parseInt(horaApertura.getHora());
        int horaFin=Integer.parseInt(horaCierre.getHora());
        if(horaInicio < horaFin)
            return true;
        else
            return false;
    }

    public boolean verificaQueLaFechaNoSeaMenor(JDateChooser x){
        Date laFechaDeHoy=new Date();
        Date fechaInsertada=x.getDate();
        System.out.println("El mes de hoy corresponde a: "+laFechaDeHoy.getMonth());
        System.out.println("El mes ingresado es: "+ fechaInsertada.getMonth());
        if((laFechaDeHoy.getMonth()< fechaInsertada.getMonth()) && (laFechaDeHoy.getYear()< fechaInsertada.getYear())
                || todoJunto(x)==true)
        return true;
        else
            return false;
    }

    public boolean verificaUnMismoMes(JDateChooser x){
        Date laFechaDeHoy=new Date();
        Date fechaInsertada=x.getDate();
        if((laFechaDeHoy.getMonth()==fechaInsertada.getMonth()) && (laFechaDeHoy.getYear()==fechaInsertada.getYear()))
            return true;
        else
            return false;
    }

    public boolean verificaEntoncesElDia(JDateChooser x){/**Metodo PROBLEMATICO*/
        Date laFechaDeHoy=new Date();
        Date fechaInsertada=x.getDate();
        int laFechaDeHoy1=getDayOfMonth(laFechaDeHoy);
        int fechaInsertada1=getDayOfMonth(fechaInsertada);
        System.out.println("El dia de la fecha de hoy es: "+ laFechaDeHoy1);
        System.out.println("La fecha insertada es: " + fechaInsertada1);
        if(laFechaDeHoy1 <= fechaInsertada1)
            return true;
        else
            return false;
    }

    public boolean todoJunto(JDateChooser x){
        if(verificaUnMismoMes(x)==true && verificaEntoncesElDia(x)==true){
            System.out.println("todoJunto() dio true");
            return true;}
        else{
            System.out.println("todoJunto() dio false");
            return false;}
    }

    //Retorna el dia del mes
    public static int getDayOfMonth(Date aDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(aDate);
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    //Verifica que exista un consultorio por dia

    public boolean verificaUnConsultorioPorDia(String a,String b){
        if(elArreglo.confirmaConsultorio(a,b)==false)
        return true;
        else
            return false;
    }
}
