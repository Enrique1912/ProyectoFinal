package view;

import controller.ContrasenaMostrarController;
import service.CitaService;
import service.ConsultorioService;
import service.PacientService;

import javax.swing.*;


public class ContrasenaMostrar extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JPasswordField passwordField1;


    public ContrasenaMostrar() {
        ContrasenaMostrarController d1=new ContrasenaMostrarController
                (buttonOK,buttonCancel,textField1,passwordField1,this);
        setContentPane(contentPane);
        setModal(true);

        buttonOK.addActionListener(d1);
        buttonCancel.addActionListener(d1);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    public static void main(String[] args) {
        PacientService A1= PacientService.getSingletonInstance();
        ConsultorioService A2= ConsultorioService.getSingletonInstance();
        CitaService A3=CitaService.getSingletonInstance();
        ContrasenaMostrar dialog = new ContrasenaMostrar();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
