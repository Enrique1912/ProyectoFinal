package controller;


import model.Pacient;
import service.PacientService;
import view.MenuAdministracionPacientes;
import view.PacientView;
import view.PacientViewMostrar;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PacientViewMostrarController implements ActionListener {
    private JTextField searchTermTextField;
    private DefaultTableModel tableModel;
    private PacientService pacientService;
    private Object[][] pacients;
    private JTable laTabla;
    private JButton regresar;
    private JButton buscar;
    private JButton eliminar;
    private JButton modificar;
    String [] a1={"Primer Apellido", "Segundo Apellido","Nombre Completo","Identificacion", "Numero de Telefono",
            "Direccion", "Fecha de Nacimiento","Enfermedades Asociadas","Observaciones"};
    private PacientViewMostrar laPagina;

    public PacientViewMostrarController(JTable laTabla, DefaultTableModel tableModel, JTextField searchTermTextField,
                                        JButton regresar, JButton buscar, JButton eliminar, JButton modificar,
                                        PacientViewMostrar x) {
        super();
        pacientService = pacientService.getSingletonInstance();
        pacients = pacientService.retornaEstCargados();
        this.searchTermTextField = searchTermTextField;
        this.tableModel = tableModel;
        this.laTabla=laTabla;
        this.regresar=regresar;
        this.buscar=buscar;
        this.eliminar=eliminar;
        this.modificar=modificar;
        tableModel.setDataVector(pacients, a1);
        this.laPagina=x;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object source = actionEvent.getSource();
        if (source == regresar){
            MenuAdministracionPacientes x1=new MenuAdministracionPacientes();
            x1.setVisible(true);
            laPagina.dispose();
        }else
            if(source == buscar){
        String buscaElemento = searchTermTextField.getText();
        if(pacientService.confirmaPaciente(buscaElemento)==true){
        buscarElemento(buscaElemento);}
        else{
            JOptionPane.showMessageDialog(null,
                    "No se ha encontrado este paciente", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        }
            else
                if(source == eliminar){
                    String buscaElemento = searchTermTextField.getText();
                    if(pacientService.confirmaPaciente(buscaElemento)==true){
                    eliminarElemento(buscaElemento);}
                    else{
                        JOptionPane.showMessageDialog(null,
                                "No se ha encontrado este paciente", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
                else{
                    String buscaElemento = searchTermTextField.getText();
                    if(pacientService.confirmaPaciente(buscaElemento)==true){
                    modificarElemento(buscaElemento);}
                    else{
                        JOptionPane.showMessageDialog(null,
                                "No se ha encontrado este paciente", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
    }

    private void buscarElemento(String searchTerm) {
        if (searchTerm != null && !"".equals(searchTerm)
                && pacients != null && pacients.length >= 1) {
            Object[][] newData = new Object[pacients.length][];
            int idx = 0;
            for (Object[] obj : pacients) {
                String fullText = obj[0].toString() + obj[1].toString()
                        + obj[2].toString() + obj[3].toString();

                if (fullText.contains(searchTerm.trim())) {
                    newData[idx++] = obj;
                }
            }
            tableModel.setDataVector(newData, a1);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Search term is empty", "Error",
                    JOptionPane.ERROR_MESSAGE);
            tableModel.setDataVector(pacients, a1);
        }
    }

    private void eliminarElemento(String searchTerm) {
        if (searchTerm != null && !"".equals(searchTerm)
                && pacientService != null ) {
            pacientService.eliminarPaciente(searchTerm);
            JOptionPane.showMessageDialog(null,
                    "Se ha borrado un elemento exitosamente", "Confirmacion",
                    JOptionPane.INFORMATION_MESSAGE);
            pacients = pacientService.retornaEstCargados();
            tableModel.setDataVector(pacients, a1);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Search term is empty", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void modificarElemento(String searchTerm) {
        Pacient x1;
        if (searchTerm != null && !"".equals(searchTerm)
                && pacientService != null ) {
            x1=pacientService.buscarPaciente(searchTerm);
            System.out.println("El a modificar es"+ x1.toString());
            PacientView a1=new PacientView(x1);
            a1.setVisible(true);
            laPagina.dispose();
        } else {
            JOptionPane.showMessageDialog(null,
                    "Search term is empty", "Error",
                    JOptionPane.ERROR_MESSAGE);
            // tableModel.setDataVector(pacients, a1);
        }
    }
}

