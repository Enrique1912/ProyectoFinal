package controller;

import view.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaginaPrincipal2Controller implements ActionListener {
    private JButton pacientes;
    private JButton consultorios;
    private JButton citas;
    private PaginaPrincipal2 laPagina;
   // private PacientService elArreglo;
   // private ConsultorioService losConsultorios;
   // private CitaService lasCitas;

    public PaginaPrincipal2Controller(JButton p, JButton co, JButton ci,PaginaPrincipal2 x){
        this.pacientes=p;
        this.consultorios=co;
        this.citas=ci;
        this.laPagina=x;
      //  this.elArreglo=elArreglo.getSingletonInstance();
      //  this.losConsultorios=losConsultorios.getSingletonInstance();
      //  this.lasCitas=lasCitas.getSingletonInstance();
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object source = actionEvent.getSource();
        if (source == pacientes) {
            MenuAdministracionPacientes x1=new MenuAdministracionPacientes();
            x1.setVisible(true);
            laPagina.dispose();


        } else
        if (source == consultorios) {
            MenuConsultorios x1=new MenuConsultorios();
            x1.setVisible(true);
            laPagina.dispose();
        }

        else
            if(source==citas){
            MenuCitas x1=new MenuCitas();
            x1.setVisible(true);
            laPagina.dispose();

        }else{
                PaginaPrincipal x1=new PaginaPrincipal();
                x1.setVisible(true);
                laPagina.dispose();
            }
    }
}