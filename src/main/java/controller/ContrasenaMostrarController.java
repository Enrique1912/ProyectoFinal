package controller;

import view.ContrasenaMostrar;
import view.PaginaPrincipal;
import view.PaginaPrincipal2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContrasenaMostrarController implements ActionListener {

    private JButton botonIngresar;
    private JButton botonRetroceder;
    private JTextField nomUsuario;
    private JPasswordField contra;
    private ContrasenaMostrar laPagina;

    public ContrasenaMostrarController(JButton botonIngresar, JButton botonRetroceder, JTextField nomUsuario,
                                       JPasswordField contra, ContrasenaMostrar x1){
        this.botonIngresar=botonIngresar;
        this.botonRetroceder=botonRetroceder;
        this.nomUsuario=nomUsuario;
        this.contra=contra;
        laPagina=x1;

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String puname = nomUsuario.getText();
        String ppaswd = contra.getText();
        Object source = actionEvent.getSource();
        if (source == botonIngresar){
        if(puname.equals("admin") && ppaswd.equals("hola123")) {
            PaginaPrincipal2 x1=new PaginaPrincipal2();
            x1.setVisible(true);
            laPagina.dispose();

        } else {

            JOptionPane.showMessageDialog(null,"Wrong Password / Username");
            nomUsuario.setText("");
            contra.setText("");

        }

    }
    else{
        PaginaPrincipal x1=new PaginaPrincipal();
        x1.setVisible(true);
        //System.exit(0);
    }
}
}
