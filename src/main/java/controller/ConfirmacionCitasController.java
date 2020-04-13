package controller;

import model.Cita;
import service.CitaService;
import service.ConsultorioService;
import service.PacientService;
import view.ConfirmacionCitasMostrar;
import view.PaginaPrincipal;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmacionCitasController implements ActionListener {
    private JComboBox confirmacion;
    private JTextField id;
    private JButton confirmar;
    private JButton regresar;
    PacientService losPacientes;
    ConsultorioService losConsultorios;
    CitaService lasCitas;
    private ConfirmacionCitasMostrar laPagina;

    public ConfirmacionCitasController(JTextField identificacion, JComboBox confirmacion, JButton confirmar,
                                       JButton regresar,ConfirmacionCitasMostrar x){
        this.id=identificacion;
        this.confirmacion=confirmacion;
        this.confirmar=confirmar;
        this.regresar=regresar;
        this.losPacientes=losPacientes.getSingletonInstance();
        this.losConsultorios=losConsultorios.getSingletonInstance();
        this.lasCitas=lasCitas.getSingletonInstance();
        confirmacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione la confirmacion",
                "Si", "No" }));
        this.laPagina=x;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object source = actionEvent.getSource();
        String identi=id.getText();
        String comoboRespuesta=confirmacion.getSelectedItem().toString();

        Cita c1=new Cita();
        if (source == regresar) {
            PaginaPrincipal x1 = new PaginaPrincipal();
            x1.setVisible(true);
            laPagina.dispose();
        } else {
            confirmacionDeLaCita(identi,comoboRespuesta);

        }
    }

    void confirmacionDeLaCita(String x,String comoboRespuesta){
        Cita c3=new Cita();
        if(confirmaCombo(comoboRespuesta)==false) {
            if (lasCitas.verificaCitaPorId(x) == true) {
               c3=lasCitas.buscarCitaPorId(x);
               c3.setConfirmacion(comoboRespuesta);
                JOptionPane.showMessageDialog(null,
                        "Se ha confirmado su cita correctamente", "Confirmacion",
                        JOptionPane.YES_OPTION);
                System.out.println("La cita finalmente queda: "+ c3.toString());
            } else {
                JOptionPane.showMessageDialog(null,
                        "No ha sido registrado", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null,
                    "No ha registrado una respuesta", "Error",
                    JOptionPane.ERROR_MESSAGE);
           // id.setText(x);
        }
    }

    boolean confirmaCombo(String comboRespuesta){
        if(comboRespuesta=="Seleccione la confirmacion")
            return true;
        else
            return false;
    }
}
