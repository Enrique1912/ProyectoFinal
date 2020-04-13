package controller;

import com.toedter.calendar.JDateChooser;
import model.Pacient;
import service.PacientService;
import view.MenuAdministracionPacientes;
import view.PacientView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class PacientController implements ActionListener {
    private PacientService elArreglo;
    private JTextField segundoApellidoTextField;
    private JTextField primerApellidoTextField;
    private JTextField numeroDeTelefonoTextField;
    private JTextArea direccionTextArea;
    private JTextArea enfermedadesAsociadasTextArea;
    private JTextArea observacionesTextArea;
    private JTextField nombreCompletoTextField;
    private JButton ingresar;
    private JButton regresar;
    private JTextField identificacion;
    private Pacient elPaciente;
    private JDateChooser calendar;
    private PacientView laPagina;
    private SimpleDateFormat formateador=new SimpleDateFormat("dd/MM/yyyy");
    //private ConsultorioService losConsultorios;
    //private CitaService lasCitas;

    public PacientController(JTextField nom, JTextField apellido1, JTextField apellido2, JTextField id , JTextField
            telefono, JTextArea direc, JTextArea enfer, JTextArea observac, JButton ingresar, JButton regresar,
                             JDateChooser elCalendario,PacientView x){
        this.elArreglo=elArreglo.getSingletonInstance();
        this.nombreCompletoTextField=nom;
        this.primerApellidoTextField=apellido1;
        this.segundoApellidoTextField=apellido2;
        this.identificacion=id;
        this.numeroDeTelefonoTextField=telefono;
        this.direccionTextArea=direc;
        this.enfermedadesAsociadasTextArea=enfer;
        this.observacionesTextArea=observac;
        this.ingresar=ingresar;
        this.regresar=regresar;
        //losConsultorios=losConsultorios.getSingletonInstance();
        calendar=elCalendario;
       // lasCitas=lasCitas.getSingletonInstance();
        this.laPagina=x;
    }

    public PacientController(JTextField nom, JTextField apellido1, JTextField apellido2,JTextField id ,JTextField
            telefono, JTextArea direc,JTextArea enfer,JTextArea observac,JButton ingresar,JButton regresar,Pacient x,
                             JDateChooser elCalendario,PacientView x1){
        elPaciente=x;
        String tel=String.valueOf(x.getTelefono());
        this.nombreCompletoTextField=nom;
        this.primerApellidoTextField=apellido1;
        this.segundoApellidoTextField=apellido2;
        this.identificacion=id;
        this.numeroDeTelefonoTextField=telefono;
        this.direccionTextArea=direc;
        this.enfermedadesAsociadasTextArea=enfer;
        this.observacionesTextArea=observac;
        this.calendar=elCalendario;
        nombreCompletoTextField.setText(x.getNombrePaciente());
        calendar.setDate(retornaFecha(x.getLaFecha()));
        primerApellidoTextField.setText(x.getApellido1());
        segundoApellidoTextField.setText(x.getApellido2());
        identificacion.setText(x.getId());
        numeroDeTelefonoTextField.setText(tel);
        direccionTextArea.setText(x.getDireccion());
        enfermedadesAsociadasTextArea.setText(x.getEnfermedadesAsociadas());
        observacionesTextArea.setText(x.getObservaciones());
        this.elArreglo=elArreglo.getSingletonInstance();
        this.ingresar=ingresar;
        this.regresar=regresar;
        this.laPagina=x1;
        //this.losConsultorios=losConsultorios.getSingletonInstance();
        //this.lasCitas=lasCitas.getSingletonInstance();

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Date fechita=new Date();
        Object source = actionEvent.getSource();
        String nom=nombreCompletoTextField.getText();
        String apellido1=primerApellidoTextField.getText();
        String apellido2=segundoApellidoTextField.getText();
        String id1=identificacion.getText();
        String telefono=numeroDeTelefonoTextField.getText();
        String direc=direccionTextArea.getText();
        String enfer=enfermedadesAsociadasTextArea.getText();
        String observac=observacionesTextArea.getText();
        if(verificaFecha(calendar)==true){
            fechita=new Date();
        }else{
            fechita=calendar.getDate();
        }
        String fechaEnString=formateador.format(fechita);
        int telFinal;

        if (source == regresar){
            MenuAdministracionPacientes x1=new MenuAdministracionPacientes();
            x1.setVisible(true);
            laPagina.dispose();
        }else{
            try {
                if(elArreglo.confirmaPaciente(id1)==false || elPaciente.getId()!=null){
                    if(verificaCampos(nom, apellido1, apellido2, id1, telefono,direc,enfer,observac)==false){
                    if(verificaFecha(calendar)==false){
                        if(elPaciente!=null){
                            elArreglo.eliminaUnElemento(elPaciente);
                        }
                    telFinal = Integer.parseInt(telefono);
                    agregarPacientes(nom, apellido1, apellido2, id1, telFinal,direc,enfer,observac,fechaEnString);
                    elPaciente = new Pacient(nom, apellido1,apellido2, id1, telFinal,direc,enfer,observac,fechaEnString);
                    }else{
                        JOptionPane.showMessageDialog(null, "Favor de ingresar una fecha",
                                "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                    }else{
                        JOptionPane.showMessageDialog(null, "Favor de completar todos los espacios",
                                "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Este paciente ya se encuentra registrado en el " +
                                    "sistema", "ERROR", JOptionPane.ERROR_MESSAGE);
                     PacientView x1=new PacientView();
                     x1.setVisible(true);
                     laPagina.dispose();
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "No es un numero", "ERROR",
                        JOptionPane.ERROR_MESSAGE);
                numeroDeTelefonoTextField.setText("*");
                numeroDeTelefonoTextField.setForeground(Color.RED);
            }
        }
            if(elPaciente!=null){//Valida si puede o no ponerse en blanco
                PacientView x1=new PacientView();
                x1.setVisible(true);
                laPagina.dispose();
            }
            else{ }//Apartir de aqui no se ha modificado este codigo
        }

    public void agregarPacientes(String a, String b, String c,String x ,int d, String e, String f, String g,String i){
        if(a.isEmpty() || b.isEmpty() || c.isEmpty() || e.isEmpty() || f.isEmpty() || g.isEmpty() ){
            JOptionPane.showMessageDialog(null,
                    "Por Favor complete todos los espacios", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null,
                    "Se ha ingresado correctamente", "Confirmacion",
                    JOptionPane.INFORMATION_MESSAGE);
            elArreglo.addPacient(a,b,c,x,d,e,f,g,i);
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

    public boolean verificaFecha(JDateChooser x){
        if(x.getDate()==null)
            return true;
        else
            return false;
    }

    public boolean verificaCampos(String a, String b, String c,String x ,String d, String e, String f, String g){
        if(a.isEmpty() || b.isEmpty() || c.isEmpty() || d.isEmpty() || e.isEmpty() || f.isEmpty() || g.isEmpty()){
            return true;
        }
        else
            return false;
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

}
