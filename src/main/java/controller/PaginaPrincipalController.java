package controller;

import view.ConfirmacionCitasMostrar;
import view.ContrasenaMostrar;
import view.PaginaPrincipal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaginaPrincipalController extends JFrame implements ActionListener {
    private JButton pacientes;
    private JButton consultorios;
    private JButton citas;
    private JPanel contentPane;
    private PaginaPrincipal laPagina;
    //private PacientService elArreglo;
    //private ConsultorioService losConsultorios;
    //private CitaService lasCitas;

    public PaginaPrincipalController(JButton p, JButton co, JButton ci, JPanel contentPane, PaginaPrincipal x1){
        this.pacientes=p;
        this.consultorios=co;
        this.citas=ci;
        this.contentPane=contentPane;
        laPagina=x1;
       // this.elArreglo=elArreglo.getSingletonInstance();
       // this.losConsultorios=losConsultorios.getSingletonInstance();
       // this.lasCitas=lasCitas.getSingletonInstance();
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object source = actionEvent.getSource();
        if (source == pacientes) {
            ContrasenaMostrar x1=new ContrasenaMostrar();
            x1.pack();
            x1.setVisible(true);
            laPagina.dispose();
        } else
        if (source == consultorios) {
            ConfirmacionCitasMostrar x1=new ConfirmacionCitasMostrar();
            x1.setVisible(true);
            this.setVisible(false);
            laPagina.dispose();
        }

        else {
            laPagina.dispose();

        }
    }
}

