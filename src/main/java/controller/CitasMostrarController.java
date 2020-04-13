package controller;

import com.toedter.calendar.JDateChooser;
import model.Cita;
import model.Hora;
import service.CitaService;
import service.ConsultorioService;
import service.PacientService;
import view.CitasMostrar;
import view.CrearCitas;
import view.MenuCitas;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CitasMostrarController implements ActionListener {
    private JComboBox searchTermTextField;
    private JComboBox horaInicioCita;
    private JComboBox minutoInicioCita;
    private JComboBox horaFinCita;
    private JComboBox minutoFinCita;
    private JDateChooser laFech;
    private DefaultTableModel tableModel;
    private ConsultorioService consultorioService;
    private Object[][] citas;
    private JTable laTabla;
    private JButton regresar;
    private JButton buscar;
    private JButton eliminar;
    private JButton modificar;
    private PacientService losPacientes;
    private Date laFecha;
    private CitaService lasCitas;
    private SimpleDateFormat formateador=new SimpleDateFormat("dd/MM/yyyy");
    String [] losTitulos={"Numero de Identificacion del Paciente", "Nombre del Consultorio","Fecha de la Consulta",
            "Hora de Inicio","Hora de Finalizacion", "Confirmacion"};
    private CitasMostrar laPagina;

    public CitasMostrarController(JTable laTabla, DefaultTableModel tableModel, JComboBox searchTermTextField,
                                  JDateChooser laFech, JButton regresar, JButton buscar,
                                  JButton eliminar, JButton modificar, JComboBox combo2,JComboBox combo3,
                                  JComboBox combo4,JComboBox combo5,CitasMostrar x) {
        super();
        this.lasCitas=lasCitas.getSingletonInstance();
        laFecha=new Date();
        formateador.setLenient(false);
        consultorioService = consultorioService.getSingletonInstance();
        citas= lasCitas.retornaEstCargados();
        this.searchTermTextField = searchTermTextField;
        this.horaInicioCita=combo2;
        this.minutoInicioCita=combo3;
        this.horaFinCita=combo4;
        this.minutoFinCita=combo5;
        this.laFech=laFech;
        this.tableModel =tableModel;
        this.laTabla=laTabla;
        this.regresar=regresar;
        this.buscar=buscar;
        this.eliminar=eliminar;
        this.modificar=modificar;
        searchTermTextField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione el Nombre del " +
                "Consultorio","Consultorio Hospital CYM", "Consultorio Centro Medico del Este" }));

        horaInicioCita.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una Hora", "00", "01",
                "02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21",
                "22","23"
        }));

        horaFinCita.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una Hora", "00", "01",
                "02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21",
                "22","23"
        }));

        minutoInicioCita.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione los Minutos", "00",
                "15", "30","45" }));

        minutoFinCita.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione los Minutos", "00",
                "15", "30","45" }));

        tableModel.setDataVector(citas, losTitulos);
        this.losPacientes=losPacientes.getSingletonInstance();
        this.laPagina=x;

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String fechaEnString;
        if(verificaFecha(laFech)==true){
            laFecha=new Date();
        }else{
            laFecha=laFech.getDate();
            fechaEnString=formateador.format(laFech);
        }

        String hourInicio=horaInicioCita.getSelectedItem().toString();
        String minuteInicio=minutoInicioCita.getSelectedItem().toString();
        String hourFin=horaFinCita.getSelectedItem().toString();
        String minuteFin=minutoFinCita.getSelectedItem().toString();
        Hora laHoraInicial=new Hora(hourInicio,minuteInicio);
        Hora laHoraFinal=new Hora(hourFin,minuteFin);
        Object source = actionEvent.getSource();
        //String fechaEnString=formateador.format(laFech);
       if (source == regresar){
            MenuCitas x1=new MenuCitas();
            x1.setVisible(true);
            laPagina.dispose();
        }else
        if(source == buscar){
            String buscaElemento = searchTermTextField.getSelectedItem().toString();
            fechaEnString=formateador.format(laFecha);
            if(verificaTodosLosEspacios(buscaElemento,laFech,laHoraInicial,laHoraFinal)==false){
            buscarElemento(buscaElemento,fechaEnString,laHoraInicial,laHoraFinal);}
            else{
                JOptionPane.showMessageDialog(null, "Favor de completar todos los espacios", "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        else
        if(source == eliminar){
            String buscaElemento = searchTermTextField.getSelectedItem().toString();
            fechaEnString=formateador.format(laFecha);
            if(verificaTodosLosEspacios(buscaElemento,laFech,laHoraInicial,laHoraFinal)==false){
            if(lasCitas.buscarCitaX(buscaElemento,fechaEnString,laHoraInicial,laHoraFinal)==true){
            eliminarElemento(buscaElemento,fechaEnString,laHoraInicial,laHoraFinal);
            }else{
                JOptionPane.showMessageDialog(null, "No se ha encontrado esta Cita", "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            }
            }else{
                JOptionPane.showMessageDialog(null, "No se han completado todos los espacios","ERROR",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            String buscaElemento = searchTermTextField.getSelectedItem().toString();
            fechaEnString=formateador.format(laFecha);
            if(verificaTodosLosEspacios(buscaElemento,laFech,laHoraInicial,laHoraFinal)==false){
            if(lasCitas.buscarCitaX(buscaElemento,fechaEnString,laHoraInicial,laHoraFinal)==true){
            modificarElemento(buscaElemento,fechaEnString,laHoraInicial,laHoraFinal);
            laPagina.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "No se ha encontrado esta Cita", "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            }}else{
                JOptionPane.showMessageDialog(null, "No se han completado todos los espacios", "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void buscarElemento(String searchTerm,String laFechaAtencion,Hora horaInicial,Hora horaFinal) {
        if (searchTerm != null && !"".equals(searchTerm) && laFechaAtencion != null && !"".equals(laFechaAtencion)
                && horaInicial != null && !"".equals(horaInicial) && horaFinal != null && !"".equals(horaFinal)
                && citas != null && citas.length >= 1) {
            Object[][] newData = new Object[citas.length][];
            int idx = 0;
            for (Object[] obj : citas) {
                String fullText = obj[0].toString() + obj[1].toString()
                        + obj[2].toString() + obj[3].toString();

                if (fullText.contains(searchTerm.trim()) && fullText.contains(laFechaAtencion.trim()) &&
                        fullText.contains(horaInicial.getHora().trim()) && fullText.contains(horaFinal.getHora().trim())
                        && fullText.contains(horaInicial.getMinutos().trim()) && fullText.contains
                        (horaFinal.getMinutos().trim())) {
                    newData[idx++] = obj;
                }
            }
            tableModel.setDataVector(newData, losTitulos);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Search term is empty", "Error",
                    JOptionPane.ERROR_MESSAGE);
            tableModel.setDataVector(citas,losTitulos);
        }
    }

    private void eliminarElemento(String searchTerm,String fechaAtender,Hora horaInicio,Hora horaFinal) {
        if (searchTerm != null && !"".equals(searchTerm) &&
        fechaAtender != null && !"".equals(fechaAtender)
                && horaInicio != null && !"".equals(horaInicio) && horaFinal != null && !"".equals(horaFinal)
                && lasCitas != null ) {
            lasCitas.eliminarCita(searchTerm,fechaAtender,horaInicio,horaFinal);
            JOptionPane.showMessageDialog(null,
                    "Se ha borrado un elemento exitosamente", "Confirmacion",
                    JOptionPane.INFORMATION_MESSAGE);
            citas = lasCitas.retornaEstCargados();
            tableModel.setDataVector(citas, losTitulos);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Search term is empty", "Error",
                    JOptionPane.ERROR_MESSAGE);

        }
    }

    private void modificarElemento(String searchTerm,String fA,Hora laInicialHora, Hora laFinalHora) {
        Cita x1;
        if ((searchTerm != null && !"".equals(searchTerm)) && (fA != null && !"".equals(fA))
                && lasCitas != null ) {
            x1=lasCitas.buscarCita(searchTerm,fA,laInicialHora,laFinalHora);
            System.out.println("La cita a modificar es: "+ x1.toString());
            CrearCitas a1=new CrearCitas(x1);
            a1.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Search term is empty", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    public boolean verificaTodosLosEspacios(String a,JDateChooser b,Hora c,Hora d){
        if((a!="Seleccione el Nombre del Consultorio")|| (b==null) || (c.getHora()!="Seleccione una Hora") ||
                (c.getMinutos()!="Seleccione los Minutos")|| (d.getHora()!="Seleccione una Hora") ||
                (d.getMinutos()!="Seleccione los Minutos")){
            System.out.println("El nombre del consultorio seleccionado es:"+a);
            return true;
        }
        else{
            return false;
        }
    }
    public boolean verificaFecha(JDateChooser x){
        if(x.getDate()==null)
            return true;
        else
            return false;
    }
}
