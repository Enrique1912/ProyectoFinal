package controller;

import view.ConsultoriosMostrar;
import view.CrearConsultorios;
import view.MenuConsultorios;
import view.PaginaPrincipal2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuConsultoriosController implements ActionListener {
    private JButton agregar;
    private JButton tresCosas;
    private JButton salir;
    private MenuConsultorios laPagina;
    //private PacientService losPacientes;
   // private ConsultorioService losConsultorios;
   // private CitaService lasCitas;

    public MenuConsultoriosController(JButton agregar, JButton tresCosas, JButton salir,MenuConsultorios x){
        this.agregar=agregar;
        this.tresCosas=tresCosas;
        this.salir=salir;
        this.laPagina=x;
        //this.losPacientes=losPacientes.getSingletonInstance();
        //this.losConsultorios=losConsultorios.getSingletonInstance();
        //this.lasCitas=lasCitas.getSingletonInstance();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object source = actionEvent.getSource();
        if (source == agregar) {
            CrearConsultorios x1=new CrearConsultorios();
            x1.setVisible(true);
            laPagina.dispose();

        } else
        if (source == tresCosas) {
            ConsultoriosMostrar x2=new ConsultoriosMostrar();
            x2.setVisible(true);
            laPagina.dispose();
        }

        else{
            PaginaPrincipal2 laPrincipal2=new PaginaPrincipal2();
            laPrincipal2.setVisible(true);
            laPagina.dispose();
        }
    }
}
