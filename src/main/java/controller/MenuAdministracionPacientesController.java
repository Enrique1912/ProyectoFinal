package controller;

import service.PacientService;
import view.MenuAdministracionPacientes;
import view.PacientView;
import view.PacientViewMostrar;
import view.PaginaPrincipal2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuAdministracionPacientesController implements ActionListener {
    JButton agregar;
    JButton mostrar;
    JButton modificar;
    JButton eliminar;
    JButton salir;
    PacientService elArreglo;
    MenuAdministracionPacientes laPagina;
    //ConsultorioService losConsultorios;
    //private CitaService lasCitas;

    public MenuAdministracionPacientesController(JButton agregar, JButton mostrar, JButton modificar, JButton eliminar,
                                                 JButton salir, MenuAdministracionPacientes x){
        this.agregar=agregar;
        this.mostrar=mostrar;
        this.modificar=modificar;
        this.eliminar=eliminar;
        this.salir=salir;
        this.elArreglo=elArreglo.getSingletonInstance();
        laPagina=x;
       // this.losConsultorios=losConsultorios.getSingletonInstance();
        //this.lasCitas=lasCitas.getSingletonInstance();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object source = actionEvent.getSource();
        if (source == agregar) {
            PacientView x1=new PacientView();
            x1.setVisible(true);
            laPagina.dispose();

        } else
            if (source == mostrar) {
            PacientViewMostrar x2=new PacientViewMostrar();
            x2.setVisible(true);
            laPagina.dispose();
        }
            else
            if (source == modificar) {
                JOptionPane.showMessageDialog(null,
                        "Aqui iria la ventana de MODIFICAR", "ERROR",
                        JOptionPane.ERROR_MESSAGE);

            }

            else
                if(source==eliminar){
                JOptionPane.showMessageDialog(null,
                        "Aqui iria la ventana de ELIMINAR", "ERROR",
                        JOptionPane.ERROR_MESSAGE);

            }
                else{
                    PaginaPrincipal2 laPrincipal2=new PaginaPrincipal2();
                    laPrincipal2.setVisible(true);
                    laPagina.dispose();
                }
    }
}
