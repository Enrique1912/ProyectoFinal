package controller;

import com.toedter.calendar.JDateChooser;
import model.Consultorio;
import service.CitaService;
import service.ConsultorioService;
import service.PacientService;
import view.ConsultoriosMostrar;
import view.CrearConsultorios;
import view.MenuConsultorios;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConsultoriosMostrarController implements ActionListener {
    private JComboBox searchTermTextField;
    private JDateChooser laFech;
    private DefaultTableModel tableModel;
    private ConsultorioService consultorioService;
    private Object[][] consultorios;
    private JTable laTabla;
    private JButton regresar;
    private JButton buscar;
    private JButton eliminar;
    private JButton modificar;
    private PacientService losPacientes;
    private Date laFecha;
    private CitaService lasCitas;
    private SimpleDateFormat formateador=new SimpleDateFormat("dd/MM/yyyy");
    String [] losTitulos={"Nombre del Consultorio", "Fecha de Atencion","Hora de Apertura","Hora de Cierre",
            "Telefono de Contacto"};
    private ConsultoriosMostrar laPagina;

    public ConsultoriosMostrarController(JTable laTabla, DefaultTableModel tableModel, JComboBox searchTermTextField,
                                         JDateChooser laFech,JButton regresar, JButton buscar, JButton eliminar,
                                         JButton modificar,ConsultoriosMostrar x) {
        super();
        laFecha=new Date();
        formateador.setLenient(false);
        consultorioService = consultorioService.getSingletonInstance();
        consultorios = consultorioService.retornaEstCargados();
        this.searchTermTextField = searchTermTextField;
        this.laFech=laFech;
        this.tableModel =tableModel;
        this.laTabla=laTabla;
        this.regresar=regresar;
        this.buscar=buscar;
        this.eliminar=eliminar;
        this.modificar=modificar;
        searchTermTextField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione el Nombre del " +
                "Consultorio","Consultorio Hospital CYM", "Consultorio Centro Medico del Este" }));
        tableModel.setDataVector(consultorios, losTitulos);
        this.losPacientes=losPacientes.getSingletonInstance();
        this.lasCitas=lasCitas.getSingletonInstance();
        this.laPagina=x;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String fechaEnString;
        Object source = actionEvent.getSource();
        if(verificaFecha(laFech)==true){
            laFecha=new Date();
        }else{
            laFecha=laFech.getDate();
        }
        //String fechaEnString=formateador.format(laFech);
        if (source == regresar){
            MenuConsultorios x1=new MenuConsultorios();
            x1.setVisible(true);
            laPagina.dispose();
        }else
        if(source == buscar){
            String buscaElemento = searchTermTextField.getSelectedItem().toString();
            fechaEnString=formateador.format(laFecha);
            buscarElemento(buscaElemento,fechaEnString);
        }
        else
        if(source == eliminar){
            String buscaElemento = searchTermTextField.getSelectedItem().toString();
            fechaEnString=formateador.format(laFecha);
            if(consultorioService.confirmaConsultorio(buscaElemento,fechaEnString)==true){
            eliminarElemento(buscaElemento,fechaEnString);}
            else{
                JOptionPane.showMessageDialog(null,
                        "No se ha encontrado este consultorio", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

        }
        else{
            String buscaElemento = searchTermTextField.getSelectedItem().toString();
            fechaEnString=formateador.format(laFecha);
            if(consultorioService.confirmaConsultorio(buscaElemento,fechaEnString)==true){
            modificarElemento(buscaElemento,fechaEnString);
            laPagina.dispose();
            }
            else{
                JOptionPane.showMessageDialog(null,
                        "No se ha encontrado este consultorio", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void buscarElemento(String searchTerm,String laFechaAtencion) {
        if (searchTerm != null && !"".equals(searchTerm) && laFechaAtencion != null && !"".equals(laFechaAtencion)
                && consultorios != null && consultorios.length >= 1) {
            Object[][] newData = new Object[consultorios.length][];
            int idx = 0;
            for (Object[] obj : consultorios) {
                String fullText = obj[0].toString() + obj[1].toString()
                        + obj[2].toString() + obj[3].toString();

                if (fullText.contains(searchTerm.trim()) && fullText.contains(laFechaAtencion.trim())) {
                    newData[idx++] = obj;
                }
            }
            tableModel.setDataVector(newData, losTitulos);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Search term is empty", "Error",
                    JOptionPane.ERROR_MESSAGE);
            tableModel.setDataVector(consultorios,losTitulos);
        }
    }

    private void eliminarElemento(String searchTerm,String fechaAtender) {
        if (searchTerm != null && !"".equals(searchTerm)
                && consultorioService != null ) {
            consultorioService.eliminarConsultorio(searchTerm,fechaAtender);
            JOptionPane.showMessageDialog(null,
                    "Se ha borrado un elemento exitosamente", "Confirmacion",
                    JOptionPane.INFORMATION_MESSAGE);
            consultorios = consultorioService.retornaEstCargados();
            tableModel.setDataVector(consultorios, losTitulos);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Search term is empty", "Error",
                    JOptionPane.ERROR_MESSAGE);

        }
    }

    private void modificarElemento(String searchTerm,String fA) {
        Consultorio x1;
        if (searchTerm != null && !"".equals(searchTerm)
                && consultorioService != null ) {
            x1=consultorioService.buscarConsultorio(searchTerm,fA);
            System.out.println("El a modificar es"+ x1.toString());
            System.out.println("El minuto de la hora de inicio es: "+ x1.getHoraInicioAtencion().getMinutos());
            CrearConsultorios a1=new CrearConsultorios(x1);
            a1.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Search term is empty", "Error",
                    JOptionPane.ERROR_MESSAGE);
            // tableModel.setDataVector(pacients, a1);
        }
    }

    public boolean verificaFecha(JDateChooser x){
        if(x.getDate()==null)
            return true;
        else
            return false;
    }
}
