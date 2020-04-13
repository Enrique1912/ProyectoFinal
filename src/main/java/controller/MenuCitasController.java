package controller;

import view.CitasMostrar;
import view.CrearCitas;
import view.MenuCitas;
import view.PaginaPrincipal2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuCitasController implements ActionListener {
    private JButton agregar;
    private JButton tresCosas;
    private JButton salir;
    private MenuCitas laPagina;
    //private PacientService losPacientes;
   // private ConsultorioService losConsultorios;
    //private CitaService lasCitas;

    public MenuCitasController(JButton agregar, JButton tresCosas, JButton salir,MenuCitas x){
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
            CrearCitas x1=new CrearCitas();
            x1.setVisible(true);
            laPagina.dispose();

        } else
        if (source == tresCosas) {
            CitasMostrar x2=new CitasMostrar();
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
